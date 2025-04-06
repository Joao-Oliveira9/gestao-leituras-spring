package com.exemplo.demo.presenter.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TesteController {

    @PostMapping(value = "create")
    public String postRequestResgistrarLeitura(@RequestBody Map<String, String> teste) {
        System.out.println(teste);
        return "";
    }
}
