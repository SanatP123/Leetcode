import java.util.*;

public class MinimumEnergytoMaintainBrightness {
    
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0] , b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else{
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        long totalTimeUnits = 0;

        for (int i = 0; i < merged.size(); i++){
            int[] currentInt = merged.get(i);
            totalTimeUnits += currentInt[1] - currentInt[0] + 1;
        }

        int bulbsNeeded = (brightness+2)/3;

        return totalTimeUnits * bulbsNeeded;
        
    }

    public static void main(String[] args) {
        MinimumEnergytoMaintainBrightness solution = new MinimumEnergytoMaintainBrightness();
        int n = 5;
        int brightness = 5;
        int[][] intervals = {{6,12}};
        long result = solution.minEnergy(n, brightness, intervals);
        System.out.println("Minimum energy to maintain brightness: " + result);

        MinimumEnergytoMaintainBrightness solution2 = new MinimumEnergytoMaintainBrightness();
        int n2 = 2;
        int brightness2 = 1;
        int[][] intervals2 = {{0, 0}, {2, 2}};
        long result2 = solution2.minEnergy(n2, brightness2, intervals2);
        System.out.println("Minimum energy to maintain brightness: " + result2);


        MinimumEnergytoMaintainBrightness solution3 = new MinimumEnergytoMaintainBrightness();
        int n3 = 4;
        int brightness3 = 2;
        int[][] intervals3 = {{1, 3}, {2, 4}};
        long result3 = solution3.minEnergy(n3, brightness3, intervals3);
        System.out.println("Minimum energy to maintain brightness: " + result3);

    
    }
    
}
