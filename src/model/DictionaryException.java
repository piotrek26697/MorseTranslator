package model;


/**
 * Exception caused by entering incorrect values
 * @author Piotr Musioł
 * @version 1.1
 */
public class DictionaryException extends Exception
{
    /**
     * Constructor
     * @param message Information about exception
     */
    DictionaryException(String message)
    {
        super(message);
    }
}
