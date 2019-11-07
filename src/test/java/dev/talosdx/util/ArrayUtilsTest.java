package dev.talosdx.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayUtilsTest
{
    
    private static final String[] NOT_EMPTY_ARRAY = new String[]{""};
    private static final String[] EMPTY_ARRAY = new String[0];
    private Map<Object, Object>[] linkedMapArray;
    private Map<Object, Object>[] hashMapArray;
    
    @BeforeEach
    void setUp()
    {
        linkedMapArray = ArrayUtils.newArrayMap(LinkedHashMap.class, 1);
        hashMapArray = ArrayUtils.newArrayMap(HashMap.class, 1);
    }
    
    @Test
    void isEmpty()
    {
        Assertions.assertTrue(ArrayUtils.isEmpty(null));
        Assertions.assertTrue(ArrayUtils.isEmpty(EMPTY_ARRAY));
        
        Assertions.assertFalse(ArrayUtils.isEmpty(NOT_EMPTY_ARRAY));
    }
    
    @Test
    void isNotEmpty()
    {
        Assertions.assertFalse(ArrayUtils.isNotEmpty(null));
        Assertions.assertFalse(ArrayUtils.isNotEmpty(EMPTY_ARRAY));
        
        Assertions.assertTrue(ArrayUtils.isNotEmpty(NOT_EMPTY_ARRAY));
    }
    
    @Test
    void requiredNotEmpty()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ArrayUtils.requiredNotEmpty(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ArrayUtils.requiredNotEmpty(EMPTY_ARRAY));
        
        Assertions.assertEquals(ArrayUtils.requiredNotEmpty(NOT_EMPTY_ARRAY), NOT_EMPTY_ARRAY);
    }
    
    @Test
    void newArrayMapNotNull() {
        Assertions.assertNotNull(ArrayUtils.newArrayMap(LinkedHashMap.class, 0));
        Assertions.assertNotNull(ArrayUtils.newArrayMap(HashMap.class, 0));
        Assertions.assertNotNull(ArrayUtils.newArrayMap(HashMap.class, 1));
        Assertions.assertNotNull(ArrayUtils.newArrayMap(HashMap.class, 2));
    }
    
    @Test
    void newArrayMapCheckType() {
        final Map<Object, Object>[] linkedMapArray = ArrayUtils.newArrayMap(LinkedHashMap.class, 1);
        final Map<Object, Object>[] hashMapArray = ArrayUtils.newArrayMap(HashMap.class, 1);
    
        Assertions.assertThrows(ArrayStoreException.class, () -> linkedMapArray[0] = new HashMap<>());
        Assertions.assertThrows(ArrayStoreException.class, () -> hashMapArray[0] = new Hashtable<>());
    }
    
    @Test
    void newArrayMap()
    {
        //expect equals to work correctly
        linkedMapArray[0] = new LinkedHashMap<>();
        hashMapArray[0] = new HashMap<>();
        Assertions.assertEquals(linkedMapArray[0], new LinkedHashMap<>());
        Assertions.assertEquals(hashMapArray[0], new HashMap<>());
    }
    
    @Test
    void newArrayMapNotNullNotZeroSize()
    {
        Assertions.assertNotNull(ArrayUtils.newArrayMap(1));
        Assertions.assertNotNull(ArrayUtils.newArrayMap(2));
    }
    
    @Test
    void newArrayMapZeroNotNullSize()
    {
        Assertions.assertNotNull(ArrayUtils.newArrayMap());
    }
}
