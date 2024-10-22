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
            int[] numbers = new int[count];
            while (true) {
                try {
                    String[] input = scanner.nextLine().split(" ");
                    if(input.length!= count){
                        System.out.println("Couldn't parse a number. Please, try again");
                        continue;
                    }
                    for (int i = 0; i < count; i++) {
                        numbers[i] = Integer.parseInt(input[i]);
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Couldn't parse a number. Please, try again");
                }
            }
            int res = findAvgMin(numbers);
            if(res<0){
                System.out.printf("%d",res);
            }else{
                System.out.println("There are no negative elements");
            }
        }

    scanner.close();
    }

    public static int findAvgMin(int[] numbers) {
        int negCount = 0;
        int negSum = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<0){
                negCount++;
                negSum += numbers[i];
            }
        }
        if(negCount>0) {
            return negSum / negCount;
        }else{
            return 0;
        }
    }
}