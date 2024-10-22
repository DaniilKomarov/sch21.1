package org.example;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            line = reader.readLine();
            int count = Integer.parseInt(line);
            if(count <=0){
                System.out.println("Input error. Size <= 0");
            }else{
                line = reader.readLine();
                String[] input;
                if(line!=null) {
                    input = line.split(" ");
                    if(input.length<count){
                        System.out.println("Input error. Insufficient number of elements");
                    }else{
                        double[] numbers = new double[count];
                        int skip = 0;
                        for(int i=0;i<count;i++){
                            try {
                                numbers[i] = Double.parseDouble(input[i+skip]);
                            }catch (NumberFormatException e){
                                i--;
                                skip++;
                            }
                        }
                        System.out.printf("%d\n",count);
                        for(int i=0;i<numbers.length;i++){
                            System.out.printf("%.2f ",numbers[i]);
                        }
                        double max = findMax(numbers);
                        double min = findMin(numbers);
                        writeRes(max,min);
                    }
                }else{
                    System.out.println("Input error. Insufficient number of elements");
                }
            }
        } catch (FileNotFoundException e) {
                System.out.println("Input error. File isn't exist");
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
        scanner.close();
    }
    public static void writeRes(double max,double min){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            writer.write(min + " " + max);
            System.out.println("\nSaving min and max values in file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static double findMax(double[] numbers){
        double max  = numbers[0];
        for(int i =1;i<numbers.length;i++){
            if(max < numbers[i]){
                max = numbers[i];
            }
        }
        return max;
    }
    public static double findMin(double[] numbers){
        double min  = numbers[0];
        for(int i =1;i<numbers.length;i++){
            if(min > numbers[i]){
                min = numbers[i];
            }
        }
        return min;
    }
}