package com.nti.testTask.clientManager.dao.impl;

import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.models.Planet;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import static com.nti.testTask.utils.HibernateUtil.getSessionFactory;

@Repository
public class PlanetDaoImpl implements PlanetDao {
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

    @Override
    public void deletePlanet(long idPlanet) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(getById(idPlanet));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Planet getById(long id) {
        Session session = getSessionFactory().openSession();
        Planet planet = (Planet) session.createQuery("FROM Planet WHERE id = " + id).list().get(0);
        session.close();
        return planet;
    }
}
