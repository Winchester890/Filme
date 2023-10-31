package com.filmes.entities;

public class Filme {
    private Integer id;
    private String nome;
    private String diretor;
    private Integer ano;
    private Integer nota;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getNota() {
        return nota;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Filme(Integer id, String nome, String diretor, Integer ano, Integer nota) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.ano = ano;
        this.nota = nota;
    }
}
