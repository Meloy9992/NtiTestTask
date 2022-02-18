package com.nti.testTask.clientManager.service;

import com.nti.testTask.clientManager.models.Planet;

public interface PlanetService {
    Planet addNewPlanet(String namePlanet);

    boolean deletePlanet(long idPlanet);

    Planet getById(long id);
}