package com.magatella.geocogingservice.controller;


import com.magatella.geocogingservice.entity.RequestDTO;
import com.magatella.geocogingservice.entity.response.ResponseDTO;
import com.magatella.geocogingservice.service.GeocoderService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/api")
public class GeocoderController {

    private final GeocoderService geocoderService;

    public GeocoderController(GeocoderService geocoderService) {
        this.geocoderService = geocoderService;
    }

    @Cacheable(value = "reqGeocod", keyGenerator = "customKeyGenerator")
    @RequestMapping(method = RequestMethod.GET, path = "/geocoder")
    public ResponseEntity<ResponseDTO> geo(@RequestBody RequestDTO requestDTO) {
        return geocoderService.checkTypeGeocoding(requestDTO);
    }
}
