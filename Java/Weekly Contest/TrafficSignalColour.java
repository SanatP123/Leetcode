
class TrafficSignalColour {
    public String trafficSignal(int timer) {
        if (timer == 0){
            return "Green";
        }
        else if (timer == 30){
            return "Orange";
        }

        else if (timer > 30 && timer <= 90){
            return "Red";
        }
        else{
            return "Invalid";
        }
    }

    public static void main(String[] args) {
        TrafficSignalColour solution = new TrafficSignalColour();

        // Test case 1
        int timer1 = 0;
        System.out.println("Test 1: " + solution.trafficSignal(timer1));  // Expected: "Green"

        // Test case 2
        int timer2 = 60;
        System.out.println("Test 2: " + solution.trafficSignal(timer2));  // Expected: "Orange"

        // Test case 3
        int timer3 = 5;
        System.out.println("Test 3: " + solution.trafficSignal(timer3));  // Expected: "Red"

        // Test case 4
        int timer4 = 100;
        System.out.println("Test 4: " + solution.trafficSignal(timer4));  // Expected: "Invalid"
    }

}