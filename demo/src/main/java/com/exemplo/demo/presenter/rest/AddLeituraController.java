package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.presenter.resources.AddLeituraResource;

import java.util.Map;


public class AddLeituraController implements AddLeituraResource {


    @Override
    public String postRequestResgistrarLeitura(Map<String, String> teste) {
        System.out.println(teste);
        return "";
    }
}
