package com.yurets_y.spring_tutor_001.ch6_jdbc.dao;

import com.yurets_y.spring_tutor_001.ch6_jdbc.dao.SingerDao;
import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcSingerDao implements SingerDao, InitializingBean {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override public String findNameById(Long id) {
		return jdbcTemplate.queryForObject(
				"select first_name || ' ' || last_name from singer where id = ?",
				new Object[]{id}, String.class);
	}

	@Override
	public String findFirstNameById(Long id) {
		return jdbcTemplate.queryForObject(
				"select first_name from singer where id = ?",
				new Object[]{id}, String.class);
	}

	@Override public List<Singer> findAll() {
		throw new RuntimeException("findAll");
	}

	@Override public List<Singer> findByFirstName(String firstName) {
		throw new RuntimeException("findByFirstName");
	}

	@Override public String findLastNameById(Long id) {
		throw new RuntimeException("findLastNameById");
	}

	@Override public void insert(Singer singer) {
		throw new RuntimeException("insert");
	}

	@Override public void update(Singer singer) {
		throw new RuntimeException("update");
	}

	@Override public void delete(Long singerId) {
		throw new RuntimeException("delete");
	}

	@Override public List<Singer> findAllWithAlbums() {
		throw new RuntimeException("findAllWithAlbums");
	}

	@Override public void insertWithAlbum(Singer singer) {
		throw new RuntimeException("insertWithAlbum");
	}

	@Override public void afterPropertiesSet() throws Exception {
		if (jdbcTemplate == null) {
			throw new BeanCreationException("Null JdbcTemplate on SingerDao");
		}
	}

}
