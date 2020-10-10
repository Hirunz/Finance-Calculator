package com.hirunz2000;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LoanCalculatorWindow {
    public static Scene LoanCalculator() {
        //display keyboard before clicking a textfield and  not allows to eenter.
        GridPane keyboardGrid=new GridPane();
        Keyboard.keyboardDisplay(keyboardGrid,null);

        Label lblHeading =new Label("Auto Loan Calculator");
        lblHeading.setPrefSize(498,55);
        lblHeading.setLayoutX(3);
        lblHeading.setLayoutY(3);
        lblHeading.setId("label-heading");

        //-------------------------------------------------Input Labels ----------------------------------------------//
        Label lblMonthlyPay =new Label("Monthly Pay");
        lblMonthlyPay.setPrefSize(105,21);
        lblMonthlyPay.setId("label1");

        Label lblAutoLoan =new Label("Auto Loan");
        lblAutoLoan.setPrefSize(105,21);
        lblAutoLoan.setId("label1");

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

        TextField txtAutoLoan = new TextField();
        txtAutoLoan.setPrefSize(176,25);
        txtAutoLoan.setId("txt");
        txtAutoLoan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid,txtAutoLoan);
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

        GridPane inputGrid=new GridPane();
        inputGrid.setPrefSize(288,226);
        inputGrid.setVgap(5);
        inputGrid.setLayoutX(35);
        inputGrid.setLayoutY(100);

        inputGrid.add(lblMonthlyPay,0,0);
        inputGrid.add(lblAutoLoan,0,1);
        inputGrid.add(lblLoanTerm,0,2);
        inputGrid.add(lblInterestRate,0,3);


        inputGrid.add(txtMonthlyPay,1,0);
        inputGrid.add(txtAutoLoan,1,1);
        inputGrid.add(txtLoanTerm,1,2);
        inputGrid.add(txtInterestRate,1,3);

//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Retrieving Last Entry------------------------------------------//

        Double[] lastEntries = new Double[4];
        try {
            try {

                File file = new File("src/history/lastEntry/last-entry-loan.txt");

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
        txtAutoLoan.setText(String.valueOf(lastEntries[1]));
        txtInterestRate.setText(String.valueOf(lastEntries[2]));
        txtLoanTerm.setText(String.valueOf(lastEntries[3]));


//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Input Type Labels----------------------------------------------//

        Label dollar1=new Label("$");
        dollar1.setPrefSize(15,25);
        dollar1.setId("label1");
        
        Label dollar2=new Label("$");
        dollar2.setPrefSize(15,25);
        dollar2.setId("label1");
        
        Label period=new Label("yrs");
        period.setPrefSize(20,25);
        period.setId("label1");
        
        Label rate=new Label("%");
        rate.setPrefSize(15,25);
        rate.setId("label1");

// -------------------------------------------------------------------------------------------------------------------//
//------------------------------------------------Input Type Grid-----------------------------------------------------//
        GridPane inputType=new GridPane();
        inputType.setPrefSize(256,226);
        inputType.setVgap(5);
        inputType.setLayoutX(295);
        inputType.setLayoutY(100);

        inputType.add(dollar1,0,0);
        inputType.add(dollar2,0,1);
        inputType.add(period,0,2);
        inputType.add(rate,0,3);

//--------------------------------------------------------------------------------------------------------------------//
// ----------------------------------------------------Calculate button-----------------------------------------------//

        Button btnCalculate = new Button("Calculate");
        btnCalculate.setId("btnCalculate");
        btnCalculate.setPrefSize(84,35);
        btnCalculate.setLayoutX(210);
        btnCalculate.setLayoutY(260);
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str = "%.2f";
               int arrSize=4;
                // assigning textfield text to  array to validate
                String[] arr=new String[arrSize];
                arr[0]=txtMonthlyPay.getText();
                arr[1]=txtAutoLoan.getText();
                arr[2]=txtInterestRate.getText();
                arr[3]=txtLoanTerm.getText();

                //finds out how many empty strings are there in the array
                int EmptyStringCount =Validations.EmptyStringCount(arr,arrSize);
                if(EmptyStringCount >1 | EmptyStringCount ==0){
                    //if empty number count is greater than 1 or less than 1 cannot calculate
                    Validations.InputErrorAlert("");

                }
                else if(arr[2].isEmpty()){
                    Validations.EmptyInterestAlert();
                }
                else {
                    //if there is only one empty index, this block will execute.
                    //then takes finds out the empty string index.
                    int EmptyStringIndex = Validations.EmptyStringIndex(arr, arrSize);
                    if (Validations.doubleInputCheck(arr)) {
                        // according to the empty string index, the relevant code block will execute.
                        //creating formulae object andthen pass the relevant arguments to the method and get the result.
                        // finally sets the value to the empty textfield.

                        if (EmptyStringIndex == 0) {
                            double P = Double.valueOf(arr[1] );
                            double r = Double.valueOf(arr[2]);
                            double t = Double.valueOf(arr[3]);
                            Formulae Loan = new Formulae();
                            double result = Loan.PMT(P, r, t);
                            txtMonthlyPay.setText(String.format(str, result));

                        }
                        else if (EmptyStringIndex ==1){
                            double PMT = Double.valueOf(arr[0]);
                            double r = Double.valueOf(arr[2]);
                            double t = Double.valueOf(arr[3]);
                            Formulae Loan = new Formulae();
                            double result = Loan.LoanAmount(PMT, t, r);
                            double totalInterest=(PMT*(t * Formulae.n) - result);
                            txtAutoLoan.setText(String.format(str, result ));
                        }
                        else {
                            double P = Double.valueOf(arr[1] );
                            double r = Double.valueOf(arr[2]);
                            double PMT = Double.valueOf(arr[0]);
                            Formulae Loan = new Formulae();
                            double result = Loan.LoanTerm(P, PMT, r);
                            txtLoanTerm.setText(String.format(str,result));
                        }

                        //-----------------------------file handling--------------------------------------------------//
                        //once the above code block is executed, writing to the file.
                        //to make the history more sense, i added date and time to the entry.

                        //date and time
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime currentTime = LocalDateTime.now();

                        //write to file begins.
                        FileWriter fileWriter =null;
                        PrintWriter output =null;
                        File file=new File("src/history/history-loan.txt");

                        try{

                            fileWriter =new FileWriter(file,true);
                            output =new PrintWriter(fileWriter,true);

                            output.write("***************************************************\n");
                            output.write("***********  Entry:"+dateTimeFormatter.format(currentTime)+"  ***********\n");
                            output.write("***************************************************\n");

                            output.write(String.format("Monthly Pay  :  $%12s\n",Double.valueOf(txtMonthlyPay.getText())));
                            output.write(String.format("Loan Price   :  $%12s\n",Double.valueOf(txtAutoLoan.getText())));
                            output.write(String.format("Interest Rate:   %10s %%\n",Double.valueOf(txtInterestRate.getText())));
                            output.write(String.format("Loan Term    :   %8s yrs\n",Double.valueOf(txtLoanTerm.getText())));

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
                            File file1=new File("src/history/lastEntry/last-entry-loan.txt");
                            FileWriter fileWriter1=new FileWriter(file1);

                            fileWriter1.write(Double.valueOf(txtMonthlyPay.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtAutoLoan.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtInterestRate.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtLoanTerm.getText()) + " ");

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
                txtAutoLoan.setText("");
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
                primaryStage.setScene(HelpView.Loan());
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
                HistoryDisplay.history("src/history/history-loan.txt");

            }
        });

//--------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------Adding to anchorPane and stage display-----------------------------------//

        AnchorPane root =new AnchorPane();
        root.getChildren().addAll(lblHeading,inputGrid,inputType,btnCalculate,keyboardGrid,btnClear, btnBack,btnHelp,btnHistory);
        root.setId("root");

        Scene scene=new Scene(root,500,400);
        scene.getStylesheets().add("css/layout.css");// link to external css
        return scene;


    }
}
//********************************************************************************************************************//