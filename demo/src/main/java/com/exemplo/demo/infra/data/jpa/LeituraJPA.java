package com.exemplo.demo.infra.data.jpa;

import com.exemplo.demo.core.domain.entities.Status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_Leitura")
public class LeituraJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID leitura_id;

    @Column(name = "paginasLidas")
    private int paginaAtual;

    @Column(name = "porcentagem")
    private double porcentagem;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_leitura", nullable = false)
    private Status Status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id",unique = false,nullable = false)
    private LivroJPA livroJPA;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
