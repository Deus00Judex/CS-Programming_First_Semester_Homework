public class MutableMap<K,V> extends AbstractReadableMap<K,V> implements WriteableMap<K,V> {

    public MutableMap(Entry<K,V>[] entries){
        this.entries=entries;
    }

    public void put(K key, V value){
        for(Entry<K,V> entry : entries){
            if(entry.equals(null) || entry.key.equals(key)){
                entry=new Entry<K,V>(key,value);
                return;
            }
        }
        entries=GenericArrayHelper.copyArrayWithIncreasedSize(entries,entries.length*2);
        for(Entry<K,V> entry : entries){
            if(entry.equals(null)){
                entry=new Entry<K,V>(key,value);
            }
        }
    }

}
