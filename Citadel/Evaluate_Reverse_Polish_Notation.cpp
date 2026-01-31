
#include <iostream>
#include <vector>
#include <string>
#include <stack>   
using namespace std;
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        // Stack to store operands and results
        stack<int> numbers;

         // Iterate through each token in the RPN expression
        for (int i = 0; i < tokens.size(); i++){
            
              // If the current token is an operator
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                if (!numbers.empty()){
                    int b = numbers.top();
                    numbers.pop();
                    int a = numbers.top();
                    numbers.pop();

                    // Apply the operator and push the result back onto the stack
                    if (tokens[i] == "+"){
                        int value = a + b;
                        numbers.push(value);
                    }
                    if (tokens[i] == "-"){
                        int value = a - b;
                        numbers.push(value);
                    }
                    if (tokens[i] == "*"){
                        int value = a * b;
                        numbers.push(value);
                    }
                    if (tokens[i] == "/"){
                        int value = a / b;
                        numbers.push(value);
                    }
                }
            }
            else {
                // If the token is a number, convert it to int and push onto stack
                numbers.push(stoi(tokens[i]));
            }
        }
     // The final result is the only value left on the stack
    return numbers.top();
    }
};


int main() {
    Solution solution;
    vector<string> tokens = {"2", "1", "+", "3", "*"};
    int result = solution.evalRPN(tokens);
    // Expected output: 9
    cout << result << endl;
    return 0;
}