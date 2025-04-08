package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.usecases.GetListAvaliacaoUseCase;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.dto.LivroAvaliacaoView;

import java.util.List;

public class GetListaAvaliacaoService implements GetListAvaliacaoUseCase {

    LivroRepository livroRepository;

    public GetListaAvaliacaoService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;

    }

//    public void buscandoAvaliacoes(){
//        //definir o status por aqui
//
//        livroRepository.buscarAvaliacoes();
//    }

    public List<LivroAvaliacaoView> buscandoAvaliacoes(){
        return  livroRepository.buscarAvaliacoes();
    }
}
