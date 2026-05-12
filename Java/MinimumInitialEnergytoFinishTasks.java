import java.util.Arrays;

public class MinimumInitialEnergytoFinishTasks {
    public int minimumEffort(int[][] tasks) {
        // Tasks needing larger extra energy buffer are done first
        Arrays.sort(tasks, (a,b) -> (b[1] - b[0]) - (a[1] - a[0]));

        long ans = 0;
        long energy = 0;

        for (int i = 0; i < tasks.length; i++){
            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            // If minimum energy required is more increase the required energy
            if (energy < minimum){
                ans += (minimum - energy);
                energy = minimum;
            }

            // Perform the task
            energy -= actual;
        }

        return (int) ans;
        
    }

    public static void main(String[] args) {
        MinimumInitialEnergytoFinishTasks sol = new MinimumInitialEnergytoFinishTasks();
        int[][] tasks = {{1,2},{2,4},{4,8}};
        int ans = sol.minimumEffort(tasks);
        System.out.println(ans);

        MinimumInitialEnergytoFinishTasks sol2 = new MinimumInitialEnergytoFinishTasks();
        int[][] tasks2 = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        int ans2 = sol2.minimumEffort(tasks2);
        System.out.println(ans2);

        MinimumInitialEnergytoFinishTasks sol3 = new MinimumInitialEnergytoFinishTasks();
        int[][] tasks3 = {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        int ans3 = sol3.minimumEffort(tasks3);
        System.out.println(ans3);
    }
    
}
