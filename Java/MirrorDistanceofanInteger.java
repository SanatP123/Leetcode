public class MirrorDistanceofanInteger {
    public int mirrorDistance(int n) {
        int reverse = returnReverse(n);
        int result = Math.abs(n - reverse);
        return result;
    }

    public int returnReverse(int a){
        int rev = 0;
        int rem;

        while (a > 0){
            rem = a % 10;
            rev = rev * 10 + rem;
            a = a / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        MirrorDistanceofanInteger solution = new MirrorDistanceofanInteger();
        // Test case 1
        int n1 = 25;
        System.out.println("Test 1: " + solution.mirrorDistance(n1));  // Expected: 27

        // Test case 2
        int n2 = 10;
        System.out.println("Test 2: " + solution.mirrorDistance(n2));  // Expected: 9

        // Test case 3
        int n3 = 7;
        System.out.println("Test 3: " + solution.mirrorDistance(n3));  // Expected: 0
    }
    
}
