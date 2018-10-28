package model;

import java.util.HashMap;
import java.util.Map;

public class Decoder
{
    private Map<String, String> dictionary;

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

    private String getCode(String character) throws DictionaryException
    {
        if(this.dictionary.get(character.toLowerCase()) == null)
            throw new DictionaryException("No data to translate");
        return this.dictionary.get(character.toLowerCase());
    }

    public String decode(String input) throws DictionaryException
    {
        input += "  ";
        String output = "";
        String letter = "";
        int i = 0;
        while(i < input.length() - 1)
        {
            if(input.charAt(i) == ' ' && input.charAt(i + 1) == ' ')    //new word
            {
                try
                {
                    output += getCode(letter);
                } catch(DictionaryException e)
                {
                    throw e;
                }
                letter = "";
                output += " ";
                i++;
            } else if(input.charAt(i) != ' ')   //coding single character
            {
                letter += Character.toString(input.charAt(i));

            } else      //next letter
            {
                try
                {
                    output += getCode(letter);
                } catch(DictionaryException e)
                {
                    throw e;
                }
                letter = "";
            }

            i++;
        }
        return output;
    }
}
