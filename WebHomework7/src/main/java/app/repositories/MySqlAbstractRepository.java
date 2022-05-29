package app.repositories;

import java.sql.*;
import java.util.Optional;

public abstract class MySqlAbstractRepository {

    public MySqlAbstractRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection newConnection() throws SQLException {
        System.out.println((DriverManager.getConnection(
                "jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName(), this.getUsername(), this.getPassword())
        ));
        return DriverManager.getConnection(
                "jdbc:mysql://" + this.getHost() + ":" + this.getPort() + "/" + this.getDatabaseName(), this.getUsername(), this.getPassword()
        );
    }

    protected String getHost() {
        return "localhost";
    }

    protected int getPort() {
        return 3306;
    }

    protected String getDatabaseName() {
        return "test";
    }

    protected String getUsername() {
        return "djole";
    }

    protected String getPassword() {
        return "aleksa";
    }

    protected void closeStatement(Statement statement) {
        try {
            Optional.of(statement).get().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    protected void closeResultSet(ResultSet resultSet) {
        try {
            Optional.of(resultSet).get().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            Optional.of(connection).get().close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
