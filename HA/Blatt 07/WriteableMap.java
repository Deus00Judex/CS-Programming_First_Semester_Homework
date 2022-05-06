public interface WriteableMap<K,V> extends ReadableMap<K,V>{
    void put(K key, V value);
}
