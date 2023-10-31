package com.filmes.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.filmes.entities.Filme;
import org.springframework.stereotype.Repository;

@Repository
public class FilmesRepository {

    private List<Filme> filmesList = new ArrayList<>();
    public List<Filme> findByNome(String nome) {
        if (filmesList != null) {
            return filmesList.stream()
                    .filter(fil -> fil.getNome().contains(nome))
                    .collect(Collectors.toList());
        }
        return filmesList;
    }

    public List<Filme> findByDiretor(String diretor) {
        if (filmesList != null) {
            return filmesList.stream()
                    .filter(fil -> fil.getDiretor().contains(diretor))
                    .collect(Collectors.toList());
        }
        return filmesList;
    }

    public Filme findById(Integer id) throws RuntimeException {
        return filmesList.stream()
                .filter(fil -> fil.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException());
    }

    public Integer add(final Filme filme) {
        if (filme.getId() == null) {
            filme.setId(filmesList.size() + 1);
        }
        filmesList.add(filme);
        return filme.getId();
    }

    public void update(final Filme filme) {
        filmesList.stream()
                .filter(fil -> fil.getId().equals(filme.getId()))
                .forEach(fil -> fil.setNome(filme.getNome()));
        filmesList.stream()
                .filter(fil -> fil.getId().equals(filme.getId()))
                .forEach(fil -> fil.setDiretor(filme.getDiretor()));
        filmesList.stream()
                .filter(fil -> fil.getId().equals(filme.getId()))
                .forEach(fil -> fil.setNota(filme.getNota()));
        filmesList.stream()
                .filter(fil -> fil.getId().equals(filme.getId()))
                .forEach(fil -> fil.setAno(filme.getAno()));
    }

    public void delete(Integer id) {
        filmesList.removeIf(fil -> fil.getId().equals(id));
    }

    public int count() {
        return filmesList.size();
    }

    public List<Filme> getFilmesList() {
        return filmesList;
    }
}
