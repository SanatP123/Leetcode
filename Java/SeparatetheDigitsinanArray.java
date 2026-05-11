import java.util.ArrayList;

public class SeparatetheDigitsinanArray {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        // Dynamic list to store separated digits
        ArrayList<Integer> list = new ArrayList<>();

        for (int num: nums){
            // Convert number to string
            String current = Integer.toString(num);

            // Traverse each character (digit) in the string
            for (int i = 0; i < current.length(); i++){
                list.add(current.charAt(i) - '0');
            }
        }

        int[] answer = new int[list.size()];

        // Copy digits from list to array
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        SeparatetheDigitsinanArray sol = new SeparatetheDigitsinanArray();
        int[] nums = {13,25,83,77};
        int[] ans = sol.separateDigits(nums);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

        SeparatetheDigitsinanArray sol2 = new SeparatetheDigitsinanArray();
        int[] nums2 = {7,1,3,9};
        int[] ans2 = sol2.separateDigits(nums2);
        System.out.println();
        for (int i = 0; i < ans2.length; i++){
            System.out.print(ans2[i] + " ");    
        }
    }
    
}
