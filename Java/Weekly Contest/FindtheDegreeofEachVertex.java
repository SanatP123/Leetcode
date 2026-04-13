
public class FindtheDegreeofEachVertex {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++){
            int degree = 0;
            for(int j = 0; j < n; j++){
                if (matrix[i][j] == 1){
                    degree += 1;
                }
            }
            ans[i] = degree;
        }

        return ans;
    }

    public static void main(String[] args) {
        FindtheDegreeofEachVertex solution = new FindtheDegreeofEachVertex();

        // Test case 1
        int[][] matrix1 = {{0,1,1},{1,0,1},{1,1,0}};
        int[] result1 = solution.findDegrees(matrix1);
        System.out.print("Test 1: ");
        printArray(result1);  

        // Test case 2
        int[][] matrix2 = {{0,1,0},{1,0,0},{0,0,0}};
        int[] result2 = solution.findDegrees(matrix2);
        System.out.print("Test 2: ");
        printArray(result2);  

        // Test case 3
        int[][] matrix3 = {{0}};
        int[] result3 = solution.findDegrees(matrix3);
        System.out.print("Test 3: ");
        printArray(result3);  
    }
    
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
