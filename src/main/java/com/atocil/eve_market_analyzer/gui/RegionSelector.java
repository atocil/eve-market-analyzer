package com.atocil.eve_market_analyzer.gui;

import com.atocil.eve_market_analyzer.dto.Region;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;


public class RegionSelector extends StackPane {

    public RegionSelector(List<Region> regions) {
        super();

        ComboBox<Region> regionComboBox = new ComboBox<>();
        regionComboBox.getItems().addAll(regions);
        regionComboBox.setCellFactory(
            new Callback<ListView<Region>, ListCell<Region>>() {

                @Override
                public ListCell<Region> call(ListView<Region> param) {
                    final ListCell<Region> cell = new ListCell<Region>() {
                        @Override
                        public void updateItem(Region item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null) {
                                setText(item.getName());
                            }
                            else {
                                setText(null);
                            }
                        }
                    };
                    return cell;
                }
            }
        );

        this.getChildren().add(regionComboBox);
    }
}
