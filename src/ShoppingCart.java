import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<Integer> productPrices = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fiyat dizisini sayılar arasında virgül olacak şekilde giriniz: ");
        String pricesStr = scanner.nextLine();
        pricesStr=pricesStr.replaceAll(" ","");


        for (String price:pricesStr.split(",")) {
            if(Integer.parseInt(price) < 0 || Integer.parseInt(price) > 2000){
                throw new IllegalArgumentException("Girilen fiyatlardan en az biri 0'dan küçük veya 2000'den büyük!!!");
            }
            productPrices.add(Integer.parseInt(price));
        }

        if (productPrices.size() > 100 || productPrices.isEmpty()) {
            throw new IllegalArgumentException("Fiyat dizisi 1<n<100 arasında olmalı");
        }
        printDiscount(productPrices);
    }

    private static void printDiscount(ArrayList<Integer> integers){
        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> discountedList = new ArrayList<Integer>();
        ArrayList<Integer> notDiscounted = new ArrayList<Integer>();
        integers.add(integers.getLast()+1);
        int cartTotal = 0;

        for(int i=0;i<integers.size()-1;i++) {
            if(integers.get(i) <= integers.get(i+1)) {
                index.add(i);
                discountedList.add(i,integers.get(i));
            }
            else {
                discountedList.add(integers.get(i)-integers.get(i+1));
            }
        }

        for (Integer price:discountedList) {
            cartTotal += price;
        }
        System.out.println("Sepet Tutarı :"+cartTotal);

        for (Integer priceIndex:index) {
            notDiscounted.add(integers.get(priceIndex));
        }
        Collections.sort(notDiscounted);
        System.out.println("İndirim Olmayan Ürünler: {"+notDiscounted.toString().replace("[","").replace("]","")+"}");
    }
}
