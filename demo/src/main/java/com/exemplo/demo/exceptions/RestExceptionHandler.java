package com.exemplo.demo.exceptions;

import com.exemplo.demo.exceptions.addAvaliacaoExceptions.NotaInvalidaException;
import com.exemplo.demo.exceptions.addLeituraExceptions.PaginasException;
import com.exemplo.demo.exceptions.addMetaExceptions.DataInvalidaException;
import com.exemplo.demo.exceptions.messages.RestErrorMessage;
import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidJson(HttpMessageNotReadableException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Formato Invalido Json");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<RestErrorMessage> handleIPropertyValueException(PropertyValueException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Existem alguns campos que estão nulos");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidFomat(NullPointerException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Existem alguns campos que estão nulos");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<RestErrorMessage> handleInvalidFomatNumberMatricula(NumberFormatException exception) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Existem alguns campos que estão nulos");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }




    //

    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> PaginasExceptionHandler(PaginasException exeception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exeception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> LivroNotFoundExceptionHandler(LivroNotFoundException exeception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exeception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> DataInvalidaExceptionHandler(DataInvalidaException exeception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exeception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> notaInvalidaExceptionHandler(NotaInvalidaException exeception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exeception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<RestErrorMessage> handleDuplicateKeyException(DataIntegrityViolationException exception) {
        String message = exception.getMostSpecificCause().getMessage();

        String userMessage = "Já existe um registro com esse valor único no banco de dados.";

        if (message != null && (message.toLowerCase().contains("duplicate key") || message.toLowerCase().contains("violates unique constraint"))) {
            userMessage = "Registro duplicado: esse valor já existe no banco.";
        }

        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.CONFLICT, userMessage);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorMessage> MetaNaoExisteExceptionHandler(MetaNaoExisteException exeception){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,exeception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

}
