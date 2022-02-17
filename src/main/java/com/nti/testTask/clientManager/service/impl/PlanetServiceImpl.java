package com.nti.testTask.clientManager.service.impl;

import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.models.Planet;
import com.nti.testTask.clientManager.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetDao planetDao;

    @Override
    public Planet addNewPlanet(String namePlanet) {
        return planetDao.addNewPlanet(namePlanet);
    }

    @Override
    public void deletePlanet(long idPlanet) {
        planetDao.deletePlanet(idPlanet);
    }

    @Override
    public Planet getById(long id) {
        return planetDao.getById(id);
    }
}
