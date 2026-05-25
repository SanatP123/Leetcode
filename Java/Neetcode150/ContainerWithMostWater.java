

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int maxAmount = 0;

        while (left < right){
            
            // Area = smaller height × width
            maxAmount = Math.max(maxAmount, Math.min(height[left], height[right]) * (right - left));

             // Move the shorter wall to try finding a taller one
            if (height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }

        }

        return maxAmount;
        
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println("Maximum area of water container: " + result);

        ContainerWithMostWater solution2 = new ContainerWithMostWater();
        int[] height2 = {1,1};
        int result2 = solution2.maxArea(height2);
        System.out.println("Maximum area of water container: " + result2);

        ContainerWithMostWater solution3 = new ContainerWithMostWater();
        int[] height3 = {4,3,2,1,4};
        int result3 = solution3.maxArea(height3);
        System.out.println("Maximum area of water container: " + result3);
    }
    
}
