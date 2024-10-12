package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.Cinema;
import database.PgSqlConnectionFactory;

public class CinemaDao extends AbstractDao<Cinema>{

    private PgSqlConnectionFactory connectionFactory;

    public CinemaDao() {
        this.connectionFactory =new PgSqlConnectionFactory();
    }

    @Override
    public Cinema findById(int id) throws SQLException {
        String query ="select *from cinemas where id =?";
        Connection connection = this.connectionFactory.createConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet =preparedStatement.executeQuery();
        if (resultSet.next()) {
            Cinema cinema =new Cinema();
            cinema.setId(resultSet.getInt("id"));
            cinema.setName(resultSet.getString("name"));
            //cinema.setAddress(resultSet.getString("address"));
            return cinema;
        }
        return null;
    }

    @Override
    public List<Cinema> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void create(Cinema entity) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Cinema entity) throws SQLException {
        // TODO Auto-generated method stub

    }

}

