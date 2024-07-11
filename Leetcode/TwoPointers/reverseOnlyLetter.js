/**
 * 
 * @param {*} s 
 * @returns {string}
 */
function reverseOnlyLetter(s) {
    let ts = '';
    let rs = '';
    let i = 0;
    const onlyWord = /\w/gi;

    while (i < s.length) {
        if (!onlyWord.test(s[i])) {
            j = ts.length - 1;
            while (j >= 0) {
                rs+= ts[j];
                j--;
            }
            rs+= s[i];
            i++;
            ts = '';
        }
        ts+= s[i];
        i++;
    }
    console.log(rs);
    return rs.trim();
}

reverseOnlyLetter("ab-cd");
reverseOnlyLetter("a-bC-dEf-ghIj");
reverseOnlyLetter("Test1ng-Leet=code-Q!");

