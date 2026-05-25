public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        // i + minJump <= j <= min(i + maxJump, s.length - 1),
        // Adjust condition, i - maxJump <= j <= i - minJump
        int n = s.length();

        // dp[i] = true means index i is reachable
        boolean[] dp = new boolean[n];
        dp[0] = true;

        // Number of reachable positions in the valid jump window
        int reach = 0;

        for (int i = 1; i < n; i++){

            // Add index that just became far enough to jump from
            if (i - minJump >= 0 && dp[i-minJump]){
                reach++;
            }

            // Remove index that is now too far away to jump from
            if (i - maxJump - 1 >= 0 && dp[i- maxJump - 1]){
                reach--;
            }

            // i is reachable if:
            // 1. s[i] is '0'
            // 2. at least one previous reachable index can jump here
            if(s.charAt(i) == '0' && reach > 0){
                dp[i] = true;
            }
        }

        return dp[n-1];
        
    }

    public static void main(String[] args) {
        JumpGameVII solution = new JumpGameVII();
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        boolean result = solution.canReach(s, minJump, maxJump);
        System.out.println("Can reach end of string: " + result);

        JumpGameVII solution2 = new JumpGameVII();
        String s2 = "01101110";
        int minJump2 = 2;
        int maxJump2 = 3;
        boolean result2 = solution2.canReach(s2, minJump2, maxJump2);
        System.out.println("Can reach end of string: " + result2);

        JumpGameVII solution3 = new JumpGameVII();    
        String s3 = "0000000000";
        int minJump3 = 1;
        int maxJump3 = 1;
        boolean result3 = solution3.canReach(s3, minJump3, maxJump3);
        System.out.println("Can reach end of string: " + result3);
    }
}
    

