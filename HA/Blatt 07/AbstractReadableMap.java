import java.util.Set;
import java.util.HashSet;

public abstract class AbstractReadableMap <K,V> implements ReadableMap<K,V> {
    protected Entry<K,V>[] entries;

    AbstractReadableMap(Entry<K,V>[] entries1){
        this.entries=GenericArrayHelper.copyArray(entries1);
    }
    AbstractReadableMap(){
        this.entries=GenericArrayHelper.newEntryArrayOfSize(10);
    }


    public V getOrThrow(K key) throws UnknownExeption {
        for(Entry<K,V> entry : entries){
            if(entry != null){
                if (entry.key.equals(key)){
                    return entry.value;
                }
            }
        }
        throw new UnknownExeption("Something went wrong");
    }

    @Override
    public ImmutableMap<K, V> asImmutableMap() {
        return new ImmutableMap<K,V> (entries);
    }

    @Override
    public Set<K> keysAsSet() {
        HashSet hashset=new HashSet();
        for(Entry<K,V> entry : this.entries){
            if(! entry.equals(null)){
                hashset.add(entry);
            }
        }
        return hashset;
    }
}
