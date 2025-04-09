package com.exemplo.demo.presenter.resources;

import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;
import com.exemplo.demo.presenter.dto.RegistroLeituraDto;
import com.exemplo.demo.presenter.response.RestMessage;
import com.exemplo.demo.presenter.response.RestMessageAddLeitura;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public interface AddLeituraResource {

   @PostMapping(value = "addLeitura")
   public ResponseEntity<RestMessageAddLeitura> postRequestResgistrarLeitura(@RequestBody RegistroLeituraDto registroLeitura);


}
