package model;

import model.Annotation.TestType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases of decoder method
 *
 * @author Piotr Musioł
 * @version 1.0
 */
public class DecoderTest
{
    Decoder decoder;

    @Before
    public void setup()
    {
        decoder = new Decoder();
    }

    @TestType(method = TestType.Method.FAIL_MESSAGE)
    @Test
    public void dotDashInput()
    {
        try
        {
            decoder.decode("*-* *--*");
        }catch(DictionaryException e)
        {
            fail("Exception shouldn't be thrown");
        }
    }

    @TestType(method = TestType.Method.EXCEPTION)
    @Test(expected = DictionaryException.class)
    public void numericInput() throws DictionaryException
    {
        decoder.decode("123");
    }

    @TestType(method = TestType.Method.EXCEPTION)
    @Test(expected = DictionaryException.class)
    public void lowerCaseLetterInput() throws DictionaryException
    {
        decoder.decode("hello");
    }

    @TestType(method = TestType.Method.EXCEPTION)
    @Test(expected = DictionaryException.class)
    public void upperCaseLetterInput() throws DictionaryException
    {
        decoder.decode("HELLO");
    }

    @TestType(method = TestType.Method.EXCEPTION)
    @Test(expected = DictionaryException.class)
    public void punctuationMarksInput() throws DictionaryException
    {
        decoder.decode(".!,/?");
    }
}
