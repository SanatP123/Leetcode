public class PathExistenceQueriesinaGraphI {
    
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // Component ID for each index
        int[] computeEdges = new int[n];
        computeEdges[0] = 0;

        for (int i = 1; i < n; i++){
            // Same component if adjacent difference is within maxDiff
            if (nums[i] - nums[i-1] <= maxDiff){
                computeEdges[i] = computeEdges[i-1];
            }
            else{
                // Start a new component
                computeEdges[i] = computeEdges[i-1] + 1;
            }
        }

        int m = queries.length;
        boolean[] ans = new boolean[m];

        for (int i = 0; i < m; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            // A path exists only if both indices belong to the same component
            if (computeEdges[u] == computeEdges[v]){
                ans[i] = true;
            }
            else{
                ans[i] = false;
            }
        }


        return ans;


    }

    public static void main(String[] args) {

        PathExistenceQueriesinaGraphI solution = new PathExistenceQueriesinaGraphI();
        int n = 2;
        int[] nums = {1, 3};
        int maxDiff = 1;
        int[][] queries = {{0, 0}, {0, 1}};
        
        boolean[] result = solution.pathExistenceQueries(n, nums, maxDiff, queries);

        for (boolean res : result) {
            System.out.println(res);
        }
        System.out.println();
        

        // expected output: [true, false]

        int n1 = 4;
        int[] nums1 = {2, 5, 6, 8};
        int maxDiff1 = 2;
        int[][] queries1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};

        boolean[] result1 = solution.pathExistenceQueries(n1, nums1, maxDiff1, queries1);

        for (boolean res : result1) {
            System.out.println(res);
        }
        System.out.println();

        // expected output: [false, false, true, true]

    }
    
}
