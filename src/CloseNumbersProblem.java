import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class CloseNumbersProblem {
    public static void main(String[] args) {
        ArrayList<Integer> numberArray = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen sayı dizisini sayılar arasında virgül olacak şekilde giriniz: ");
        String numbersStr = scanner.nextLine();
        numbersStr=numbersStr.replaceAll(" ","");
        for(String num:numbersStr.split(",")){
            if(Integer.parseInt(num) < -20000 || Integer.parseInt(num) > 20000){
                throw new IllegalArgumentException("Girilen dizideki sayılardan en az biri -20.000 ile 20.000 aralığında" +
                        " değildir");
            }
            numberArray.add(Integer.parseInt(num));
        }
        if(numberArray.isEmpty() || numberArray.size() > 2500){
            throw new IllegalArgumentException("Sayı dizisi boyutu 1<n<2500 aralığında değil");
        }
        Collections.sort(numberArray);
        printCloseNumbers(findMinDiff(numberArray),numberArray);
    }

    private static void printCloseNumbers(int min,ArrayList<Integer> integers){
        ArrayList<String> closeNumbers = new ArrayList<String>();
        for(int i=0;i<integers.size()-1;i++){
            if(Math.abs(integers.get(i) - integers.get(i+1)) == min){
                closeNumbers.add(String.format("%d %d",integers.get(i),integers.get(i+1)));
            }
        }
        System.out.println("Minimum fark: "+min);
        System.out.println("Yakın Komşu Sayılar: ");
        for (String numbers:closeNumbers) {
            System.out.println(numbers);
        }
    }
    private static int findMinDiff(ArrayList<Integer> integers){
        int min=Integer.MAX_VALUE;
        for (int i=0;i<integers.size()-1;i++) {
            if( (Math.abs(integers.get(i) - integers.get(i+1)) < min) &&
                    (Math.abs(integers.get(i) - integers.get(i+1)) !=0)){
                min = Math.abs(integers.get(i) - integers.get(i+1));
            }
        }
        return min;
    }


}
