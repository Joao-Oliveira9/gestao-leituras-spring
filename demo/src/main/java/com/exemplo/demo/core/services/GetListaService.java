package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.usecases.GetListaUseCase;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.data.Dto.LivroLeituraView;
import com.exemplo.demo.presenter.response.RestMessageAddLeitura;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetListaService implements GetListaUseCase {

    LeituraRepository leituraRepository;
    public GetListaService(LeituraRepository leituraRepository){
        this.leituraRepository = leituraRepository;
    }

    public List<LivroLeituraView> buscarLivrosEmProgresso(){
        return leituraRepository.buscarLivrosEmProgresso();
    }

//    public void buscarLivrosEmProgresso(){
//       leituraRepository.buscarLivrosEmProgresso();
//   }
}
