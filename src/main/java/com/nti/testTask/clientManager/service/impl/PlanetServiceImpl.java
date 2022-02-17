package com.nti.testTask.clientManager.service.impl;

import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.models.Planet;
import com.nti.testTask.clientManager.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для обработки данных Planet
 */
@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetDao planetDao;

    /**
     * Добавление новой Планеты
     *
     * @param namePlanet Название планеты
     * @return Возвращает созданную планету
     */
    @Override
    public Planet addNewPlanet(String namePlanet) {
        return planetDao.addNewPlanet(namePlanet);
    }

    /**
     * Удаление Планеты
     *
     * @param idPlanet Id Планеты
     */
    @Override
    public void deletePlanet(long idPlanet) {
        planetDao.deletePlanet(idPlanet);
    }

    /**
     * Получение Планеты по Id
     *
     * @param id Id Планеты
     * @return Возвращает полученную планету
     */
    @Override
    public Planet getById(long id) {
        return planetDao.getById(id);
    }
}
