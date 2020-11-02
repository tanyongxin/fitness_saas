package consumer.aspect;

import api.pojo.PageReq;
import api.pojo.Res;
import api.pojo.StateCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class ControllerAspect {


    Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut(value = "execution(* consumer.controller.*.add*(..))")
    public void checkAddParameterPointcut(){}

    @Pointcut(value = "execution(* consumer.controller.*.update*(..)) || execution(* consumer.controller.*.del*(..))")
    public void checkUpdateAndDelParameterPointcut(){}

    @Around(value = "checkAddParameterPointcut()")
    public Res<?> checkAddParameter(JoinPoint joinPoint) {
        MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
        Object[] args = methodInvocationProceedingJoinPoint.getArgs();
        PageReq<?> pageReq = null;
        BindingResult bindingResult = null;
        for (Object arg : args) {
            if (arg instanceof PageReq)
                pageReq = (PageReq<?>) arg;
            if (arg instanceof  BindingResult)
                bindingResult = (BindingResult) arg;
        }
        if (pageReq == null) {
            try {
                return (Res<?>) methodInvocationProceedingJoinPoint.proceed(args);
            } catch (Throwable throwable) {
                logger.error("consumer.aspect.ControllerAspect.checkAddParameter throw " + throwable);
                return new Res<>(StateCode.OPERATION_FAILURE);
            }
        }
        if (pageReq.getId() != null || (bindingResult != null && bindingResult.hasErrors()))
            return new Res<>(StateCode.INVALIDPARAMETER);
        try {
            return (Res<?>) methodInvocationProceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            logger.error("consumer.aspect.ControllerAspect.checkAddParameter throw " + throwable);
            return new Res<>(StateCode.OPERATION_FAILURE);
        }
    }

    @Around(value = "checkUpdateAndDelParameterPointcut()")
    public Res<?> checkUpdateAndDelParameter(JoinPoint joinPoint){
        MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;
        Object[] args = methodInvocationProceedingJoinPoint.getArgs();
        PageReq<?> pageReq = null;
        for (Object arg : args) {
            if (arg instanceof PageReq) {
                pageReq = (PageReq<?>) arg;
                break;
            }
        }
        if (pageReq == null) {
            try {
                return (Res<?>) methodInvocationProceedingJoinPoint.proceed(args);
            } catch (Throwable throwable) {
                logger.error("consumer.aspect.ControllerAspect.checkAddParameter throw " + throwable);
                return new Res<>(StateCode.OPERATION_FAILURE);
            }
        }
        if (pageReq.getId() == null)
            return new Res<>(StateCode.INVALIDPARAMETER);
        try {
            return (Res<?>) methodInvocationProceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            logger.error("consumer.aspect.ControllerAspect.checkAddParameter throw " + throwable);
            return new Res<>(StateCode.OPERATION_FAILURE);
        }
    }


}
