package com.exemplo.demo.presenter.resources;

import com.exemplo.demo.presenter.dto.LivroDeletarDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public interface DeleteLivroResource {
    @DeleteMapping(value = "delete")
    public ResponseEntity<RestMessage> deleteRequestLivro(@RequestBody LivroDeletarDto livroDeletarDto);
}
