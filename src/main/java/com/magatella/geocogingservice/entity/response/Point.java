package com.magatella.geocogingservice.entity.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Point {
    @JsonProperty("lat")
    public String lat;
    @JsonProperty("lon")
    public String lon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Point withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public Point withLon(String lon) {
        this.lon = lon;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Point withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
