package com.exemplo.demo.presenter.resources;

import com.exemplo.demo.presenter.response.RestMessageGetListaLivro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GetListLeituraResource {
    @GetMapping(value = "getListLeitura")
    public ResponseEntity<RestMessageGetListaLivro> getRequestListaController();


}
