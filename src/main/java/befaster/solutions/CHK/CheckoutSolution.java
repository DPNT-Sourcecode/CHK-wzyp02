package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char c : skus.toCharArray()) {
            if(c >= 'A' && c <= 'E') {
                int count = counts.getOrDefault(c, 0);
                counts.put(c, count + 1);
            } else {
                return -1;
            }
        }
        if(counts.get('B') != null && counts.get('E') != null) {
            counts.put('B', counts.get('B') - (counts.get('E') / 2));
        }
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
            } else {
                res += 40 * count;
            }
        }
        return res;
    }
}








