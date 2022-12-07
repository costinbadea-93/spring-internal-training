package repository;

import model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Scope("prototype")
public class BankAccountRepository {

    private String connectionDateTime;
    /**
     * constructor
     */
    private final DBConnection dbConnection;

    @Autowired
    public BankAccountRepository( @Qualifier("oracle") DBConnection dbConnection) {
        this.dbConnection = dbConnection;
        connectionDateTime = LocalDateTime.now().toString();
        System.out.println("Creating Bank Account Service bean!!!");

    }

    public void connectAndSaveToDb(BankAccount bankAccount){
        System.out.println("Connecting db at " + connectionDateTime);
        dbConnection.connectToDb();
    }
}
