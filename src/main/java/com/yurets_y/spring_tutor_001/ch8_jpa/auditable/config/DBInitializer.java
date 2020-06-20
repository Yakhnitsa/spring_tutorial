package com.yurets_y.spring_tutor_001.ch8_jpa.auditable.config;


import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.Creator;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.entities.SingerAudit;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.repos.CreatorRepository;
import com.yurets_y.spring_tutor_001.ch8_jpa.auditable.repos.SingerAuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
@Service
public class DBInitializer {
	private Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
    SingerAuditRepository singerRepository;

	@Autowired
	CreatorRepository creatorRepository;

	@PostConstruct
	public void initDB(){
		logger.info("Starting database initialization...");

		logger.info("Add auditor...");

		Creator creator = new Creator();
		creator.setFirstName("Architect");
		creator.setLastName("Architect");
		creatorRepository.save(creator);
		logger.info(creator.toString());

		SingerAudit singer = new SingerAudit();
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1977, 9, 16)).getTime().getTime()));

		singerRepository.save(singer);

		singer = new SingerAudit();
		singer.setFirstName("Eric");
		singer.setLastName("Clapton");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1945, 2, 30)).getTime().getTime()));

		singerRepository.save(singer);

		singer = new SingerAudit();
		singer.setFirstName("John");
		singer.setLastName("Butler");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1975, 3, 1)).getTime().getTime()));

		singerRepository.save(singer);

		logger.info("Database initialization finished.");
	}

}
