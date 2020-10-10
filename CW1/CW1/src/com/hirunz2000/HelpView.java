package com.hirunz2000;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelpView {
    private static char ch1 ='\u29BF';// unicode character for bullet

//********************************* This class contains all four help windows ****************************************//


//--------------------------------------------------------------------------------------------------------------------//
//***************************************** Fixed Deposit Calculator *************************************************//
//--------------------------------------------------------------------------------------------------------------------//
    public static Scene FD(){

        Label lblheading =new Label("Help View - Fixed Deposit Calculator");
        lblheading.setPrefSize(479,55);
        lblheading.setLayoutX(3);
        lblheading.setLayoutY(3);
        lblheading.setId("label-heading");

        Label lblQuestion1 = new Label("What can this calculator calculate ?");
        lblQuestion1.setPrefSize(250,21);
        lblQuestion1.setLayoutX(24);
        lblQuestion1.setLayoutY(76);
        lblQuestion1.setId("question");

        Label lblPrincipleAmount = new Label(ch1 +" Principle Amount");
        lblPrincipleAmount.setPrefSize(150,20);
        lblPrincipleAmount.setId("answer");

        Label lblFutureValue = new Label(ch1 +" Future Value");
        lblFutureValue.setPrefSize(150,20);
        lblFutureValue.setId("answer");

        Label lblInterestRate = new Label(ch1 +" Interest Rate");
        lblInterestRate.setPrefSize(150,20);
        lblInterestRate.setId("answer");

        Label lblTimePeriod = new Label(ch1 +" Time Period");
        lblTimePeriod.setPrefSize(150,20);
        lblTimePeriod.setId("answer");

        //adding above labels to a gridpane
        GridPane gridQuestion1 =new GridPane();
        gridQuestion1.setPrefSize(130,90);
        gridQuestion1.setLayoutX(50);
        gridQuestion1.setLayoutY(105);

        gridQuestion1.add(lblPrincipleAmount,0,0);
        gridQuestion1.add(lblFutureValue,0,1);
        gridQuestion1.add(lblInterestRate,0,2);
        gridQuestion1.add(lblTimePeriod,0,3);


        Label lblQuestion2 = new Label("How to calculate ?");
        lblQuestion2.setPrefSize(235,21);
        lblQuestion2.setLayoutX(24);
        lblQuestion2.setLayoutY(215);
        lblQuestion2.setId("question");

        Label lblInstruction1 = new Label(ch1 +" Insert all the other fields except the one which you wish to calculate.");
        lblInstruction1.setPrefSize(410,20);
        lblInstruction1.setId("answer");

        Label lblInstruction2 = new Label(ch1 +" Use the on screen keyboard to avoid entering alphabetical values.");
        lblInstruction2.setPrefSize(410,20);
        lblInstruction2.setId("answer");

        Label lblInstruction3 = new Label(ch1 +" Click calculate button to calculate.");
        lblInstruction3.setPrefSize(410,20);
        lblInstruction3.setId("answer");

        //adding above labels to a gridpane
        GridPane gridQuestion2 =new GridPane();
        gridQuestion2.setPrefSize(410,90);
        gridQuestion2.setLayoutX(50);
        gridQuestion2.setLayoutY(242);

        gridQuestion2.add(lblInstruction1,0,0);
        gridQuestion2.add(lblInstruction2,0,1);
        gridQuestion2.add(lblInstruction3,0,2);


        Label lblQuestion3 = new Label("What to enter ?");
        lblQuestion3.setPrefSize(235,21);
        lblQuestion3.setLayoutX(24);
        lblQuestion3.setLayoutY(341);
        lblQuestion3.setId("question");

        Label lblPrincipleAmount2 = new Label(ch1 +" Principle Amount");
        lblPrincipleAmount2.setPrefSize(150,20);
        lblPrincipleAmount2.setId("answer");

        Label lblFutureValue2 = new Label(ch1 +" Future Value");
        lblFutureValue2.setPrefSize(150,20);
        lblFutureValue2.setId("answer");

        Label lblInterestRate2 = new Label(ch1 +" Interest Rate");
        lblInterestRate2.setPrefSize(150,20);
        lblInterestRate2.setId("answer");

        Label lblTimePeriod2 = new Label(ch1 +" Time Period");
        lblTimePeriod2.setPrefSize(150,20);
        lblTimePeriod2.setId("answer");

        Label lblPrincipleAmount1 = new Label("Principle Investment");
        lblPrincipleAmount1.setPrefSize(200,20);
        lblPrincipleAmount1.setId("answer");

        Label lblFutureValue1 = new Label("Future value of the Principle amount");
        lblFutureValue1.setPrefSize(200,20);
        lblFutureValue1.setId("answer");

        Label lblInterestRate1 = new Label("Annual Interest Rate");
        lblInterestRate1.setPrefSize(200,20);
        lblInterestRate1.setId("answer");

        Label lblTimePeriod1 = new Label("Time of investment in years");
        lblTimePeriod1.setPrefSize(200,20);
        lblTimePeriod1.setId("answer");

        //adding above labels to a gridpane
        GridPane gridQuestion3 =new GridPane();
        gridQuestion3.setPrefSize(350,95);
        gridQuestion3.setLayoutX(50);
        gridQuestion3.setLayoutY(370);

        gridQuestion3.add(lblPrincipleAmount2,0,0);
        gridQuestion3.add(lblFutureValue2,0,1);
        gridQuestion3.add(lblInterestRate2,0,2);
        gridQuestion3.add(lblTimePeriod2,0,3);

        gridQuestion3.add(lblPrincipleAmount1,1,0);
        gridQuestion3.add(lblFutureValue1,1,1);
        gridQuestion3.add(lblInterestRate1,1,2);
        gridQuestion3.add(lblTimePeriod1,1,3);

        //Close button to close this window
        Button btnClose = new Button("Close");
        btnClose.setFocusTraversable(false);
        btnClose.setId("btnClose");
        btnClose.setPrefSize(70,30);
        btnClose.setLayoutX(360);
        btnClose.setLayoutY(450);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnClose.getScene().getWindow();
                stage.close();
            }
        });

        //add the above grids and labels to an anchorpane and setting the scene
        AnchorPane root=new AnchorPane();
        root.getChildren().addAll(lblheading,lblQuestion1,lblQuestion2,lblQuestion3,gridQuestion1,gridQuestion2,gridQuestion3,btnClose);
        root.setId("root");
        Scene scene=new Scene(root,500,550);
        scene.getStylesheets().add("css/layout.css");
        return scene;
    }


