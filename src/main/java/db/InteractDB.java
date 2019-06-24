package db;

import app.entities.Product;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

public class InteractDB implements Interact {
    /**
     *
     */
    private static InteractDB ourInstance = new InteractDB();
    private String userName;
    private String pass;
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/cash_machine";
    public static final String ROWSET_IMPL_CLASS = "com.sun.rowset.CachedRowSetImpl";
    private CachedRowSet cachedRowSet;

    public static InteractDB getInstance() {
        return ourInstance;
    }

    private InteractDB() {
        userName = "root";
        pass = "root";
        try {
            connection = DriverManager.getConnection(connectionUrl, userName, pass);
            statement = connection.createStatement();
            Class.forName("com.mysql.jdbc.Driver");
            Class c = Class.forName(ROWSET_IMPL_CLASS);
            try {
                cachedRowSet = (CachedRowSet) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            cachedRowSet.setUrl(connectionUrl);
            cachedRowSet.setUsername(userName);
            cachedRowSet.setPassword(pass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean setSQLCommandCached(String sqlCommand) {
        try {
            cachedRowSet.setCommand(sqlCommand);
            cachedRowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addProduct(Product product) {
        String sqlCommandProduct = "INSERT INTO products VALUE (" + product.getCode() + ",'" + product.getName() + "'," + product.getPrice() + ");";
        String sqlCommandStorage = "INSERT INTO storage_for_products (ProductCode) VALUES (" + product.getCode() + ");";
        return (setSQLCommandCached(sqlCommandProduct) && setSQLCommandCached(sqlCommandStorage));
    }


    @Override
    public boolean setQuantity(int amount, int code) {
        String sqlCommandStorage = "UPDATE storage_for_products SET Amount=" + amount + " WHERE ProductCode=" + code + ";";
        return setSQLCommandCached(sqlCommandStorage);
    }


    @Override
    public int createCheck(int idCashier) {
        String sqlCommandAddCheck = "INSERT INTO checks (IdCashier) VALUES (" + idCashier + ");";
        setSQLCommandCached(sqlCommandAddCheck);
        int id = getMaxIdForChecks();
        System.out.println("hrrr" + id);
        return id;
    }

    @Override
    public boolean addProduct(ResultSet resultSet, int code, int amount, int id) {
        int amountStorage = 0;
        try {
            while (resultSet.next()) {
                amountStorage = resultSet.getInt("Amount");
            }
            System.out.println(amountStorage);
            if (amount > amountStorage) {
                amount = amountStorage;
            }
            amountStorage -= amount;
            System.out.println(amountStorage);
            String sqlCommandModyAmount = "UPDATE storage_for_products SET Amount=" + amountStorage + " WHERE ProductCode=" + code + ";";
            statement.executeUpdate(sqlCommandModyAmount);
            String sqlCommandAddProduct = "INSERT INTO check_contents VALUE (" + id + "," + code + "," + amount + ");";
            statement.executeUpdate(sqlCommandAddProduct);
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ResultSet allProducts() {
        String sqlCommandSelectProducts="SELECT storage.Amount, storage.ProductCode, product.ProductName as ProductName\n" +
                "    FROM storage_for_products storage\n" +
                "    INNER JOIN products product ON storage.ProductCode =product.Code";
        ResultSet resultSet =null;
        try {
            resultSet = statement.executeQuery(sqlCommandSelectProducts);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public boolean addProduct(int code, int amount, int id) {
        Savepoint savepoint = null;
        System.out.println("this" + id);
        String sqlCommandSelectAmount = "SELECT Amount FROM storage_for_products WHERE ProductCode=" + code + ";";
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Savepoint");
            cachedRowSet.setCommand(sqlCommandSelectAmount);
            ResultSet resultSet = statement.executeQuery(sqlCommandSelectAmount);
            addProduct(resultSet, code, amount, id);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint);
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean addProduct(String name, int amount, int id) {
        Savepoint savepoint = null;

        try {
            connection.setAutoCommit(false);
            String sqlCommandSearchProductCode = "SELECT Code FROM products WHERE ProductName='" + name + "'";
            ResultSet resultSet = statement.executeQuery(sqlCommandSearchProductCode);
            int code = 0;
            while (resultSet.next()) {
                code = resultSet.getInt("Code");
            }
            String sqlCommandAddCheck = "SELECT Amount FROM storage_for_products WHERE ProductCode=" + code + ";";
            savepoint = connection.setSavepoint("Savepoint");
            resultSet = statement.executeQuery(sqlCommandAddCheck);
            addProduct(resultSet, code, amount, id);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint);
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public int getMaxIdForChecks() {
        int id = 0;
        String sqlCommandSelectAllFromCheck = "SELECT * FROM checks ORDER BY Id;";
        try {
            cachedRowSet.setCommand(sqlCommandSelectAllFromCheck);
            while (cachedRowSet.next()) {
                id = cachedRowSet.getInt("Id");
            }
            cachedRowSet.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }

    @Override
    public void selectSeniorCashier(int id) {

    }

    @Override
    public void addingToDocumentation(int numberOperation) {

    }

    @Override
    public boolean removeCheck(int idCheck) {
        String sqlCommandRemoveFromChecks = "DELETE FROM checks WHERE Id=" + idCheck + "";
        String sqlCommandRemoveFromCheckContents = "DELETE FROM check_contents WHERE IdCheck=" + idCheck + "";
        Savepoint savepoint = null;
        try {
            savepoint = connection.setSavepoint("Savepoint");
            connection.setAutoCommit(false);
            setSQLCommandCached(sqlCommandRemoveFromCheckContents);
            setSQLCommandCached(sqlCommandRemoveFromChecks);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint);
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean removeProduct(int idCheck, int idProduct) {
        String sqlCommandRemoveFromCheckContents = "DELETE FROM check_contents WHERE IdCheck=" + idCheck + " && ProductCode=" + idProduct + "";
        Savepoint savepoint = null;
        try {
            savepoint = connection.setSavepoint("Savepoint");
            connection.setAutoCommit(false);
            setSQLCommandCached(sqlCommandRemoveFromCheckContents);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
                return false;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return true;
    }

}
