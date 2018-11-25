package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class objects decode Morse Code
 *
 * @author Piotr Musioł
 * @version 2.0
 */
public class Decoder
{
    /**
     * Field for holding codes
     */
    private Map<String, String> dictionary;

    /**
     * Constructor
     */
    public Decoder()
    {
        dictionary = new HashMap<String, String>();
        dictionary.put("", "");
        dictionary.put("*-", "a");
        dictionary.put("-***", "b");
        dictionary.put("-*-*", "c");
        dictionary.put("-**", "d");
        dictionary.put("*", "e");
        dictionary.put("**-*", "f");
        dictionary.put("--*", "g");
        dictionary.put("****", "h");
        dictionary.put("**", "i");
        dictionary.put("*---", "j");
        dictionary.put("-*-", "k");
        dictionary.put("*-**", "l");
        dictionary.put("--", "m");
        dictionary.put("-*", "n");
        dictionary.put("---", "o");
        dictionary.put("*--*", "p");
        dictionary.put("--*-", "q");
        dictionary.put("*-*", "r");
        dictionary.put("***", "s");
        dictionary.put("-", "t");
        dictionary.put("**-", "u");
        dictionary.put("***-", "v");
        dictionary.put("*--", "w");
        dictionary.put("-**-", "x");
        dictionary.put("-*--", "y");
        dictionary.put("--**", "z");
    }

    /**
     * Decoding single letter
     *
     * @param character Morse Code representing single letter
     * @return translated character from Morse Code
     * @throws DictionaryException Incorrect input symbol
     */
    private String getCode(String character) throws DictionaryException
    {
        if (this.dictionary.get(character.toLowerCase()) == null)
            throw new DictionaryException("No data to translate");
        return this.dictionary.get(character.toLowerCase());
    }

    /**
     * Decoding input string
     *
     * @param input input text
     * @return Translated text from Morse Code
     * @throws DictionaryException Incorrect input symbol
     */
    public String decode(String input) throws DictionaryException
    {
        if (input == null)
            return "";
        input += "  ";
        String output = "";
        String letter = "";
        int i = 0;
        while (i < input.length() - 1)
        {
            if (input.charAt(i) == ' ' && input.charAt(i + 1) == ' ')    //new word
            {
                output += getCode(letter);
                letter = "";
                output += " ";
                i++;
            } else if (input.charAt(i) != ' ')   //coding single character
            {
                letter += Character.toString(input.charAt(i));

            } else      //next letter
            {
                output += getCode(letter);
                letter = "";
            }

            i++;
        }
        return output;
    }
}
