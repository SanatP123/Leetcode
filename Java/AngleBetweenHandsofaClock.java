public class AngleBetweenHandsofaClock {
    public double angleClock(int hour, int minutes) {

        // Minute hand moves 360/60 = 6 degrees per minute
        double minAngle = minutes * 6;

        // Minute hand affects position of the hour hand by 0.5 degrees per minute
        double buffer = 0.5 * minutes;

        // Hour hand moves 360/12 = 30 degrees per hour
        // and additionally 0.5 degrees per minute
        double hourAngle = hour * 30 + buffer;

        // Angle between the two hands
        double difference = Math.abs(hourAngle - minAngle);

        // A clock forms two angles; return the smaller one
        return Math.min(difference, 360 - difference);

    }

    public static void main(String[] args) {
        AngleBetweenHandsofaClock solution = new AngleBetweenHandsofaClock();
        int hour = 3;
        int minutes = 15;
        double result = solution.angleClock(hour, minutes);
        System.out.println(result); // Output: 7.5

        AngleBetweenHandsofaClock solution2 = new AngleBetweenHandsofaClock();
        int hour2 = 12;
        int minutes2 = 30;
        double result2 = solution2.angleClock(hour2, minutes2);
        System.out.println(result2); // Output: 165.0

        AngleBetweenHandsofaClock solution3 = new AngleBetweenHandsofaClock();
        int hour3 = 3;
        int minutes3 = 30;
        double result3 = solution3.angleClock(hour3, minutes3);
        System.out.println(result3); // Output: 75.0
    }
    
}
