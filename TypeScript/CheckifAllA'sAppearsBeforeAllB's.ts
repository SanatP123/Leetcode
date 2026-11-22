// Check if All A's Appears Before All B's

// Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' appears before every 'b' in the string. Otherwise, return false.


function checkString(s: string): boolean {
    let flag = false;
    for(let i = 0; i < s.length; i++){
        if (s[i] === "b"){
            flag = true;
        }
        if (s[i] === "a" && flag){
            return false;
        }
    }
    return true;
    
};

console.log(checkString("aaabbb")); // Output: true
console.log(checkString("abab")); // Output: false
console.log(checkString("bbb")); // Output: true