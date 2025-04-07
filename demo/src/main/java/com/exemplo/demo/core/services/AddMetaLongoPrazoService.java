package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.core.domain.usecases.AddMetaLongoPrazoUseCase;
import com.exemplo.demo.infra.Port.MetaLongoPrazoRepository;
import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public class AddMetaLongoPrazoService implements AddMetaLongoPrazoUseCase {

    MetaLongoPrazoRepository metaLongoPrazoRepository;

    public AddMetaLongoPrazoService(MetaLongoPrazoRepository metaLongoPrazoRepository){
        this.metaLongoPrazoRepository = metaLongoPrazoRepository;
    }

    public ResponseEntity<RestMessage> adicionarMeta(MetaLongoPrazoDto metaLongoPrazoDto){
        MetaLongoPrazo metaLongoPrazo = metaMapp(metaLongoPrazoDto);
        if(verificarDatas(metaLongoPrazo.getDataInicio(),metaLongoPrazo.getDataMeta())){
            //salvar no repository
            System.out.println(metaLongoPrazo.getDataInicio());
            System.out.println(metaLongoPrazo.getDataMeta());
            System.out.println(metaLongoPrazo.getNomeAutor());
            metaLongoPrazoRepository.salvar(metaLongoPrazo);

            RestMessage message = new RestMessage("Data cadastrada");

            return ResponseEntity.status(HttpStatus.OK).body(message);

        }
        else{
            System.out.println("Datas Invalidas");
            RestMessage message = new RestMessage("Erro");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
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
