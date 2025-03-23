package generics;

import java.util.HashMap;
import java.util.Map;

public class GenericCache<T> {
    Map<String,T> cache = new HashMap<>();

    public void insert(String key, T val){
        cache.put(key,val);
    }

    public T getVal(String key){
        return cache.get(key);
    }

    public static void main(String[] args) {
        GenericCache<Integer> integerGenericCache = new GenericCache<>();
        integerGenericCache.insert("one",1);

        GenericCache<String> stringGenericCache = new GenericCache<>();
        stringGenericCache.insert("sundar","sundar");

    }
}
