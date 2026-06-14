
public class MaximizeSumofDeviceRatings {
   
    public long maxRatings(int[][] units) {
        long sum = 0;
        long sum2 = 0;
        long firstmin = Integer.MAX_VALUE;
        long secondmin = Integer.MAX_VALUE;

        for (int unit[]: units){
            // Smallest value in that unit
            int first = Integer.MAX_VALUE;
            // Second smallest value in that unit
            int second = Integer.MAX_VALUE;

            for (int i : unit){
                if (i < first){
                    second = first;
                    first = i;
                }
                else if (i < second){
                    second = i;
                }
            }

            if (unit.length == 1){
                second = 0;
            } 

            // Summation of all smallest values
            sum += first;
            // Summation of all second smallest values
            sum2 += second;

            firstmin = Math.min(firstmin, first);
            secondmin = Math.min(secondmin, second);
        }

        return Math.max(sum, (long) firstmin + sum2 - secondmin);
    }

    public static void main(String[] args) {
        MaximizeSumofDeviceRatings solution = new MaximizeSumofDeviceRatings();
        int[][] units = {{1,2,3},{4,5,6}};
        long result = solution.maxRatings(units);
        System.out.println(result); // Output: 6

        MaximizeSumofDeviceRatings solution2 = new MaximizeSumofDeviceRatings();
        int[][] units2 = {{1,3},{2,2}};
        long result2 = solution2.maxRatings(units2);
        System.out.println(result2); // Output: 4

        MaximizeSumofDeviceRatings solution3 = new MaximizeSumofDeviceRatings();
        int[][] units3 = {{5,5,5},{1,1,1}};
        long result3 = solution3.maxRatings(units3);
        System.out.println(result3); // Output: 6
    }
    
}
