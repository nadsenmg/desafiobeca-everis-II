package br.com.nadsen.gerenciadorsaques.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler (NullPointerException.class)
    public ResponseEntity<StandardError> handleNullPointerException(NullPointerException e){
        StandardError st = new StandardError(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(st);
    }
}
