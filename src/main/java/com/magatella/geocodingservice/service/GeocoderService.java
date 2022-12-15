package com.magatella.geocodingservice.service;

import com.magatella.geocodingservice.entity.request.RequestDTO;
import com.magatella.geocodingservice.entity.response.ResponseDTO;
import org.springframework.http.ResponseEntity;

public interface GeocoderService {
    ResponseEntity<ResponseDTO> directGeo(RequestDTO requestDTO);
    ResponseEntity<ResponseDTO> reserveGEO(RequestDTO requestDTO);
}
