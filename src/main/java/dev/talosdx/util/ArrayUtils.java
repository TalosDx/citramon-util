package dev.talosdx.util;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtils
{
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }
    
    public static <T> boolean isEmpty(T[] array)
    {
        return array == null || array.length == 0;
    }
    
    public static <T> T[] requiredNotEmpty(T[] array) {
        if(isEmpty(array))
            throw new IllegalArgumentException("Required array non null and not empty");
        return array;
    }
    
    /**
     * Create map array without type erase
     * for batch spring jdbc and other (don't ask me why)
     * @param mapClass map we need
     * @param size array length
     * @param <M> map
     * @param <KEY> map key
     * @param <VALUE> map value
     * @return array map with generic
     */
    @SuppressWarnings("unchecked")
    public static <M extends Map<KEY, VALUE>, KEY, VALUE> M[] newArrayMap(Class<? extends Map> mapClass, int size) {
        return (M[]) Array.newInstance(mapClass, size);
    }
    
    /**
     * Create map array without type erase
     * for batch spring jdbc (don't ask me why)
     * @param size array length
     * @param <M> map
     * @param <KEY> map key
     * @param <VALUE> map value
     * @return array map with generic
     */
    public static <M extends Map<KEY, VALUE>, KEY, VALUE> M[] newArrayMap(int size) {
        return newArrayMap(HashMap.class, size);
    }
    
    /**
     * Create map array without type erase
     * for batch spring jdbc (don't ask me why)
     * @param <M> map
     * @param <KEY> map key
     * @param <VALUE> map value
     * @return array map with generic
     */
    public static <M extends Map<KEY, VALUE>, KEY, VALUE> M[] newArrayMap() {
        return newArrayMap(0);
    }
}
