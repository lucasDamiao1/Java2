package br.edu.edu.up.pessoa.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.edu.up.pessoa.domain.Pessoa;
import br.edu.edu.up.pessoa.repository.PessoaRepository;

@RestController
public class PessoaController {
    
    private final PessoaRepository repository;

    PessoaController(PessoaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/pessoa")
    Iterable<Pessoa> lsitar(){
        return repository.findAll();
    }

    @GetMapping("/pessoa/{id}")
    Pessoa buscarPorId(@PathVariable long id){
        return repository.findById(id).get();
    }

    @PostMapping("/pessoa")
    Pessoa incluir(@RequestBody Pessoa novaPessoa){
        return repository.save(novaPessoa);
    }

    @PutMapping("/pessoa/{id}")
    Pessoa atualizar(@RequestBody Pessoa pessoaAlterada, @PathVariable long id ){
        return repository.findById(id).map(pessoa -> {
            pessoa.setNome(pessoaAlterada.getNome());
            return repository.save(pessoaAlterada);
        })
        .orElseGet(() -> {
            pessoaAlterada.setId(id);
            return repository.save(pessoaAlterada);
        });
    }

    @DeleteMapping("/pessoa/{id}")
        void excluir(@PathVariable long id){
            repository.deleteById(id);
        }

}
