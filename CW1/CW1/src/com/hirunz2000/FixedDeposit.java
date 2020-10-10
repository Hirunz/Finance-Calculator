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

public class FixedDeposit {
    public static Scene FD(){
        //display keyboard before clicking a textfield and  not allows to enter.
        GridPane keyboardGrid=new GridPane();
        Keyboard.keyboardDisplay(keyboardGrid,null);

//-----------------------------------------------------------Input Labels---------------------------------------------//
        Label lblHeading =new Label("Fixed Deposit Calculator");
        lblHeading.setPrefSize(498,55);
        lblHeading.setLayoutX(3);
        lblHeading.setLayoutY(3);
        lblHeading.setId("label-heading");

        Label lblPrincipleAmount =new Label("Principle Amount");
        lblPrincipleAmount.setPrefSize(125,21);
        lblPrincipleAmount.setId("label1");

        Label lblFutureValue =new Label("Future Value");
        lblFutureValue.setPrefSize(125,21);
        lblFutureValue.setId("label1");

        Label lblInterestRate =new Label("Interest Rate");
        lblInterestRate.setPrefSize(125,21);
        lblInterestRate.setId("label1");

        Label lblTimePeriod =new Label("Time Period");
        lblTimePeriod.setPrefSize(125,21);
        lblTimePeriod.setId("label1");

//--------------------------------------------------------------------------------------------------------------------//
//--------------------------------------------------------Input TextFields--------------------------------------------//

        TextField txtPrincipleAmount = new TextField();
        txtPrincipleAmount.setPrefSize(170,25);
        txtPrincipleAmount.setId("txt");
        txtPrincipleAmount.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid, txtPrincipleAmount);
            }
        });

        TextField txtFutureValue =new TextField();
        txtFutureValue.setPrefSize(170,25);
        txtFutureValue.setId("txt");
        txtFutureValue.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid, txtFutureValue);
            }
        });

        TextField txtInterestRate =new TextField();
        txtInterestRate.setPrefSize(170,25);
        txtInterestRate.setId("txt");
        txtInterestRate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid, txtInterestRate);
            }
        });

        TextField txtTimePeriod = new TextField();
        txtTimePeriod.setPrefSize(170,25);
        txtTimePeriod.setId("txt");
        txtTimePeriod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Keyboard.keyboardDisplay(keyboardGrid, txtTimePeriod);
            }
        });


//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Add Inputs to a gridpane---------------------------------------//

        GridPane inputs=new GridPane();
        inputs.setPrefSize(288,226);
        inputs.setVgap(5);
        inputs.setLayoutX(35);
        inputs.setLayoutY(100);

        inputs.add(lblPrincipleAmount,0,0);
        inputs.add(lblFutureValue,0,1);
        inputs.add(lblInterestRate,0,2);
        inputs.add(lblTimePeriod,0,3);

        inputs.add(txtPrincipleAmount,1,0);
        inputs.add(txtFutureValue,1,1);
        inputs.add(txtInterestRate,1,2);
        inputs.add(txtTimePeriod,1,3);

