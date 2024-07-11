/**
 * @param {number[]} nums
 * @returns {number}
 */
function missingNumbers(nums) {
    const nSet = new Set();
    const n = nums.length;

    for (const num of nums) {
        nSet.add(num);
    }
    for (let i = 0; i < n; i++) {
        if (!nSet.has(n - i)) {
            return n - i;
        }
    }
    return 0;
}