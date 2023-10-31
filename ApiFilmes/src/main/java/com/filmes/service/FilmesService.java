package com.filmes.service;

import com.filmes.entities.Filme;
import com.filmes.processor.RemovendoFilmesIguais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.filmes.repository.FilmesRepository;

import java.util.List;

@Service
public class FilmesService {
    @Autowired
    private FilmesRepository filmesRepository;
    @Autowired
    private RemovendoFilmesIguais removendoFilmesIguais;

    public List<Filme> findByNome(String nome) {
        if (filmesRepository.getFilmesList() != null) {
            return filmesRepository.findByNome(nome);
        }
        return filmesRepository.getFilmesList();
    }

    public List<Filme> findByDiretor(String diretor) {
        if (filmesRepository.getFilmesList() != null) {
            return filmesRepository.findByDiretor(diretor);
        }
        return filmesRepository.getFilmesList();
    }

    public Filme findById(Integer id) throws RuntimeException {
        return filmesRepository.findById(id);
    }

    public Integer add(final Filme filme) {
        if (filme.getId() == null) {
            filme.setId(filmesRepository.count() + 1);
        }
        filmesRepository.add(filme);
        removendoFilmesIguais.process(filme);
        if (filmesRepository.getFilmesList() != null) {
            removendoFilmesIguais.process(filme);
        }
        return filme.getId();
    }

    public void update(final Filme filme) {
        filmesRepository.update(filme);
    }

    public void delete(Integer id) {
        filmesRepository.delete(id);
    }
}
