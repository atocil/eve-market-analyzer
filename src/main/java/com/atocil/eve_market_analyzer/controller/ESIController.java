package com.atocil.eve_market_analyzer.controller;

import com.atocil.eve_market_analyzer.dto.Region;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ESIController {
    private static final String ESI_BASE_URL = "https://esi.tech.ccp.is/latest/";

    public ESIController() {
        // Only one time
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public List<Region> getAllRegions() {
        List<Integer> regionIds = getRegionIds();
        return regionIds.stream()
                .map(this::getRegionInfo)
                .collect(Collectors.toList());
    }

    private List<Integer> getRegionIds() {
        HttpResponse<Integer[]> response = null;
        try {
            response =  Unirest.get(ESI_BASE_URL + "universe/regions/?datasource=tranquility")
                    .header("accept", "application/json")
                    .asObject(Integer[].class);


            System.out.println("Number of regions" + response.getBody().length);
        } catch(UnirestException ue) {
            ue.printStackTrace();
        }

        return Arrays.asList(response.getBody());
    }

    private Region getRegionInfo(int regionId) {
        HttpResponse<Region> response = null;
        try {
            response = Unirest.get(ESI_BASE_URL + "universe/regions/{regionId}/?datasource=tranquility&language=en-us")
                    .header("accept", "application/json")
                    .routeParam("regionId", Integer.toString(regionId))
                    .asObject(Region.class);

        } catch(UnirestException ue) {
            ue.printStackTrace();
        }

        return response.getBody();
    }
}
