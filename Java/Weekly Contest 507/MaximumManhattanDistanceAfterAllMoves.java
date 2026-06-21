public class MaximumManhattanDistanceAfterAllMoves {
    public int maxDistance(String moves) {
        int x = 0;
        int y = 0;
        int underscores = 0;
        for (char c : moves.toCharArray()){
            if (c == 'U'){
                y += 1;
            }
            else if (c == 'D'){
                y -= 1;
            }
            else if (c == 'R'){
                x += 1;
            }
            else if (c == 'L'){
                x -= 1;
            }
            else{
                underscores += 1;
            }

        }
        // Each underscore can always be chosen to increase the final Manhattan distance by 1
        return Math.abs(x) + Math.abs(y) + underscores;
    }

    public static void main(String[] args) {
        MaximumManhattanDistanceAfterAllMoves solution = new MaximumManhattanDistanceAfterAllMoves();
        String moves = "L_D_";
        int result = solution.maxDistance(moves);
        System.out.println(result); // Output: 4

        MaximumManhattanDistanceAfterAllMoves solution2 = new MaximumManhattanDistanceAfterAllMoves();
        String moves2 = "U_R";
        int result2 = solution2.maxDistance(moves2);
        System.out.println(result2); // Output: 3

        MaximumManhattanDistanceAfterAllMoves solution3 = new MaximumManhattanDistanceAfterAllMoves();
        String moves3 = "DU";
        int result3 = solution3.maxDistance(moves3);
        System.out.println(result3); // Output: 0
    }
    
}
