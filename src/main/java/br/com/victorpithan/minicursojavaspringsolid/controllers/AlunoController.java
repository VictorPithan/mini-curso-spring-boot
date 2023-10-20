package br.com.victorpithan.minicursojavaspringsolid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorpithan.minicursojavaspringsolid.dtos.AlunoDTO;
import br.com.victorpithan.minicursojavaspringsolid.models.AlunoModel;
import br.com.victorpithan.minicursojavaspringsolid.services.interfaces.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
  
      @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoModel>> getAll() {
        List<AlunoModel> alunos = alunoService.getAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> getById(@PathVariable int id) {
        AlunoModel aluno = alunoService.getById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<AlunoModel> save(@RequestBody AlunoDTO alunoDto) {
        AlunoModel aluno = alunoService.save(alunoDto);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> update(@PathVariable int id, @RequestBody AlunoDTO alunoDto) {
        AlunoModel aluno = alunoService.update(id, alunoDto);
        return ResponseEntity.ok().body(aluno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean deletado = alunoService.delete(id);        
        if (deletado) {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.NOT_FOUND);
        }
    }
  
}
