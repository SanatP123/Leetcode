// Remove Invalid Parentheses

// Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

// Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

function removeInvalidParentheses(s: string): string[] {

    let ans : string[] = [];

    const remove = (s : string, i: number, j: number, b1: string, b2: string) => {
        let count = 0;

        // Scan the string looking for an imbalance.
        for (let k = i; k <= s.length; k++){
            if (s[k] === b1)
                count++;
            
            if (s[k] === b2)
                count--;

            if (count < 0){

                // Removing each possible closing parenthesis between j and k.
                for (let x = j; x <= k; x++){
                    // Skip duplicate removals.
                    if (s[x] === b2 && (x === j || s[x-1] !== b2)){
                        remove(s.slice(0,x) + s.slice(x+1), k, x, b1, b2);
                    }
                }
            
            return;
            }
        }
            
            // Reverse to handle extra '(' using the same logic.
            const rev = s.split("").reverse().join("");

            if (b1 === "("){
                remove(rev, 0, 0, b2, b1);
            }
            else{
                ans.push(rev);
            }
        };

        remove(s,0,0,"(",")");
        return ans;
};


console.log(removeInvalidParentheses("()())()")); // Output: ["()()()", "(())()"]
console.log(removeInvalidParentheses("(a)())()")); // Output: ["(a)()()", "(a())()"]
console.log(removeInvalidParentheses(")(")); // Output: [""]