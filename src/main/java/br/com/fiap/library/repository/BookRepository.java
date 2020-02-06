package br.com.fiap.library.repository;

import br.com.fiap.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Integer> {

    List<Book> findAllByTitleStartsWith(String title);

    @Query("from Book b where b.title = :title")
    List<Book> findByTitle(String title);

}
