package com.nti.testTask.clientManager.service;

import com.nti.testTask.clientManager.models.Lord;

import java.util.List;

public interface LordService {
    Lord addNewLord(String name, long age);

    void appointLord(long idLord, long idPlanet);

    List<Lord> searchAllLordLazy();

    List<Lord> searchTopTenYoungLords();

    Lord getById(long id);
}