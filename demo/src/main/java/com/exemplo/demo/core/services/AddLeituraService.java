package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.Status.Status;
import com.exemplo.demo.core.domain.usecases.AddLeituraUseCase;
import com.exemplo.demo.core.services.config.EntityMapper;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import com.exemplo.demo.presenter.dto.LeituraDto;
import com.exemplo.demo.presenter.dto.LivroDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddLeituraService implements AddLeituraUseCase {

    //arrumar/deixar menos porco
    EntityMapper entityMapper = new EntityMapper();

    //COLOCAR NO CONSTRUTOR tirar autowired
    LeituraRepository leituraRepository;

    @Autowired
    LivroRepository livroRepository;

    public Livro adicionarLivro(LivroDto livroDto){
      //Nao sei se posso colocar entidade no service
        String nomeLivro = livroDto.nomeLivro();

        String nomeAutor = livroDto.nomeAutor();

        System.out.println(nomeAutor);
        Integer numero = Integer.parseInt(livroDto.numPaginasLivro());
        Livro livro = new Livro(nomeLivro,nomeAutor,numero);

//        RestMessage message = new RestMessage("Leitura inserida com sucesso");
        LivroJPA livroJPA = entityMapper.mapLivro(livro);

        System.out.println(livroJPA.getAutor());
        System.out.println(livroJPA.getNome());
//        livroRepository.salvar(livroJPA);

        return livro;
        // adicionar a parte do repository , mas ai vem a parte do jpa junto
//        return ResponseEntity.status(HttpStatus.OK).body(message);

    }

    public ResponseEntity<RestMessage> adicionarLeitura(LeituraDto leituraDto,LivroDto livroDto){
        //Colocar o Livro no Banco de Dados
       Livro livro = adicionarLivro(livroDto);
       Integer numPaginaAtual = Integer.parseInt(livroDto.numPaginasLivro());

       Status status = determinarStatusLeitura(livro.getNumPaginas(),numPaginaAtual);

       Leitura leitura = new Leitura(livro,status,numPaginaAtual);

//       System.out.println(leitura.getLivro().getNome());
//       ADICIONAR LEITURA
//        leituraRepository.salvar(entityMapper.mapLeitura(leitura));



       RestMessage restMessage = new RestMessage("Leitura adicionada");
       return ResponseEntity.status(HttpStatus.OK).body(restMessage);

    }

    public Status determinarStatusLeitura(int numPaginasTotal,int numPaginasLidas){
        if(numPaginasLidas<numPaginasTotal && numPaginasLidas>0){
            return Status.EmAndamento;
        }
        else if(numPaginasLidas == numPaginasTotal){
            return Status.Finalizado;
        }
        else{
            return Status.NaoIniciado;
        }
    }

}
