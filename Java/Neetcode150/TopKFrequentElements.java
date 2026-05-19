
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        

        for (int i = 0;  i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> ((a,b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()){
            minHeap.add(key);

            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++){
            ans[i] = minHeap.poll();
        }

        return ans;



    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = sol.topKFrequent(nums, k);
        for (int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
        

        TopKFrequentElements sol2 = new TopKFrequentElements();
        int[] nums2 = {1};
        int k2 = 1;
        int[] ans2 = sol2.topKFrequent(nums2, k2);
        for (int i : ans2){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
    

