//using type arguments/custom parameters
/**
 * @author Sagar
 */

public class HashMap<K, V> {
	K key;
	V value;
	private int capacity=16;
	private Node<K, V>[] table;
	
	public HashMap() {
		table=new Node[capacity];
	}
	
	public void put(K key, V value) {
		int hash=key.hashCode();
		int index=hash%capacity;
		if(index<0) index+=capacity;
		if(table[index]==null){
			table[index]=new Node<K,V>(key, value);
		}else{
			Node<K, V> head=table[index];
			while(head.next!=null){
				if(head.key.equals(key)){
					head.value=value;
					return;
				}
				head=head.next;
			}
			if(head.key.equals(key)){
				head.value=value;
				return;
			}
			head.next=new Node<K, V>(key,value);
		}
	}
	
	public V get(K key){
		int hash=key.hashCode();
		int index=hash%capacity;
		if(index<0) index+=capacity;
		Node<K, V> head=table[index];
		while(head!=null){
			if(head.key.equals(key)) return head.value;
			head=head.next;
		}
		return null;
	}
	
	public boolean remove(K key){
		int hash=key.hashCode();
		int index=hash%capacity;
		if(index<0) index+=capacity;
		Node<K, V> head=table[index];
		if(head==null) return false;
		if(head.key.equals(key)){
			table[index]=head.next;
			return true;
		}
		while(head.next!=null){
			if(head.next.key.equals(key)){
				head.next=head.next.next;
				return true;
			}
			head=head.next;
		}
		return false;
	}
}
