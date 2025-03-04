package com.d7g.d7gback.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {
    private String path;
    private String component;
    private String name;
    private Meta meta;
    private List<Route> children;

    public Route(String path, String component, String name, Meta meta, List<Route> children) {
        this.path = path;
        this.component = component;
        this.name = name;
        this.meta = meta;
        this.children = children;
    }
}