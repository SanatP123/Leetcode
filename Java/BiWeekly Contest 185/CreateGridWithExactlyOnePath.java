public class CreateGridWithExactlyOnePath {
    public String[] createGrid(int m, int n) {
        String[] mat = new String[m];
        for (int i = 0; i < m; i++){
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++){
                if (i == 0 || j == n-1){
                    row.append('.');
                }
                else{
                    row.append('#');
                }

                mat[i] = row.toString();
            }
        }

        return mat;
        
    }

    public static void main(String[] args) {
        CreateGridWithExactlyOnePath solution = new CreateGridWithExactlyOnePath();
        String[] result = solution.createGrid(2, 3);
        for (String row : result) {
            System.out.println(row);
        }
        // ["..#","#.."]

        CreateGridWithExactlyOnePath solution2 = new CreateGridWithExactlyOnePath();
        String[] result2 = solution2.createGrid(3, 3);
        for (String row : result2) {
            System.out.println(row);
        }
        // ["..#","#..","##."]
    }
    
}
