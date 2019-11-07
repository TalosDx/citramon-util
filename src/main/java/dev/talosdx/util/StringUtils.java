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
    
    /**
     * Check string on empty include spaces
     * @param string the string we check
     * @return true if string has only spaces or empty or null
     */
    public static boolean isEmpty(String string)
    {
        return string == null || string.isEmpty() || removeSpaces(string).isEmpty();
    }
    
    /**
     * use check {@link #isEmpty(String)}, if string is empty throw exception else return string
     * @param string the string we check
     * @return string unchanged
     */
    public static String requiredNotEmpty(String string)
    {
        if (isEmpty(string))
        {
            throw new IllegalArgumentException("string required non null and not empty");
        }
        return string;
    }
    
    /**
     * Remove any spaces include non-breaking space
     * @param string the string we clear
     * @return string without spaces
     */
    public static String removeSpaces(String string)
    {
        return string.replaceAll("[\\s\\u00A0]", "");
    }
}
