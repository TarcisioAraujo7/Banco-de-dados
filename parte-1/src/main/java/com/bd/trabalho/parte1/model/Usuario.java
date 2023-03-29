package com.bd.trabalho.parte1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Usuario {
    @Id
    private int cpf;
    @Column
    private String nome;
    @Column
    private Date data_nascimento;

    public Usuario(int cpf, String nome, Date data_nascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public Usuario() {

    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
