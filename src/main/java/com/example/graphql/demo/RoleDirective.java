package com.example.graphql.demo;


import com.example.graphql.demo.bean.AuthContext;
import graphql.schema.*;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

import java.util.List;

public class RoleDirective implements SchemaDirectiveWiring {
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
        List<String> targetRoles = (List<String>) env.getDirective().getArgument("roles").getValue();
        System.out.println("targetRole");
        System.out.println(targetRoles);
        DataFetcher originDataFetcher = env.getFieldDataFetcher();
        env.setFieldDataFetcher(new DataFetcher() {
            @Override
            public Object get(DataFetchingEnvironment environment) throws Exception {
                AuthContextHolder authContextHolder = new AuthContextHolder();
                AuthContext authContext = authContextHolder.getContext();
                if(targetRoles.contains(authContext.getRole())){
                    return originDataFetcher.get(environment);
                }else{
                    return null;
                }

            }
        });
        return env.getElement();

    }
}