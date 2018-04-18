package com.atocil.eve_market_analyzer;

import com.atocil.eve_market_analyzer.controller.ApplicationController;
import com.atocil.eve_market_analyzer.controller.ESIController;
import com.atocil.eve_market_analyzer.gui.RegionSelector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App {
    public static void main(String[] args) {
        Application.launch(ApplicationController.class, args);
    }
}
