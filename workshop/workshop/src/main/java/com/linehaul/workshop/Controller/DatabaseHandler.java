package com.linehaul.workshop.Controller;

import com.linehaul.workshop.Model.GenericResponse;
import com.linehaul.workshop.Model.QueryModel;
import com.linehaul.workshop.Services.DatabaseConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class DatabaseHandler {
    @Autowired private DatabaseConnector connector;

    @PostMapping("/OperateOnDb")
    public ResponseEntity<GenericResponse> saveData(@RequestBody QueryModel argQryMod){
        return ResponseEntity.ok(connector.operateOnDb(argQryMod));
    }
}
