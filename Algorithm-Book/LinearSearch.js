//Organize array using linear search
// const unOrderedArray = [5,3,10,55,19,2,9,100,1000];

const stringArray = process.argv[2];

function linearSearch() {
    const unOrderedArray = castStringInputToArrayElements(stringArray);
    console.log("UnOrdered array: >", unOrderedArray);
    for (i = 1; i < unOrderedArray.length; i++) {
        let k = unOrderedArray[i];
        let j = i - 1;
        while (j >= 0 && unOrderedArray[j] > k) {
            unOrderedArray[j + 1] = unOrderedArray[j];
            j = j - 1;
        }
        unOrderedArray[j + 1] = k;
    }

    console.log("Ordered Array: >", unOrderedArray);
}

function castStringInputToArrayElements(stringArray) {
    const arrayOfNumber = [];
    for (i = 0; i < stringArray.length;) {
        let collector = '';
        let currChar = stringArray[i]; 
        while (!isNaN(currChar)) {
            collector = collector + currChar;
            i++
            currChar = stringArray[i]
        }
        if (collector.length) arrayOfNumber.push(parseInt(collector));
        collector = '';
        i++;
    }
    return arrayOfNumber;
}

linearSearch();