package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<Character, Integer> counts = new HashMap<>();
        if(countItemsInBasket(counts, skus) == -1) return -1;
        recalculateCountOnOffer(counts);
        return calculatePrice(counts);
    }

    private int countItemsInBasket(Map<Character, Integer> counts, String skus) {
        for(char c : skus.toCharArray()) {
            if(c >= 'A' && c <= 'Z') {
                int count = counts.getOrDefault(c, 0);
                counts.put(c, count + 1);
            } else {
                return -1;
            }
        }
        return 0;
    }

    private void recalculateCountOnOffer(Map<Character, Integer> counts) {
        if(counts.get('B') != null && counts.get('E') != null) {
            counts.put('B', counts.get('B') - (counts.get('E') / 2));
        }
        if(counts.get('M') != null && counts.get('N') != null) {
            counts.put('M', counts.get('M') - (counts.get('N') / 3));
        }
        if(counts.get('Q') != null && counts.get('R') != null) {
            counts.put('Q', counts.get('Q') - (counts.get('R') / 3));
        }
        if()
    }

    private int calculatePrice(Map<Character, Integer> counts) {
        int res = 0;
        for(char sku : counts.keySet()) {
            int count = counts.get(sku) > 0 ? counts.get(sku) : 0;
            if(sku == 'A') {
                int count5A =  count / 5;
                int count3A = (count - count5A * 5) / 3;
                int restA = count - count5A * 5 - count3A * 3;
                res += count5A * 200 + count3A * 130 + restA * 50;
            } else if(sku == 'B') {
                res += (count / 2) * 45 + (count % 2) * 30;
            } else if(sku == 'C' || sku == 'G' || sku == 'T' || sku == 'W') {
                res += 20 * count;
            } else if(sku == 'D' || sku == 'M'){
                res += 15 * count;
            } else if(sku == 'E' || sku == 'N'){
                res += 40 * count;
            } else if(sku == 'F'){
                res += (count / 3) * 20 + (count % 3) * 10;
            } else if(sku == 'H'){
                int count10H =  count / 10;
                int count5H =  (count - count10H * 10) / 5;
                int restH = count - count10H * 10 - count5H * 5;
                res += count10H * 80 + count5H * 45 + restH * 10;
            } else if(sku == 'I'){
                res += 35 * count;
            } else if(sku == 'J'){
                res += 60 * count;
            } else if(sku == 'K'){
                res += (count / 2) * 150 + (count % 2) * 80;
            } else if(sku == 'L' || sku == 'X'){
                res += 90 * count;
            } else if(sku == 'O' || sku == 'Y'){
                res += 10 * count;
            } else if(sku == 'P'){
                res += (count / 5) * 200 + (count % 5) * 50;
            } else if(sku == 'Q'){
                res += (count / 3) * 80 + (count % 3) * 30;
            } else if(sku == 'R' || sku == 'Z'){
                res += 50 * count;
            } else if(sku == 'S'){
                res += 30 * count;
            } else if(sku == 'U'){
                res += (count / 4) * 120 + (count % 4) * 40;
            } else if(sku == 'V'){
                int count3V =  count / 3;
                int count2V =  (count - count3V * 3) / 2;
                int restH = count - count3V * 3 - count2V * 2;
                res += count3V * 130 + count2V * 90 + restH * 50;
            }
        }
        return res;
    }
}
