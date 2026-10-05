// Score of Parentheses

// Given a balanced parentheses string s, return the score of the string.

// The score of a balanced parentheses string is based on the following rule:

// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.


function scoreOfParentheses(s: string): number {
    const stack : number[] = [];
    let score = 0;

    for (let i = 0; i < s.length; i++){
        if (s[i] === "("){
            stack.push(score);
            score = 0;
        }
        else {
            // () = 1, otherwise (A) = 2A
            if(s[i-1] === "("){
                score = 1;
            }
            else{
                score = 2 * score;
            }

            // Return to previous level
            score += stack.pop()!;
                        
        }
    }

    return score;

    
};

console.log(scoreOfParentheses("()")); // Output: 1
console.log(scoreOfParentheses("(())")); // Output: 2
console.log(scoreOfParentheses("()()")); // Output: 2
console.log(scoreOfParentheses("(()(()))")); // Output: 6