package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.Avaliacao;
import com.exemplo.demo.core.domain.entities.Status.StatusAval;
import com.exemplo.demo.core.domain.usecases.AddAvaliacaoUseCase;
import com.exemplo.demo.exceptions.addAvaliacaoExceptions.NotaInvalidaException;
import com.exemplo.demo.infra.Port.NotaRepository;
import com.exemplo.demo.presenter.dto.AvaliacaoDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddAvaliacaoService implements AddAvaliacaoUseCase {

    NotaRepository notaRepository;

    public AddAvaliacaoService(NotaRepository notaRepository){
        this.notaRepository = notaRepository;
    }

    //criar uma pasta especifica para mapear
    public Avaliacao mapearAvaliacao(AvaliacaoDto avaliacaoDto){
        int nota = Integer.parseInt(avaliacaoDto.nota());

        if(nota<=10){
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setNomeAutor(avaliacaoDto.nomeAutor());
            avaliacao.setNomeLivro(avaliacaoDto.nomeLivro());

            StatusAval status = determinarStatusAvaliacao(nota);
            avaliacao.setNota(nota);
            avaliacao.setStatusAval(status);

            System.out.println(avaliacao.getNomeAutor());
            System.out.println("nome-livro" + avaliacao.getNomeLivro());
            return  avaliacao;
        }
        else{
            throw new NotaInvalidaException();
        }

    }

    public ResponseEntity<RestMessage> adicionarNota(AvaliacaoDto avaliacaoDto){
        RestMessage message = new RestMessage("SALVE");


        Avaliacao avaliacao = mapearAvaliacao(avaliacaoDto);

        notaRepository.salvar(avaliacao);

        return ResponseEntity.status(HttpStatus.OK).body(message);

    }

    public StatusAval determinarStatusAvaliacao(int nota){
        if(nota > 0 && nota <= 5){
            return StatusAval.Ruim;
        }else if(nota > 5 && nota <= 7){
            return StatusAval.Mediano;
        }else{
            return StatusAval.Bom;
        }
    }
}
