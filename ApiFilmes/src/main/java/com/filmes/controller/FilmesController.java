package com.filmes.controller;

import com.filmes.entities.Filme;
import com.filmes.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
    private List<Filme> filmeList = new ArrayList<>();
    @Autowired
    private FilmesService filmesService;

    @GetMapping("/nome")
    public List<Filme> findByNome(@RequestParam(required = false) String nome) {
        try {
            filmeList = filmesService.findByNome(nome);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return filmeList;
    }

    @GetMapping("/diretor")
    public List<Filme> findByDiretor(@RequestParam(required = false) String diretor) {
        try {
            filmeList = filmesService.findByDiretor(diretor);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return filmeList;
    }

   @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") Integer id) {
        try {
          filmeList = (List<Filme>) filmesService.findById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return (Filme) filmeList;
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Filme filme) {
        Integer id = filmesService.add(filme);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping
    public void update(@RequestBody final Filme filme) {
        filmesService.update(filme);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        filmesService.delete(id);
    }

}
