package db;

import app.entities.Product;

import java.sql.*;

public  class InteractDB implements Interact {
    /**
     *
     */
    private static InteractDB ourInstance = new InteractDB();
  //  private static BdLogic logic;
    String userName;
    String pass;
    Connection connection;
    Statement statement;
    String connectionUrl = "jdbc:mysql://localhost:3306/cash_machine";
    public static InteractDB getInstance() {
        return ourInstance;
    }

    protected InteractDB() {
      //  logic = new BdLogic();
        userName = "root";
        pass = "root";
        try {
            connection = DriverManager.getConnection(connectionUrl, userName, pass);
            statement = connection.createStatement();
            Class.forName("com.mysql.jdbc.Driver");
        } catch (SQLException e) {
      //      logic.showException(e);
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
     //       logic.showException(e);
            e.printStackTrace();
        }
    }


    @Override
    public void addProduct(Product product) {
        String sqlCommandProduct = "INSERT INTO products VALUE ("+product.getCode()+",'"+product.getName()+"',"+product.getPrice()+");";
        String sqlCommandStorage= "INSERT INTO storage_for_products (ProductCode) VALUES ("+product.getCode()+");";
        try {
            statement.executeUpdate(sqlCommandProduct);
            statement.executeUpdate(sqlCommandStorage);
            System.out.println(product.getCode()+" "+product.getName());
        } catch (SQLException e) {
     //       logic.showException(e);
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void select(Object o) {

    }

    @Override
    public void setQuantity(int amount,int code) {
        String sqlCommandStorage= "UPDATE storage_for_products SET Amount="+amount+" WHERE ProductCode="+code+";";
        System.out.println(amount+" "+code);
        try {
            statement.executeUpdate(sqlCommandStorage);
        } catch (SQLException e) {
            //       logic.showException(e);
            e.printStackTrace();
        }
    }


    @Override
    public int createCheck(int idCashier) {
        int id=getMaxIdForChecks();
        String sqlCommandSelectAll= "SELECT * FROM checks;";
        try {
            String sqlCommandAddCheck= "INSERT INTO checks (IdCashier) VALUES ("+idCashier+");";
            statement.executeUpdate(sqlCommandAddCheck);
        } catch (SQLException e) {
            //       logic.showException(e);
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void addProduct(int code, int amount,int id) {
        Savepoint savepoint=null;
        String sqlCommandAddCheck= "SELECT Amount FROM storage_for_products WHERE ProductCode="+code+";";
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Savepoint");
            ResultSet resultSet = statement.executeQuery(sqlCommandAddCheck);
            int amountStorage=0;
            while (resultSet.next()) {
                amountStorage = resultSet.getInt("Amount");
            }
            System.out.println(amountStorage);
            if(amount>amountStorage){
                amount=amountStorage;
            }
            amountStorage-=amount;
            System.out.println(amountStorage);
            String sqlCommandModyAmount= "UPDATE storage_for_products SET Amount="+amountStorage+" WHERE ProductCode="+code+";";
            statement.executeUpdate(sqlCommandModyAmount);
            String sqlCommandAddProduct= "INSERT INTO check_contents VALUE ("+id+","+code+","+amount+");";
            statement.executeUpdate(sqlCommandAddProduct);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void addProduct(String name, int amount, int id) {
        Savepoint savepoint=null;

        try {
            connection.setAutoCommit(false);
            String sqlCommandSearchProductCode="SELECT Code FROM products WHERE ProductName='"+name+"'";
            ResultSet resultSet = statement.executeQuery(sqlCommandSearchProductCode);
            int code=0;
            while (resultSet.next()) {
                code = resultSet.getInt("Code");
            }
            String sqlCommandAddCheck= "SELECT Amount FROM storage_for_products WHERE ProductCode="+code+";";
            savepoint = connection.setSavepoint("Savepoint");
            resultSet = statement.executeQuery(sqlCommandAddCheck);
            int amountStorage=0;
            while (resultSet.next()) {
                amountStorage = resultSet.getInt("Amount");
            }
            System.out.println(amountStorage);
            if(amount>amountStorage){
                amount=amountStorage;
            }
            amountStorage-=amount;
            System.out.println(amountStorage);
            String sqlCommandModyAmount= "UPDATE storage_for_products SET Amount="+amountStorage+" WHERE ProductCode="+code+";";
            statement.executeUpdate(sqlCommandModyAmount);
            String sqlCommandAddProduct= "INSERT INTO check_contents VALUE ("+id+","+code+","+amount+");";
            statement.executeUpdate(sqlCommandAddProduct);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback(savepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int getMaxIdForChecks() {
        int id=0;
        String sqlCommandSelectAll= "SELECT * FROM checks ORDER BY Id;";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sqlCommandSelectAll);
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void selectSeniorCashier(int id){

    }

    @Override
    public void addingToDocumentation(int numberOperation) {

    }

    @Override
    public void removeCheck(int idCheck) {
        String sqlCommandRemoveFromChecks= "DELETE FROM checks WHERE Id="+idCheck+"";
        String sqlCommandRemoveFromCheckContents= "DELETE FROM check_contents WHERE IdCheck="+idCheck+"";
        Savepoint savepoint=null;
        try {
            savepoint= connection.setSavepoint("Savepoint");
            connection.setAutoCommit(false);
            statement.executeUpdate(sqlCommandRemoveFromCheckContents);
            statement.executeUpdate(sqlCommandRemoveFromChecks);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

}
