package br.com.victorpithan.minicursojavaspringsolid.infraestructure;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.victorpithan.minicursojavaspringsolid.dtos.ExceptionDTO;
import br.com.victorpithan.minicursojavaspringsolid.services.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<br.com.victorpithan.minicursojavaspringsolid.dtos.ExceptionDTO> threatDuplicateEntry(DataIntegrityViolationException exception) {
        int statusCode = HttpStatus.CONFLICT.value();
        ExceptionDTO exceptionDto = new ExceptionDTO("Valor já inserido no banco de dados.", statusCode);
        return ResponseEntity.status(statusCode).body(exceptionDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> threatStandardException(Exception exception) {
        ExceptionDTO exceptionDto = new ExceptionDTO(exception.getMessage(), 500);
        return ResponseEntity.internalServerError().body(exceptionDto);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> threatNotFound404(NotFoundException exception) {
        int statusCode = HttpStatus.NOT_FOUND.value();
        ExceptionDTO exceptionDto = new ExceptionDTO(exception.getMessage(), statusCode);
        return ResponseEntity.status(statusCode).body(exceptionDto);
    }
    
}