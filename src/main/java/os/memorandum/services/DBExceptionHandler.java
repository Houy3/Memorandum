package os.memorandum.services;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import os.memorandum.exceptions.ServiceValidationException;

import java.util.ArrayList;

@Aspect
@Component
public class DBExceptionHandler {



    @AfterThrowing(value = "execution(* os.memorandum.services..*.*(..))", throwing = "dataAccessException")
    public void after(DataAccessException dataAccessException) {
//TODO
//        String message = dataAccessException.getMessage();

        System.out.println(dataAccessException.getMessage());
        throw new ServiceValidationException(new ArrayList<>());
    }
}
