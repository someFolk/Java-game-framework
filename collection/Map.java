package folk.collection;

public class Map<K,V> {

	// Elements container.
	private List<V> values;
	private List<K> keys;

	public Map(){
		values = new List<>();
		keys = new List<>();
	}

	// Setting value to specific index.
	public void set(K key, V value){
		int index = keys.indexOf(key);
		if(index < -1){
			keys.add(key);
			values.add(value);
			return;
		}
		values.set(index, value);
	}

	// Get value by index.
	public V get(K key){
		ensureRange();
		return values.get(getIndexByKey( key ));
	}

	private void ensureRange(){
		if(keys.length() < 1 ) throw new IllegalStateException("Map is empty");
	}

	private int getIndexByKey(K key){
		int index = keys.indexOf(key);
		if(index < 0) throw new IllegalStateException("No such key exist");
		return index;
	}



	// Remove and return last item.
	public V pull(K key){
		ensureRange();
		int index = getIndexByKey( key );
		V temp = values.get(index);
		remove(index);
		return temp;
	}

	private void remove(int index){
		keys.remove(index);
		values.remove(index);
	}
	// Remove value by index.
	public void remove(K key){
		remove(getIndexByKey(key));
	}

	// return index of value if exist
	public boolean containsValue(V value){
		if(isEmpty()) return false;
		for(int i = 0, s = values.length(); i < s; i++){
			if(values.get(i) == value) return true;
		}
		return false;
	}

	// return index of value if exist
	public boolean containsKey(K key){
		if(isEmpty()) return false;
		for(int i = 0, s = keys.length(); i < s; i++){
			if(keys.get(i) == key) return true;
		}
		return false;
	}

	// Ditching all values while remaining structure.
	public void clear(){
		values.clear();
		keys.clear();
	}

	// Merging two arrays into one.
	public void join(Map<K,V> map){
		// todo
		throw new IllegalStateException("Method not constructed yet..");
	}

	// Starting clean
	public void reset(){
		values.reset();
		keys.reset();
	}

	// Release memory when necessary
	public void shrink(){
		values.shrink();
		keys.shrink();
	}


	public boolean isEmpty(){
		return keys.length() == 0? true : false;
	}

}


