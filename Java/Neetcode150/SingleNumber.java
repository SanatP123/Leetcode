public class  SingleNumber {
    public int singleNumber(int[] nums) {
    // Concept
    // If we take XOR of zero and some bit, it will return that bit
    // a⊕0=a
    // If we take XOR of two same bits, it will return 0
    // a⊕a=0
    // a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
        int a = 0;
        for (int i : nums){
            a ^= i;
        }
        return a;
        
    }
    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();
        int[] nums = {2,2,1};
        int ans = sol.singleNumber(nums);
        System.out.println(ans);

        SingleNumber sol2 = new SingleNumber();
        int[] nums2 = {4,1,2,1,2};
        int ans2 = sol2.singleNumber(nums2);
        System.out.println(ans2);
}
    
}
