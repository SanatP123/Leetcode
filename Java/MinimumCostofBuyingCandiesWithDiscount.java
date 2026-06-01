import java.util.Arrays;

public class MinimumCostofBuyingCandiesWithDiscount {
    
    public int minimumCost(int[] cost) {
        Arrays.sort(cost); 
        int n = cost.length;
        int candies = 0;
        int minimumCost = 0;

        for (int i = n-1; i >= 0; i--){
            if (candies == 2){
                candies = 0;
            }
            else{
                minimumCost += cost[i];
                candies += 1;
            }
        }
        

        return minimumCost;
    }

    public static void main(String[] args) {
        MinimumCostofBuyingCandiesWithDiscount solution = new MinimumCostofBuyingCandiesWithDiscount();
        int[] cost = {1,2,3};
        int result = solution.minimumCost(cost);
        System.out.println("Minimum cost of buying candies with discount: " + result);

        MinimumCostofBuyingCandiesWithDiscount solution2 = new MinimumCostofBuyingCandiesWithDiscount();
        int[] cost2 = {6,5,7,9,2,2};
        int result2 = solution2.minimumCost(cost2);
        System.out.println("Minimum cost of buying candies with discount: " + result2);

        MinimumCostofBuyingCandiesWithDiscount solution3 = new MinimumCostofBuyingCandiesWithDiscount();
        int[] cost3 = {5,5};
        int result3 = solution3.minimumCost(cost3);
        System.out.println("Minimum cost of buying candies with discount: " + result3);
    }
    
}
