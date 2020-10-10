package com.hirunz2000;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MortgageCalculatorWindow  {

    public static Scene MortgageCalculator() {
        //display keyboard before clicking a textfield and  not allows to eenter.
        GridPane keyboardGrid=new GridPane();
        Keyboard.keyboardDisplay(keyboardGrid,null);

//-----------------------------------------------------------Input Labels---------------------------------------------//


        Label lblHeading =new Label("Mortgage Calculator");
        lblHeading.setPrefSize(498,55);
        lblHeading.setLayoutX(3);
        lblHeading.setLayoutY(3);
        lblHeading.setId("label-heading");



        Label lblMonthlyPay =new Label("Monthly Pay");
        lblMonthlyPay.setPrefSize(105,21);
        lblMonthlyPay.setId("label1");

        Label lblHousePrice =new Label("Home Price");
        lblHousePrice.setPrefSize(105,21);
        lblHousePrice.setId("label1");

        Label lblDownPayment =new Label("Down Payment");
        lblDownPayment.setPrefSize(105,21);
        lblDownPayment.setId("label1");

        Label lblLoanTerm =new Label("Loan Term");
        lblLoanTerm.setPrefSize(105,21);
        lblLoanTerm.setId("label1");

        Label lblInterestRate =new Label("Interest Rate");
        lblInterestRate.setPrefSize(105,21);
        lblInterestRate.setId("label1");


//--------------------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------Input TextFields--------------------------------------------//
        TextField txtMonthlyPay = new TextField();
        txtMonthlyPay.setPrefSize(176,25);
        txtMonthlyPay.setId("txt");
        txtMonthlyPay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid,txtMonthlyPay);
            }
        });

        TextField txtHousePrice =new TextField();
        txtHousePrice.setPrefSize(176,25);
        txtHousePrice.setId("txt");
        txtHousePrice.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid,txtHousePrice);
            }
        });

        TextField txtDownPayment =new TextField();
        txtDownPayment.setPrefSize(176,25);
        txtDownPayment.setId("txt");
        txtDownPayment.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid,txtDownPayment);
            }
        });

        TextField txtLoanTerm = new TextField();
        txtLoanTerm.setPrefSize(176,25);
        txtLoanTerm.setId("txt");
        txtLoanTerm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid,txtLoanTerm);
            }
        });

        TextField txtInterestRate = new TextField();
        txtInterestRate.setPrefSize(176,25);
        txtInterestRate.setId("txt");
        txtInterestRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid,txtInterestRate);
            }
        });

//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Add Inputs to a gridpane---------------------------------------//

        GridPane inputs=new GridPane();
        inputs.setPrefSize(288,226);
        inputs.setVgap(5);
        inputs.setLayoutX(35);
        inputs.setLayoutY(90);

        inputs.add(lblMonthlyPay,0,0);
        inputs.add(lblHousePrice,0,1);
        inputs.add(lblDownPayment,0,2);
        inputs.add(lblLoanTerm,0,3);
        inputs.add(lblInterestRate,0,4);

        inputs.add(txtMonthlyPay,1,0);
        inputs.add(txtHousePrice,1,1);
        inputs.add(txtDownPayment,1,2);
        inputs.add(txtLoanTerm,1,3);
        inputs.add(txtInterestRate,1,4);

