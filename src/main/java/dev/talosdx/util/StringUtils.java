package dev.talosdx.util;

public class StringUtils
{
    public static boolean isNotEmpty(String... strings)
    {
        return !isEmpty(strings);
    }
    
    public static boolean isEmpty(String... strings)
    {
        if (ArrayUtils.isEmpty(strings))
            return false;
        
        for (String string : strings)
        {
            if (isNotEmpty(string))
                return false;
        }
        return true;
    }
    
    public static boolean isNotEmpty(String string)
    {
        return !isEmpty(string);
    }
    
    public static boolean isEmpty(String string)
    {
        return string == null || string.isEmpty() || removeSpaces(string).isEmpty();
    }
    
    public static String requiredNotEmpty(String string)
    {
        if (isEmpty(string))
        {
            throw new IllegalArgumentException("string required non null and not empty");
        }
        return string;
    }
    
    public static String removeSpaces(String string)
    {
        return string.replaceAll("[\\s\\u00A0]", "");
    }
}
