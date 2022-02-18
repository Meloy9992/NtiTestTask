package com.nti.testTask.clientManager.service.impl;

import com.nti.testTask.clientManager.dao.LordDao;
import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.dao.impl.LordDaoImpl;
import com.nti.testTask.clientManager.dao.impl.PlanetDaoImpl;
import com.nti.testTask.clientManager.models.Planet;
import com.nti.testTask.clientManager.service.LordService;
import com.nti.testTask.clientManager.service.PlanetService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(PowerMockRunner.class)
class PlanetServiceImplTest {

    private PlanetDao planetDao = PowerMockito.mock(PlanetDaoImpl.class);
    private PlanetService planetService = PowerMockito.spy(new PlanetServiceImpl(planetDao));


    @Test
    void addNewPlanet() {
        Planet planet = PowerMockito.mock(Planet.class);
        PowerMockito.when(planetDao.addNewPlanet(Mockito.anyString())).thenReturn(planet);
        Planet returnedPlanet = planetService.addNewPlanet("Mars");
        Assert.assertEquals(planet,returnedPlanet);
    }

    @Test
    void deletePlanet(){
        PowerMockito.when(planetDao.deletePlanet(Mockito.anyLong())).thenReturn(true);
        boolean isDelete = planetService.deletePlanet(4);
        Assert.assertTrue(isDelete);

    }

    @Test
    void getById() {
        Planet planet = PowerMockito.mock(Planet.class);
        PowerMockito.when(planetDao.getById(Mockito.anyLong())).thenReturn(planet);
        Planet returnedPlanet = planetService.getById(5);
        Assert.assertEquals(planet, returnedPlanet);
    }
}