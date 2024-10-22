package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double firstX = checkScan(scanner);
        double firstY= checkScan(scanner);
        double secondX= checkScan(scanner);
        double secondY= checkScan(scanner);
        double triX= checkScan(scanner);
        double tixY= checkScan(scanner);
        double sidA = calcSide(firstX,firstY,secondX,secondY);
        double sidB = calcSide(secondX,secondY,triX,tixY);
        double sidC = calcSide(triX,tixY,firstX,firstY);
        if(chekTreugol(sidA,sidB,sidC)){
            double res = sidA + sidB+sidC;
            System.out.printf("Perimeter: %.3f",res);
        }else{
            System.out.println("It isn't triangle");
        }
        scanner.close();
    }
    public static double checkScan(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            double number;
            try {
                number = Double.parseDouble(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
    }
    public static boolean chekTreugol(double sidA,double sidB,double sidC){
        return sidA + sidB > sidC && sidB + sidC > sidA && sidA + sidC > sidB;
    }
    public  static double calcSide(double firstX,double firstY,double secondX,double secondY){
        return Math.sqrt(Math.pow((secondX-firstX),2) + Math.pow((secondY-firstY),2));
    }
}