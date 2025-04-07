package com.exemplo.demo.infra.data.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_META")
public class MetaLongoPrazoJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID meta_id;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;

    @Column(name = "data_meta", nullable = false)
    private LocalDate data_meta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "livro_id", nullable = false)
    private LivroJPA livroJPA;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
