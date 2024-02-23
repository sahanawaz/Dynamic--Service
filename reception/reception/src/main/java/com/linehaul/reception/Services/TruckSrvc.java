package com.linehaul.reception.Services;

import com.linehaul.reception.Model.GenericResponse;
import com.linehaul.reception.Model.QueryReqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
public class TruckSrvc {
    @Autowired private WebClient webClient;

    public GenericResponse getAllTrucks()
    {
        //==Declare Query Request Model object
        QueryReqModel qryReq = new QueryReqModel();
        //==Set values for this model based on what operation we want to perform
        qryReq.queryId = "FAD";
        qryReq.repoName = "TruckType";
        qryReq.queryParams = Collections.emptyList();

        return webClient.post()
                .uri("/OperateOnDb")
                .body(Mono.just(qryReq), QueryReqModel.class)
                .retrieve()
                .bodyToMono(GenericResponse.class)
                .block();
    }
}
