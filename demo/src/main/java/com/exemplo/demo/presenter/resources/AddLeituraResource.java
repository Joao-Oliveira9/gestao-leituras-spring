package com.exemplo.demo.presenter.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public interface AddLeituraResource {

    @PostMapping(value = "create")
    public String postRequestResgistrarLeitura(@RequestBody Map<String,String> teste);
}
