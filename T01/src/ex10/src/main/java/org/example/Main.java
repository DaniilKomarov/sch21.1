package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<User> users = new ArrayList<User>();
        for(int i=0;i<count;i++){
            try {
                String name = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                if(age <= 0){
                    System.out.println("Incorrect input. Age <= 0");
                    i--;
                }else {
                    User user = new User(name, age);
                    users.add(user);
                }
            }catch (NumberFormatException e){
                System.out.println("Couldn't parse a number. Please, try again");
                i--;
            }
        }
        users.stream().
                filter(user -> user.getAge() >= 18)
                .forEach(user -> System.out.print( user.getName() + " "));

    }
}