public class EarliestFinishTimeforLandandWaterRidesI {
    
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // Land first, Water second
                int land = landStartTime[i] + landDuration[i];
                int landWater = Math.max(land,waterStartTime[j]) + waterDuration[j];
                res = Math.min(res, landWater);

                // Water first, Land second
                int water = waterStartTime[j] + waterDuration[j];
                int waterLand = Math.max(water, landStartTime[i]) + landDuration[i];
                res = Math.min(res, waterLand);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        EarliestFinishTimeforLandandWaterRidesI solution = new EarliestFinishTimeforLandandWaterRidesI();
        int[] landStartTime = {2, 8};
        int[] landDuration = {4, 1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        int result = solution.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println("Earliest finish time for land and water rides: " + result);

        EarliestFinishTimeforLandandWaterRidesI solution2 = new EarliestFinishTimeforLandandWaterRidesI();
        int[] landStartTime2 = {5};
        int[] landDuration2 = {3};
        int[] waterStartTime2 = {1};
        int[] waterDuration2 = {10};
        int result2 = solution2.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2);
        System.out.println("Earliest finish time for land and water rides: " + result2);


    }

    
}
