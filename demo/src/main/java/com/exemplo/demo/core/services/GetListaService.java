package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.usecases.GetListaUseCase;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.data.dto.LivroLeituraView;

import java.util.List;

public class GetListaService implements GetListaUseCase {

    LeituraRepository leituraRepository;
    public GetListaService(LeituraRepository leituraRepository){
        this.leituraRepository = leituraRepository;
    }

    public List<LivroLeituraView> buscarLivrosEmProgresso(){
        return leituraRepository.buscarLeiturasEmProgresso();
    }


}
