// Count Valid Prefixes

// You are given a binary string s.

// A prefix of s is considered valid if its characters can be rearranged to form an alternating string.

// Return the number of valid prefixes of s.

// A binary string is a string consisting only of '0' and '1'.

// A prefix of a string is a substring that starts from the beginning of the string and extends to any point within it.

// A substring is a contiguous non-empty sequence of characters within a string.

// A string is considered alternating if no two adjacent characters are equal.

function countValidPrefixes(s: string): number {
    function checkAlternating(s: string): boolean{
        let zeros = 0;
        let ones = 0;

        // Count zeros and ones
        for (let i = 0; i < s.length; i++){
            if (s[i] === "0"){
                zeros++;
            }
            else{
                ones++;
            }
        }

        // Rearrangement is possible only if counts differ by at most 1
        if (Math.abs(zeros - ones) > 1){
            return false;
        }
        return true;
        
    } 

    let res = 0;

    // Check every prefix
    for (let j = 0; j < s.length; j++ ){
        const prefix = s.slice(0,j+1);
        // console.log(prefix);
        if (checkAlternating(prefix)){
            res++;
        }
    }
    
    
    return res;
};

console.log(countValidPrefixes("00101")); // Output: 3
console.log(countValidPrefixes("101")); // Output: 3
