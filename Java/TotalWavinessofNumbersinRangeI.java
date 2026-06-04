public class TotalWavinessofNumbersinRangeI {
    
    public int totalWaviness(int num1, int num2) {
        int totalWaviness = 0;
        for (int i = num1; i <= num2; i++){
            totalWaviness += solve(i);
        }

        return totalWaviness;
        
    }

    public int solve(int num){
        String s = Integer.toString(num);
        if (s.length() < 3) return 0;
        int res = 0;
        int prev = s.charAt(0) - '0';
        for (int i = 1; i < s.length() - 1; i++){
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i+1) - '0';

            if ((prev < curr)  && (curr > next)){
                res += 1;
            }
            else if ((prev > curr) && (curr < next)){
                res += 1;
            }

            prev = curr;

        }

        return res;
        
    }

    public static void main(String[] args) {
        TotalWavinessofNumbersinRangeI solution = new TotalWavinessofNumbersinRangeI();
        int num1 = 120;
        int num2 = 130;
        int result = solution.totalWaviness(num1, num2);
        System.out.println("Total waviness of numbers in range: " + result);

        TotalWavinessofNumbersinRangeI solution2 = new TotalWavinessofNumbersinRangeI();
        int num3 = 198;
        int num4 = 202;
        int result2 = solution2.totalWaviness(num3, num4);
        System.out.println("Total waviness of numbers in range: " + result2);

        TotalWavinessofNumbersinRangeI solution3 = new TotalWavinessofNumbersinRangeI();
        int num5 = 4848;
        int num6 = 4848;
        int result3 = solution3.totalWaviness(num5, num6);
        System.out.println("Total waviness of numbers in range: " + result3);
    
    }
    
}
