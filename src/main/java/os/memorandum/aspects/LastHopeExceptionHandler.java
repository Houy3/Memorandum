package os.memorandum.aspects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import os.memorandum.dto.ExceptionDto;

@RestControllerAdvice
public class LastHopeExceptionHandler implements Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> handle(Exception e) {
//        logger.error(e.getMessage(), e);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ExceptionDto)
//    }


    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
