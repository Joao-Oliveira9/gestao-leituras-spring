package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.usecases.DeleteLivroUseCase;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import com.exemplo.demo.presenter.dto.LivroDeletarDto;

public class DeleteLivroService implements DeleteLivroUseCase {

    LeituraRepository leituraRepository;
    LivroRepository livroRepository;

    public DeleteLivroService(LeituraRepository leituraRepository,LivroRepository livroRepository){
        this.leituraRepository = leituraRepository;
        this.livroRepository = livroRepository;
    }

    public void deletarLeitura(LivroDeletarDto livroDeletarDto){
        Livro livro = new Livro();
        livro.setNome(livroDeletarDto.nomeLivro());
        livro.setNomeAutor(livroDeletarDto.nomeAutor());


        System.out.println("passei nesse service de delete");
        livroRepository.deletar(livro);
        System.out.println("passei nesse service de delete2");
//        System.out.println(livro.getNome());
    }


}
