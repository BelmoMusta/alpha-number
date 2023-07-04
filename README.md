# alpha-number
Convert numbers from digital format to letters.

This code provides a tool to convert a number from its digital value to the letter format.

This release only deals with the french based conversion.

## Example :

```JAVA
Number x = 182345009;
Number numberInWords = new numberInWords(x);
Number french = new numberInWords(x);
Number numberInWords = new numberInWords(x);
System.out.println(numberInWords);
System.out.println(french);
System.out.println(numberInWords);
```
```shell
{
value : 182345009,
letters: 'one hundred eighty two million, three hundred forty five thousand, nine'
}
{
value : 182345009,
letters: 'cent quatre-vingt deux million, trois cent quarante cinq mille, neuf'
}
{
value : 182345009,
letters: 'مائة واثنان وثمانون مليون وثلاثمائة وخمسة وأربعون ألف وتسعة'
}
```

## TODO :white_check_mark:

- Integrate the english format conversion. :white_check_mark:
- Integrate the arabic format conversion. :white_check_mark:


