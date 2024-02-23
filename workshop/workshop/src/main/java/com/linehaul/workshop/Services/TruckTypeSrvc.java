package com.linehaul.workshop.Services;

import com.linehaul.workshop.Model.GenericResponse;
import com.linehaul.workshop.Model.QueryModel;
import com.linehaul.workshop.Repositories.TruckTypeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
    public class TruckTypeSrvc extends DbMainSrvc{
    Logger logger = LoggerFactory.getLogger(TruckTypeSrvc.class);
    @Autowired
    private TruckTypeRepo truckRepo;


    @Override
    public GenericResponse dbOperations(QueryModel argQryMod) {
        GenericResponse genResp = new GenericResponse();
        try {
            genResp.respCode = 200;
            genResp.respMessage = "SUCCESS";
            switch (argQryMod.queryId) {
                case "FAD" -> genResp.respData = truckRepo.findAll();
                case "FADS" -> genResp.respData = truckRepo.findAll(
                        Sort.by(argQryMod.queryParams.get(0).equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC,
                        argQryMod.queryParams.size() > 1 ? argQryMod.queryParams.get(1) : "truckId"));
                case "SAVE" -> {
                    truckRepo.saveNative(argQryMod.queryParams.get(0));
                    genResp.respData = Collections.emptyList();
                }
                default -> {
                    genResp.respCode = 404;
                    genResp.respMessage = "Query Id Not Found";
                    genResp.respData = Collections.emptyList();
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            genResp.respCode = 500;
            genResp.respMessage = "ERROR";
            genResp.respData = Collections.emptyList();
        }
        return genResp;
    }
}
