import java.util.Scanner;

public class MergeString {
    public static void main(String[] args) {
        Scanner scannerA = new Scanner(System.in);
        Scanner scannerB = new Scanner(System.in);

        System.out.print("Lütfen string A'yı giriniz: ");
        String a = scannerA.nextLine();
        System.out.print("Lütfen string B'yi giriniz: ");
        String b = scannerB.nextLine();
        System.out.println("Birleştirilmiş metin: "+mergeString(a,b));
    }

    private static String mergeString(String a, String b){
        StringBuilder mergedString = new StringBuilder();
        int i;

        int lenA = a.length();
        int lenB = b.length();

        if(lenA > 2500 || lenA < 1 || lenB > 2500 || lenB < 1){
            throw new IllegalArgumentException("Girilen metinlerin boyutu kısıta uymamaktadır");
        }
        int size = Math.min(a.length(), b.length());

        for(i=0; i<size; i++){
            mergedString.append(a.charAt(i));
            mergedString.append(b.charAt(i));
        }
        // A string'i , B string'inden uzunsa A string'inden kalanı en sona ekle
        if(lenB < lenA) {
            while (i < lenA){
                mergedString.append(a.charAt(i));
                i++;
            }
        }// B string'i , A string'inden uzunsa B string'inden kalanı en sona ekle
        else {
            while (i < lenB){
                mergedString.append(b.charAt(i));
                i++;
            }
        }
        return mergedString.toString();
    }
}