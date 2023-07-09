# Write numbers in words
[![Maven Build](https://github.com/BelmoMusta/alpha-number/actions/workflows/maven.yml/badge.svg)](https://github.com/BelmoMusta/alpha-number/actions/workflows/maven.yml)
[![Maven Test and Coverage](https://github.com/BelmoMusta/alpha-number/actions/workflows/test.yml/badge.svg)](https://github.com/BelmoMusta/alpha-number/actions/workflows/test.yml)

Convert numbers from digital format to words.

This code provides a tool to convert a number from its digital value to the words format.
This release supports 3 built-in languages : `English`, `French` and `Arabic`.
# Using as instance
## Basic Example :

```JAVA
Number x = 192345009;
NumberInWords numberInWords = new NumberInWords(x, Locale.ENGLISH);
System.out.println(numberInWords.toString());
```

```shell
one hundred ninety two million, three hundred forty five thousand, nine
```
## Decimal Format :
The decimals are supported too : 
```java
double value = 200.0098;
NumberInWords numberInWords = new NumberInWords(value);
System.out.println(numberInWords.toString());
```
```shell
two hundred and zero zero ninety eight
```
## Customization
If a customization is wanted, it will be by extending the `Rules` class and implement its method, the way the words format of a number is wanted.
Then, the new `Extended Rules` will be registered for a locale, if it depends on a Region or a Language : 
```java
LocalesRulesRegistry.register(Locale.XXXX, new MyNewRules());
```

Or simply create a number by providing the new Rules : 
```java
NumberInWords numberInWords = new NumberInWords(29, new MyNewRules());
```
## Testing And Coverage
Test are written in order to maintain the coverage of all the rules that implemented, but not to cover all the possible cases.

Coverage is ensured to be `100%` on branches, lines, and methods.

## Limitations
- Some limitations are found, due to the big numbers, if a million multiple in a such rank does not exist, it will be replaced by `10^{rank}`.
- Decimal numbers beyond 10^15 are recommended to be dealt with as `String` not with `double`, because the decimal part is lost when converting it to `BigDecimal`
```java
String x = "1000000000000000.001";
NumberInWords numberInWords = new NumberInWords(x);
String toLetters = numberInWords.toLetters();
```
This will yield
```shell
one quadrillion and zero zero one
```
Whereas 

```java
double x = 1000000000000000.001;
NumberInWords numberInWords = new NumberInWords(x);
String toLetters = numberInWords.toLetters();
```
Will yield 
```shell
one quadrillion
```
## Usage a stateless Service
The conversion can be used without needing to create an instance for each number, 
which is useful for the dependency injection oriented architectures : 

```java
Rules frenchRules = LocalesRulesRegistry.get(Locale.FRANCE);
INumberToWordsConverter numbersToWordsConverter = new NumberToWordsConverter();
String numberInWords = numbersToWordsConverter.convert("1500", frenchRules);
System.out.println(numberInWords);
```
```shell
mille cinq cents
```

## References 
[FR : Noms_des_grands_nombres](https://fr.wikipedia.org/wiki/Noms_des_grands_nombres) 

[EN : Names_of_large_numbers](https://en.wikipedia.org/wiki/Names_of_large_numbers) 

[EN : List_of_Illion_numbers](https://character.fandom.com/wiki/List_of_Illion_numbers) 


