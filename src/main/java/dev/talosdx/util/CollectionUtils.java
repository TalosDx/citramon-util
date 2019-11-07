package dev.talosdx.util;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils
{
    public static <C extends Collection> boolean isEmpty(C collection)
    {
        return collection == null || collection.isEmpty();
    }
    
    public static <C extends Collection> boolean isNotEmpty(C collection)
    {
        return !isEmpty(collection);
    }
    
    public static <C extends Collection<TYPE>, TYPE> C removeNulls(C collection)
    {
        while (collection.contains(null))
            collection.remove(null);
        
        return collection;
    }
    
    public static <C extends Collection<TYPE>, TYPE> C requiredNotEmpty(C collection)
    {
        if (isEmpty(collection))
            throw new IllegalArgumentException("Required collection non null and not empty");
        return collection;
    }
    
    public static <M extends Map<KEY, VALUE>, KEY, VALUE> M requiredNotEmpty(M map)
    {
        if (isEmpty(map))
            throw new IllegalArgumentException("Required map non null and not empty");
        return map;
    }
    
    private static <M extends Map> boolean isEmpty(M map)
    {
        return map == null || map.isEmpty();
    }
    
    private static <M extends Map> boolean isNotEmpty(M map)
    {
        return isEmpty(map);
    }
}
