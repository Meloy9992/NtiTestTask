package com.nti.testTask.clientManager.dao.impl;

import com.nti.testTask.clientManager.dao.LordDao;
import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.models.Lord;
import com.nti.testTask.clientManager.models.Planet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.nti.testTask.utils.HibernateUtil.getSessionFactory;

/**
 * Доступ к данным Lord
 */

@Repository
public class LordDaoImpl implements LordDao {

    @Autowired
    private PlanetDao planetDao;


    /**
     * Добавляет нового пользователя в базу данных
     *
     * @param name Имя Повелителя
     * @param age  Возраст Повелителя
     * @return Возвращает повелителя
     */
    @Override
    public Lord addNewLord(String name, long age) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Lord lord = new Lord(name, age);
        session.save(lord);
        session.getTransaction().commit();
        session.close();
        return lord;
    }

    /**
     * Назначение Повелителя управлять Планетой
     *
     * @param idLord   Id Повелителя
     * @param idPlanet Id Планеты
     */
    @Override
    public void appointLord(long idLord, long idPlanet) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Lord lord = getById(idLord);
        Planet planet = planetDao.getById(idPlanet);
        List<Planet> planetsCopy = new ArrayList<>(lord.getPlanets());
        planetsCopy.add(planet);
        lord.setPlanets(planetsCopy);
        planet.setLord(lord);
        session.saveOrUpdate(lord);
        session.saveOrUpdate(planet);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Поиск всех Повелителей без планет
     *
     * @return Возвращает список Повелителей без планет
     */
    @Override
    public List<Lord> searchAllLordLazy() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Lord.class);
        criteria.add(Restrictions.sizeEq("planets", 0));
        List<Lord> lords = criteria.list();
        session.close();
        return lords;
    }

    /**
     * Поиск топ 10 молодых Повелителей
     *
     * @return Возвращает список Повелителей
     */
    @Override
    public List<Lord> searchTopTenYoungLords() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Lord.class);
        criteria.addOrder(Order.asc("age"));
        criteria.setMaxResults(10);
        List<Lord> lords = criteria.list();
        session.close();
        return lords;
    }

    /**
     * Получение Повелителя по Id
     *
     * @param id Id Повелителя
     * @return Возвращает созданного Повелителя
     */
    @Override
    public Lord getById(long id) {
        Session session = getSessionFactory().openSession();
        Lord lord = (Lord) session.createQuery("FROM Lord WHERE id = " + id).list().get(0);
        session.close();
        return lord;
    }
}
