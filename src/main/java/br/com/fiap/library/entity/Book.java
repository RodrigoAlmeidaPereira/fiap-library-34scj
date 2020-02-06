package br.com.fiap.library.entity;

import br.com.fiap.library.dto.CreateBookDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_book")
@Builder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private Integer pages;

    @Column
    private String isbm;

    @CreatedDate
    @Column(name="created_at", updatable = false, nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = true)
    private Date lastModifiedAt;

    @Column(name = "release_date")
    private ZonedDateTime releaseDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public static Book fromCreateBookDTO(CreateBookDTO dto) {
        return Book.builder()
                .title(dto.getTitulo())
                .isbm(dto.getISBN())
                .pages(dto.getQuantidadeDePaginas())
                .releaseDate(dto.getDataLancamento())
                .build();
    }

}
