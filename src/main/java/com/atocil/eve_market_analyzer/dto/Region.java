package com.atocil.eve_market_analyzer.dto;

import java.util.List;
import lombok.Data;

@Data public class Region {
    private int region_id;
    private String name;
    private List<Integer> constellations;
    private String description;
}
