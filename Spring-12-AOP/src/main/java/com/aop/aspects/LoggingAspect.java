package com.aop.aspects;

import com.aop.controller.ProductController;
import com.aop.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    //1 option
//    @Pointcut("execution(* com.aop.controller.ProductController.*(..))")
//    public void pointcut() {}
//
//    @Before("pointcut()")
//    public void log() {
//        logger.info("-------1--------");
//    }
//
//    //2 option
//    @Before("execution(* com.aop.controller.ProductController.*(..))")
//    public void beforeAdvice() {
//        logger.info("-------2-------");
//    }

    //execution
    @Pointcut("execution(* com.aop.controller.ProductController.up*(..))")
    private void anyUpdateOperation() {}

    @Pointcut("execution(* com.aop.repository.ProductRepository.findById(Long))")
    private void anyProductRepositoryFindById() {}

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(JoinPoint joinPoint) {
        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    @Before("anyUpdateOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //within
    @Pointcut("within(com.aop.controller..*)")
    private void anyControllerOperation() {}

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation() {}

    @Before("anyServiceAnnotatedOperation() || anyControllerOperation()")
    public void beforeControllerAdvice2(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //annotation
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation() {}

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice3(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //after returning - will run after successful execution with no exception
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation() {}

    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, ResponseEntity<Product> results) {
        logger.info("After Returning(Mono Result) -> Method : {} - results : {}", joinPoint.getSignature().toShortString(), results);
    }

    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results) {
        logger.info("After Returning(List Result) -> Method : {} - results : {}", joinPoint.getSignature().toShortString(), results);
    }

    //after throwing - will run when exception thrown
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation() {}

    @AfterThrowing(pointcut = "anyGetPutProductOperation()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, RuntimeException exception) {
        logger.info("After Throwing(Send Email to L2 Team) -> Method : {} - Exception : {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    //after - will run anyway
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation2() {}

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice(JoinPoint joinPoint) {
        logger.info("After Finally -> Method : {} - results : {}", joinPoint.getSignature().toShortString());
    }

    //around
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void anyPostProductOperation() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void anyPutProductOperation() {}

    @Around("anyPostProductOperation()")
    public Object anyPostControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Before(Method) : {} - Parameters : {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        ResponseEntity<List<Product>> results = (ResponseEntity<List<Product>>)proceedingJoinPoint.proceed();
        logger.info("After(Method) : {} - Results : {}", proceedingJoinPoint.getSignature().toShortString(), results);
        return results;
    }

}
