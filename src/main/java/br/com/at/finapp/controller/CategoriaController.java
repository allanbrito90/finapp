package br.com.at.finapp.controller;

import br.com.at.finapp.dto.CategoriaDto;
import br.com.at.finapp.form.CategoriaForm;
import br.com.at.finapp.model.Categoria;
import br.com.at.finapp.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/list")
    public ResponseEntity<List<CategoriaDto>> listar(){
        return ResponseEntity.ok(CategoriaDto.converter(service.list()));
    }

    @GetMapping("/list/{ativo}")
    public ResponseEntity<List<CategoriaDto>> listarAtivos(@PathVariable boolean ativo){
        return ResponseEntity.ok(CategoriaDto.converter(service.findAllByActive(ativo)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> obter(@PathVariable Long id){
        Optional<Categoria> categoria = service.findById(id);
        if(categoria.isPresent()) { return ResponseEntity.ok(new CategoriaDto(categoria.get())); }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody CategoriaForm form, UriComponentsBuilder uriBuilder){
        Categoria categoria = CategoriaForm.toCategoria(form);
        service.save(categoria);
        URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody CategoriaForm form){
        Optional<Categoria> categoria = service.findById(id);
        if(categoria.isPresent()){
            return ResponseEntity.ok(form.atualizar(categoria.get(), service));
        }
        return ResponseEntity.notFound().build();

    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<CategoriaDto> desativar(@PathVariable Long id){
        return service.deactivate(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaDto> deletar(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
