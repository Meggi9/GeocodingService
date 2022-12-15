package com.magatella.geocodingservice.controller;


import com.magatella.geocodingservice.entity.request.RequestDTO;
import com.magatella.geocodingservice.entity.response.ResponseDTO;
import com.magatella.geocodingservice.service.TwoGisGeocoderService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class GeocoderController {

    private final TwoGisGeocoderService geocoderService;

    public GeocoderController(TwoGisGeocoderService geocoderService) {
        this.geocoderService = geocoderService;
    }

    @Cacheable(value = "reqGeocod", keyGenerator = "customKeyGenerator")
    @RequestMapping(method = RequestMethod.GET, path = "/geocoder")
    public ResponseEntity<ResponseDTO> geo(@RequestBody RequestDTO requestDTO) {
        return geocoderService.checkTypeGeocoding(requestDTO);
    }
}
