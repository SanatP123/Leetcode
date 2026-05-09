public class ScoreValidator {
    public int[] scoreValidator(String[] events) {
        int[] ans = new int[2];
        int score = 0;
        int counter = 0;

        for (String x : events){
            if (counter == 10){
                break;
            }
            if (x.equals("0") || x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6")){

                score += Integer.parseInt(x);
            }
            else if (x.equals("W")){
                counter += 1;
            }

            else if (x.equals("WD") || x.equals("NB")){
                score += 1;
            }
            
        }

        ans[0] = score;
        ans[1] = counter;
        return ans;
        
    }

    public static void main(String[] args) {
        ScoreValidator sol = new ScoreValidator();
        String[] events = {"1","4","W","6","WD"};
        int[] ans = sol.scoreValidator(events);
        System.out.println(ans[0] + " " + ans[1]);

        ScoreValidator sol2 = new ScoreValidator();
        String[] events2 = {"WD","NB","0","4","4"};
        int[] ans2 = sol2.scoreValidator(events2);
        System.out.println(ans2[0] + " " + ans2[1]);

        ScoreValidator sol3 = new ScoreValidator();
        String[] events3 = {"W","W","W","W","W","W","W","W","W","W","W"};
        int[] ans3 = sol3.scoreValidator(events3);
        System.out.println(ans3[0] + " " + ans3[1]);

    }
    
}
