package com.nti.testTask.clientManager.service.impl;

import com.nti.testTask.clientManager.dao.LordDao;
import com.nti.testTask.clientManager.models.Lord;
import com.nti.testTask.clientManager.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LordServiceImpl implements LordService {

    @Autowired
    private LordDao lordDao;

    @Override
    public Lord addNewLord(String name, long age) {
        return lordDao.addNewLord(name, age);
    }

    @Override
    public void appointLord(long idLord, long idPlanet) {
        lordDao.appointLord(idLord, idPlanet);
    }

    @Override
    public List<Lord> searchAllLordLazy() {
        return lordDao.searchAllLordLazy();
    }

    @Override
    public List<Lord> searchTopTenYoungLords() {
        return lordDao.searchTopTenYoungLords();
    }

    @Override
    public Lord getById(long id) {
        return lordDao.getById(id);
    }
}
