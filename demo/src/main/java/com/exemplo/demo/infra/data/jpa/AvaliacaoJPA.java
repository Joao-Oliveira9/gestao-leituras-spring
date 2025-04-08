package com.exemplo.demo.infra.data.jpa;

import com.exemplo.demo.core.domain.entities.Status.StatusAval;
import jakarta.persistence.*;
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
@Table(name = "TB_Avaliacao")
public class AvaliacaoJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID avaliacao_id;

    @Column(name = "nota", nullable = false)
    private double nota;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id", unique = false,nullable = false)
    private LivroJPA livroJPA;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private StatusAval estado;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
