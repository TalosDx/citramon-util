package dev.talosdx.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest
{
    private static final String EMPTY_STRING = "";
    private static final String WHITE_SPACE_STRING = " ";
    private static final String LINE_BREAK_STRING = "\n";
    private static final String NON_BREAKING_SPACE_STRING = "\u00A0";
    private static final String TAB_STRING = "\t";
    private static final String NON_EMPTY = "0-9";
    
    private static final String DIRTY_STRING = NON_EMPTY + WHITE_SPACE_STRING + LINE_BREAK_STRING + TAB_STRING + NON_BREAKING_SPACE_STRING + NON_EMPTY;
    private static final String CLEAN_STRING = NON_EMPTY + NON_EMPTY;
    
    @Test
    void isEmpty()
    {
        Assertions.assertTrue(StringUtils.isEmpty(WHITE_SPACE_STRING));
        Assertions.assertTrue(StringUtils.isEmpty(LINE_BREAK_STRING));
        Assertions.assertTrue(StringUtils.isEmpty(TAB_STRING));
        Assertions.assertTrue(StringUtils.isEmpty(NON_BREAKING_SPACE_STRING));
        Assertions.assertFalse(StringUtils.isEmpty(NON_EMPTY));
    }
    
    @Test
    void isNotEmpty()
    {
        Assertions.assertFalse(StringUtils.isNotEmpty(EMPTY_STRING));
        Assertions.assertFalse(StringUtils.isNotEmpty(WHITE_SPACE_STRING));
        Assertions.assertFalse(StringUtils.isNotEmpty(LINE_BREAK_STRING));
        Assertions.assertFalse(StringUtils.isNotEmpty(NON_BREAKING_SPACE_STRING));
        Assertions.assertFalse(StringUtils.isNotEmpty(TAB_STRING));
        Assertions.assertTrue(StringUtils.isNotEmpty(NON_EMPTY));
    }
    
    @Test
    void isEmptyVarArg()
    {
        Assertions.assertTrue(StringUtils.isEmpty(WHITE_SPACE_STRING, LINE_BREAK_STRING, TAB_STRING, NON_BREAKING_SPACE_STRING));
    }
    
    @Test
    void isNotEmptyVarArg()
    {
        Assertions.assertFalse(StringUtils.isNotEmpty(WHITE_SPACE_STRING, LINE_BREAK_STRING, TAB_STRING, NON_BREAKING_SPACE_STRING));
    }
    
    @Test
    void requiredNotEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.requiredNotEmpty(WHITE_SPACE_STRING));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.requiredNotEmpty(LINE_BREAK_STRING));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.requiredNotEmpty(TAB_STRING));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.requiredNotEmpty(NON_BREAKING_SPACE_STRING));
        Assertions.assertEquals(StringUtils.requiredNotEmpty(NON_EMPTY), NON_EMPTY);
    }
    
    @Test
    void removeSpaces()
    {
        assertTrue(StringUtils.removeSpaces(WHITE_SPACE_STRING).isEmpty());
        assertTrue(StringUtils.removeSpaces(LINE_BREAK_STRING).isEmpty());
        assertTrue(StringUtils.removeSpaces(TAB_STRING).isEmpty());
        assertTrue(StringUtils.removeSpaces(NON_BREAKING_SPACE_STRING).isEmpty());
        assertEquals(StringUtils.removeSpaces(DIRTY_STRING), CLEAN_STRING);
    }
}