//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Retrieving Last Entry------------------------------------------//

        Double[] lastEntries = new Double[5];
        try {
            try {

                File file = new File("src/history/lastEntry/last-entry-mortgage.txt");

                Scanner input = new Scanner(file);
                for (int i = 0; i < lastEntries.length; i++) {
                    lastEntries[i]=input.nextDouble();
                }
                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }catch (InputMismatchException e){// to handle the error when the file is empty
            System.out.println("File is empty.");;
        }
        txtMonthlyPay.setText(String.valueOf(lastEntries[0]));
        txtHousePrice.setText(String.valueOf(lastEntries[1]));
        txtInterestRate.setText(String.valueOf(lastEntries[2]));
        txtLoanTerm.setText(String.valueOf(lastEntries[3]));
        txtDownPayment.setText(String.valueOf(lastEntries[4]));

//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Input Type Labels----------------------------------------------//


        Label dollar1=new Label("$");
        dollar1.setPrefSize(15,25);
        dollar1.setId("label1");

        Label dollar2=new Label("$");
        dollar2.setPrefSize(15,25);
        dollar2.setId("label1");

        Label dollar3=new Label("$");
        dollar3.setPrefSize(15,25);
        dollar3.setId("label1");

        Label period=new Label("yrs");
        period.setPrefSize(20,25);
        period.setId("label1");

        Label rate=new Label("%");
        rate.setPrefSize(15,25);
        rate.setId("label1");


//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------------Input Type Grid----------------------------------------------//

        GridPane inputType=new GridPane();
        inputType.setPrefSize(256,226);
        inputType.setVgap(5);
        inputType.setLayoutX(295);
        inputType.setLayoutY(90);

        inputType.add(dollar1,0,0);
        inputType.add(dollar2,0,1);
        inputType.add(dollar3,0,2);
        inputType.add(period,0,3);
        inputType.add(rate,0,4);


//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Calculate button-----------------------------------------------//

        Button btnCalculate = new Button("Calculate");
        btnCalculate.setId("btnCalculate");
        btnCalculate.setPrefSize(84,35);
        btnCalculate.setLayoutX(210);
        btnCalculate.setLayoutY(260);
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = "%.2f";
                int arrSize=5;
                // assigning textfield text to  array to validate
                String[] arr=new String[arrSize];
                arr[0]=txtMonthlyPay.getText();
                arr[1]=txtHousePrice.getText();
                arr[2]=txtInterestRate.getText();
                arr[3]=txtLoanTerm.getText();
                arr[4]=txtDownPayment.getText();

                //finds out how many empty strings are there in the array
                int EmptyStringCount =Validations.EmptyStringCount(arr,arrSize,4);
                if(EmptyStringCount >1 | EmptyStringCount ==0 ){
                    Validations.InputErrorAlert("(except down payment) ");
                }
                else if(arr[2].isEmpty()){
                    //if empty number count is greater than 1 or less than 1 cannot calculate
                    Validations.EmptyInterestAlert();
                }
                else {
                    //if there is only one empty index, this block will execute.
                    //then takes finds out the empty string index.
                    int EmptyStringIndex = Validations.EmptyStringIndex(arr, arrSize);
                    // according to the empty string index, the relevant code block will execute.
                    if (Validations.doubleInputCheck(arr)) {
                        if (arr[4].isEmpty()){
                            //assigned value 0 to down payment if  there is no value.
                            arr[4]="0";
                            txtDownPayment.setText("0.00");
                        }
                        if (EmptyStringIndex == 0) {
                            double P = Double.valueOf(arr[1] )-Double.valueOf(arr[4]);
                            double r = Double.valueOf(arr[2]);
                            double t = Double.valueOf(arr[3]);
                            //creating an object of formulae class
                            Formulae Loan = new Formulae();
                            // then pass the relevant arguments to the method and get the result.
                            double result = Loan.PMT(P, r, t);
                            // finally sets the value to the empty textfield.
                            txtMonthlyPay.setText(String.format(str, result));
                        }
                        else if (EmptyStringIndex ==1){
                            double PMT = Double.valueOf(arr[0]);
                            double r = Double.valueOf(arr[2]);
                            double t = Double.valueOf(arr[3]);
                            //creating an object of formulae class
                            Formulae Loan = new Formulae();
                            // then pass the relevant arguments to the method and get the result
                            double result = Loan.LoanAmount(PMT, t, r);
                            // finally sets the value to the empty textfield.
                            txtHousePrice.setText(String.format(str, result +Double.valueOf(arr[4])));
                        }
                        else {
                            double P = Double.valueOf(arr[1] )-Double.valueOf(arr[4]);
                            double r = Double.valueOf(arr[2]);
                            double PMT = Double.valueOf(arr[0]);
                            //creating an object of formulae class
                            Formulae Loan = new Formulae();
                            // then pass the relevant arguments to the method and get the result
                            double result = Loan.LoanTerm(P, PMT, r);
                            // finally sets the value to the empty textfield.
                            txtLoanTerm.setText(String.format(str,result));

                        }
                    //-----------------------------file handling------------------------------------------------------//
                        //once the above code block is executed, writing to the file.
                        //to make the history more sense, i added date and time to the entry.

                        //date and time
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime currentTime = LocalDateTime.now();

                        //write to file begins.
                        FileWriter fileWriter =null;
                        PrintWriter output =null;
                        File file=new File("src/history/history-mortgage.txt");

                        try{

                            fileWriter =new FileWriter(file,true);
                            output =new PrintWriter(fileWriter,true); //auto flush.

                            output.write("***************************************************\n");
                            output.write("***********  Entry:"+dateTimeFormatter.format(currentTime)+"  ***********\n");
                            output.write("***************************************************\n");

                            output.write(String.format("Monthly Pay  :  $%12s\n",Double.valueOf(txtMonthlyPay.getText())));
                            output.write(String.format("Home Price   :  $%12s\n",Double.valueOf(txtHousePrice.getText())));
                            output.write(String.format("Interest Rate:   %10s %%\n",Double.valueOf(txtInterestRate.getText())));
                            output.write(String.format("Loan Term    :   %8s yrs\n",Double.valueOf(txtLoanTerm.getText())));
                            output.write(String.format("Down Payment :  $%12s\n",Double.valueOf(txtDownPayment.getText())));

                            output.write("***************************************************\n\n\n");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally {
                            try {
                                fileWriter.close();// closing the file writer.
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            output.close();// closing the output.
                        }

                        // again I write write to a file. This time i don't use auto flush because  i want to overwrite.
                        // by overwriting, i save the last entry.

                        try {
                            File file1=new File("src/history/lastEntry/last-entry-mortgage.txt");
                            FileWriter fileWriter1=new FileWriter(file1);

                            fileWriter1.write(Double.valueOf(txtMonthlyPay.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtHousePrice.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtInterestRate.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtLoanTerm.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtDownPayment.getText()) + "\n");
                            fileWriter1.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------Clear button-------------------------------------------------------//

        Button btnClear = new Button("Clear");
        btnClear.setId("btnClear");
        btnClear.setPrefSize(70,35);
        btnClear.setLayoutX(40);
        btnClear.setLayoutY(260);
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtMonthlyPay.setText("");
                txtHousePrice.setText("");
                txtDownPayment.setText("");
                txtInterestRate.setText("");
                txtLoanTerm.setText("");

            }
        });

//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------Back button--------------------------------------------------------//

        Button btnBack = new Button("Go Back");
        btnBack.setId("btn2");
        btnBack.setPrefSize(60,20);
        btnBack.setLayoutX(10);
        btnBack.setLayoutY(15);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //closing the current stage
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.close();

                Stage primaryStage=new Stage();
                //setting a fix size for stage
                primaryStage.setMaxHeight(440);
                primaryStage.setMaxWidth(420);
                primaryStage.setMinHeight(440);
                primaryStage.setMinWidth(420);

                primaryStage.setTitle("All in One Finance Calculator");
                primaryStage.setScene(MainMenu.Mainmenu());
                primaryStage.show();
            }
        });

