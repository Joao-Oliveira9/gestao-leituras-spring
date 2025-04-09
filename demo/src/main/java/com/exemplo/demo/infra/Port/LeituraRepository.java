package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.dto.LivroLeituraView;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface LeituraRepository  {
    public void salvar(Leitura leitura);
    public void deletar(Livro livro);
    public List<LivroLeituraView> buscarLivrosEmProgresso();
    public void atualizarLeituraEMetaBd(String nomeLivro, String nomeAutor, int paginaAtualizada);
//    public void buscarLivrosEmProgresso();
}
