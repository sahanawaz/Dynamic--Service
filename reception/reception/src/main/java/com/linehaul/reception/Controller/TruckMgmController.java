package com.linehaul.reception.Controller;

import com.linehaul.reception.Model.GenericResponse;
import com.linehaul.reception.Services.TruckSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TruckMgmController {

    @Autowired private TruckSrvc trkSrvc;

    @GetMapping("/GetAllTrks")
    public ResponseEntity<GenericResponse> getAllTruckTypes(){
        return ResponseEntity.ok(trkSrvc.getAllTrucks());
    }
}
