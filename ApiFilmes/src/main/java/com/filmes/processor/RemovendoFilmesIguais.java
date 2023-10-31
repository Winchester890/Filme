package com.filmes.processor;

import com.filmes.entities.Filme;
import com.filmes.repository.FilmesRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RemovendoFilmesIguais implements Processor{

   private FilmesRepository filmesRepository;
    @Override
    public void process(Filme filme) {
        List<Filme> filmes = filmesRepository.getFilmesList();
        for (Filme fil : filmes) {
            if (filme.getNome().equals(fil.getNome()) && filme.getAno() == fil.getAno()) {
                filmes.remove(filme);
            }
        }
    }
}
