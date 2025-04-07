package com.exemplo.demo.core.services.config;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class EntityMapper {


    public LeituraJPA mapLeitura(Leitura leitura){
        LivroJPA livroJPA = mapLivro(leitura.getLivro());
        LeituraJPA leituraJPA = new LeituraJPA();
        leituraJPA.setLivroJPA(livroJPA);
        leituraJPA.setStatus(leitura.getStatus());
        leituraJPA.setPorcentagem(10);
        leituraJPA.setPaginaAtual(leitura.getPaginaAtual());

        return leituraJPA;
    }


    public LivroJPA mapLivro(Livro livro){
        LivroJPA livroJPA = new LivroJPA();
        livroJPA.setNome(livro.getNome());
        livroJPA.setAutor(livro.getNomeAutor());
        livroJPA.setQtdPaginas(livro.getNumPaginas());


        return livroJPA;
    }
}
