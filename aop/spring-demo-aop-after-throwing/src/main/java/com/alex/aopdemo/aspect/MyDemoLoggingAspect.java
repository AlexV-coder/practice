package com.alex.aopdemo.aspect;

import com.alex.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.alex.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>> The exception is: " + exc);
    }

    @AfterReturning(
            pointcut = "execution(* com.alex.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>> Result is: " + result);

        // let's post-process the data ..

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for(Account account : result) {

            // get uppercase version of name
            String upperCaseName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperCaseName);
        }
    }

    @Before("com.alex.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=======>>> Executing @Before advice on method");

        // display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for(Object arg : args) {
            System.out.println(arg);
            if(arg instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }
}
