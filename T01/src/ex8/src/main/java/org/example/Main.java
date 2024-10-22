package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputAr = input.split(" ");
        List<Integer> numbers = new ArrayList<Integer>();
        try {
            for(int i=0;i<inputAr.length;i++){
                int num = Integer.parseInt(inputAr[i]);
                numbers.add(num);
            }
        } catch (NumberFormatException e) {
        }
        if(numbers.size()>0){
            int position  = 0;
            for(int i =1;i<numbers.size();i++){
                if(numbers.get(i)<numbers.get(i-1)){
                    position = i;
                    break;
                }
            }
            if(position==0){
                System.out.println("Последовательность упорядочена в порядке возрастания.");
            }else{
                System.out.println("Последовательность не упорядочена, начиная с порядкового номера числа " + position);
            }
        }else{
            System.out.println("Ошибка ввода");
        }
    }
}