//--------------------------------------------------------------------------------------------------------------------//
//*********************************************** Savings Calculator *************************************************//
//--------------------------------------------------------------------------------------------------------------------//

    public static Scene Savings(){

        Label lblheading =new Label("Help View - Savings Calculator");
        lblheading.setPrefSize(479,55);
        lblheading.setLayoutX(3);
        lblheading.setLayoutY(3);
        lblheading.setId("label-heading");

        Label lblQuestion1 = new Label("What can this calculator calculate ?");
        lblQuestion1.setPrefSize(250,21);
        lblQuestion1.setLayoutX(24);
        lblQuestion1.setLayoutY(76);
        lblQuestion1.setId("question");

        Label lblPrincipleAmount = new Label(ch1 +" Principle Amount");
        lblPrincipleAmount.setPrefSize(150,20);
        lblPrincipleAmount.setId("answer");

        Label lblFutureValue = new Label(ch1 +" Future Value");
        lblFutureValue.setPrefSize(150,20);
        lblFutureValue.setId("answer");

        Label lblPMT = new Label(ch1 +" Monthly Payment");
        lblPMT.setPrefSize(150,20);
        lblPMT.setId("answer");

        Label lblTimePeriod = new Label(ch1 +" Time Period");
        lblTimePeriod.setPrefSize(150,20);
        lblTimePeriod.setId("answer");

        GridPane gridQuestion1 =new GridPane();
        gridQuestion1.setPrefSize(130,90);
        gridQuestion1.setLayoutX(50);
        gridQuestion1.setLayoutY(105);

        gridQuestion1.add(lblPrincipleAmount,0,0);
        gridQuestion1.add(lblFutureValue,0,1);
        gridQuestion1.add(lblPMT,0,2);
        gridQuestion1.add(lblTimePeriod,0,3);


        Label lblQuestion2 = new Label("How to calculate ?");
        lblQuestion2.setPrefSize(235,21);
        lblQuestion2.setLayoutX(24);
        lblQuestion2.setLayoutY(215);
        lblQuestion2.setId("question");

        Label lblInstruction1 = new Label(ch1 +" Insert all the other fields except the one which you wish to calculate.");
        lblInstruction1.setPrefSize(410,20);
        lblInstruction1.setId("answer");

        Label lblInstruction2 = new Label(ch1 +" Use the on screen keyboard to avoid entering alphabetical values.");
        lblInstruction2.setPrefSize(410,20);
        lblInstruction2.setId("answer");

        Label lblInstruction3 = new Label(ch1 +" Click calculate button to calculate.");
        lblInstruction3.setPrefSize(410,20);
        lblInstruction3.setId("answer");

        Label lblInstruction4 = new Label(ch1 +" Cannot calculate interest in this calculator.");
        lblInstruction4.setPrefSize(410,20);
        lblInstruction4.setId("answer");

        GridPane gridQuestion2 =new GridPane();
        gridQuestion2.setPrefSize(410,100);
        gridQuestion2.setLayoutX(50);
        gridQuestion2.setLayoutY(242);

        gridQuestion2.add(lblInstruction1,0,0);
        gridQuestion2.add(lblInstruction2,0,1);
        gridQuestion2.add(lblInstruction3,0,2);
        gridQuestion2.add(lblInstruction4,0,3);


        Label lblQuestion3 = new Label("What to enter ?");
        lblQuestion3.setPrefSize(235,21);
        lblQuestion3.setLayoutX(24);
        lblQuestion3.setLayoutY(341);
        lblQuestion3.setId("question");

        Label lblPrincipleAmount2 = new Label(ch1 +" Principle Amount");
        lblPrincipleAmount2.setPrefSize(150,20);
        lblPrincipleAmount2.setId("answer");

        Label lblFutureValue2 = new Label(ch1 +" Future Value");
        lblFutureValue2.setPrefSize(150,20);
        lblFutureValue2.setId("answer");

        Label lblPMT2 = new Label(ch1 +" Monthly Payment");
        lblPMT2.setPrefSize(150,20);
        lblPMT2.setId("answer");

        Label lblTimePeriod2 = new Label(ch1 +" Time Period");
        lblTimePeriod2.setPrefSize(150,20);
        lblTimePeriod2.setId("answer");

        Label lblInterestRate2 = new Label(ch1 +" Interest Rate");
        lblInterestRate2.setPrefSize(150,20);
        lblInterestRate2.setId("answer");


        Label lblPrincipleAmount1 = new Label("Principle Investment");
        lblPrincipleAmount1.setPrefSize(200,20);
        lblPrincipleAmount1.setId("answer");

        Label lblFutureValue1 = new Label("Future value of the Principle amount");
        lblFutureValue1.setPrefSize(200,20);
        lblFutureValue1.setId("answer");

        Label lblPMT1 = new Label("Monthly payment amount");
        lblPMT1.setPrefSize(200,20);
        lblPMT1.setId("answer");

        Label lblTimePeriod1 = new Label("Time of investment in years");
        lblTimePeriod1.setPrefSize(200,20);
        lblTimePeriod1.setId("answer");

        Label lblInterestRate1 = new Label("Annual Interest Rate");
        lblInterestRate1.setPrefSize(200,20);
        lblInterestRate1.setId("answer");

        GridPane gridQuestion3 =new GridPane();
        gridQuestion3.setPrefSize(350,95);
        gridQuestion3.setLayoutX(50);
        gridQuestion3.setLayoutY(370);

        gridQuestion3.add(lblPrincipleAmount2,0,0);
        gridQuestion3.add(lblFutureValue2,0,1);
        gridQuestion3.add(lblPMT2,0,2);
        gridQuestion3.add(lblTimePeriod2,0,3);
        gridQuestion3.add(lblInterestRate2,0,4);

        gridQuestion3.add(lblPrincipleAmount1,1,0);
        gridQuestion3.add(lblFutureValue1,1,1);
        gridQuestion3.add(lblPMT1,1,2);
        gridQuestion3.add(lblTimePeriod1,1,3);
        gridQuestion3.add(lblInterestRate1,1,4);

        Button btnClose = new Button("Close");
        btnClose.setFocusTraversable(false);
        btnClose.setId("btnClose");
        btnClose.setPrefSize(70,30);
        btnClose.setLayoutX(360);
        btnClose.setLayoutY(450);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnClose.getScene().getWindow();
                stage.close();
            }
        });

        AnchorPane root=new AnchorPane();
        root.getChildren().addAll(lblheading,lblQuestion1,lblQuestion2,lblQuestion3,gridQuestion1,gridQuestion2,gridQuestion3,btnClose);
        root.setId("root");
        Scene scene=new Scene(root,500,550);
        scene.getStylesheets().add("css/layout.css");
        return scene;
    }


