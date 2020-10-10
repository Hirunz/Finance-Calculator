package com.hirunz2000;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MainMenu {
    public static Scene Mainmenu() {

        //heading
        Label lblheading=new Label("WELCOME TO MY CALC");
        lblheading.setId("heading1");
        lblheading.setFocusTraversable(false);
        lblheading.setPrefSize(250,35);
        lblheading.setLayoutX(95);
        lblheading.setLayoutY(25);

        //button which opens the mortgage calculator
        Button btnMortgage = new Button("Mortgage Calculator");
        btnMortgage.setId("btn1");
        btnMortgage.setFocusTraversable(false);// remove the selection when mouse clicked
        btnMortgage.setPrefSize(80,80);
        btnMortgage.setLayoutX(304);
        btnMortgage.setLayoutY(220);
        btnMortgage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close the current stage
                Stage stage = (Stage) btnMortgage.getScene().getWindow();
                stage.close();

                Stage primaryStage=new Stage();
                // set the stage to a fixed size
                primaryStage.setMaxHeight(400);
                primaryStage.setMaxWidth(520);
                primaryStage.setMinHeight(400);
                primaryStage.setMinWidth(520);

                primaryStage.setTitle("All in One Finance Calculator");
                primaryStage.setScene(MortgageCalculatorWindow.MortgageCalculator());
                primaryStage.show();
            }
        });

        Button btnLoan = new Button("Loan Calculator");
        btnLoan.setPrefSize(80,80);
        btnLoan.setFocusTraversable(false);// remove the selection when mouse clicked
        btnLoan.setId("btn1");
        btnLoan.setLayoutX(208);
        btnLoan.setLayoutY(220);
        btnLoan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close the current stage
                Stage stage = (Stage) btnLoan.getScene().getWindow();
                stage.close();

                Stage primaryStage=new Stage();
                // set the stage to a fixed size
                primaryStage.setMaxHeight(400);
                primaryStage.setMaxWidth(520);
                primaryStage.setMinHeight(400);
                primaryStage.setMinWidth(520);

                primaryStage.setTitle("All in One Finance Calculator");
                primaryStage.setScene(LoanCalculatorWindow.LoanCalculator());
                primaryStage.show();
            }
        });

        Button btnFD = new Button("Fixed Deposit Calculator");
        btnFD.setPrefSize(80,80);
        btnFD.setId("btn1");
        btnFD.setFocusTraversable(false);// remove the selection when mouse clicked
        btnFD.setLayoutX(112);
        btnFD.setLayoutY(220);
        btnFD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close the current stage
                Stage stage = (Stage) btnLoan.getScene().getWindow();
                stage.close();

                Stage primaryStage=new Stage();
                // set the stage to a fixed size
                primaryStage.setMaxHeight(400);
                primaryStage.setMaxWidth(520);
                primaryStage.setMinHeight(400);
                primaryStage.setMinWidth(520);

                primaryStage.setTitle("All in One Finance Calculator");
                primaryStage.setScene(FixedDeposit.FD());
                primaryStage.show();

            }
        });

        Button btnFinance = new Button("Savings Calculator");
        btnFinance.setId("btn1");
        btnFinance.setFocusTraversable(false);// remove the selection when mouse clicked
        btnFinance.setPrefSize(80,80);
        btnFinance.setLayoutX(16);
        btnFinance.setLayoutY(220);
        btnFinance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close the current stage
                Stage stage = (Stage) btnLoan.getScene().getWindow();
                stage.close();

                Stage primaryStage=new Stage();
                // set the stage to a fixed size
                primaryStage.setMaxHeight(400);
                primaryStage.setMaxWidth(520);
                primaryStage.setMinHeight(400);
                primaryStage.setMinWidth(520);

                primaryStage.setTitle("All in One Finance Calculator");
                primaryStage.setScene(SavingsCalculator.savings());
                primaryStage.show();
            }
        });

        Button btnExit = new Button("Exit");
        btnExit.setId("btnExit");
        btnExit.setFocusTraversable(false);// remove the selection when mouse clicked
        btnExit.setPrefSize(75,30);
        btnExit.setLayoutX(300);
        btnExit.setLayoutY(350);
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //close the current stage and this closes the whole application
                Stage stage = (Stage) btnExit.getScene().getWindow();
                stage.close();
            }
        });
//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------Adding the image to main menu ---------------------------------------------------//

        Image image = null;
        try {
            image = new Image(new FileInputStream("src/images/img1.png"));
        } catch (FileNotFoundException e) {
            System.out.println("Warning! Image not found.");
        }
        ImageView imageView = new ImageView(image);

        imageView.setX(65);
        imageView.setY(71);

        imageView.setFitHeight(140);
        imageView.setFitWidth(270);
        imageView.setId("image");


//--------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------Adding to anchorpane and stage display-----------------------------------//

        AnchorPane root =new AnchorPane();
        root.setId("root");
        root.getChildren().addAll(btnExit,btnFD,btnFinance,btnLoan,btnMortgage,lblheading,imageView);
        Scene scene=new Scene(root,400,400);
        scene.getStylesheets().add("css/layout.css");
        return scene;
    }
}
//********************************************************************************************************************//