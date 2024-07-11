/**
 * @param {string} sentence
 * @returns {boolean}
 */
function panGram(sentence) {
    const cSet = new Set();

    for (i = 0; i < sentence.length; i++) {
        cSet.add(sentence[i]);
    };

    if (cSet.size > 25) {
        return true;
    }
    
    return false;
}