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
        counts.put('B', counts.get('B') - (counts.get('E') / 2));
        int res = 0;
        for(char sku : counts.keySet()) {
            int count = counts.get(sku);
            if(sku == 'A') {
                res += (count / 3) * 130 + (count % 3) * 50;
            } else if(sku == 'B') {
                res += (count / 2) * 45 + (count % 2) * 30;
            } else if(sku == 'C') {
                res += 20 * count;
            } else {
                res += 15 * count;
            }
        }
        return res;
    }
}




