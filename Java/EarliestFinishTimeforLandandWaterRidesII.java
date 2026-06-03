public class EarliestFinishTimeforLandandWaterRidesII {
    final static int MAX = Integer.MAX_VALUE;
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int l = MAX, w = MAX, minL = MAX, minW = MAX;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        // Earliest possible land ride finish
        for (int i = 0; i < n; i++){
            l = Math.min(l, landStartTime[i] + landDuration[i]);
        }

        for (int i = 0; i < m; i++){
            // Earliest possible water ride finish
            w = Math.min(w, waterStartTime[i] + waterDuration[i]);

            // Land -> Water
            minL = Math.min(minL, Math.max(waterStartTime[i], l) + waterDuration[i]);
        }

        for (int i = 0; i < n; i++){
             // Water -> Land
            minW = Math.min(minW, Math.max(landStartTime[i], w) + landDuration[i]);
        }

        // Best of both orders
        return Math.min(minL,minW);
        
        
    }


    public static void main(String[] args) {
        EarliestFinishTimeforLandandWaterRidesII solution = new EarliestFinishTimeforLandandWaterRidesII();
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        int result = solution.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println("Earliest finish time for land and water rides: " + result);

        EarliestFinishTimeforLandandWaterRidesII solution2 = new EarliestFinishTimeforLandandWaterRidesII();
        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};
        int result2 = solution2.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2);
        System.out.println("Earliest finish time for land and water rides: " + result2);
    
    }
}
