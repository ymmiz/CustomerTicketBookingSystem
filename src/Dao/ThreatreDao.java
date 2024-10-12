package Dao;

import Model.Theatre;
import database.PgSqlConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThreatreDao extends AbstractDao<Theatre> {

    private PgSqlConnectionFactory connectionFactory;//database nae chate pyy foh
    private CinemaDao cinemaDao;
    public ThreatreDao() {
        this.connectionFactory = new PgSqlConnectionFactory();
        this.cinemaDao = new CinemaDao();
    }
    @Override
    public Theatre findById(int id) throws SQLException {
        String query = "select * from threatres where id = ?";
        Connection connection = this.connectionFactory.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Theatre theatre = new Theatre();
            theatre.setId(resultSet.getInt("id"));
            theatre.setName(resultSet.getString("name"));
            theatre.setCinema(this.cinemaDao.findById(resultSet.getInt("cinema_id")));
            return theatre;
        }
        return null;
    }

    @Override
    public List<Theatre> getAll() throws SQLException {
        String query = "select * from threatres";
        List<Theatre> theatres = new ArrayList<>();
        Connection connection = this.connectionFactory.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Theatre theatre = new Theatre();
            theatre.setId(resultSet.getInt("id"));
            theatre.setName(resultSet.getString("name"));
            theatre.setCinema(this.cinemaDao.findById(resultSet.getInt("cinema_id")));
            theatres.add(theatre);
        }
        return theatres;
    }

    @Override
    public void create(Theatre theatre) throws SQLException {
        String query = "insert into threatres (name, cinema_id) values (?, ?)";
        Connection connection = this.connectionFactory.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, theatre.getName());
        preparedStatement.setInt(2, theatre.getCinema().getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(Theatre theatre) throws SQLException {
        String query = "delete from threatres where id = ?";
        Connection connection = this.connectionFactory.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, theatre.getId());
        preparedStatement.executeUpdate();
    }
}
