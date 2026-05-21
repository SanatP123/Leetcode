
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        // Sort meetings by start time
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        // Stores end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        
        for (int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            // Reuse room if earliest meeting has ended
            if (!minHeap.isEmpty() && start >= minHeap.peek()){
                minHeap.poll();
            }
            // Allocate current meeting
            minHeap.add(end);
        }

        return minHeap.size();
        
    }

    public static void main(String[] args) {
        MeetingRoomsII sol = new MeetingRoomsII();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int ans = sol.minMeetingRooms(intervals);
        System.out.println(ans);

        MeetingRoomsII sol2 = new MeetingRoomsII();
        int[][] intervals2 = {{7,10},{2,4}};
        int ans2 = sol2.minMeetingRooms(intervals2);
        System.out.println(ans2);
    }
}

