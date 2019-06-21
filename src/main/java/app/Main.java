package app;

import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import log.BdLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static BdLogic logic;

    public static void main(String[] args) throws ClassNotFoundException {
        logic = new BdLogic();
        connectAndUpdateBd();
    }


    private static void connectAndUpdateBd() throws ClassNotFoundException {
        String userName = "root";
        String pass = "root";
        String connectionUrl = "jdbc:mysql://localhost:3306/cash_machine";
        Class.forName("com.mysql.jdbc.Driver");
        String sqlCommand = "CREATE TABLE products (code INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, pass)) {
            logic.doConnectToBd();
            logic.successfulConnectionToBd();
            updateBd(sqlCommand, connection);
        } catch (SQLException e) {
            logic.unsuccessfulConnectionToBd(e);
        }
    }

    private static void updateBd(String sqlCommand, Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlCommand);
            logic.successfulUpdateBd();
        } catch (MySQLNonTransientConnectionException e) {
            System.out.println("djn");
            logic.showException(e);
        } catch (MySQLSyntaxErrorException e) {
            logic.unsuccessfulUpdateBd(e);
        } catch (SQLException e) {
            logic.showException(e);
        }


    }


}
