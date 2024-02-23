package com.linehaul.workshop.Services;

import com.linehaul.workshop.Model.GenericResponse;
import com.linehaul.workshop.Model.QueryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DatabaseConnector {
    Logger logger = LoggerFactory.getLogger(DatabaseConnector.class);

    @Autowired
    private ApplicationContext appContext;

    public GenericResponse operateOnDb(QueryModel argQryMod) {
        GenericResponse genResp = new GenericResponse();
        String className = "com.linehaul.workshop.Services." + argQryMod.repoName + "Srvc";
        try {
            Class<?> srvcClass = Class.forName(className);
            DbMainSrvc srvc = getServiceByName(srvcClass);
            if (srvc == null) {
                throw new ClassNotFoundException();
            }
            else {
                genResp = srvc.dbOperations(argQryMod);
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
            genResp.respCode = 404;
            genResp.respMessage = "Service class not found starting with " + argQryMod.repoName;
            genResp.respData = Collections.emptyList();
        }
        return genResp;
    }

    private DbMainSrvc getServiceByName(Class<?> srvcName) {
        try {
            return (DbMainSrvc) appContext.getBean(srvcName);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }

    }
}
