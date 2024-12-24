package com.fitlifegym.fit_life_gym_pos.advisor;

import com.fitlifegym.fit_life_gym_pos.exception.NotFoundException;
import com.fitlifegym.fit_life_gym_pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : K.M.G.I.K.konara
 * @Time :12:42 AM
 * @since : 12/24/2024
 **/
@RestControllerAdvice
public class AppWideExceptionhandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(new StandardResponse(404,"error occured",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
