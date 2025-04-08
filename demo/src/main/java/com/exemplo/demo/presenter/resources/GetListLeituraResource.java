package com.exemplo.demo.presenter.resources;

import com.exemplo.demo.presenter.response.RestMessage;
import com.exemplo.demo.presenter.response.RestMessageGetListaLivroEmAndamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GetListLeituraResource {
    @GetMapping(value = "getListLeitura")
    public ResponseEntity<RestMessageGetListaLivroEmAndamento> getRequestListaController();


}