//--------------------------------------------------------------------------------------------------------------------//
//********************************************** Mortgage Calculator *************************************************//
//--------------------------------------------------------------------------------------------------------------------//

    public static Scene Mortgage(){

        Label lblheading =new Label("Help View - Mortgage Calculator");
        lblheading.setPrefSize(479,55);
        lblheading.setLayoutX(3);
        lblheading.setLayoutY(3);
        lblheading.setId("label-heading");

        Label lblQuestion1 = new Label("What can this calculator calculate ?");
        lblQuestion1.setPrefSize(250,21);
        lblQuestion1.setLayoutX(24);
        lblQuestion1.setLayoutY(76);
        lblQuestion1.setId("question");

        Label lblPrincipleAmount = new Label(ch1 +" Loan Amount");
        lblPrincipleAmount.setPrefSize(150,20);
        lblPrincipleAmount.setId("answer");


        Label lblPMT = new Label(ch1 +" Monthly Payment");
        lblPMT.setPrefSize(150,20);
        lblPMT.setId("answer");

        Label lblTimePeriod = new Label(ch1 +" Time Period");
        lblTimePeriod.setPrefSize(150,20);
        lblTimePeriod.setId("answer");

        GridPane gridQuestion1 =new GridPane();
        gridQuestion1.setPrefSize(130,90);
        gridQuestion1.setLayoutX(50);
        gridQuestion1.setLayoutY(105);

        gridQuestion1.add(lblPrincipleAmount,0,0);
        gridQuestion1.add(lblPMT,0,2);
        gridQuestion1.add(lblTimePeriod,0,3);


        Label lblQuestion2 = new Label("How to calculate ?");
        lblQuestion2.setPrefSize(235,21);
        lblQuestion2.setLayoutX(24);
        lblQuestion2.setLayoutY(180);
        lblQuestion2.setId("question");

        Label lblInstruction1 = new Label(ch1 +" Insert all the other fields except the one which you wish to calculate.");
        lblInstruction1.setPrefSize(410,20);
        lblInstruction1.setId("answer");

        Label lblInstruction2 = new Label(ch1 +" Use the on screen keyboard to avoid entering alphabetical values.");
        lblInstruction2.setPrefSize(410,20);
        lblInstruction2.setId("answer");

        Label lblInstruction3 = new Label(ch1 +" Click calculate button to calculate.");
        lblInstruction3.setPrefSize(410,20);
        lblInstruction3.setId("answer");

        Label lblInstruction4 = new Label(ch1 +" Cannot calculate interest or down payment in this calculator.");
        lblInstruction4.setPrefSize(410,20);
        lblInstruction4.setId("answer");

        Label lblInstruction5 = new Label(ch1 +" If down payment is zero you can leave it empty or put zero.");
        lblInstruction5.setPrefSize(410,20);
        lblInstruction5.setId("answer");

        GridPane gridQuestion2 =new GridPane();
        gridQuestion2.setPrefSize(410,125);
        gridQuestion2.setLayoutX(50);
        gridQuestion2.setLayoutY(212);

        gridQuestion2.add(lblInstruction1,0,0);
        gridQuestion2.add(lblInstruction2,0,1);
        gridQuestion2.add(lblInstruction3,0,2);
        gridQuestion2.add(lblInstruction4,0,3);
        gridQuestion2.add(lblInstruction5,0,4);


        Label lblQuestion3 = new Label("What to enter ?");
        lblQuestion3.setPrefSize(235,21);
        lblQuestion3.setLayoutX(24);
        lblQuestion3.setLayoutY(341);
        lblQuestion3.setId("question");

        Label lblHousePrice2 = new Label(ch1 +" House Price");
        lblHousePrice2.setPrefSize(150,20);
        lblHousePrice2.setId("answer");

        Label lblDownPayment2 = new Label(ch1 +" Down Payment");
        lblDownPayment2.setPrefSize(150,20);
        lblDownPayment2.setId("answer");

        Label lblPMT2 = new Label(ch1 +" Monthly Payment");
        lblPMT2.setPrefSize(150,20);
        lblPMT2.setId("answer");

        Label lblTimePeriod2 = new Label(ch1 +" Time Period");
        lblTimePeriod2.setPrefSize(150,20);
        lblTimePeriod2.setId("answer");

        Label lblInterestRate2 = new Label(ch1 +" Interest Rate");
        lblInterestRate2.setPrefSize(150,20);
        lblInterestRate2.setId("answer");


        Label lblHousePrice1 = new Label("Full price including down payment");
        lblHousePrice1.setPrefSize(250,20);
        lblHousePrice1.setId("answer");

        Label lblDownPayment1 = new Label("Down payment");
        lblDownPayment1.setPrefSize(200,20);
        lblDownPayment1.setId("answer");

        Label lblPMT1 = new Label("Monthly payment amount");
        lblPMT1.setPrefSize(200,20);
        lblPMT1.setId("answer");

        Label lblTimePeriod1 = new Label("Time of investment in years");
        lblTimePeriod1.setPrefSize(200,20);
        lblTimePeriod1.setId("answer");

        Label lblInterestRate1 = new Label("Annual Interest Rate");
        lblInterestRate1.setPrefSize(200,20);
        lblInterestRate1.setId("answer");

        GridPane gridQuestion3 =new GridPane();
        gridQuestion3.setPrefSize(350,95);
        gridQuestion3.setLayoutX(50);
        gridQuestion3.setLayoutY(370);

        gridQuestion3.add(lblHousePrice2,0,0);
        gridQuestion3.add(lblDownPayment2,0,1);
        gridQuestion3.add(lblPMT2,0,2);
        gridQuestion3.add(lblTimePeriod2,0,3);
        gridQuestion3.add(lblInterestRate2,0,4);

        gridQuestion3.add(lblHousePrice1,1,0);
        gridQuestion3.add(lblDownPayment1,1,1);
        gridQuestion3.add(lblPMT1,1,2);
        gridQuestion3.add(lblTimePeriod1,1,3);
        gridQuestion3.add(lblInterestRate1,1,4);

        Button btnClose = new Button("Close");
        btnClose.setFocusTraversable(false);
        btnClose.setId("btnClose");
        btnClose.setPrefSize(70,30);
        btnClose.setLayoutX(360);
        btnClose.setLayoutY(450);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnClose.getScene().getWindow();
                stage.close();
            }
        });

        AnchorPane root=new AnchorPane();
        root.getChildren().addAll(lblheading,lblQuestion1,lblQuestion2,lblQuestion3,gridQuestion1,gridQuestion2,gridQuestion3,btnClose);
        root.setId("root");
        Scene scene=new Scene(root,500,550);
        scene.getStylesheets().add("css/layout.css");
        return scene;
    }


