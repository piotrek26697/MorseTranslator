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

    private String getCode(String character)
    {
        return this.dictionary.get(character.toLowerCase());
    }

    public String decode(String input)
    {
        input += "  ";
        String output = "";
        String temp = "";
        int i = 0;
        while(i < input.length() - 1)
        {
            if(input.charAt(i) == ' ' && input.charAt(i + 1) == ' ')    //nowe słowo
            {
                output += getCode(temp);
                temp = "";
                output += " ";
                i++;
            } else if(input.charAt(i) != ' ')   //kodowanie pojedynczej litery
            {
                temp += Character.toString(input.charAt(i));

            } else      //kolejna litera
            {
                output += getCode(temp);
                temp = "";
            }

            i++;
        }
        return output;
    }
}
