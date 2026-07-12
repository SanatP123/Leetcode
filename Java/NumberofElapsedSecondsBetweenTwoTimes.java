public class NumberofElapsedSecondsBetweenTwoTimes {
    
    public int secondsBetweenTimes(String startTime, String endTime) {

        // Split the time strings into hours, minutes, and seconds
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int totalStart = 0, totalEnd = 0;
        
        // Convert each time component into total seconds
        for (int i = 0; i < start.length; i++){
            int currentStart = Integer.parseInt(start[i]);
            int currentEnd = Integer.parseInt(end[i]);

            // Hours
            if (i == 0){
                 
                totalStart += currentStart * 3600;
                totalEnd += currentEnd * 3600;
            }


            // Minutes
            if (i == 1){
                totalStart += currentStart * 60;
                totalEnd += currentEnd * 60;
            }

            // Seconds
            if (i == 2){
                totalStart += currentStart;
                totalEnd += currentEnd;
            }
            
        }

        // Return the difference in seconds
        return totalEnd - totalStart;
        
    }

    public static void main(String[] args) {

        NumberofElapsedSecondsBetweenTwoTimes solution = new NumberofElapsedSecondsBetweenTwoTimes();
        String startTime = "01:00:00";
        String endTime = "01:00:25";
        
        int result = solution.secondsBetweenTimes(startTime, endTime);

        System.out.println(result); // Output: 25

        String startTime1 = "12:34:56";
        String endTime1 = "13:00:00";

        int result1 = solution.secondsBetweenTimes(startTime1, endTime1);
        
        System.out.println(result1); // Output: 1504
    }
}
