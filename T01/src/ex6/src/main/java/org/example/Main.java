package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        while (true) {
            String inputStr = scanner.nextLine();
            try {
                count = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        if (count <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            double[] numbers = new double[count];
            while (true) {
                try {
                    String[] input = scanner.nextLine().split(" ");
                    if (input.length != count) {
                        System.out.println("Couldn't parse a number. Please, try again");
                        continue;
                    }
                    for (int i = 0; i < count; i++) {
                        numbers[i] = Double.parseDouble(input[i]);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Couldn't parse a number. Please, try again");
                }
            }
            numbers = sortMas(numbers);
            for(int i=0;i<numbers.length;i++){
                System.out.printf("%.2f ",numbers[i]);
            }
        }
    }
    public static double[] sortMas(double[] numbers){
        for(int i=0;i<numbers.length;i++){
            for(int j = 0;j<numbers.length-1;j++){
                if(numbers[j]>numbers[j+1]){
                    double tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }
        return numbers;
    }
}
