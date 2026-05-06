public class RotatingTheBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] rotatedBox = new char[n][m];

        // Rotate 90 degrees clockwise
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                rotatedBox[j][m-1-i] = boxGrid[i][j];
            }
        }

        // Apply Gravity
        for (int col = 0; col < m; col++){ // columns = m
            int emptyRow = n - 1; // rows = n
            for (int row = n-1; row >= 0; row--){
                if (rotatedBox[row][col] == '*'){
                    emptyRow = row - 1; // reset after obstacle
                }
                else if (rotatedBox[row][col] == '#'){
                    // move stone down
                    char temp = rotatedBox[emptyRow][col];
                    rotatedBox[emptyRow][col] = '#';
                    rotatedBox[row][col] = temp;
                    emptyRow--;
                }
            }
        }

        return rotatedBox;
        
    }

    public static void main(String[] args) {
        RotatingTheBox sol = new RotatingTheBox();
        char[][] boxGrid = {{'#','.','#'}};
        char[][] ans = sol.rotateTheBox(boxGrid);
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
            
        }

        System.out.println();
        System.out.println();

        RotatingTheBox sol2 = new RotatingTheBox();
        char[][] boxGrid2 = {{'#','.','*','.'},{'#','#','*','.'}};
        char[][] ans2 = sol2.rotateTheBox(boxGrid2);
        for (int i = 0; i < ans2.length; i++){
            for (int j = 0; j < ans2[0].length; j++){
                System.out.print(ans2[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
