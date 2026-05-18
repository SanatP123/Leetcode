import java.util.*;
public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        // value -> all indices having that value
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++){
            indexMap.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        int steps = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // start BFS from index 0
        queue.offer(0);
        visited[0] = true;


        while (!queue.isEmpty()){
            int size = queue.size();

            // one BFS level = one jump
            for (int i = 0; i < size; i++){
                int curr = queue.poll();

                // reached end
                if (curr == n-1){
                    return steps;
                }

                // jump to curr + 1
                if (curr + 1 < n && !visited[curr + 1]){
                    queue.offer(curr + 1);
                    visited[curr + 1] = true;
                }

                // jump to curr - 1
                if (curr - 1 >= 0 && !visited[curr - 1]){
                    queue.offer(curr - 1);
                    visited[curr - 1] = true;
                }

                // jump to all same-value indices
                if (indexMap.containsKey(arr[curr])){
                    List<Integer> indexes = new ArrayList<>();

                    indexes = indexMap.get(arr[curr]);

                    for (int idx : indexes){
                        queue.offer(idx);
                        visited[idx] = true;
                    }

                    // avoid reprocessing same value again
                    indexMap.remove(arr[curr]);
                }
            }
            steps++;
        }

        return -1;
        
    }

    public static void main(String args[]){
        JumpGameIV sol = new JumpGameIV();
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        int ans = sol.minJumps(arr);
        System.out.println(ans);

        JumpGameIV sol2 = new JumpGameIV();
        int[] arr2 = {7,6,9,6,9,6,9,7};
        int ans2 = sol2.minJumps(arr2);
        System.out.println(ans2);

        JumpGameIV sol3 = new JumpGameIV();
        int[] arr3 = {7};
        int ans3 = sol3.minJumps(arr3);
        System.out.println(ans3);
    }
}

