package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = input(scanner);
        if(n==0){
            System.out.println("0");
        }else {
            fibonachi(n, 0, 1);
        }
        scanner.close();
        }
    public static int input(Scanner scanner) {
        while (true) {
            String inputStr = scanner.nextLine();
            try {
                int res = Integer.parseInt(inputStr);
                return res;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
    }
    public static void fibonachi(int n,long first,long second){
        long curent = first + second;
        if(curent > Integer.MAX_VALUE){
            System.out.println("Too large n");
            return;
        }else{
            n--;
            if(n<=1){
                System.out.printf("%d",curent);
                return;
            }
            fibonachi(n,second,curent);
        }

    }
}