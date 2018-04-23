package gsu.edu.cis2370.DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;


public class AdminToDatabaseConnection {
	private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
  //Admins personal URL
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/AdventureAwaits\", \"root\", \"ch3y3nn3\"";
    //private static String username = User.getUsername(); 
    //private static String password = User.getPassword();
    //username, password

    //method to connect to the database
    public  Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
           Connection connection = DriverManager.getConnection(DATABASE_URL);
    
            System.out.println("database connection successful");
        }

        catch (Exception e) {
            e.printStackTrace();

            System.out.println("unable to connect to database");
        }
        return connection;
    }

}
