package com.example.ex1.aspect;

import com.example.ex1.model.BankAccount;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static java.nio.file.StandardOpenOption.APPEND;

@EnableAspectJAutoProxy
@Configuration
@Aspect
public class AuditAspect {

    /**
     * Advice =>cand rulam o noua logica raportat la momentul interceptarii
     * -before
     * -after
     * -after returning
     * -after throwing
     * -around
     * <p>
     * pointcut => indetifica locul in care se va face interceptare
     * jointPoint => informatia de la momentul interceptarii
     */

    @Pointcut(value = "execution(* com.example.ex1.service.BankAccountService.saveBankAccount(..))")
    public void saveBankAccountPointCut() {
    }

    @After("saveBankAccountPointCut()")
    public void logAuditAfterMethodExecution(JoinPoint joinPoint){
        var param = (BankAccount) joinPoint.getArgs()[0];
        var methodName = joinPoint.getSignature().getName();

        var logEntry = LocalDateTime.now() + ": Calling " + methodName + " with arguments: " + param + "\n";
        writeToFile(logEntry);
    }

//    @AfterThrowing(value = "saveBankAccountPointCut()", throwing = "err")
//    public void logAuditAfterThrowing(JoinPoint joinPoint, Throwable err){
//
//    }
//
//    @AfterReturning(value = "saveBankAccountPointCut()", returning = "data")
//    public void logAuditAfterReturning(JoinPoint joinPoint, Object data){
//
//    }

    @Around(value = "saveBankAccountPointCut()")
    public Object loggAuditAround(ProceedingJoinPoint proceedingJoinPoint){
        var b2 = new BankAccount("000000A502C5",
                "lalallalala",
                "lalalala",
                10000,
                "$");
        try {
            return proceedingJoinPoint.proceed(new Object[]{b2});
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }


    public void writeToFile(String auditEntry) {
        try {
            var p = Paths.get("C:\\Users\\cbadea\\OneDrive - ENDAVA\\Desktop\\VocalinkPresentation\\day2\\ex1\\src\\main\\java\\com\\example\\ex1\\audit\\bankAccountAudit.txt");
            Files.writeString(p, auditEntry, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