//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------Help button--------------------------------------------------------//

        Button btnHelp = new Button("Help");
        btnHelp.setId("btn2");
        btnHelp.setPrefSize(60,20);
        btnHelp.setLayoutX(360);
        btnHelp.setLayoutY(15);
        btnHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage=new Stage();
                //setting a fix size for stage
                primaryStage.setMaxHeight(550);
                primaryStage.setMaxWidth(500);
                primaryStage.setMinHeight(550);
                primaryStage.setMinWidth(500);

                primaryStage.setTitle("All in One Finance Calculator");
                primaryStage.setScene(HelpView.Mortgage());
                primaryStage.show();
            }
        });

//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------History button-----------------------------------------------------//

        Button btnHistory = new Button("History");
        btnHistory.setId("btn2");
        btnHistory.setPrefSize(60,20);
        btnHistory.setLayoutX(430);
        btnHistory.setLayoutY(15);
        btnHistory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HistoryDisplay.history("src/history/history-mortgage.txt");

            }
        });

//--------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------Adding to anchorPane and stage display-----------------------------------//

        AnchorPane root =new AnchorPane();
        root.getChildren().addAll(lblHeading,inputs, inputType,keyboardGrid,btnCalculate,btnClear,btnBack, btnHistory,btnHelp);
        root.setId("root");

        Scene scene=new Scene(root,500,400);
        scene.getStylesheets().add("css/layout.css");// link to external css
        return scene;

    }

}
//********************************************************************************************************************//