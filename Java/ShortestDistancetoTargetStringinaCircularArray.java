public class ShortestDistancetoTargetStringinaCircularArray {
    public int closestTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            // Check if current word matches target
            if (words[i].equals(target)){
                // Direct distance
                int diff = Math.abs(i - startIndex);
                // Circular distance
                int circular_diff = Math.abs(n - diff);
                // Keep minimum of all possible distances
                distance = Math.min(distance,Math.min(diff, circular_diff));
            }
        }

        // Return -1 if target not found
        return(distance == Integer.MAX_VALUE) ? -1: distance;
        
    }

    public static void main(String[] args) {
        ShortestDistancetoTargetStringinaCircularArray solution = new ShortestDistancetoTargetStringinaCircularArray();

        // Test case 1
        String[] words1 = {"hello","i","am","leetcode","hello"};
        String target1 = "hello";
        int startIndex1 = 1;
        System.out.println("Test 1: " + solution.closestTarget(words1, target1, startIndex1));  // Expected: 1

        // Test case 2
        String[] words2 = {"a","b","leetcode"};
        String target2 = "leetcode";
        int startIndex2 = 0;
        System.out.println("Test 2: " + solution.closestTarget(words2, target2, startIndex2));  // Expected: -1

        // Test case 3
        String[] words3 = {"i","eat","leetcode"};
        String target3 = "ate";
        int startIndex3 = 2;
        System.out.println("Test 3: " + solution.closestTarget(words3, target3, startIndex3));  // Expected: 2
    }
}