//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Retrieving Last Entry------------------------------------------//

        Double[] lastEntries = new Double[4];
        try {
            try {

                File file = new File("src/history/lastEntry/last-entry-fd.txt");

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
        txtPrincipleAmount.setText(String.valueOf(lastEntries[0]));
        txtFutureValue.setText(String.valueOf(lastEntries[1]));
        txtInterestRate.setText(String.valueOf(lastEntries[2]));
        txtTimePeriod.setText(String.valueOf(lastEntries[3]));


//--------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------Input Type Labels----------------------------------------------//

        Label dollar1=new Label(" $");
        dollar1.setPrefSize(15,25);
        dollar1.setId("label1");

        Label dollar2=new Label(" $");
        dollar2.setPrefSize(15,25);
        dollar2.setId("label1");

        Label rate=new Label("%");
        rate.setPrefSize(15,25);
        rate.setId("label1");

        Label period=new Label("yrs");
        period.setPrefSize(20,25);
        period.setId("label1");

//--------------------------------------------------------------------------------------------------------------------//
//-------------------------------------------------------Input Type Grid----------------------------------------------//

        GridPane inputType=new GridPane();
        inputType.setPrefSize(256,226);
        inputType.setVgap(5);
        inputType.setLayoutX(295);
        inputType.setLayoutY(100);

        inputType.add(dollar1,0,0);
        inputType.add(dollar2,0,1);
        inputType.add(rate,0,2);
        inputType.add(period,0,3);

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
                int arrSize=4;
                // assigning textfield text to  array to validate
                String[] arr=new String[arrSize];
                arr[0]= txtPrincipleAmount.getText();
                arr[1]=txtFutureValue.getText();
                arr[2]=txtInterestRate.getText();
                arr[3]=txtTimePeriod.getText();

                //finds out how many empty strings are there in the array
                int EmptyStringCount =Validations.EmptyStringCount(arr,arrSize);
                if(EmptyStringCount !=1){
                    //if empty number count is greater than 1 or less than 1 cannot calculate
                    Validations.InputErrorAlert("");
                }
                else {
                    //if there is only one empty index, this block will execute.
                    //then takes finds out the empty string index.
                    int EmptyStringIndex = Validations.EmptyStringIndex(arr, arrSize);
                    // according to the empty string index, the relevant code block will execute.
                    if (Validations.doubleInputCheck(arr)) {
                        //creating formulae object andthen pass the relevant arguments to the method and get the result.
                        // finally sets the value to the empty textfield.
                        if (EmptyStringIndex == 0) {
                            Formulae P=new Formulae();
                            double result=P.presentValue(Double.valueOf(arr[3]),Double.valueOf(arr[1]),Double.valueOf(arr[2]));
                            txtPrincipleAmount.setText(String.format(str,result));
                        }
                        else if (EmptyStringIndex ==1) {
                            Formulae A = new Formulae();
                            double result = A.futureValue(Double.valueOf(arr[3]), Double.valueOf(arr[0]), Double.valueOf(arr[2]));
                            txtFutureValue.setText(String.format(str, result));
                        }
                        else if (EmptyStringIndex ==2){
                            Formulae r=new Formulae();
                            double result=r.interestRate(Double.valueOf(arr[3]),Double.valueOf(arr[0]),Double.valueOf(arr[1]));
                            txtInterestRate.setText(String.format(str,result));
                        }
                        else {
                            Formulae t=new Formulae();
                            double result=t.timePeriod(Double.valueOf(arr[1]),Double.valueOf(arr[0]),Double.valueOf(arr[2]));
                            txtTimePeriod.setText(String.format(str,result));
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
                        File file=new File("src/history/history-fd.txt");

                        try{

                            fileWriter =new FileWriter(file,true);
                            output =new PrintWriter(fileWriter,true);

                            output.write("***************************************************\n");
                            output.write("***********  Entry:"+dateTimeFormatter.format(currentTime)+"  ***********\n");
                            output.write("***************************************************\n");

                            output.write(String.format("Principle Amount  :  $%12s\n",Double.valueOf(txtPrincipleAmount.getText())));
                            output.write(String.format("Future Value   :  $%12s\n",Double.valueOf(txtFutureValue.getText())));
                            output.write(String.format("Interest Rate:   %10s %%\n",Double.valueOf(txtInterestRate.getText())));
                            output.write(String.format("Time Period    :   %8s yrs\n",Double.valueOf(txtTimePeriod.getText())));

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
                            File file1=new File("src/history/lastEntry/last-entry-fd.txt");
                            FileWriter fileWriter1=new FileWriter(file1);

                            fileWriter1.write(Double.valueOf(txtPrincipleAmount.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtFutureValue.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtInterestRate.getText()) + " ");
                            fileWriter1.write(Double.valueOf(txtTimePeriod.getText()) + " ");
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
                txtPrincipleAmount.setText("");
                txtFutureValue.setText("");
                txtInterestRate.setText("");
                txtTimePeriod.setText("");
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
                primaryStage.setScene(HelpView.FD());
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
                HistoryDisplay.history("src/history/history-fd.txt");

            }
        });

//--------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------Adding to anchorPane and stage display-----------------------------------//

        AnchorPane root =new AnchorPane();
        root.getChildren().addAll(lblHeading,inputs, inputType,keyboardGrid,btnCalculate,btnClear,btnBack, btnHelp,btnHistory);
        root.setId("root");

        Scene scene=new Scene(root,500,400);
        scene.getStylesheets().add("css/layout.css");// link to external css
        return scene;
    }
}
