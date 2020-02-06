package br.com.fiap.library.service;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;
import br.com.fiap.library.entity.Author;
import br.com.fiap.library.entity.Book;
import br.com.fiap.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class BookServiceImpl implements BookService {

    private BookRepository repository;

    @Override
    public List<BookDTO> findAll(String title) {
        return repository.findAll().stream()
                .map(BookDTO::fromBook)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Integer id) {
        return BookDTO.fromBook(repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public BookDTO update(Integer id, CreateBookDTO createBookDTO) {
        Book book = Book.fromCreateBookDTO(createBookDTO).toBuilder()
                .id(id)
                .build();
        return BookDTO.fromBook(repository.save(book));
    }

    @Override
    public BookDTO update(Integer id, AutorDTO autorDTO) {
        Book book = repository.getOne(id).toBuilder()
                .author(Author.fromDTO(autorDTO))
                .build();
        return BookDTO.fromBook(repository.save(book));
    }

    @Override
    public BookDTO create(CreateBookDTO createBookDTO) {
        Book book = Book.fromCreateBookDTO(createBookDTO);
        return BookDTO.fromBook(repository.save(book));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.getOne(id));
    }
}
