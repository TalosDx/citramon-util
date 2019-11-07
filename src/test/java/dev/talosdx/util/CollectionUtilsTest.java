package dev.talosdx.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class CollectionUtilsTest
{
    
    @Test
    void isEmpty()
    {
        Assertions.assertTrue(CollectionUtils.isEmpty(null));
        Assertions.assertTrue(CollectionUtils.isEmpty(Collections.emptyList()));
    }
    
    @Test
    void isNotEmpty()
    {
        Assertions.assertFalse(CollectionUtils.isNotEmpty(null));
        Assertions.assertTrue(CollectionUtils.isNotEmpty(Collections.singletonList("")));
    }
    
    @Test
    void requiredNotEmptyCollection()
    {
        final List<String> checkedList = new ArrayList<>();
        checkedList.add("someElement");
        Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.requiredNotEmpty(Collections.emptyList()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.requiredNotEmpty((List<?>) null));
        Assertions.assertEquals(CollectionUtils.requiredNotEmpty(checkedList), checkedList);
    }
    
    @Test
    void requiredNotEmptyMap()
    {
        final Map<String, String> checkedMap = new HashMap<>();
        checkedMap.put("someKey", "someValue");
        Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.requiredNotEmpty(Collections.emptyMap()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionUtils.requiredNotEmpty((Map<?, ?>) null));
        Assertions.assertEquals(CollectionUtils.requiredNotEmpty(checkedMap), checkedMap);
    }
    
    @Test
    void removeNulls()
    {
        final List<String> checkedList = new ArrayList<>(Arrays.asList(null, "", null, null, ""));
        final List<String> equalsList = new ArrayList<>(Arrays.asList("", ""));
        Assertions.assertEquals(CollectionUtils.removeNulls(checkedList), equalsList);
    }
}