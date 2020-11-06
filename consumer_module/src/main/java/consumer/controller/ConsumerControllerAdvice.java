package consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ConsumerControllerAdvice {

    public static String ERR_TYPE = "err_type";

    Logger logger = LoggerFactory.getLogger(ConsumerControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public String handleControllerException(Exception e, HttpServletRequest request, HandlerMethod handlerMethod){
        request.setAttribute(ERR_TYPE,e);
        logger.warn("throw err : " + e + " by " + handlerMethod.getBeanType().getSimpleName() + " " + handlerMethod.getMethod().getName());
        return "forward:/handleErr";
    }
}
