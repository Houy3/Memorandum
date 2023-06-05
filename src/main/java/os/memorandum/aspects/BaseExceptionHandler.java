package os.memorandum.aspects;

import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler implements Ordered {


//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handle(Exception e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(ExceptionDto.builder()
//                        .time(LocalDateTime.now())
//                        .message("dhrthr")
//                        .build());
//    }


    @Override
    public int getOrder() {
        return 0;
    }
}
