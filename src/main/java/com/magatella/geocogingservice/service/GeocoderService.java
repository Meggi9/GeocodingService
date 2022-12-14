package com.magatella.geocogingservice.service;

import com.magatella.geocogingservice.entity.RequestDTO;
import com.magatella.geocogingservice.entity.response.ResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Service
@Log4j2
public class GeocoderService {
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${URL_basic}")
    private String twoGisURL;

    @Value("${API_key}")
    private String APIkey;

    public ResponseDTO checkTypeGeocoding(RequestDTO requestDTO) throws URISyntaxException {
        if(!requestDTO.getAddress().isEmpty()){
            return directGeo(requestDTO);
        }
        else
        {
            return reselveGEO(requestDTO);
        }
    }

    public ResponseDTO directGeo(RequestDTO requestDTO) throws URISyntaxException {
        String url = twoGisURL;

            url += "?q=" + requestDTO.getAddress();
            url += "&fields=items.point";
            url += "&key=" + APIkey;

            log.info("Direct Geocoding. Request: " + url);

        return restTemplate.getForObject(url, ResponseDTO.class);
    }

    public ResponseDTO reselveGEO(RequestDTO requestDTO) {
        String url = twoGisURL;

        url += "?lat=" + requestDTO.getLat();
        url += "&lon=" + requestDTO.getLon();
        url += "&fields=items.point";
        url += "&key=" + APIkey;

        log.info("Reverse Geocoding. Request: " + url);

        return restTemplate.getForObject(url, ResponseDTO.class);
    }
}
