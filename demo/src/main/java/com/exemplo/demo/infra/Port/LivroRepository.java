package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository  {
    public void salvar(Livro livro);
//    public void deletar(Livro livro);
}
