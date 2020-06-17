package com.yurets_y.spring_tutor_001.ch8_jpa.service;


import com.yurets_y.spring_tutor_001.ch8_jpa.dto.SingerSummary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("singerSummaryService")
@Repository
@Transactional
public class SingerSummaryServiceImpl implements SingerSummaryService {

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<SingerSummary> findAll() {

		/*Выборка данных из базы по последнему альбому и запись в класс dto с помощью конструктора*/
		String lastAlbumQuery = "select new com.yurets_y.spring_tutor_001.ch8_jpa.dto.SingerSummary("
				+ "s.firstName, s.lastName, a.title, a.releaseDate) from Singer s "
				+ "left join s.albums a "
				+ "where a.releaseDate=(select max(a2.releaseDate) from Album a2 where a2.singer.id = s.id)";
		List<SingerSummary> result = em.createQuery(
				lastAlbumQuery,
				SingerSummary.class).getResultList();
		return result;
	}
}
