package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Set<Character> skusKey = new HashSet<>();
        skusKey.add('A');
        skusKey.add('B');
        skusKey.add('C');
        skusKey.add('D');
        Map<Character, Integer> counts = new HashMap<>();
        for(char c : skus.toCharArray()) {
            if(skusKey.contains(c)) {
                int count = counts.getOrDefault(c, 0);
                counts.put(c, count + 1);
            } else {
                return -1;
            }
        }
        int res = 0;
        for()
    }
}

