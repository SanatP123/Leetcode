

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        // Sort by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int prevEnd = intervals[0][1];
        int ans = 0;

        for (int i = 1; i < n; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // No overlap
            if (currentStart >= prevEnd){
                prevEnd = currentEnd;
            }
            else {
                // Overlap: remove one interval
                ans += 1;

                 // Keep the interval that ends earlier
                prevEnd = Math.min(prevEnd, currentEnd);
            }

        }

        return ans;
        
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int result = solution.eraseOverlapIntervals(intervals);
        System.out.println("Minimum intervals to remove: " + result);

        NonOverlappingIntervals solution2 = new NonOverlappingIntervals();
        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        int result2 = solution2.eraseOverlapIntervals(intervals2);
        System.out.println("Minimum intervals to remove: " + result2);

        NonOverlappingIntervals solution3 = new NonOverlappingIntervals();
        int[][] intervals3 = {{1,2},{2,3}};
        int result3 = solution3.eraseOverlapIntervals(intervals3);
        System.out.println("Minimum intervals to remove: " + result3);
    }

    
}
