package com.magatella.geocodingservice.service;

import com.magatella.geocodingservice.entity.request.RequestDTO;
import com.magatella.geocodingservice.entity.response.ResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class TwoGisGeocoderService implements GeocoderService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${URL_basic}")
    private String twoGisURL;

    @Value("${API_key}")
    private String APIkey;

    public ResponseEntity<ResponseDTO> checkTypeGeocoding(RequestDTO requestDTO) {
        if(!Strings.isEmpty(requestDTO.getAddress())){
            return directGeo(requestDTO);
        }
        else
        {
            return reserveGEO(requestDTO);
        }
    }

    public ResponseEntity<ResponseDTO> directGeo(RequestDTO requestDTO) {
        String url = twoGisURL;

        url += "?q=" + requestDTO.getAddress();
        url += "&fields=items.point";
        url += "&key=" + APIkey;

        log.info("Direct Geocoding. Request: " + url);

        return new ResponseEntity<>(restTemplate.getForObject(url, ResponseDTO.class), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> reserveGEO(RequestDTO requestDTO) {
        String url = twoGisURL;

        url += "?lat=" + requestDTO.getLat();
        url += "&lon=" + requestDTO.getLon();
        url += "&fields=items.point";
        url += "&key=" + APIkey;

        log.info("Reverse Geocoding. Request: " + url);

        return new ResponseEntity<>(restTemplate.getForObject(url, ResponseDTO.class), HttpStatus.OK);
    }
}
