package com.nti.testTask.clientManager.service.impl;

import com.nti.testTask.clientManager.dao.LordDao;
import com.nti.testTask.clientManager.dao.impl.LordDaoImpl;
import com.nti.testTask.clientManager.models.Lord;
import com.nti.testTask.clientManager.models.Planet;
import com.nti.testTask.clientManager.service.LordService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@RunWith(PowerMockRunner.class)
class LordServiceImplTest {

    private LordDao lordDao = PowerMockito.mock(LordDaoImpl.class);
    private LordService lordService = PowerMockito.spy(new LordServiceImpl(lordDao));

    @Test
    public void addNewLordTest(){
        Lord lord = PowerMockito.mock(Lord.class);
        PowerMockito.when(lordDao.addNewLord(Mockito.any(), Mockito.anyLong())).thenReturn(lord);
        Lord returnedLord = lordService.addNewLord("Sergey", 22);
        Assert.assertEquals(lord, returnedLord);
    }

    @Test
    void appointLord() {
        PowerMockito.doNothing().when(lordDao).appointLord(Mockito.anyLong(), Mockito.anyLong());

        lordService.appointLord(20, 5);
    }


    @Test
    void searchAllLordLazy() {
        List<Lord> lords = PowerMockito.mock(List.class);
        PowerMockito.when(lordDao.searchAllLordLazy()).thenReturn(lords);
        List<Lord> returnLords = lordService.searchAllLordLazy();
        Assert.assertEquals(lords, returnLords);
    }

    @Test
    void searchTopTenYoungLords() {
        List<Lord> youngLords = PowerMockito.mock(List.class);
        PowerMockito.when(lordDao.searchTopTenYoungLords()).thenReturn(youngLords);
        List<Lord> returnYoungLords = lordService.searchTopTenYoungLords();
        Assert.assertEquals(youngLords, returnYoungLords);
    }

    @Test
    void getById() {
        Lord lord = PowerMockito.mock(Lord.class);
        PowerMockito.when(lordDao.getById(Mockito.anyLong())).thenReturn(lord);
        Lord returnedLord = lordService.getById(4);
        Assert.assertEquals(lord, returnedLord);
    }
}