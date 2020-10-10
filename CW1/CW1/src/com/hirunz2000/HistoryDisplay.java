package com.hirunz2000;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HistoryDisplay {
    public static void history(String url){
        // arraylist to get all the lines in history
        ArrayList<String> arr=new ArrayList<>();

        //label to store the all arraylist data
        Label lbl=new Label();
        lbl.setPrefWidth(435);
        lbl.setId("historyDisplay1");

        //----------------------------- Reading The history file--------------------------------------------------//
        try {
            try {

                File file = new File(url);
                Scanner input = new Scanner(file);
                while(input.hasNext()){
                    arr.add(input.nextLine());
                }

                for (int i=0;i<arr.size();i++){
                    lbl.setText(lbl.getText()+"\n"+arr.get(i));
                }

                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }catch (InputMismatchException e){
            System.out.println("File is empty.");;
        }

//--------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------- Label and back button------------------------------------------------//

        Label lblHeading =new Label("History");
        lblHeading.setPrefSize(479,55);
        lblHeading.setLayoutX(3);
        lblHeading.setLayoutY(3);
        lblHeading.setId("label-heading");


        Button btnBack = new Button("Go Back");
        btnBack.setId("btn2");
        btnBack.setPrefSize(60,20);
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(15);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.close();
            }
        });

//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------Adding the label to a scrollpane and then displaying---------------------------//

        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setId("scroll");
        scrollPane.setContent(lbl);
        scrollPane.setPrefSize(450,350);
        scrollPane.setLayoutX(15);
        scrollPane.setLayoutY(80);

        AnchorPane root=new AnchorPane();
        root.setPrefSize(500,500);
        root.getChildren().addAll(lblHeading,scrollPane,btnBack);
        root.setId("root");

        Stage primaryStage=new Stage();
        //setting a fix size for stage
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(500);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(500);


        Scene scene=new Scene(root,500,500);
        scene.getStylesheets().add("css/layout.css");//link to external css file
        primaryStage.setTitle("All in One Finance Calculator");
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }
}
//********************************************************************************************************************//