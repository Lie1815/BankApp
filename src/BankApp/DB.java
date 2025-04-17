package BankApp;

import java.sql.*;

public class DB {
    private final String host = "localhost";
    private final String port = "5432";
    private String db_name = "postgres1";
    private final String login ="postrges";
    private final String password = "";

    private Connection dbConn;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String str = "jdbc:postgresql://" + host + ":" + port + "/" + db_name;
        Class.forName("org.postgresql.Driver");
        dbConn = DriverManager.getConnection(str, login, password);
        return  dbConn;
    }

    public void isConnection()throws SQLException, ClassNotFoundException{
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }
    public void InsertTable(String tableName, String firstInsert, String secondInsert, String thirdInsert) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO " + tableName + " VALUES " + "(" + "'" + firstInsert + "'" + ", " + "'" + secondInsert + "'" + ", " + "'" + thirdInsert + "'" + ")";
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }
    public double SelectFromTable(String tableName, int accountNumber) throws SQLException, ClassNotFoundException {
        Statement statement = getDbConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT balance FROM " + tableName + " WHERE account_number = " + accountNumber);
        double balance = 0;
        while (resultSet.next()) {
            balance = resultSet.getInt(1);
            System.out.printf("%s \n", balance);

        }
        return balance;
    }

    public void UpdateTablePlus(String tableName, int account, int amount) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE " + tableName + " SET balance = (SELECT balance from " + tableName + " WHERE account_number = " + account + ") + " + amount + " WHERE account_number = " + account;
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);

    }

    public void UpdateTableMinus(String tableName, int account, int amount) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE " + tableName + " SET balance = (SELECT balance from " + tableName + " WHERE account_number = " + account + ") - " + amount + " WHERE account_number = " + account;
        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);

    }

}
