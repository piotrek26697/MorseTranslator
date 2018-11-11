package model;


/**
 * Exception caused by entering incorrect values
 * @author Piotr Musioł
 * @version 1.0
 */
public class DictionaryException extends Exception
{
    DictionaryException()
    {
    }

    /**
     * Constructor
     * @param message Information about exception
     */
    DictionaryException(String message)
    {
        super(message);
    }
}
