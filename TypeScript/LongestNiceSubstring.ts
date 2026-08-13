function longestNiceSubstring(s: string): string {

    let maxLen = 0;
    let maxstring = "";

    for (let i = 0; i < s.length; i++){
        const map = new Map<string,number>();
        let current = "";
        let currentLen = 0;

        for (let j = i; j < s.length; j++){
            map.set(s[j], (map.get(s[j]) ?? 0) + 1);

            current += s[j];
            currentLen += 1;

            let isNice = true;

            // Check both cases exist
            for (const char of map.keys()){
                if (!map.get(char.toLowerCase()) || !map.get(char.toUpperCase())){
                    isNice = false;
                    break;
                }

            }

            // Update longest substring
            if (isNice && currentLen > maxLen){
                maxstring = current;
                maxLen = currentLen;
            }
        }
    }

    return maxstring;
};


console.log(longestNiceSubstring("YazaAay")); // Output: "aAa"
console.log(longestNiceSubstring("Bb")); // Output: "Bb"
console.log(longestNiceSubstring("c")); // Output: ""