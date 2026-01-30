#include <iostream>
using namespace std;


class Solution {
public:
    int mySqrt(int x) {
        if (x < 2){
            return x;
        }
        long num;
        int pivot, left = 2, right = x/2;
        while (left <= right){
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x){
                right = pivot - 1;
            }
            else if (num < x)
                left = pivot + 1;
            else
                return pivot;
        }

        return right;
        
    }
};


int main() {
    Solution sol;
    int x = 8;
    cout << "The integer square root of " << x << " is " << sol.mySqrt(x) << endl;
    return 0;
}


