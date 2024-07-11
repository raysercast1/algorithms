/**
 * @param {string} w
 * @param {character} c
 * @return {string}
 */
function reversePrefix(w, c) {
    let sp = 0;
    let p = 0;
    let s = '';
    while (sp < w.length) {
        if (w[sp] !== c) {
            p++
            sp++
        } else {
            break;
        }
    }

    if (sp == w.length) {
        console.log("Target char doesn't exist");
        return w;
    }

    while (p >= 0) {
        s+= w[p];
        p--;
    }

    sp++;
    while (sp < w.length) {
        s+= w[sp]
        sp++;
    }
    console.log("Result: ", s);
    return s;
};

reversePrefix("abcd", "z");