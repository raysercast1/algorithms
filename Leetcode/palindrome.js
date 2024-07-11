/**
 @param {string} s 
 @returns {boolean}
 */
function checkIfPalindrome(s) {
    leftIdx = 0;
    rightIdx = s.length - 1;

    while (leftIdx < rightIdx) {
        if (s[leftIdx] !== s[rightIdx]) {
            console.log('FALSE')
            return false;
        }
        leftIdx++;
        rightIdx--;
    }
    console.log('TRUE')
    return true;
}

checkIfPalindrome('abcdcba');
checkIfPalindrome('racecar');
checkIfPalindrome('rayser');