package com.nti.testTask.controllers;

import com.nti.testTask.clientManager.dao.LordDao;
import com.nti.testTask.clientManager.dao.PlanetDao;
import com.nti.testTask.clientManager.models.Lord;
import com.nti.testTask.clientManager.models.Planet;
import com.nti.testTask.clientManager.service.LordService;
import com.nti.testTask.clientManager.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LordControllers {

    private LordService lordService;
    private PlanetService planetService;

    @Autowired
    public LordControllers(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @PostMapping("/add/lord")
    public ResponseEntity<Lord> addNewLord(@RequestParam String name, @RequestParam long age) {
        Lord lord = lordService.addNewLord(name, age);
        return new ResponseEntity<>(lord, HttpStatus.OK);
    }

    @PostMapping("/add/planet")
    public ResponseEntity<Planet> addNewPlanet(@RequestParam String title) {
        Planet planet = planetService.addNewPlanet(title);
        return new ResponseEntity<>(planet, HttpStatus.OK);
    }

    @PutMapping("/appointLord")
    public ResponseEntity<?> appointLord(@RequestParam long idLord, @RequestParam long idPlanet) {
        lordService.appointLord(idLord, idPlanet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/lazyLords")
    public ResponseEntity<List<Lord>> lazyLords() {
        List<Lord> lords = lordService.searchAllLordLazy();
        return new ResponseEntity<>(lords, HttpStatus.OK);
    }

    @GetMapping("/topTen/YoungLord")
    public ResponseEntity<List<Lord>> topYangLord() {
        return new ResponseEntity<>(lordService.searchTopTenYoungLords(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/planet")
    public ResponseEntity<Long> deletePlanet(@RequestParam long idPlanet) {
        planetService.deletePlanet(idPlanet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
