package com.yurets_y.spring_tutor_001.ch8_jpa.service;

import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Album;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Album_;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer;
import com.yurets_y.spring_tutor_001.ch8_jpa.entities.Singer_;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {
    final static String ALL_SINGER_NATIVE_QUERY =
        "SELECT id, first_name, last_name, birth_date, version FROM singer";

    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

    @PersistenceContext
    private EntityManager em;


    @Transactional(readOnly=true)
    @Override
    public List<Singer> findAll() {
        return em.createNamedQuery(Singer.FIND_ALL, Singer.class).getResultList();
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Singer> findAllWithAlbum() {
        List<Singer> singers = em.createNamedQuery(Singer.FIND_ALL_WITH_ALBUM, Singer.class).getResultList();
        return singers;
    }

    @Transactional(readOnly=true)
    @Override
    public Singer findById(Long id) {
        TypedQuery<Singer> query = em.createNamedQuery(Singer.FIND_SINGER_BY_ID, Singer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Singer save(Singer singer) {
        if (singer.getId() == null) {
            logger.info("Inserting new singer");
            em.persist(singer);
        } else {
            em.merge(singer);
            logger.info("Updating existing singer");
        }

        logger.info("Singer saved with id: " + singer.getId());

        return singer;
    }

    @Override
    public void delete(Singer singer) {
        Singer mergedContact = em.merge(singer);
        em.remove(mergedContact);

        logger.info("Singer with id: " + singer.getId()  + " deleted successfully");
    }

    @Transactional(readOnly=true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, Singer.class).getResultList();
//        Возвращение результата Native query с преобразованием в класс, с использованием @SqlResultSetMapping под именем singerResult
//        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult").getResultList();
    }

    @Transactional(readOnly=true)
    @Override
    // Для работы необходим hibernate-jpamodelgen, см README.md
    public List<Singer> findByCriteriaQuery(String firstName, String lastName) {
        logger.info("Finding singer for firstName: " + firstName
                + " and lastName: " + lastName);

//        Получение фабрики критериев
        CriteriaBuilder cb = em.getCriteriaBuilder();
//        Создание типизированного запроса
        CriteriaQuery<Singer> criteriaQuery = cb.createQuery(Singer.class);
        Root<Singer> singerRoot = criteriaQuery.from(Singer.class);
        /* Подгружаем к результату выборки списки инструментов и альбомов
        * Без данных манипуляций попытка доступа к Singer.albums или Singer.instruments
        * завершится org.hibernate.LazyInitializationException
        * */
        singerRoot.fetch(Singer_.albums, JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments, JoinType.LEFT);
//      Исключение дублирующихся значений из выборки
        criteriaQuery.select(singerRoot).distinct(true);

        Predicate criteria = cb.conjunction();

        if (firstName != null) {
//            Выборка по критерию equal для имени пользователя
            Predicate p = cb.equal(singerRoot.get(Singer_.firstName),
                    firstName);
            criteria = cb.and(criteria, p);
        }

        if (lastName != null) {
            Predicate p = cb.equal(singerRoot.get(Singer_.lastName),
                    lastName);
            criteria = cb.and(criteria, p);
        }

        criteriaQuery.where(criteria);

        return em.createQuery(criteriaQuery).getResultList();
    }

    /*
    * Выборка списка певцов по дате последнего альбома
    */
    public List<Album> findByAlbumPeriod(Date from, Date until){
        //        Получение фабрики критериев
        CriteriaBuilder cb = em.getCriteriaBuilder();
//        Создание типизированного запроса
        CriteriaQuery<Album> criteriaQuery = cb.createQuery(Album.class);
        Root<Album> albumRoot = criteriaQuery.from(Album.class);

        albumRoot.fetch(Album_.singer, JoinType.LEFT);

        Predicate criteria = cb.conjunction();

        if (from != null) {
//            Выборка по критерию equal для имени пользователя
            Predicate p = cb.greaterThan(albumRoot.get(Album_.releaseDate),
                    from);
            criteria = cb.and(criteria, p);
        }
        if (until != null) {
//            Выборка по критерию equal для имени пользователя
            Predicate p = cb.lessThan(albumRoot.get(Album_.releaseDate),
                    until);
            criteria = cb.and(criteria, p);
        }
        criteriaQuery.where(criteria);

        return em.createQuery(criteriaQuery).getResultList();
    }
}
