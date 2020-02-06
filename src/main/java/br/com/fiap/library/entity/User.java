package br.com.fiap.library.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @CreatedDate
    @Column(name="created_at", updatable = false, nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = true)
    private Date lastModifiedAt;

}
