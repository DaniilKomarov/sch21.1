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
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        List<String> strings = new ArrayList<String>();
        for(int i=0;i<count;i++){
            input = scanner.nextLine();
            strings.add(input);
        }
        String findStr = scanner.nextLine();
        scanner.close();
        filtrStr(findStr,strings);
    }
    public static void filtrStr(String findStr, List<String> strings){
        for(int i=0;i<strings.size();i++){
            if(strings.get(i).contains(findStr)){
                System.out.print(strings.get(i) + " ");
            }
        }
    }
}