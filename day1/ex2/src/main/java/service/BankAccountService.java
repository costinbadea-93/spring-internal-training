package service;

import model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import repository.BankAccountRepository;
import repository.DBConnection;
import repository.MySqlDbConnection;

@Service
//@Lazy
//@Scope("prototype")
public abstract class BankAccountService {

    /**
     * @Autowired to inject a bean
     * into another bean
     *
     * we can use autowired on:
     * -field
     * -constructor
     * -setter
     */

    /**
     * field
     */
//    @Autowired
//    private MySqlDbConnection mySqlDbConnection;


    /**
     *
     * SINGLETON - o singura instanta(pe contextul de spring)
     * prototype - o noua instanta de bean la fiecare cere
     *
     */
        private BankAccountRepository bankAccountRepository;

        public BankAccountService(BankAccountRepository bankAccountRepository) {
            this.bankAccountRepository = bankAccountRepository;
        }
    /**
     *setter
     *
     */
//    private  MySqlDbConnection mySqlDbConnection;

    @Lookup
    public abstract BankAccountRepository bankAccountRepository();

    public void connectAndSaveBankAccount(BankAccount bankAccount){
        var bar = bankAccountRepository();
        bar.connectAndSaveToDb(bankAccount);
        System.out.println(bar.hashCode());
        System.out.println("Saving ...." + bankAccount);
    }
//
//    @Autowired
//    public void setMySqlDbConnection(MySqlDbConnection mySqlDbConnection) {
//        this.mySqlDbConnection = mySqlDbConnection;
//    }
}
