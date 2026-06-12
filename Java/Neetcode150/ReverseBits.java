public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++){
            // // Shift the result left by 1 bit to make room for the next incoming bit
            res <<= 1;

            // Extract the rightmost bit of n using a bitwise AND (& 1) then combine it into the result using a bitwise OR (|=)
            res |= (n & 1);

            // Perform right shift on n to move the next bit into position.
            n >>= 1;

        }

        return res;
        
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        int n = 43261596;
        int result = solution.reverseBits(n);
        System.out.println(result); // Output: 964176192

        ReverseBits solution2 = new ReverseBits();
        int n2 = 2147483644;
        int result2 = solution2.reverseBits(n2);
        System.out.println(result2); // Output: 3221225471
    }
    
}
