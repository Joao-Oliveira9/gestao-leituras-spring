package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.Status.Status;
import com.exemplo.demo.presenter.dto.LeituraDto;
import com.exemplo.demo.presenter.dto.LivroDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

public interface AddLeituraUseCase {
       public Livro adicionarLivro(LivroDto livroDto);
       public ResponseEntity<RestMessage> adicionarLeitura(LeituraDto leituraDto,LivroDto livroDto);
       public Status determinarStatusLeitura(int numPaginasTotal, int numPaginasLidas);
}
