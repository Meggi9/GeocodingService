package com.magatella.geocogingservice.entity;

import lombok.Data;

@Data
public class ResponseDTO {
    private String full_name;
    private String id;
    private String lat;
    private String lon;
}
