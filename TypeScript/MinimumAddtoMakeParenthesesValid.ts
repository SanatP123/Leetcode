// Minimum Add to Make Parentheses Valid

// A parentheses string is valid if and only if:

// It is the empty string,
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
// You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

// For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
// Return the minimum number of moves required to make s valid.

function minAddToMakeValid(s: string): number {
    let stack = [];
    let moves = 0;

    for (let i = 0; i < s.length; i++){
        if (s[i] === "("){
            stack.push(s[i]);
        }
        else if (s[i] === ")" && stack.length! > 0){
            stack.pop();
        }
        else{
            moves += 1;
        }

    }

    return moves + stack.length;
    
};


console.log(minAddToMakeValid("())")); // Output: 1
console.log(minAddToMakeValid("(((")); // Output: 3
console.log(minAddToMakeValid("()")); // Output: 0