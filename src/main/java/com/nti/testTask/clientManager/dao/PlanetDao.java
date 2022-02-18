package com.nti.testTask.clientManager.dao;

import com.nti.testTask.clientManager.models.Planet;

public interface PlanetDao {
    Planet addNewPlanet(String namePlanet);

    boolean deletePlanet(long idPlanet);

    Planet getById(long id);
}
