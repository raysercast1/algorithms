/**
 * 
 * @param {character[]} s 
 * @return {void}
 */
function reverseString(s) {
    const reversedArray = [];
    let p = 0;
    for (let sp = s.length - 1; sp >= 0; sp--) {
        reversedArray[p] = s[sp];
        p++;
    }
    console.log("Original array");
    console.log(s);
    console.log("Modified Array");
    console.log(reversedArray);
};

// reverseString(['h', 'e', 'l', 'l', 'o']);

/**
 * @param {string} s
 * @returns {void}
 */
function reverseStringWithSpaces(n) {
    let s = '';
    let sb = '';
    for (let i = 0; i < n.length; i++) {
        s+= n[i];
        if (s[s.length - 1] == ' ') {
            let j = s.length - 1;
            while (j >= 0) {
                sb+= s[j];
                j--;
            }
            s = '';
        }
    }
    
    if (s.length > 0) {
        j = s.length - 1;
        sb+= ' ';
        while (j >= 0) {
            sb+= s[j];
            j--;
        }
    }
    console.log(sb.trim());
    return sb.trim();
}

reverseStringWithSpaces("Test1ng-Leet=code-Q!");
