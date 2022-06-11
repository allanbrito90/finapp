package br.com.at.finapp.controller;

import br.com.at.finapp.dto.CategoriaDto;
import br.com.at.finapp.dto.ObjetivoDto;
import br.com.at.finapp.form.ObjetivoForm;
import br.com.at.finapp.model.Objetivo;
import br.com.at.finapp.service.ObjetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/objetivo")
public class ObjetivoController {

    @Autowired
    private ObjetivoService objetivoService;

    @GetMapping("/list")
    public List<ObjetivoDto> listar(){
        return ObjetivoDto.converter(objetivoService.list());
    }

    @GetMapping("/list/{ativo}")
    public ResponseEntity<List<ObjetivoDto>> listarAtivos(@PathVariable boolean ativo){
        return ResponseEntity.ok(ObjetivoDto.converter(objetivoService.findAllByActive(ativo)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoDto> obter(@PathVariable Long id){
        Optional<Objetivo> objetivo = objetivoService.findById(id);
        if(objetivo.isPresent()){return ResponseEntity.ok(new ObjetivoDto(objetivo.get()));}
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ObjetivoDto> cadastrar(@RequestBody ObjetivoForm form, UriComponentsBuilder uriBuilder){
        Objetivo objetivo = form.toObjetivo(form);
        objetivoService.save(objetivo);
        URI uri = uriBuilder.path("/objetivo/{id}").buildAndExpand(objetivo.getId()).toUri();
        return ResponseEntity.created(uri).body(new ObjetivoDto(objetivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoDto> atualizar(@PathVariable Long id, @RequestBody ObjetivoForm form){
        Optional<Objetivo> objetivo = objetivoService.findById(id);
        if(objetivo.isPresent()){
            objetivoService.save(form.atualizar(objetivo.get()));
            return ResponseEntity.ok(new ObjetivoDto(objetivo.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/desativar/{id}")
    public ResponseEntity<ObjetivoDto> desativar(@PathVariable Long id){
        return objetivoService.deactivate(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjetivoDto>excluir(@PathVariable Long id){
        objetivoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
