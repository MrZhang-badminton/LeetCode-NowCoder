package advanced.rbtree;

/**
 * @Classname: RBTNode
 * @Author: zhanghua
 * @Date: 2021/7/30 10:48 下午
 */
public class RBTNode<K extends Comparable<K>, V> extends Node<K, V> {

	public RBTNode<K, V> parent;
	public RBTNode<K, V> left;
	public RBTNode<K, V> right;

	public boolean red;

	public RBTNode(K key, V value, boolean red) {
		super(key, value);
		this.red = red;
	}
}
