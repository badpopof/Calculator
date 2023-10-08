import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

public class DefineTypeNumber {

    public String checkWords(String[] words) throws InputException {

        if (checkArabNumber(words[0]) && checkArabNumber(words[2])) return Main.ARAB_NUMBER;

        if (checkRimNumber(words[0]) && checkRimNumber(words[2])) return Main.ROMAN_NUMBER;

        if (checkArabNumber(words[0]) && checkRimNumber(words[2]))
            throw new InputException("Используются одновременно разные системы счисления");

        if (checkRimNumber(words[0]) && checkArabNumber(words[2]))
            throw new InputException("Используются одновременно разные системы счисления");

        throw new InputException("строка не является математической операцией");
    }

    public boolean checkInteger(double x){
        return x - Math.floor(x) > 0;
    }

    private boolean checkArabNumber(String word) {
        return NumberUtils.isParsable(word);
    }

    private boolean checkRimNumber(String word) {
        String[] arr = word.split("");

        for (String ch : arr) {
            int I = 0;
            for(RomanNumeral n : RomanNumeral.getReverseSortedValues()){
                if (n.toString().equals(ch)) I++;
            }
            if (I == 0) return false;
        }
        return true;
    }
}
