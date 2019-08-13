package com.example.graphql.demo.bean;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class AuthContext {
    private String username;
    private String role;
}
