package com.server.healthapp.springHealthApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PlanDto {
    Integer id ;
    String user_Id;
    int sport_id;
    double rec_01;
    String metric_01;
    double rec_02;
    String metric_02;
    Date duedate;
    Boolean success;
    Date success_date;

}
