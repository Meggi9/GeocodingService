package com.magatella.geocogingservice.entity.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class ResponseDTO {
//    @JsonProperty("meta")
//    public Meta meta;
    @JsonProperty("result")
    public Result result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

//    public ResponseDTO withMeta(Meta meta) {
//        this.meta = meta;
//        return this;
//    }

    public ResponseDTO withResult(Result result) {
        this.result = result;
        return this;
    }

//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//    public ResponseDTO withAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//        return this;
//    }
}
