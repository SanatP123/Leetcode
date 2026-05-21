public class FindThePrefixCommonArrayofTwoArrays {
   
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] freqArray = new int[n+1];
        int common = 0;

        for (int i = 0; i < n; i++){
            freqArray[A[i]] += 1;

            if (freqArray[A[i]] == 2) common++;

            freqArray[B[i]] += 1;
            if (freqArray[B[i]] == 2) common++;

            ans[i] = common;

        }

        return ans;

        
    }

    public static void main(String[] args) {
        FindThePrefixCommonArrayofTwoArrays sol = new FindThePrefixCommonArrayofTwoArrays();
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[] ans = sol.findThePrefixCommonArray(A, B);
        for (int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();

        FindThePrefixCommonArrayofTwoArrays sol2 = new FindThePrefixCommonArrayofTwoArrays();
        int[] A2 = {2,3,1};
        int[] B2 = {3,1,2};
        int[] ans2 = sol2.findThePrefixCommonArray(A2, B2);
        for (int i : ans2){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
}
