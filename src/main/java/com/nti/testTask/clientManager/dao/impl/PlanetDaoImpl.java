package com.nti.testTask.clientManager.dao.impl;

import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.models.Planet;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import static com.nti.testTask.utils.HibernateUtil.getSessionFactory;

/**
 * Доступ к данным Planet
 */

@Repository
public class PlanetDaoImpl implements PlanetDao {

    /**
     * Добавление новой Планеты
     *
     * @param namePlanet Название планеты
     * @return Возвращает созданную планету
     */
    @Override
    public Planet addNewPlanet(String namePlanet) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Planet planet = new Planet(namePlanet);
        session.save(planet);
        session.getTransaction().commit();
        session.close();
        return planet;
    }

    /**
     * Удаление Планеты
     *
     * @param idPlanet Id Планеты
     */
    @Override
    public void deletePlanet(long idPlanet) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(getById(idPlanet));
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Получение Планеты по Id
     *
     * @param id Id Планеты
     * @return Возвращает полученную планету
     */
    @Override
    public Planet getById(long id) {
        Session session = getSessionFactory().openSession();
        Planet planet = (Planet) session.createQuery("FROM Planet WHERE id = " + id).list().get(0);
        session.close();
        return planet;
    }
}
