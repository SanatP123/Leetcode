import java.util.HashMap;

public class MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0) + 1);
        }

        int freq_b = freq.getOrDefault('b', 0);
        int freq_a = freq.getOrDefault('a', 0);
        int freq_n = freq.getOrDefault('n', 0);
        int freq_l = freq.getOrDefault('l', 0);
        int freq_o = freq.getOrDefault('o', 0);

        int ans = freq_b;
        ans = Math.min(ans, freq_a);
        ans = Math.min(ans, freq_n);
        ans = Math.min(ans, freq_l/2);
        ans = Math.min(ans, freq_o/2);
        
        return ans; 

    }

    public static void main(String[] args) {
        MaximumNumberofBalloons solution = new MaximumNumberofBalloons();
        String text = "nlaebolko";
        int result = solution.maxNumberOfBalloons(text);
        System.out.println(result); // Output: 1

        MaximumNumberofBalloons solution2 = new MaximumNumberofBalloons();
        String text2 = "loonbalxballpoon";
        int result2 = solution2.maxNumberOfBalloons(text2);
        System.out.println(result2); // Output: 2

        MaximumNumberofBalloons solution3 = new MaximumNumberofBalloons();
        String text3 = "leetcode";
        int result3 = solution3.maxNumberOfBalloons(text3);
        System.out.println(result3); // Output: 0
    }
    
    
}
