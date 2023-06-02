package os.memorandum.aspects;

import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler implements Ordered {



    @Override
    public int getOrder() {
        return 0;
    }
}
