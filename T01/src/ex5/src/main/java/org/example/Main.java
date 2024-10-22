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
            int[] res = findNumber(numbers);
            //int ch = findNumber(numbers);
            for(int i=0;i<res.length;i++){
                if(res[i]!=0) {
                    System.out.printf("%d ", res[i]);
                }
            }
        }

        scanner.close();
        }
        public static int[] findNumber(int[] numbers){
        int[] res = new int[numbers.length];
        int count = 0;
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            int lastNum = num%10;
            int firstNum = num%10;
            while(num/10 >0){
                num = num/10;
                firstNum = num%10;
            }
            if(lastNum==firstNum){
                res[count] = numbers[i];
                count++;
            }
        }
        return res;
    }
    }