function longestCommonPrefix(s: string, t: string): number {
    var left = 0;
    var right = 0
    var removed = false;

    while (left < s.length && right < t.length){
        if (s[left] == t[right]){
            left++;
            right++;
        }
        else{
            if (!removed){
                removed = true;
                left++;
            }
            
            else{
                break;
            }
            
        }
    }

    return right;
    
};


console.log(longestCommonPrefix("madxa", "madam")); // Output: 4
console.log(longestCommonPrefix("leetcode", "eetcode")); // Output: 7
console.log(longestCommonPrefix("one", "one")); // Output: 3
console.log(longestCommonPrefix("a", "b")); // Output: 0