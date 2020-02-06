package br.com.fiap.library.dto;

import br.com.fiap.library.entity.Author;
import lombok.Builder;

import java.util.Objects;

@Builder
public class AutorDTO {

    private Integer id;
    private String nome;

    public static AutorDTO fromAuthor(Author entity) {
        AutorDTO dto = null;
        if (Objects.nonNull(entity)) {
            dto = AutorDTO.builder()
                    .id(entity.getId())
                    .nome(entity.getName())
                    .build();
        }
        return dto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
