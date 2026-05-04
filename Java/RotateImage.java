public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose - flip the matrix along its main diagonal so rows become columns.
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row 
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
        
    }

    public static void main(String[] args) {
        RotateImage sol = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        sol.rotate(matrix);
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        RotateImage sol2 = new RotateImage();
        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        sol2.rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++){
            for (int j = 0; j < matrix2[0].length; j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }

}
