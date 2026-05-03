class RotateString {
    public boolean rotateString(String s, String goal) {
        int len = s.length();

        // If lengths are different, it's impossible to be a rotation
        if (len != goal.length()){
            return false;
        }

        // Try all possible rotation amounts (0 to len-1)
        for (int i = 0; i < len; i++){
            if (rotateString(s,goal,i)){
                return true;
            }
        }
        return false;
        
    }

    public boolean rotateString(String curr, String target, int rotation){
        int n = curr.length();

        // Compare each character after applying rotation to curr
        // We compare rotated curr with target at position i
        for (int i = 0; i < n ; i++){
            if (curr.charAt((i+rotation) % n) != target.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RotateString sol = new RotateString();
        String s = "abcde";
        String goal = "cdeab";
        boolean ans = sol.rotateString(s, goal);
        System.out.println(ans);

        RotateString sol2 = new RotateString();
        String s2 = "abcde";
        String goal2 = "abced";
        boolean ans2 = sol2.rotateString(s2, goal2);
        System.out.println(ans2);
    }
}