package com.example.ammacias.appsorteo.Clase;

/**
 * Created by ammacias on 17/01/2017.
 */

public class Item {
    String input1;
    String input2;
    String input3;

    public Item() {
    }

    public Item(String input1) {
        this.input1 = input1;
    }

    public Item(String input1, String input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    public Item(String input1, String input2, String input3) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
    }

    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
    }

    public String getInput3() {
        return input3;
    }

    public void setInput3(String input3) {
        this.input3 = input3;
    }

    @Override
    public String toString() {
        return "Item{" +
                "input1='" + input1 + '\'' +
                ", input2='" + input2 + '\'' +
                ", input3='" + input3 + '\'' +
                '}';
    }
}
