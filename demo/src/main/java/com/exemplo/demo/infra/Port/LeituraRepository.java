package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.dto.LivroLeituraView;

import java.util.List;


public interface LeituraRepository  {
    public void salvar(Leitura leitura);
    public void deletar(Livro livro);
    public List<LivroLeituraView> buscarLivrosEmProgresso();
//    public void buscarLivrosEmProgresso();
}
