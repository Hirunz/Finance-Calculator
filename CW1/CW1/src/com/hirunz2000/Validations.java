package com.hirunz2000;

import javafx.scene.control.Alert;

public class Validations {

    // This method checks whether the given String array can be converted into Double.
    // If possible, it will return true and otherwise it will put an error msg.
    // This method also ignores the empty strings.
    public static boolean doubleInputCheck(String[] arr){
        try{
            for(int i=0;i<arr.length;i++) {
                if (arr[i].isEmpty()) {
                    continue;
                }
                double double_input = Double.parseDouble(arr[i]);
            }
                return true;

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please input only integer or double values!");
            alert.showAndWait();
        }
        return false;
    }

    // this is an error message to inform the user to input only one field empty.
    //for mortgage calculation, there can be two empty fields but one of them must be down payment.
    public static void InputErrorAlert(String str){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText("Please leave only one field empty "+str+"to calculate.\nRefer HELP for more details.");
        alert.showAndWait();
    }

    // this method will accept a String array and returns the number of empty strings.
    // this method is used to prevent the user from entering all or leaving more than 2 text fields.
    public static int EmptyStringCount(String[] arr,int stop){
        int EmptyStringCount =0;
        for(int i=0;i<stop;i++){

            if(arr[i].isEmpty()){
                EmptyStringCount++;
            }
        }
        return EmptyStringCount;
    }

    // this method will return the empty string index of an array.
    // string with the index exception will be excluded.
    // this method used after the previous method.
    // this method determines what to calculate.
    public static int EmptyStringCount(String[] arr,int stop,int exception){
        int EmptyStringCount =0;
        for(int i=0;i<stop;i++){
            if(i==exception){
                continue;
            }
            if(arr[i].isEmpty()){
                EmptyStringCount++;
            }
        }
        return EmptyStringCount;
    }

    // this is an overloaded method of the EmptyStringCount method.
    // this is used when there is no exception.
    // usage is same as EmptyStringCount method
    public static int EmptyStringIndex(String[] arr,int stop){
        int EmptyStringIndex = 0;
        for(int i=0;i<stop;i++){
            if(arr[i].isEmpty()){
                EmptyStringIndex = i;
                break;
            }
        }
       return EmptyStringIndex;
    }

    // alert message to alert user that the interest cannot be calculated in relevant calculators.
    public static void EmptyInterestAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText("Sorry!. Cannot calculate interest in this calculator.");
        alert.showAndWait();
    }

    // this method is called only in keyboard class
    // this method is used to alert the user when they try to input more than one periods per text field.'
    public static void periodErrorAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText("Cannot enter period twice for a number!");
        alert.showAndWait();
    }



}
//********************************************************************************************************************//