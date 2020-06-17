package com.yurets_y.spring_tutor_001.ch8_jpa.test;

import com.yurets_y.spring_tutor_001.ch8_jpa.config.DataJpaConfig;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Album;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EntityManagerTest {

    @Test
    public void sqlResultSetMappingTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();
        List<String> names = em.createNamedQuery("SingerNamesQuery").getResultList();
        names.forEach(System.out::println);

        List<Singer.SingerIdName> singers = em.createNamedQuery("SingerNamesAndIdQuery",Singer.SingerIdName.class).getResultList();

        singers.forEach(System.out::println);
    }
}
