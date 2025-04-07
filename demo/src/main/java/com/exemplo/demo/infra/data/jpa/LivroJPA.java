package com.exemplo.demo.infra.data.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_Livro")
public class LivroJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID livro_id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "paginasTotais", nullable = false)
    private int qtdPaginas;

    @OneToOne(mappedBy = "livroJPA")
    LeituraJPA leituraJPA;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

}
