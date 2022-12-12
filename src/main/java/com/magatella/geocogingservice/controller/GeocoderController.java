package com.magatella.geocogingservice.controller;


import com.magatella.geocogingservice.entity.RequestDTO;
import com.magatella.geocogingservice.entity.response.ResponseDTO;
import com.magatella.geocogingservice.service.GeocoderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/geocoder")
public class GeocoderController {

    private final GeocoderService geocoderService;

    public GeocoderController(GeocoderService geocoderService) {
        this.geocoderService = geocoderService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ds")
    public ResponseDTO geocod(@RequestBody RequestDTO requestDTO) throws URISyntaxException {

        return geocoderService.getAddress(requestDTO);
    }
}
