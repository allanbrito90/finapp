package br.com.at.finapp.controller;

import br.com.at.finapp.dto.CategoriaDto;
import br.com.at.finapp.dto.ReceitaDto;
import br.com.at.finapp.form.ReceitaForm;
import br.com.at.finapp.model.Receita;
import br.com.at.finapp.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/list")
    public ResponseEntity<List<ReceitaDto>> listar(){
        return ResponseEntity.ok(ReceitaDto.converter(receitaService.list()));
    }

    @GetMapping("/list/{ativo}")
    public ResponseEntity<List<ReceitaDto>> listarAtivos(@PathVariable boolean ativo){
        return ResponseEntity.ok(ReceitaDto.converter(receitaService.findAllByActive(ativo)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDto> obter (@PathVariable Long id){
        Optional<Receita> receita = receitaService.findById(id);
        return receita.isPresent() ? ResponseEntity.ok(new ReceitaDto(receita.get())) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReceitaDto> cadastrar (@RequestBody ReceitaForm form, UriComponentsBuilder uriBuilder){
        Receita receita = form.toReceita();
        receitaService.save(receita);
        URI uri = uriBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
        return ResponseEntity.created(uri).body(new ReceitaDto(receita));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaDto> atualizar(@PathVariable Long id, @RequestBody ReceitaForm form){
        Optional<Receita> receita = receitaService.findById(id);
        if(receita.isPresent()){
            form.atualizar(receita.get());
            receitaService.save(receita.get());
            return ResponseEntity.ok(new ReceitaDto(receita.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<ReceitaDto> desativar (@PathVariable Long id){
        return receitaService.deactivate(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReceitaDto> deletar(@PathVariable Long id){
        receitaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
