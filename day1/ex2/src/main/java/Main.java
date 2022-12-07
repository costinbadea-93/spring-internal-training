import context_configuration.ContextConfig;
import model.BankAccount;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankAccountService;

public class Main {
    public static void main(String[] args) {
           var context = new AnnotationConfigApplicationContext(ContextConfig.class);

           var bankAccount = new BankAccount("000000A501C5",
                   "BankAcc1",
                   "Saving account",
                   20000,
                   "$");

           System.out.println("Retrieving bankAccountService bean from context");
           var bankAccountServiceA = context.getBean(BankAccountService.class);
//           var bankAccountServiceB = context.getBean(BankAccountService.class);
           bankAccountServiceA.connectAndSaveBankAccount(bankAccount);
           bankAccountServiceA.connectAndSaveBankAccount(bankAccount);
//           System.out.println(bankAccountServiceB.hashCode());
        bankAccountServiceA.connectAndSaveBankAccount(bankAccount);

       /**
         *  lazy
         *  eager
         */

        /**
         * injectarea de prototype in singleton face ca beanul prototype sa devina singleton
         */

    }
}
