package repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysql")
public class MySqlDbConnection implements DBConnection{
    @Override
    public void connectToDb() {
        System.out.println("Connecting to database via MySql....");
    }
}
