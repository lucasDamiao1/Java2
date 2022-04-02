package br.edu.edu.up.pessoa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    
    public Pessoa(){

    }
    public Pessoa(String nome){
        this.nome = nome;
    }

    public Pessoa(long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public long getId(){
        return id;
    }

    public String setNome(){
        return nome;
    }

    public long setId(){
        return id;
    }
    public void setNome(String nome2) {
    }
    public void setId(long id2) {
    }


}
