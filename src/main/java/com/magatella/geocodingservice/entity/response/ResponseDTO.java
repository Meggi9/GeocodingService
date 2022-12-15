package com.magatella.geocodingservice.entity.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ResponseDTO {

    @JsonProperty("result")
    public Result result;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ResponseDTO withResult(Result result) {
        this.result = result;
        return this;
    }
}
