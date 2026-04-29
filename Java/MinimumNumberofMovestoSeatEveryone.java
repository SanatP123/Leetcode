import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int total = 0;

        // Sort both arrays to match closest positions
        Arrays.sort(seats);
        Arrays.sort(students); 

        for (int i = 0; i < seats.length; i++){
            // Sum absolute differences between matched pairs
            total += Math.abs((students[i] - seats[i]));
        }

        return total;
    }

    public static void main(String[] args) {
        MinimumNumberofMovestoSeatEveryone sol = new MinimumNumberofMovestoSeatEveryone();
        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        int ans = sol.minMovesToSeat(seats, students);
        System.out.println(ans);

        MinimumNumberofMovestoSeatEveryone sol2 = new MinimumNumberofMovestoSeatEveryone();
        int[] seats2 = {4,1,5,9};
        int[] students2 = {1,3,2,6};
        int ans2 = sol2.minMovesToSeat(seats2, students2);
        System.out.println(ans2);

        MinimumNumberofMovestoSeatEveryone sol3 = new MinimumNumberofMovestoSeatEveryone();
        int[] seats3 = {2,2,6,6};
        int[] students3 = {1,3,2,6};    
        int ans3 = sol3.minMovesToSeat(seats3, students3);
        System.out.println(ans3);
    }

    
}
