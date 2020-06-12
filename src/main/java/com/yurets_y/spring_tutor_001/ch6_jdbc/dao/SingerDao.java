package com.yurets_y.spring_tutor_001.ch6_jdbc.dao;


import com.yurets_y.spring_tutor_001.ch6_jdbc.entities.Singer;

import java.util.List;

public interface SingerDao {

	List<Singer> findAll();

	List<Singer> findByFirstName(String firstName);

	String findNameById(Long id);

	String findLastNameById(Long id);

	String findFirstNameById(Long id);

	void insert(Singer singer);

	void update(Singer singer);

	void delete(Long singerId);

	List<Singer> findAllWithAlbums();

	void insertWithAlbum(Singer singer);
}

