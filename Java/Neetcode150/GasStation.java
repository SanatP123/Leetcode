
public class GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;

        int totalGain = 0;
        int currentGain = 0;
        int ans = 0;

        for (int i = 0; i < n; i++){
            // gain[i] = gas[i] - cost[i]
            totalGain += gas[i] - cost[i];
            currentGain += gas[i] - cost[i];

            // If we meet a "valley", start over from the next station with 0 initial gas
            if (currentGain < 0){
                currentGain = 0;
                ans = i+1;
            }
        }

        if (totalGain >= 0){
            return ans;
        }
        else{
            return -1;
        }
        
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println("Starting station index: " + result);

        GasStation solution2 = new GasStation();
        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        int result2 = solution2.canCompleteCircuit(gas2, cost2);
        System.out.println("Starting station index: " + result2);

        GasStation solution3 = new GasStation();
        int[] gas3 = {5,1,2,3,4};
        int[] cost3 = {4,4,1,5,1};
        int result3 = solution3.canCompleteCircuit(gas3, cost3);
        System.out.println("Starting station index: " + result3);
    }
    
}
