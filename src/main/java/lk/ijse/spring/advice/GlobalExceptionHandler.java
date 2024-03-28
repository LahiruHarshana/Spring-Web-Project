package lk.ijse.spring.advice;

import lk.ijse.spring.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.Objects;

/**
 * @author : L.H.J
 * @File: GlobalExceptionHandler
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-03-28, Thursday
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Map<String, Objects>> handleServiceException(ServiceException ex){
        return null;
    }
}
