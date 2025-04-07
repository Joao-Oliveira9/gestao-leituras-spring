package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.core.domain.usecases.AddMetaLongoPrazoUseCase;
import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;

import java.time.LocalDate;

public class AddMetaLongoPrazoService implements AddMetaLongoPrazoUseCase {

    public void adicionarMeta(MetaLongoPrazoDto metaLongoPrazoDto){
        MetaLongoPrazo metaLongoPrazo = metaMapp(metaLongoPrazoDto);
        if(verificarDatas(metaLongoPrazo.getDataInicio(),metaLongoPrazo.getDataMeta())){
            //salvar no repository
            System.out.println(metaLongoPrazo.getDataInicio());
            System.out.println(metaLongoPrazo.getDataMeta());
            System.out.println(metaLongoPrazo.getNomeAutor());
            System.out.println(metaLongoPrazo.getNomeLivro());
        }
        else{
            System.out.println("Datas Invalidas");
        }
    }

    public boolean verificarDatas(LocalDate dataInicio,LocalDate dataMetaLongoPrazo){
        return dataMetaLongoPrazo.isAfter(dataInicio);
    }

    //criar um mapper pro dto
    public MetaLongoPrazo metaMapp(MetaLongoPrazoDto metaLongoPrazoDto){
        String nomeAutor = metaLongoPrazoDto.nomeAutor();
        String nomeLivro = metaLongoPrazoDto.nomeLivro();

        LocalDate dataInicio = metaLongoPrazoDto.dataInicio();
        LocalDate dataMeta = metaLongoPrazoDto.dataPrevista();

        MetaLongoPrazo metaLongoPrazo = new MetaLongoPrazo(nomeAutor,nomeLivro,dataInicio,dataMeta);
        return  metaLongoPrazo;
    }
}
