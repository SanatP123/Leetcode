

public class MergeTripletstoFormTargetTriplet {
    
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int n = triplets.length;
        boolean check_a = false;
        boolean check_b = false;
        boolean check_c = false;

        for (int i = 0; i < n; i++){

            // Only usable if it cannot exceed target after merging
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                if (triplets[i][0] == target[0]){
                    check_a = true;
                }
            
                if (triplets[i][1] == target[1]){
                    check_b = true;
                }
            
                if (triplets[i][2] == target[2]){
                check_c = true;
                }
            }
        }

       return (check_a && check_b && check_c);


    }

    public static void main(String[] args) {
        MergeTripletstoFormTargetTriplet solution = new MergeTripletstoFormTargetTriplet();
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        boolean result = solution.mergeTriplets(triplets, target);
        System.out.println("Can merge to form target: " + result);

        MergeTripletstoFormTargetTriplet solution2 = new MergeTripletstoFormTargetTriplet();
        int[][] triplets2 = {{3,4,5},{4,5,6}};
        int[] target2 = {3,2,5};
        boolean result2 = solution2.mergeTriplets(triplets2, target2);
        System.out.println("Can merge to form target: " + result2);

        MergeTripletstoFormTargetTriplet solution3 = new MergeTripletstoFormTargetTriplet();
        int[][] triplets3 = {{1,3,4},{2,5,8}};
        int[] target3 = {2,5,8};
        boolean result3 = solution3.mergeTriplets(triplets3, target3);
        System.out.println("Can merge to form target: " + result3);
    }
    
}
