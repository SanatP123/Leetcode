

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (char c : s.toCharArray()){
            count[c - 'a']++;
        }

        for (char d : t.toCharArray()){
            count[d - 'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (count[i] != 0){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean ans = sol.isAnagram(s, t);
        System.out.println(ans);

        ValidAnagram sol2 = new ValidAnagram();
        String s2 = "rat";
        String t2 = "car";
        boolean ans2 = sol2.isAnagram(s2, t2);
        System.out.println(ans2);
    }
}
    

