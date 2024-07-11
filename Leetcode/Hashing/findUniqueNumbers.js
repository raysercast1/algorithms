/**
 * @param {number[]} n
 * @returns {number[]}
 */
function findNumbers(n) {
    const nSet = new Set();
    const ans = [];
    for (const number of n) {
        nSet.add(number);
    }

    for (const m of nSet) {
        if (!nSet.has(m + 1) && !nSet.has(m - 1)) {
            ans.push(m);
        }
    }

    return ans;
}