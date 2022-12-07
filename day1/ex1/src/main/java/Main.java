import context_configuration.ContextConfig;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * IOC(inversion of control) -> DI(dep. inj)
         *
         * AOP(aspect oriented programming)
         */

//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(ContextConfig.class);

        var context = new AnnotationConfigApplicationContext(ContextConfig.class);
        /**
         * Retrieve a bean from context:
         * -byName (need implicit cast)
         * -byClass
         */

//        var bankAccountA = (BankAccount) context.getBean("bankAccountA");
//        var bankAccountB = (BankAccount) context.getBean("bankAccountB");

        var bankAccountA = context.getBean(BankAccount.class);

        printBankAccountDetails(bankAccountA);
//        printBankAccountDetails(bankAccountB);
//        List<Integer> list = new ArrayList<>();
//        var list2 = new ArrayList<Integer>();
//        list2.add(1);
//        list2.add(3.4);

    }

    private static void printBankAccountDetails(BankAccount bankAccount) {
        System.out.println("========================");
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Account Type: " + bankAccount.getAccountType());
        System.out.println("Account Name: " + bankAccount.getName());
        System.out.println("Account Balance: " + bankAccount.getBalance() + bankAccount.getCurrency());
        System.out.println("========================");
    }
}
