package com.hirunz2000;

import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        //starting the main menu
        primaryStage.setTitle("All in One Finance Calculator");
        primaryStage.setScene(MainMenu.Mainmenu());
        primaryStage.show();

        //setting a fix size for stage
        primaryStage.setMaxHeight(440);
        primaryStage.setMaxWidth(420);
        primaryStage.setMinHeight(440);
        primaryStage.setMinWidth(420);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//********************************************************************************************************************//