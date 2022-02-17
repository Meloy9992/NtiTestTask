package com.nti.testTask.clientManager.dao;

import com.nti.testTask.clientManager.models.Lord;
import com.nti.testTask.clientManager.models.Planet;

import java.util.List;


public interface LordDao {
    Lord addNewLord(String name, long age);

    void appointLord(long idLord, long idPlanet);

    List<Lord> searchAllLordLazy();

    List<Lord> searchTopTenYoungLords();

    Lord getById(long id);
}
