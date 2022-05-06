import java.util.Set;

public interface ReadableMap<K,V> {
    V getOrThrow(K key) throws UnknownExeption;
    ImmutableMap<K,V> asImmutableMap();
    Set<K> keysAsSet();
}
