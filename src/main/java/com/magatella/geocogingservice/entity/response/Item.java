package com.magatella.geocogingservice.entity.response;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Item {
//    @JsonProperty("address_name")
//    public String addressName;
//    @JsonProperty("full_name")
//    public String fullName;
//    @JsonProperty("id")
//    public String id;
//    @JsonProperty("name")
//    public String name;
//    @JsonProperty("point")
//    public Point point;
//    @JsonProperty("purpose_name")
//    public String purposeName;
//    @JsonProperty("type")
//    public String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

//    public Item withAddressName(String addressName) {
//        this.addressName = addressName;
//        return this;
//    }
//
//    public Item withFullName(String fullName) {
//        this.fullName = fullName;
//        return this;
//    }
//
//    public Item withId(String id) {
//        this.id = id;
//        return this;
//    }
//
//    public Item withName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Item withPoint(Point point) {
//        this.point = point;
//        return this;
//    }
//
//    public Item withPurposeName(String purposeName) {
//        this.purposeName = purposeName;
//        return this;
//    }
//
//    public Item withType(String type) {
//        this.type = type;
//        return this;
//    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Item withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
