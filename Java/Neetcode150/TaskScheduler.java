

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    
    public int leastInterval(char[] tasks, int n) {
        // Build frequency map
        int[] freq = new int[26];

        for(char task : tasks){
            freq[task - 'A']++;
        }

        // Max heap to store frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++){
            if (freq[i] > 0){
                pq.offer(freq[i]);
            }
        }

        int intervals = 0;

         // Process tasks until the heap is empty
        while (!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            // Execute tasks in each cycle
            while (cycle > 0 && !pq.isEmpty()){
                int current = pq.poll();
                if (current > 1){
                    store.add(current - 1);
                }
                taskCount++;
                cycle--;
            }

            // Restore updated frequencies to the heap
            for (int s : store){
                pq.offer(s);
            }

             // Add time for the completed cycle
            if(pq.isEmpty()){
                intervals += taskCount;
            }
            else{
                intervals += n+1; 
            }

        }

        return intervals;
        
    }

    public static void main(String[] args) {
        TaskScheduler solution = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int result = solution.leastInterval(tasks, n);
        System.out.println("Least intervals needed: " + result);

        TaskScheduler solution2 = new TaskScheduler();
        char[] tasks2 = {'A','A','A','B','B','B'};
        int n2 = 0;
        int result2 = solution2.leastInterval(tasks2, n2);
        System.out.println("Least intervals needed: " + result2);

        TaskScheduler solution3 = new TaskScheduler();
        char[] tasks3 = {'A','A','A','B','B','B'};
        int n3 = 1;
        int result3 = solution3.leastInterval(tasks3, n3);
        System.out.println("Least intervals needed: " + result3);
    }
}
    

