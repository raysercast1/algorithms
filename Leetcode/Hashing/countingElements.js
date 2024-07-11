/**
 * @param {number[]} a
 * @returns {number}
 */
function countingElements(a) {
    const nSet = new Set();
    let c = 0;
    for (n of a) {
        nSet.add(n);
    }
    for (let j = 0; j < a.length; j++) {
        if (nSet.has(a[j] + 1)) {
            c++;
        }
    }
    return c;
}