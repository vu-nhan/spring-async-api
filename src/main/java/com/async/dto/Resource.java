package com.async.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resource {

    private String id;

    private String name;

    @JsonProperty("parent_fxf")
    private List<String> parentFxf;

    private String description;

    private String attribution;

    private String type;

    private String updatedAt;

    private String createdAt;

    @JsonProperty("columns_name")
    private List<String> columnsName;

    @JsonProperty("columns_field_name")
    private List<String> columnsFieldName;

    @JsonProperty("columns_datatype")
    private List<String> columnsDatatype;

    @JsonProperty("columns_description")
    private List<String> columnsDescription;
}
