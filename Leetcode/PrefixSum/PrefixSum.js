/**
 * @param {number[]} nums
 * @returns {number[]}
 */
function _prefixSum(nums) {
    let prefix = [];
    prefix[0] = nums[0];
    for (let i = 1; i < nums.length; i++) {
        prefix[i] = nums[i] + prefix[prefix.length - 1];
    }
    return prefix;
}

/**
 * @param {number[]} nums
 * @param {queries[][]} queries
 * @param {number} limit
 * @returns {boolean[]}
 */
function answerQueries(nums, queries, limit) {
    const prefix = _prefixSum(nums);
    let ans = [];
    for (let i = 0; i < queries.length; i++) {
        const x = queries[i][0];
        const y = queries[i][1];
        const curr = prefix[y] - prefix[x] + nums[x];
        ans[i] = curr < limit;
    }
    return ans;
}

const nums = [1, 6, 3, 2, 7, 2];
const queries = [[0,3], [2,5], [2,4]];
const limit = 13;
answerQueries(nums, queries, limit);