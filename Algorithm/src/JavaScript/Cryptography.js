 function isAlpha(word) {
    let alphabets = "abcdefghijklmnopqrstuvwxyz";
    word = word.toLowerCase();
    for(let count = 0; count < word.length(); count++){
        let alphabetCheck = 0;
        for(let counter = 0; counter < alphabets.length(); counter++){
            alphabetCheck += 1;
            if(word.charAt(count) === alphabets.charAt(counter)) break;
        }
        if(alphabetCheck === 26) return false;
    }
    return true;
}


 function isBetweenOneToTwentySix(number) {
     if(number  > 0 && number < 27) return true;
     return false;
 }

