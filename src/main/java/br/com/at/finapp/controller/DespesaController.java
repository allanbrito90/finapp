package br.com.at.finapp.controller;

import br.com.at.finapp.dto.CategoriaDto;
import br.com.at.finapp.dto.DespesaDto;
import br.com.at.finapp.form.DespesaForm;
import br.com.at.finapp.model.Categoria;
import br.com.at.finapp.model.Despesa;
import br.com.at.finapp.service.CategoriaService;
import br.com.at.finapp.service.DespesaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/list")
    public ResponseEntity<List<DespesaDto>> listar(){
        return ResponseEntity.ok().body(DespesaDto.converter(despesaService.list()));
    }

    @GetMapping("/list/{ativo}")
    public ResponseEntity<List<DespesaDto>> listarAtivos(@PathVariable boolean ativo){
        return ResponseEntity.ok(DespesaDto.converter(despesaService.findAllByActive(ativo)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDto> obter(@PathVariable Long id){
        Optional<Despesa> despesa = despesaService.findById(id);
        if(despesa.isPresent()) { return ResponseEntity.ok(new DespesaDto(despesaService.findById(id).get())); }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DespesaDto> cadastrar (@RequestBody @Valid DespesaForm form, UriComponentsBuilder uriBuilder){
        Optional<Categoria> categoria = categoriaService.findById(form.getCategoria().getId());
        Despesa despesa = DespesaForm.toDespesa(form, categoria.get());
        despesaService.save(despesa);
        URI uri = uriBuilder.path("/despesa/{id}").buildAndExpand(despesa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DespesaDto(despesa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaDto> atualizar (@PathVariable Long id, @RequestBody @Valid DespesaForm form){
        Optional<Despesa> despesa = despesaService.findById(id);
        if(despesa.isPresent()){
            form.atualizar(despesa.get());
            despesa.get().setCategoria(categoriaService.findById(form.getCategoria().getId()).get());
            despesaService.save(despesa.get());
            return ResponseEntity.ok(new DespesaDto(despesa.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<DespesaDto> desativar(@PathVariable Long id){
        return despesaService.deactivate(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DespesaDto>deletar(@PathVariable Long id){
        despesaService.delete(id);
        return ResponseEntity.ok().build();
    }



}
