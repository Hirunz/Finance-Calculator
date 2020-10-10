package com.hirunz2000;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Keyboard{
    // keyboard
    public static void keyboardDisplay(GridPane keyboardGrid,TextField txt){

        // setting properties for the received gridpane
        keyboardGrid.setPrefSize(141,228);
        keyboardGrid.setHgap(5);
        keyboardGrid.setVgap(5);
        keyboardGrid.setLayoutX(335);
        keyboardGrid.setLayoutY(80);
        keyboardGrid.setId("keyboard");// id for external css


     //---------------------------------------------- keyboard buttons------------------------------------------------//

        Button btnZero=new Button("0");
        btnZero.setPrefSize(45,45);
        btnZero.setFocusTraversable(false);
        btnZero.setId("keyboardButton");
        btnZero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("0"); //add 0 to the received textfield
                }
            }
        });

        Button btnPeriod =new Button(".");
        btnPeriod.setPrefSize(45,45);
        btnPeriod.setFocusTraversable(false);
        btnPeriod.setId("period");
        btnPeriod.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    if (!txt.getText().contains(".")) {
                        txt.appendText(".");//add period to the received textfield

                    } else {
                        //if there is a period sign already, shows an error message
                        Validations.periodErrorAlert();
                    }
                }

            }
        });

        Button btnOne =new Button("1");
        btnOne.setPrefSize(45,45);
        btnOne.setFocusTraversable(false);
        btnOne.setId("keyboardButton");
        btnOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("1");//add 1 to the received textfield
                }
            }
        });

        Button btnTwo =new Button("2");
        btnTwo.setPrefSize(45,45);
        btnTwo.setFocusTraversable(false);
        btnTwo.setId("keyboardButton");
        btnTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("2");//add 2 to the received textfield
                }
            }
        });

        Button btnThree =new Button("3");
        btnThree.setPrefSize(45,45);
        btnThree.setFocusTraversable(false);
        btnThree.setId("keyboardButton");
        btnThree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("3");//add 3 to the received textfield
                }
            }
        });

        Button btnFour =new Button("4");
        btnFour.setPrefSize(45,45);
        btnFour.setFocusTraversable(false);
        btnFour.setId("keyboardButton");
        btnFour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("4");//add 4 to the received textfield
                }
            }
        });

        Button btnFive =new Button("5");
        btnFive.setPrefSize(45,45);
        btnFive.setFocusTraversable(false);
        btnFive.setId("keyboardButton");
        btnFive.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("5");//add 5 to the received textfield
                }
            }
        });

        Button btnSix =new Button("6");
        btnSix.setPrefSize(45,45);
        btnSix.setFocusTraversable(false);
        btnSix.setId("keyboardButton");
        btnSix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("6");//add 6 to the received textfield
                }
            }
        });

        Button btnSeven =new Button("7");
        btnSeven.setPrefSize(45,45);
        btnSeven.setFocusTraversable(false);
        btnSeven.setId("keyboardButton");
        btnSeven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("7");//add 7 to the received textfield
                }
            }
        });

        Button btnEight =new Button("8");
        btnEight.setPrefSize(45,45);
        btnEight.setFocusTraversable(false);
        btnEight.setId("keyboardButton");
        btnEight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("8");//add 8 to the received textfield
                }
            }
        });

        Button btnNine =new Button("9");
        btnNine.setPrefSize(45,45);
        btnNine.setFocusTraversable(false);
        btnNine.setId("keyboardButton");
        btnNine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.appendText("9");//add 9 to the received textfield
                }
            }
        });

        Button btnBackSP =new Button("Backspace");
        btnBackSP.setPrefSize(90,45);
        btnBackSP.setFocusTraversable(false);
        btnBackSP.setId("backSP");
        btnBackSP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    String str = txt.getText();
                   if (str.length()>0) {// deletes only if the string is not null
                       str = str.substring(0, str.length() - 1);//make a substring of the textfield string and return
                       txt.setText(str);
                   }


                }
            }
        });

        Button btnClr =new Button("Del");
        btnClr.setPrefSize(45,45);
        btnClr.setFocusTraversable(false);
        btnClr.setId("backSP");// applied  the same id in css
        btnClr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txt!=null) {
                    txt.setText("");// clears a one textfield completely
                }
            }
        });

        //--------------------------------------------add buttons to keyboard grid------------------------------------//
        keyboardGrid.add(btnBackSP,0,0,2,1);
        keyboardGrid.add(btnSeven,0,1);
        keyboardGrid.add(btnClr,2,0);
        keyboardGrid.add(btnEight,1,1);
        keyboardGrid.add(btnNine,2,1);
        keyboardGrid.add(btnFour,0,2);
        keyboardGrid.add(btnFive,1,2);
        keyboardGrid.add(btnSix,2,2);
        keyboardGrid.add(btnOne,0,3);
        keyboardGrid.add(btnTwo,1,3);
        keyboardGrid.add(btnThree,2,3);
        keyboardGrid.add(btnZero,0,4);
        keyboardGrid.add(btnPeriod,2,4);

    }

}
//********************************************************************************************************************//