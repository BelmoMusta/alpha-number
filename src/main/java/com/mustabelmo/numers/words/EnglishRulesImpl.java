package com.mustabelmo.numers.words;

public class EnglishRulesImpl extends Rules {
    String[] ones = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };
    String[] tens = {
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
    };
    
    String[] multiplesOfTen = {
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"};
    
    String[] units = {
            "",
            "thousand",//3
            "million",
            "billion",
            "trillion",
            "quadrillion",
            "quintillion",
            "sextillion",
            "septillion",
            "octillion",
            "nonillion",
            "decillion",
            "undecillion",
            "duodecillion",
            "tredecillion",
            "quattuordecillion",
            "quindecillion",
            "sexdecillion",
            "septendecillion",
            "octodecillion",
            "novemdecillion",
            "vigintillion",
            "unvigintillion",
            "duovigintillion",
            "tresvigintillion",
            "quattuorvigintillion",
            "quinquavigintillion",
            "sesvigintillion",
            "septemvigintillion",
            "octovigintillion",
            "novemvigintillion",
            "trigintillion",
            "untrigintillion",
            "duotrigintillion",
            "trestrigintillion",
            "quattuortrigintillion",
            "quinquatrigintillion",
            "sestrigintillion",
            "septentrigintillion",
            "octotrigintillion",
            "novemtrigintillion",
            "quadragintillion",
            "unquadragintillion",
            "duoquadragintillion",
            "tresquadragintillion",
            "quattuorquadragintillion",
            "quinquaquadragintillion",
            "sesquadragintillion",
            "septemquadragintillion",
            "octoquadragintillion",
            "novemquadragintillion",
            "quinquagintillion",
            "unquinquagintillion",
            "duoquinquagintillion",
            "tresquinquagintillion",
            "quattuorquinquagintillion",
            "quinquaquinquagintillion",
            "sesquinquagintillion",
            "septenquinquagintillion",
            "octoquinquagintillion",
            "novemquinquagintillion",
            "sexagintillion",
            "unsexagintillion",
            "duosexagintillion",
            "tressexagintillion",
            "quattuorsexagintillion",
            "quinquasexagintillion",
            "sexasexagintillion",
            "septemsexagintillion",
            "octosexagintillion",
            "novemsexagintillion",
            "septuagintillion",
            "unseptuagintillion",
            "duoseptuagintillion",
            "tresseptuagintillion",
            "quattuorseptuagintillion",
            "quinquaseptuagintillion",
            "sexaseptuagintillion",
            "septenseptuagintillion",
            "octoseptuagintillion",
            "novemseptuagintillion",
            "octogintillion",
            "unoctogintillion",
            "duooctogintillion",
            "tresoctogintillion",
            "quattuoroctogintillion",
            "quinquaoctogintillion",
            "sesoctogintillion",
            "septemoctogintillion",
            "octooctogintillion",
            "novemoctogintillion",
            "nonagintillion",
            "unnonagintillion",
            "duononagintillion",
            "tresnonagintillion",
            "quattuornonagintillion",
            "quinquanonagintillion",
            "sesnonagintillion",
            "septemnonagintillion",
            "octononagintillion",
            "novemnonagintillion",
    };
    
    @Override
    public String getHundreds(int unit, int hundredsDigit) {
        return ones[hundredsDigit];
    }
    
    @Override
    public String getUnitString(int unit) {
        if (unit >= units.length) {
            return "10^" + 3 * unit;
        }
        return units[unit];
    }
    
    @Override
    public String getPluralUnitString(int unit) {
        return getUnitString(unit);
    }
    
    @Override
    public String getOne(int unitsDigit) {
        return ones[unitsDigit];
    }
    
    @Override
    public String getMultipleOfTen(int tensDigit) {
        return multiplesOfTen[tensDigit];
    }
    
    @Override
    public String getTen(int unitsDigit) {
        return tens[unitsDigit];
    }
    
    @Override
    public String getDecimalConnector() {
        return " and ";
    }
    
    @Override
    public String getHundredName(int number) {
        return "hundred";
    }
    
    @Override
    public boolean onesComeAfterTens() {
        return true;
    }
    
    @Override
    public String getZero() {
        return ones[0];
    }
    
    @Override
    public String getJunction() {
        return getDecimalConnector();
    }
}
