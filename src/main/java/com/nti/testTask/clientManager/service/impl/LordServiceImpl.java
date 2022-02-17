package com.nti.testTask.clientManager.service.impl;

import com.nti.testTask.clientManager.dao.LordDao;
import com.nti.testTask.clientManager.models.Lord;
import com.nti.testTask.clientManager.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис для обработки данных Lord
 */
@Service
public class LordServiceImpl implements LordService {

    @Autowired
    private LordDao lordDao;

    /**
     * Добавляет нового пользователя в базу данных
     *
     * @param name Имя Повелителя
     * @param age  Возраст Повелителя
     * @return Возвращает повелителя
     */
    @Override
    public Lord addNewLord(String name, long age) {
        return lordDao.addNewLord(name, age);
    }

    /**
     * Назначение Повелителя управлять Планетой
     *
     * @param idLord   Id Повелителя
     * @param idPlanet Id Планеты
     */
    @Override
    public void appointLord(long idLord, long idPlanet) {
        lordDao.appointLord(idLord, idPlanet);
    }

    /**
     * Поиск всех Повелителей без планет
     *
     * @return Возвращает список Повелителей без планет
     */
    @Override
    public List<Lord> searchAllLordLazy() {
        return lordDao.searchAllLordLazy();
    }

    /**
     * Поиск топ 10 молодых Повелителей
     *
     * @return Возвращает список Повелителей
     */
    @Override
    public List<Lord> searchTopTenYoungLords() {
        return lordDao.searchTopTenYoungLords();
    }

    /**
     * Получение Повелителя по Id
     *
     * @param id Id Повелителя
     * @return Возвращает созданного Повелителя
     */
    @Override
    public Lord getById(long id) {
        return lordDao.getById(id);
    }
}
