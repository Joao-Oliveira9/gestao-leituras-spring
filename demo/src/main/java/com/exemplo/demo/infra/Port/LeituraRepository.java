package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.dto.LivroLeituraView;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface LeituraRepository  {
    public void salvar(Leitura leitura);
//    public void deletarLeitura1(Livro livro);
    public List<LivroLeituraView> buscarLeiturasEmProgresso();
    public void atualizarLeituraEMeta(String nomeLivro, String nomeAutor, int paginaAtualizada);
//    public void buscarLivrosEmProgresso();
}
