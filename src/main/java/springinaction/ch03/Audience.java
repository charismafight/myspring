package springinaction.ch03;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Before("execution(* springinaction.ch03.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("silence phome call");
    }

    @Before("execution(* springinaction.ch03.Performance.perform(..))")
    public void takeSeat() {
        System.out.println("Take seats");
    }

    @AfterReturning("execution(* springinaction.ch03.Performance.perform(..))")
    public void applause() {
        System.out.println("papapapa");
    }

    @AfterThrowing("execution(* springinaction.ch03.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("demandRefund");
    }
}
