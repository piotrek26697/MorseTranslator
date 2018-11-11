package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Piotr Musioł
 * @version 1.0
 */
public class Coder
{
    /**
     * Field for holding codes
     */
    private Map<String, String> dictionary;

    /**
     * Constructor
     */
    public Coder()
    {
        this.dictionary = new HashMap<String, String>();
        dictionary.put(" ", " ");
        dictionary.put("a", "*- ");
        dictionary.put("b", "-*** ");
        dictionary.put("c", "-*-* ");
        dictionary.put("d", "-** ");
        dictionary.put("e", "* ");
        dictionary.put("f", "**-* ");
        dictionary.put("g", "--* ");
        dictionary.put("h", "**** ");
        dictionary.put("i", "** ");
        dictionary.put("j", "*--- ");
        dictionary.put("k", "-*- ");
        dictionary.put("l", "*-** ");
        dictionary.put("m", "-- ");
        dictionary.put("n", "-* ");
        dictionary.put("o", "--- ");
        dictionary.put("p", "*--* ");
        dictionary.put("q", "--*- ");
        dictionary.put("r", "*-* ");
        dictionary.put("s", "*** ");
        dictionary.put("t", "- ");
        dictionary.put("u", "**- ");
        dictionary.put("v", "***- ");
        dictionary.put("w", "*-- ");
        dictionary.put("x", "-**- ");
        dictionary.put("y", "-*-- ");
        dictionary.put("z", "--** ");
    }

    /**
     * Coding single letter
     * @param character Letter to code
     * @return Morse code of a single letter
     * @throws DictionaryException Incorrect input symbol
     */
    private String getCode(String character) throws DictionaryException
    {
        if (this.dictionary.get(character.toLowerCase()) == null)
            throw new DictionaryException("No data to translate");
        return this.dictionary.get(character.toLowerCase());
    }

    /**
     * Coding input string
     * @param input input text
     * @return Coded input text
     * @throws DictionaryException Incorrect input symbol
     */
    public String code(String input) throws DictionaryException
    {
        String output = "";
        for (int i = 0; i < input.length(); i++)
        {
            String character = Character.toString(input.charAt(i));
            output += this.getCode(character);

        }
        return output;
    }
}
