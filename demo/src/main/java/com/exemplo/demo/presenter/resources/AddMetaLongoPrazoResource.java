package com.exemplo.demo.presenter.resources;

import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AddMetaLongoPrazoResource {

    @PostMapping(value = "add")
    public ResponseEntity<RestMessage> postRequestMetaLongoPrazo(@RequestBody MetaLongoPrazoDto metaLongoPrazo);
}
