/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
const getCommon = function(nums1, nums2) {
    let ans = 0;
    let sp = 0;
    let p = 0;
    const largestArray = nums1.length < nums2.length ? nums2.length : nums1.length;
    for (let i = 0; i < largestArray; i++) {
        const k = nums1[sp];
        console.log("This is K", k);
        const z = nums2[p];
        console.log("This is Z", z);
        if (k === z) {
            ans = k;
            console.log("This is also ANS", ans);
            return ans;
        }
        if (k < z) {
            sp++;
        } else {
            p++;
        }
    }
    ans = - 1;
    console.log("This is ANS",ans);
    return ans;
};

const nums1 = [10,2,3,4];
const nums2 = [2,3,4,5,10];

getCommon(nums1, nums2);