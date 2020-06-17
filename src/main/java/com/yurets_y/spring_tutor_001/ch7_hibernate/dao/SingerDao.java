package com.yurets_y.spring_tutor_001.ch7_hibernate.dao;



import com.yurets_y.spring_tutor_001.ch7_hibernate.entities.Album;
import com.yurets_y.spring_tutor_001.ch7_hibernate.entities.Singer;

import java.util.List;

/**
 *
 */
public interface SingerDao {

	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);

	List<Album> findAllAlbums();
}
