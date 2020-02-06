package br.com.fiap.library.entity;

import br.com.fiap.library.dto.AutorDTO;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Table(name = "tb_author")
@Builder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    public static Author fromDTO(AutorDTO dto) {
        Author entity = null;

        if (Objects.nonNull(dto)) {
            entity = Author.builder()
                    .id(dto.getId())
                    .name(dto.getNome())
                    .build();
        }

        return entity;
    }

}
