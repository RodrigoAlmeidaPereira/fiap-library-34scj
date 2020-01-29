package br.com.fiap.library.controller;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;
import br.com.fiap.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("books")
public class BookController {

    private BookService service;

    @GetMapping
    public List<BookDTO> getAll(@RequestParam(required = false, value = "title") String titulo){
        return service.findAll(titulo);
    }

    @GetMapping("{id}")
    public BookDTO findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody CreateBookDTO createBookDTO){
        return service.create(createBookDTO);
    }

    @PutMapping("{id}")
    public BookDTO update(@PathVariable Integer id,
                          @RequestBody CreateBookDTO createBookDTO){
        return service.update(id, createBookDTO);
    }

    @PatchMapping("{id}")
    public BookDTO update(@PathVariable Integer id,
                          @RequestBody AutorDTO autorDTO){
        return service.update(id, autorDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

}
