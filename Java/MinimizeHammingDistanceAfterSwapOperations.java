import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations {
    private int[] parent;

    // Find root with path compression
    private int find(int x){
        if (parent[x]!= x) parent[x] = find(parent[x]);             
        return parent[x];
    }

    // Union two nodes
    private void union(int a, int b){
        parent[find(a)] = find(b);
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;
        parent = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }

        // Build connected components
        for (int[] swap: allowedSwaps){
            union(swap[0],swap[1]);
        }

        // root -> {value -> frequency in source}
        Map<Integer, Map<Integer,Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++){
            int root = find(i);

            groups.computeIfAbsent(root, k-> new HashMap<>()).merge(source[i],1,Integer::sum);

        }

        int hammingdist = 0;

        // Try matching target values within each group
        for (int i = 0; i < n; i++){
            int root = find(i);
            Map<Integer,Integer> freq = groups.get(root);

            if (freq.getOrDefault(target[i],0) > 0){
                freq.merge(target[i],-1,Integer::sum); // Use one match
            }
            else{
                hammingdist += 1; //Mismatch
            }
        }

        return hammingdist;

        



        
    }


    public static void main(String[] args) {
        MinimizeHammingDistanceAfterSwapOperations solution = new MinimizeHammingDistanceAfterSwapOperations();
        // Test case 1
        int[] source1 = {1,2,3,4};
        int[] target1 = {2,1,4,5};
        int[][] allowedSwaps1 = {{0,1},{2,3}};
        System.out.println("Test 1: " + solution.minimumHammingDistance(source1, target1, allowedSwaps1));  // Expected: 1

        // Test case 2
        int[] source2 = {1,2,3,4};
        int[] target2 = {1,3,2,4};
        int[][] allowedSwaps2 = {};
        System.out.println("Test 2: " + solution.minimumHammingDistance(source2, target2, allowedSwaps2));  // Expected: 2

        // Test case 3
        int[] source3 = {5,1,2,4,3};
        int[] target3 = {1,5,4,2,3};
        int[][] allowedSwaps3 = {{0,4},{4,2},{1,3},{1,4}};
        System.out.println("Test 3: " + solution.minimumHammingDistance(source3, target3, allowedSwaps3));  // Expected: 0
    }
    
}
