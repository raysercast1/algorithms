/**
 * @param {number[]} numbers
 * @param {number} valueToSearch
 * @returns {number|null}
 */
function searchXValueInIndex(numbers, valueToSearch) {
    for (let i = 0; i < numbers.length; i++) {
        if (numbers[i] === valueToSearch) return i;
    }
    return null;
}

/**
 * @returns {void}
 */
function printOut() {
    const numbers = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]
    const stringValue = process.argv[2];
    const value = searchXValueInIndex(numbers, Number(stringValue));
    value ? console.log("Value is here: ", value) : console.log("Null: ", value);
}
printOut();


