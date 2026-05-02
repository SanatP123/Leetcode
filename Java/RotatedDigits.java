class RotatedDigits {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1 ; i <= n; i++){
            String s = Integer.toString(i);
            if (check_good(s)){
                count += 1;
            }
        }

        return count;
        
    }

    public boolean check_good(String num){
        String new_num = ""; 
        for (char c: num.toCharArray()){
            if (c == '3' || c == '4' || c == '7'){
                return false;
            }
            else{
                if (c == '0' || c == '1' || c == '8'){
                    new_num += c;
                }
                else if (c == '2' || c == '5'){
                    if (c == '2'){
                        new_num += '5';
                    }
                    else{
                        new_num += '2';
                    }
                }
                else{
                    if (c == '6'){
                        new_num += '9';
                    }
                    else{
                        new_num += '6';
                    }
                }
            }

        }

        if (new_num.equals(num)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RotatedDigits sol = new RotatedDigits();
        int n = 10;
        int ans = sol.rotatedDigits(n);
        System.out.println(ans);

        RotatedDigits sol2 = new RotatedDigits();
        int n2 = 1;
        int ans2 = sol2.rotatedDigits(n2);
        System.out.println(ans2);

        RotatedDigits sol3 = new RotatedDigits();
        int n3 = 2;
        int ans3 = sol3.rotatedDigits(n3);
        System.out.println(ans3);
    }
}