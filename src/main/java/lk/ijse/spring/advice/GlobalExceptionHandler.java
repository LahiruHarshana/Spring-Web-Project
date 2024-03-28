package lk.ijse.spring.advice;

import lk.ijse.spring.service.exception.DuplicateRecordException;
import lk.ijse.spring.service.exception.NotFoundException;
import lk.ijse.spring.service.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
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
    public ResponseEntity<Map<String, Object>> handleServiceException(ServiceException ex){
        Map<String,Object> errorAttributes;
        if (ex instanceof DuplicateRecordException) {
            errorAttributes=getCommonErrorAttribute(HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NotFoundException) {
            errorAttributes=getCommonErrorAttribute(HttpStatus.NOT_FOUND);
        }else {
            errorAttributes=getCommonErrorAttribute(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        errorAttributes.put("message",ex.getMessage());
        return new ResponseEntity<>(errorAttributes, HttpStatus.valueOf((Integer) errorAttributes.get("code")));
    }

    public Map<String, Object> getCommonErrorAttribute(HttpStatus sts){
            LinkedHashMap<String,Object> pky  = new LinkedHashMap<>();
            pky.put("code",sts.value());
            pky.put("message",sts);
            return pky;
    }


}
