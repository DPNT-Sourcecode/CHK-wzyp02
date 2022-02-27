package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<Character, Integer> counts = new HashMap<>();
        if(countItemsInBasket(counts, skus) == -1) return -1;
        recalculateCountOnOffer(counts);
        int res = 0;
        for(char sku : counts.keySet()) {
            int count = counts.get(sku);
            if(sku == 'A') {
                int count5 =  count / 5;
                int count3 = (count - count5 * 5) / 3;
                int rest = count - count5 * 5 - count3 * 3;
                res += count5 * 200 + count3 * 130 + rest * 50;
            } else if(sku == 'B') {
                if(count > 0) {
                    res += (count / 2) * 45 + (count % 2) * 30;
                }
            } else if(sku == 'C') {
                res += 20 * count;
            } else if(sku == 'D'){
                res += 15 * count;
            } else if(sku == 'E'){
                res += 40 * count;
            } else {
                res += (count / 3) * 20 + (count % 3) * 10;
            }
        }
        return res;
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
    }

    private void calculatePrice(Map<Character, Integer> counts) {
        int res = 0;
        for(char sku : counts.keySet()) {
            int count = counts.get(sku);
            if(sku == 'A') {
                int count5A =  count / 5;
                int count3A = (count - count5A * 5) / 3;
                int rest = count - count5A * 5 - count3A * 3;
                res += count5A * 200 + count3A * 130 + rest * 50;
            } else if(sku == 'B') {
                if(count > 0) {
                    res += (count / 2) * 45 + (count % 2) * 30;
                }
            } else if(sku == 'C' || sku == 'G') {
                res += 20 * count;
            } else if(sku == 'D'){
                res += 15 * count;
            } else if(sku == 'E'){
                res += 40 * count;
            } else if(sku == 'F'){
                res += (count / 3) * 20 + (count % 3) * 10;
            } else if(sku == 'G'){
                res += c;
            }
        }
    }
}

