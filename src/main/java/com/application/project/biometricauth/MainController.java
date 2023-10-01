package com.application.project.biometricauth;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {//this controller makes use of a button that will launch the quiz gui

    @FXML
    protected void onButtonClick() {
        Quiz quiz = new Quiz();
    }

    }



    

