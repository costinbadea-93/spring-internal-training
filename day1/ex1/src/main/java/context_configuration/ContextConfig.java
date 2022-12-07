package context_configuration;

import model.BankAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ContextConfig {

//    @Bean(name = "myBankAccount")
    @Bean
    public BankAccount bankAccountA() {
        return new BankAccount("000000A501C5",
                "BankAcc1",
                "Saving account",
                20000,
                "$");
    }

    @Bean
    @Primary
    public BankAccount bankAccountB() {
        return new BankAccount("000000A502C5",
                "BankAcc2",
                "Checking account",
                1000,
                "$");
    }
}
