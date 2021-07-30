package advanced.rbtree;

/**
 * @Classname: Node
 * @Author: zhanghua
 * @Date: 2021/7/30 10:44 下午
 */
public class Node<K extends Comparable<K>, V> {
	public K key;

	public V value;

	Node<K, V> next;

	public Node() {

	}

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public Node(K key, V value, Node<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

}
