// Minimum Insertions to Balance a Parentheses String

// Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

// Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
// Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
// In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

// For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
// You can insert the characters '(' and ')' at any position of the string to balance it if needed.

// Return the minimum number of insertions needed to make s balanced.


function minInsertions(s: string): number {
    let stack : string[] = [];
    let answer = 0;

    for (let i = 0; i < s.length; i++){
        
        if (s[i] === "("){
            stack.push(s[i]);
        }
        else{

            // If the next character is not ')',
            // insert one to complete the pair.
            if (i + 1 < s.length && s[i+1] === ")"){
                i++;
            }
            else{
                answer++;
            }
        
        // Match the closing pair with an opening '('.
        if (stack.length > 0){
            stack.pop();
        }
        else{
            // Insert a missing opening '('
            answer++;
            }
        }
    }
    

    answer += 2 * stack.length;

    return answer;
};


console.log(minInsertions("(()))")); // Output: 1
console.log(minInsertions("())")); // Output: 0
console.log(minInsertions("))())(")); // Output: 3