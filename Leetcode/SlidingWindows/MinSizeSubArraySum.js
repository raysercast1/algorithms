/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
const minSubArrayLen = function(target, nums) {
    let l = 0;
    let c = 0;
    let ans = 0;

    for (let r = 0; r < nums.length; r++) {
        c = c + nums[r];
        while (c >= target) {
            console.log("When R is: ",r)
            console.log("When C is: ", c)
            console.log("Then L is: ", l)
            ans = r - l + 1;
            c = c - nums[l];
            l++;
        }
    }
    return ans;
};

const ans = minSubArrayLen(7, [2,3,1,2,4,3]);
console.log("Ans is: ", ans)