/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const maxVowels = function(s, k) {
    let p = '';
    let c = 0;
    let ans = 0;
    let l = 0;
    const v = ['a','e','i','o','u'];
    for (let r = 0; r < s.length; r++) {
        p += s[r];
        for (let j = 0; j < v.length; j++) {
            if (p[p.length - 1] === v[j]) {
                c++;
            }
        }

        if (c === 0) {
            l++;
        }

        if (c > 0) {
            ans = Math.max(ans, r - l + 1);
            c = 0;
        }

        if (ans === k) {
            return ans;
        }
    }
    return ans;
};

const result = maxVowels("ltcode", 3);
console.log("Final result is: ", result);