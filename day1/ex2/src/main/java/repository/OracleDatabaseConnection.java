package repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("oracle")
public class OracleDatabaseConnection implements DBConnection{
    @Override
    public void connectToDb() {
        System.out.println("Connecting to database via Oracle....");
    }
}
