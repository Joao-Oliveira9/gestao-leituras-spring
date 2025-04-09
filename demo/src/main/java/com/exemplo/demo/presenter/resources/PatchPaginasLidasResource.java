package com.exemplo.demo.presenter.resources;


import com.exemplo.demo.presenter.dto.LeituraAtualizadaDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public interface PatchPaginasLidasResource {

    @PatchMapping(value = "atualizarLeitura")
    ResponseEntity<RestMessage> patchPaginasLidasRequest(@RequestBody LeituraAtualizadaDto leituraAtualizadaDto);
}
