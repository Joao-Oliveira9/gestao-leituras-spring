package com.exemplo.demo.infra.data.config;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import com.exemplo.demo.infra.data.jpa.MetaLongoPrazoJPA;


public class EntityMapper implements EntityMapperInterface {

    //Livro e Leitura
    public LeituraJPA mapLeitura(Leitura leitura){
        LivroJPA livroJPA = mapLivro(leitura.getLivro());
        LeituraJPA leituraJPA = new LeituraJPA();
        leituraJPA.setLivroJPA(livroJPA);
        leituraJPA.setStatus(leitura.getStatus());
        System.out.println(leitura.getPorcentagemLeitura());
        leituraJPA.setPorcentagem(leitura.getPorcentagemLeitura());
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


    //MetaLongoPrazo

    public MetaLongoPrazoJPA mapLongoPrazo(MetaLongoPrazo metaLongoPrazo,LivroJPA livroJPA){
        MetaLongoPrazoJPA metaLongoPrazoJPA = new MetaLongoPrazoJPA();
        metaLongoPrazoJPA.setData_meta(metaLongoPrazo.getDataMeta());
        metaLongoPrazoJPA.setData_inicio(metaLongoPrazo.getDataInicio());
        metaLongoPrazoJPA.setLivroJPA(livroJPA);
        return metaLongoPrazoJPA;
    }

}
