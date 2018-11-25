package model.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
public @interface TestType
{
    public enum Method
    {
        BOOLEAN, EXCEPTION, NULL_OBJECT, IDENTICAL, ASSERT_EQUALS, ASSERT_ARRAY_EQUALS, FAIL_MESSAGE
    }
    Method method();
}
