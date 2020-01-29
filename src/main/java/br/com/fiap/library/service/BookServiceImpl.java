package br.com.fiap.library.service;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
class BookServiceImpl implements BookService {

    List<BookDTO> bookDTOList = new ArrayList<>();

    @PostConstruct
    private void mockBooks() {
        bookDTOList.add(new BookDTO(1,
                "Senhor do Aneis",
                800,
                "67125371213",
                ZonedDateTime.now().minusYears(40),
                new AutorDTO()));
        bookDTOList.add(new BookDTO(2,
                "O Hobbit",
                800,
                "67125371213",
                ZonedDateTime.now().minusYears(40),
                new AutorDTO()));
        bookDTOList.add(new BookDTO(3,
                "Silmarillion",
                800,
                "67125371213",
                ZonedDateTime.now().minusYears(40),
                new AutorDTO()));
    }

    @Override
    public List<BookDTO> findAll(String title) {
        return bookDTOList.stream()
                .filter(bookDTO -> title == null || bookDTO.getTitulo().startsWith(title))
                .collect(Collectors.toList());

    }

    @Override
    public BookDTO findById(Integer id) {
        return null;
    }

    @Override
    public BookDTO update(Integer id, CreateBookDTO createBookDTO) {
        return null;
    }

    @Override
    public BookDTO update(Integer id, AutorDTO autorDTO) {
        return null;
    }

    @Override
    public BookDTO create(CreateBookDTO createBookDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
