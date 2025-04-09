package com.exemplo.demo.presenter.resources;

import com.exemplo.demo.presenter.response.RestMessageGetListaLivro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public interface GetListLeituraResource {
    @GetMapping(value = "getListLeitura")
    public ResponseEntity<RestMessageGetListaLivro> getRequestListaController();


}
