#include <vector>
#include <algorithm>
#include <iostream>    
using namespace std;

class Solution {
public:
    int minimumCost(vector<int>& nums) {

        sort(nums.begin()+1,nums.end());

        return nums[0] + nums[1] + nums[2];
        

        
    }
};


// Test cases based on the examples provided

int main() {
    Solution s;
    vector<vector<int>> inputs = {{1,2,3,12},{5,4,3},{10,3,1,1}};
    for (const auto& nums : inputs) {
        int result = s.minimumCost(const_cast<vector<int>&>(nums));
        // Print the result
        cout << "Input: nums = [";
        for (size_t i = 0; i < nums.size(); ++i) {
            cout << nums[i];
            if (i < nums.size() - 1) cout << ",";
        }
        cout << "]\n";
        cout << "Output: " << result << "\n\n";
    }
    return 0;
}
