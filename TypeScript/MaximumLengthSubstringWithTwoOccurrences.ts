function maximumLengthSubstring(s: string): number {
    let maxLen = 0;
    for (let i = 0; i < s.length; i++){
        const map = new Map<string, number>();
        for (let j = i; j < s.length; j++){
            map.set(s[j], (map.get(s[j]) ?? 0) + 1);

            if (map.get(s[j])! > 2){
                break;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
    }

    return maxLen;
    
};

console.log(maximumLengthSubstring("bcbbbcba")); // Output: 4
console.log(maximumLengthSubstring("aaaa")); // Output: 2