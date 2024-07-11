/**
 * @param {number[]} nums
 * @param {number} target
 * @returns {number[]} 
 */
function twoSum(nums, target) {
    const hashMap = new Map();
    
    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];
        const complement = target - num;
        if (hashMap.has(complement)) { 
            return [i, hashMap.get(complement)];
        }
        hashMap.set(num, i);
    }
    return [-1, -1];
}

const ans = twoSum([5,2,7,10,3,9], 8)
console.log(ans);