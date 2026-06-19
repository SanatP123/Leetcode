public class FindtheHighestAltitude {
    
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int res = 0;
        for (int i = 0; i < gain.length; i++){
            altitude += gain[i];
            res = Math.max(res,altitude);
        }

        return res;
        
    }

    public static void main(String[] args) {
        FindtheHighestAltitude solution = new FindtheHighestAltitude();
        int[] gain = {-5,1,5,0,-7};
        int result = solution.largestAltitude(gain);
        System.out.println(result); // Output: 1

        FindtheHighestAltitude solution2 = new FindtheHighestAltitude();
        int[] gain2 = {-4,-3,-2,-1,4,3,2};
        int result2 = solution2.largestAltitude(gain2);
        System.out.println(result2); // Output: 0

        FindtheHighestAltitude solution3 = new FindtheHighestAltitude();
        int[] gain3 = {4,3,2};
        int result3 = solution3.largestAltitude(gain3);
        System.out.println(result3); // Output: 9
    }
    
}
