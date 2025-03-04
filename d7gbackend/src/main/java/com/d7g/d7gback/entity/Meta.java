package com.d7g.d7gback.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {
    private String title;
    private String icon;
    private Integer rank;
    private List<String> roles;
    private List<String> auths;

    public Meta(String title, String icon, Integer rank, List<String> roles, List<String> auths) {
        this.title = title;
        this.icon = icon;
        this.rank = rank;
        this.roles = roles;
        this.auths = auths;
    }
}