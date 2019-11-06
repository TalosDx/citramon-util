package dev.talosdx.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest
{
    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE_STRING = " ";
    private static final String LINE_BREAK_STRING = "\n";
    private static final String NON_BREAKING_SPACE_STRING = "\u00A0";
    private static final String TAB_STRING = "\t";
    private static final String NON_EMPTY = "0-9";
    
    @Test
    void isNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(EMPTY_STRING));
        assertFalse(StringUtils.isNotEmpty(WHITE_SPACE_STRING));
        assertFalse(StringUtils.isNotEmpty(LINE_BREAK_STRING));
        assertFalse(StringUtils.isNotEmpty(NON_BREAKING_SPACE_STRING));
        assertFalse(StringUtils.isNotEmpty(TAB_STRING));
        assertTrue(StringUtils.isNotEmpty(NON_EMPTY));
    }
    
    @Test
    void isNotEmptyVarArg()
    {
    }
    
    @Test
    void isEmpty()
    {
    }
    
    @Test
    void isEmptyVarArg()
    {
    }
    
    @Test
    void requiredNotEmpty()
    {
    }
    
    @Test
    void removeSpaces()
    {
        assertTrue(StringUtils.removeSpaces(WHITE_SPACE_STRING).isEmpty());
        assertTrue(StringUtils.removeSpaces(LINE_BREAK_STRING).isEmpty());
        assertTrue(StringUtils.removeSpaces(TAB_STRING).isEmpty());
        assertTrue(StringUtils.removeSpaces(NON_BREAKING_SPACE_STRING).isEmpty());
        assertEquals(StringUtils.removeSpaces(NON_EMPTY), NON_EMPTY);
    }
}
