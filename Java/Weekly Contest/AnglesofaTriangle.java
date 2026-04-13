import java.util.Arrays;
public class AnglesofaTriangle {
    public double[] internalAngles(int[] sides) {
        double[] ans = new double[3];
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        if (a + b <= c){
            return new double[]{};
        }

        double cos_a = (b*b + c*c - a*a)/(2.0*b*c);
        double cos_b = (a*a + c*c - b*b)/(2.0*a*c);
        double cos_c = (b*b + a*a - c*c)/(2.0*a*b);

        ans[0] = Math.toDegrees(Math.acos(cos_a));
        ans[1] = Math.toDegrees(Math.acos(cos_b));
        ans[2] = Math.toDegrees(Math.acos(cos_c));

        Arrays.sort(ans);
        return ans;


    }

    public static void main(String[] args) {
        AnglesofaTriangle solution = new AnglesofaTriangle();

        // Test case 1
        int[] sides1 = {3,4,5};
        System.out.println("Test 1: " + Arrays.toString(solution.internalAngles(sides1)));  // Expected: [36.86989764584401, 53.13010235415599, 90.0]

        // Test case 2
        int[] sides2 = {2,4,2};
        System.out.println("Test 2: " + Arrays.toString(solution.internalAngles(sides2)));  // Expected : []

        // Test case 3
        int[] sides3 = {1, 2, 3};
        System.out.println("Test 3: " + Arrays.toString(solution.internalAngles(sides3)));  // Expected: []
    }
}