//--------------------------------------------------------------------------------------------------------------------//
//************************************************** Loan Calculator *************************************************//
//--------------------------------------------------------------------------------------------------------------------//

    public static Scene Loan(){

        Label lblheading =new Label("Help View - Loan Calculator");
        lblheading.setPrefSize(479,55);
        lblheading.setLayoutX(3);
        lblheading.setLayoutY(3);
        lblheading.setId("label-heading");

        Label lblQuestion1 = new Label("What can this calculator calculate ?");
        lblQuestion1.setPrefSize(250,21);
        lblQuestion1.setLayoutX(24);
        lblQuestion1.setLayoutY(76);
        lblQuestion1.setId("question");

        Label lblPrincipleAmount = new Label(ch1 +" Loan Amount");
        lblPrincipleAmount.setPrefSize(150,20);
        lblPrincipleAmount.setId("answer");


        Label lblPMT = new Label(ch1 +" Monthly Payment");
        lblPMT.setPrefSize(150,20);
        lblPMT.setId("answer");

        Label lblTimePeriod = new Label(ch1 +" Time Period");
        lblTimePeriod.setPrefSize(150,20);
        lblTimePeriod.setId("answer");

        GridPane gridQuestion1 =new GridPane();
        gridQuestion1.setPrefSize(140,90);
        gridQuestion1.setLayoutX(50);
        gridQuestion1.setLayoutY(105);

        gridQuestion1.add(lblPrincipleAmount,0,0);
        gridQuestion1.add(lblPMT,0,2);
        gridQuestion1.add(lblTimePeriod,0,3);


        Label lblQuestion2 = new Label("How to calculate ?");
        lblQuestion2.setPrefSize(250,21);
        lblQuestion2.setLayoutX(24);
        lblQuestion2.setLayoutY(180);
        lblQuestion2.setId("question");

        Label lblInstruction1 = new Label(ch1 +" Insert all the other fields except the one which you wish to calculate.");
        lblInstruction1.setPrefSize(410,20);
        lblInstruction1.setId("answer");

        Label lblInstruction2 = new Label(ch1 +" Use the on screen keyboard to avoid entering alphabetical values.");
        lblInstruction2.setPrefSize(410,20);
        lblInstruction2.setId("answer");

        Label lblInstruction3 = new Label(ch1 +" Click calculate button to calculate.");
        lblInstruction3.setPrefSize(410,20);
        lblInstruction3.setId("answer");

        Label lblInstruction4 = new Label(ch1 +" Cannot calculate interest in this calculator.");
        lblInstruction4.setPrefSize(410,20);
        lblInstruction4.setId("answer");


        GridPane gridQuestion2 =new GridPane();
        gridQuestion2.setPrefSize(410,110);
        gridQuestion2.setLayoutX(50);
        gridQuestion2.setLayoutY(212);

        gridQuestion2.add(lblInstruction1,0,0);
        gridQuestion2.add(lblInstruction2,0,1);
        gridQuestion2.add(lblInstruction3,0,2);
        gridQuestion2.add(lblInstruction4,0,3);


        Label lblQuestion3 = new Label(" What to enter ?");
        lblQuestion3.setPrefSize(235,21);
        lblQuestion3.setLayoutX(24);
        lblQuestion3.setLayoutY(321);
        lblQuestion3.setId("question");

        Label lblLoanAmount2 = new Label(ch1 +" Loan Amount");
        lblLoanAmount2.setPrefSize(150,20);
        lblLoanAmount2.setId("answer");

        Label lblPMT2 = new Label(ch1 +" Monthly Payment");
        lblPMT2.setPrefSize(150,20);
        lblPMT2.setId("answer");

        Label lblTimePeriod2 = new Label(ch1 +" Time Period");
        lblTimePeriod2.setPrefSize(150,20);
        lblTimePeriod2.setId("answer");

        Label lblInterestRate2 = new Label(ch1 +" Interest Rate");
        lblInterestRate2.setPrefSize(150,20);
        lblInterestRate2.setId("answer");


        Label lblLoanAmunt1 = new Label("Loan Amount");
        lblLoanAmunt1.setPrefSize(250,20);
        lblLoanAmunt1.setId("answer");

        Label lblPMT1 = new Label("Monthly payment amount");
        lblPMT1.setPrefSize(200,20);
        lblPMT1.setId("answer");

        Label lblTimePeriod1 = new Label("Time of investment in years");
        lblTimePeriod1.setPrefSize(200,20);
        lblTimePeriod1.setId("answer");

        Label lblInterestRate1 = new Label("Annual Interest Rate");
        lblInterestRate1.setPrefSize(200,20);
        lblInterestRate1.setId("answer");

        GridPane gridQuestion3 =new GridPane();
        gridQuestion3.setPrefSize(350,95);
        gridQuestion3.setLayoutX(50);
        gridQuestion3.setLayoutY(350);

        gridQuestion3.add(lblLoanAmount2,0,0);
        gridQuestion3.add(lblPMT2,0,1);
        gridQuestion3.add(lblTimePeriod2,0,2);
        gridQuestion3.add(lblInterestRate2,0,3);

        gridQuestion3.add(lblLoanAmunt1,1,0);
        gridQuestion3.add(lblPMT1,1,1);
        gridQuestion3.add(lblTimePeriod1,1,2);
        gridQuestion3.add(lblInterestRate1,1,3);

        Button btnClose = new Button("Close");
        btnClose.setFocusTraversable(false);
        btnClose.setId("btnClose");
        btnClose.setPrefSize(70,30);
        btnClose.setLayoutX(360);
        btnClose.setLayoutY(450);
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnClose.getScene().getWindow();
                stage.close();
            }
        });

        AnchorPane root=new AnchorPane();
        root.getChildren().addAll(lblheading,lblQuestion1,lblQuestion2,lblQuestion3,gridQuestion1,gridQuestion2,gridQuestion3,btnClose);
        root.setId("root");
        Scene scene=new Scene(root,500,550);
        scene.getStylesheets().add("css/layout.css");
        return scene;
    }

}
//********************************************************************************************************************//