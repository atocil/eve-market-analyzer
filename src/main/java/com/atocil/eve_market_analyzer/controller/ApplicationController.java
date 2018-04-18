package com.atocil.eve_market_analyzer.controller;

import com.atocil.eve_market_analyzer.gui.RegionSelector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationController extends Application {
    ESIController esiController = new ESIController();

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("EVE Online Market Analyzer");

        RegionSelector regionSelector = new RegionSelector(esiController.getAllRegions());
        primaryStage.setScene(new Scene(regionSelector, 300, 250));
        primaryStage.show();
    }
}

