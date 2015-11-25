package utils;

public class HashMap<K, V> {

	private ArrayList<HashMapObject> hashMap = new ArrayList<>();

	public HashMap() {

	}

	public void addEntry(K key, V value) {
		this.hashMap.add(new HashMapObject(key, value));
	}

	public void removeEntry(K key) {

		ArrayList<HashMapObject> arrayList = new ArrayList<>(this.hashMap);

		for (HashMapObject hashMapObject : arrayList)
			if (hashMapObject.getKey().equals(key)) {
				this.hashMap.remove(hashMapObject);
				return;
			}

		Logger.log("key not found, didn't remove entry");

	}

	public ArrayList<K> getKeys() {

		ArrayList<K> keys = new ArrayList<>();

		for (HashMapObject hashMapObject : this.hashMap)
			keys.add(hashMapObject.getKey());

		return keys;

	}

	public K getKey(V value) {

		for (HashMapObject hashMapObject : this.hashMap)
			if (hashMapObject.getValue().equals(value))
				return hashMapObject.getKey();

		Logger.log("value not found, returning null");

		return null;

	}

	public ArrayList<V> getValues() {

		ArrayList<V> values = new ArrayList<>();

		for (HashMapObject hashMapObject : this.hashMap)
			values.add(hashMapObject.getValue());

		return values;

	}

	public V getValue(K key) {

		for (HashMapObject hashMapObject : this.hashMap)
			if (hashMapObject.getKey().equals(key))
				return hashMapObject.getValue();

		Logger.log("key not found, returning null");

		return null;

	}

	private class HashMapObject {

		private K key;
		private V value;

		public HashMapObject(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

	}

}