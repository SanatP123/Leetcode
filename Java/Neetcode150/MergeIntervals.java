import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    
    public int[][] merge(int[][] intervals) {

        // Sort intervals by start time
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int n = intervals.length;

        List<int[]> temp = new ArrayList<>();

        // Current interval being merged
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++){
            // Overlapping interval → extend end
            if (intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }
            // Non-overlapping → store previous interval
            else{
                temp.add(new int[] {start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // Add final merged interval
        temp.add(new int[] {start,end});

        int[][] ans = new int[temp.size()][];

        for (int i = 0; i < temp.size(); i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = sol.merge(intervals);
        for (int[] i : ans){
            System.out.print(Arrays.toString(i) + " ");
        }
        System.out.println();

        MergeIntervals sol2 = new MergeIntervals();
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] ans2 = sol2.merge(intervals2);
        for (int[] i : ans2){
            System.out.print(Arrays.toString(i) + " ");
        }
        System.out.println();
    }
    
}
