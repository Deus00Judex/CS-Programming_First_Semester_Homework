public final class ImmutableMap<K,V> extends AbstractReadableMap<K,V>{

    public ImmutableMap(Entry<K,V>[] entries){
        super(entries);
    }
}
