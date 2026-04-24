public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {

        // Right moves counter
        int r = 0;
        // Left moves counter
        int l = 0;
        // Empty moves counter
        int e = 0;

        for(char m: moves.toCharArray()){
            if (m == 'L'){
                l += 1;
            }
            else if (m == 'R'){
                r += 1;
            }
            else{
                e += 1;
            }
        }

        // Use all blanks in the direction that gives the greater distance
        return Math.abs(l - r) + e;
    }

    public static void main(String[] args) {
        FurthestPointFromOrigin sol = new FurthestPointFromOrigin();
        String moves = "L_RL__R";
        int ans = sol.furthestDistanceFromOrigin(moves);
        System.out.println(ans);

        FurthestPointFromOrigin sol2 = new FurthestPointFromOrigin();
        String moves2 = "_R__LL_";
        int ans2 = sol2.furthestDistanceFromOrigin(moves2);
        System.out.println(ans2);

        FurthestPointFromOrigin sol3 = new FurthestPointFromOrigin();
        String moves3 = "_______";
        int ans3 = sol3.furthestDistanceFromOrigin(moves3);
        System.out.println(ans3);
    }
    
}
