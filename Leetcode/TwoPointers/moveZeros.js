/**
 * @param {number[]} n
 * @return {void} Do not return anything, modify n in-place instead.
 */
const moveZeroes = function(n) {
    let sp = 0;
    while (sp < n.length) {
        const k = n[sp];
        if (k === 0) {
            let p = n.length - 1;
            let t = n[p];
            while ((p - sp) > 0) {
                let j = n[p - 1];
                n[p - 1] = t;
                t = j;
                p--;
            }
            n[n.length - 1] = k;
        }
        sp++;
    }
    console.log(n);
    return n;
};

moveZeroes([0,0,1]);