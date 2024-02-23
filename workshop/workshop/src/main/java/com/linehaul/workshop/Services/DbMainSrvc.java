package com.linehaul.workshop.Services;

import com.linehaul.workshop.Model.GenericResponse;
import com.linehaul.workshop.Model.QueryModel;
import org.springframework.stereotype.Service;

@Service
public class DbMainSrvc {

    GenericResponse dbOperations(QueryModel argQryMod){
        return new GenericResponse();
    };
}
