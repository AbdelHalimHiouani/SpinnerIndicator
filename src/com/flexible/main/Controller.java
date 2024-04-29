package com.flexible.main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static final double delta = 2;
    private static final double radius = 50;

    private double sx, sy, tx, ty;

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(this::getMask);

        root.setOnMousePressed(event -> {
            sx = event.getSceneX();
            sy = event.getSceneY();
            tx = root.getTranslateX();
            ty = root.getTranslateY();
        });

        root.setOnMouseDragged(event -> {
            MainApplication.pStage.setX(event.getScreenX() - sx + tx);
            MainApplication.pStage.setY(event.getScreenY() - sy + ty);

        });
    }

    private void  getMask() {
        Rectangle mask = new Rectangle(delta, delta, root.getWidth() - (delta * 2), root.getHeight() - (delta * 2));
        mask.setArcWidth(radius);
        mask.setArcHeight(radius);
        root.setClip(mask);
    }
}
