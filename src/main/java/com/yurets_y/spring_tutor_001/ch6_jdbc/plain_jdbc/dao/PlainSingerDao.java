package com.yurets_y.spring_tutor_001.ch6_jdbc.plain_jdbc.dao;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainSingerDao implements SingerDao {

	private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			logger.error("Problem loading DB dDiver!", ex);
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/TESTDB?useSSL=true",
				"developer", "password");
	}

	private void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		}
		try {
			connection.close();
		} catch (SQLException ex) {
			logger.error("Problem closing connection to the database!",ex);
		}
	}

	@Override
	public List<Singer> findAll() {
		List<Singer> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement =
					connection.prepareStatement("select * from singer");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Singer singer = new Singer();
				singer.setId(resultSet.getLong("id"));
				singer.setFirstName(resultSet.getString("first_name"));
				singer.setLastName(resultSet.getString("last_name"));
				singer.setBirthDate(resultSet.getDate("birth_date"));
				result.add(singer);
			}
			statement.close();
		} catch (SQLException ex) {
			logger.error("Problem when executing SELECT!",ex);
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public void insert(Singer singer) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into Singer (first_name, last_name, birth_date) values (?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, singer.getFirstName());
			statement.setString(2, singer.getLastName());
			statement.setDate(3, singer.getBirthDate());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				singer.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException ex) {
			logger.error("Prblem executing INSERT", ex);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public void delete(Long singerId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from singer where id=?");
			statement.setLong(1, singerId);
			statement.execute();
		} catch (SQLException ex) {
			logger.error("Problem executing DELETE", ex);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		throw new RuntimeException("findByFirstName");
	}

	@Override
	public String findFirstNameById(Long id) {
		throw new RuntimeException("findFirstNameById");
	}

	@Override
	public String findLastNameById(Long id) {
		throw new RuntimeException("findLastNameById");
	}

	@Override
	public void update(Singer singer) {
		throw new RuntimeException("update");
	}

	@Override public List<Singer> findAllWithAlbums() {
		throw new RuntimeException("findAllWithAlbums");
	}

	@Override public void insertWithAlbum(Singer singer) {
		throw new RuntimeException("insertWithAlbum");
	}

	@Override public String findNameById(Long id) {
		throw new RuntimeException("findNameById");
	}
}
