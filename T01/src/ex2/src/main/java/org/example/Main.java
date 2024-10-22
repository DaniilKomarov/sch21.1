package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sec = input(scanner);
        if(sec<0){
            System.out.println("Incorrect time");
        }else{
            int[] time = findTime(sec);
            output(time);
        }
    }
    public static  int input(Scanner scanner){
        while(true){
            String inputStr = scanner.nextLine();
            try{
                int sec = Integer.parseInt(inputStr);
                return sec;
            }catch (NumberFormatException e){
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
    }
    public static int[] findTime(int sec){
        int[] time = new int[3];
        time[0] = sec/3600;
        time[1] = sec/60 % 60;
        time[2] = sec % 60;
        return time;
    }
    public static void output(int[] time){
        System.out.printf("%02d:%02d:%02d",time[0],time[1],time[2]);
    }
};