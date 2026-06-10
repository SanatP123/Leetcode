import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumAmountofTimetoFillCups {
    
    public int fillCups(int[] amount) {
        // Max-heap to always pick the two largest amounts
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int amt: amount) pq.add(amt);

        int ans = 0;

        while (pq.peek() > 0){
            int num1 = pq.poll();
            int num2 = pq.poll();

             // Fill one cup from each of the two largest types
            pq.add(--num1);
            pq.add(--num2);
            ans++;
        }
        return ans;

    }

    public static void main(String[] args) {
        MinimumAmountofTimetoFillCups solution = new MinimumAmountofTimetoFillCups();
        int[] amount = {1, 4, 2};
        int result = solution.fillCups(amount);
        System.out.println(result); // Output: 4

        MinimumAmountofTimetoFillCups solution2 = new MinimumAmountofTimetoFillCups();
        int[] amount2 = {5, 4, 4};
        int result2 = solution2.fillCups(amount2);
        System.out.println(result2); // Output: 5

        MinimumAmountofTimetoFillCups solution3 = new MinimumAmountofTimetoFillCups();
        int[] amount3 = {5, 0, 0};
        int result3 = solution3.fillCups(amount3);
        System.out.println(result3); // Output: 5


    }
    
}
