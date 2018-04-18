package com.atocil.eve_market_analyzer;

import com.atocil.eve_market_analyzer.controller.ESIController;
import com.atocil.eve_market_analyzer.gui.RegionSelector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application{
    ESIController esiController = new ESIController();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("EVE Online Market Analyzer");

        RegionSelector regionSelector = new RegionSelector(esiController.getAllRegions());
        primaryStage.setScene(new Scene(regionSelector, 300, 250));
        primaryStage.show();
    }
}
