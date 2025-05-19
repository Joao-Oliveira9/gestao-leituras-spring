package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.Status.Status;
import com.exemplo.demo.core.domain.usecases.AddLeituraUseCase;
import com.exemplo.demo.exceptions.addLeituraExceptions.PaginasException;
import com.exemplo.demo.infra.data.config.EntityMapper;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.presenter.dto.LeituraDto;
import com.exemplo.demo.presenter.dto.LivroDto;
import com.exemplo.demo.presenter.response.RestMessageAddLeitura;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddLeituraService implements AddLeituraUseCase {

    //arrumar/deixar menos porco
    EntityMapper entityMapper = new EntityMapper();

    //COLOCAR NO CONSTRUTOR tirar autowired
    LeituraRepository leituraRepository;

//    LivroRepository livroRepository;

    public AddLeituraService(LeituraRepository leituraRepository,LivroRepository livroRepository){
        this.leituraRepository = leituraRepository;
//        this.livroRepository = livroRepository;
    }

    public AddLeituraService(){

    }

    public Livro adicionarLivro(LivroDto livroDto){
        String nomeLivro = livroDto.nomeLivro();
        String nomeAutor = livroDto.nomeAutor();
        Integer numero = Integer.parseInt(livroDto.numPaginasLivro());

        Livro livro = new Livro(nomeLivro,nomeAutor,numero);
//        livroRepository.salvar(livro);
        return livro;
    }

    public ResponseEntity<RestMessageAddLeitura> adicionarLeitura(LeituraDto leituraDto, LivroDto livroDto){
        int numPaginaAtual = Integer.parseInt(leituraDto.paginasLidas());
        int numPaginaTotal = Integer.parseInt(livroDto.numPaginasLivro());
       if(numPaginaAtual <= numPaginaTotal){
           Livro livro = adicionarLivro(livroDto);
//           int numPaginaAtual = Integer.parseInt(leituraDto.paginasLidas());
           Status status = determinarStatusLeitura(livro.getNumPaginas(),numPaginaAtual);
           double porcentagem = determinarPorcentagemLeitura(numPaginaAtual,livro.getNumPaginas());
//           System.out.println(porcentagem);
           Leitura leitura = new Leitura(livro,status,numPaginaAtual,porcentagem);
//           System.out.println(leitura.getPorcentagemLeitura());
           leituraRepository.salvar(leitura);

//       RestMessage restMessage = new RestMessage("Leitura adicionada");
           RestMessageAddLeitura restMessageAddLeitura = new RestMessageAddLeitura(leitura.getStatus());
           return ResponseEntity.status(HttpStatus.OK).body(restMessageAddLeitura);
       }else{
           throw new PaginasException();
       }

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

    public double determinarPorcentagemLeitura(int paginasLidas,int paginasTotais){
        return Math.round(paginasLidas * 100 / (paginasTotais * 1.0) ) ;
    }

}
