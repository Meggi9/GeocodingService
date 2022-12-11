package com.magatella.geocogingservice.service;

import com.magatella.geocogingservice.entity.RequestDTO;
import com.magatella.geocogingservice.entity.ResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class GeocoderService {
    private RestTemplate restTemplate = new RestTemplate();
    private static final String twoGisURL = "https://catalog.api.2gis.com/3.0/items/geocode?";
    private static final String APIkey = "&key=ruczst5782";

    public Object getAddress(RequestDTO requestDTO){
        String url = twoGisURL;

        if(!Strings.isEmpty(requestDTO.getAddress())) {
            url += "q=" + requestDTO.getAddress();
            url += "&fields=items.point";
            url += APIkey;

            log.info("Direct Geocoding. Request: " + url);
        }
        if(!Strings.isEmpty(requestDTO.getLat()))
        {
            url +="lat=" + requestDTO.getLat();
            url +="&lon=" + requestDTO.getLon();
            url +="&fields=items.point";
            url += APIkey;

            log.info("Reverse Geocoding. Request: " + url);
        }

        return restTemplate.getForEntity(url, Object.class).getBody();
    }
}
