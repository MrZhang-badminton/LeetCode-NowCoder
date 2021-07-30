package advanced.rbtree;

/**
 * @Classname: RBTree
 * @Author: zhanghua
 * @Date: 2021/7/30 10:44 下午
 */
public class RBTree<K extends Comparable<K>, V> {

	public RBTNode<K, V> root;

	public RBTree() {
		this.root = null;
	}

	public V get(K key) {
		RBTNode p = root;
		while (p != null) {
			if (p.key.equals(key)) {
				return (V) p.value;
			} else if (p.key.compareTo(key) > 0) {
				p = p.right;
			} else {
				p = p.left;
			}
		}
		return (V) p.value;
	}

	public void put(K key, V value) {
		RBTNode node = new RBTNode(key, value, true);
		insert(node);
	}

	private void insert(RBTNode node) {
		if (this.root == null) {
			node.red = false;
			this.root = node;
			return;
		}

		RBTNode p = root, parent = null;
		//p = p.right则为true, p = p.left则为false
		boolean flag = false;
		do {
			parent = p;
			if (p.key.equals(node.key)) {
				p.value = node.value;
				return;
			} else if (node.key.compareTo(p.key) > 0) {
				p = p.right;
				flag = true;
			} else {
				p = p.left;
				flag = false;
			}
		} while (p != null);
		node.parent = parent;
		if (flag) {
			parent.right = node;
		} else {
			parent.left = node;
		}
		//如果key不存在,并且增加的节点不是根节点,则需要对颜色进行调整
		insertFixTree(node);
	}

	/**
	 * 这边对传入的红色节点进行平衡操作
	 *
	 * @param node
	 */
	private void insertFixTree(RBTNode node) {
		RBTNode parent, grandParent;
		parent = node.parent;
		grandParent = parent != null ? parent.parent : null;

		if (parent != null && parent.red) {
			if (parent == grandParent.left) {
				//如果父节点是祖父节点的左节点
				RBTNode uncle = grandParent.right;
				if (uncle != null && uncle.red) {
					parent.red = false;
					uncle.red = false;
					grandParent.red = true;
					insertFixTree(grandParent);
					return;
				}


				if (node == parent.left) {
					rightRotate(grandParent);
				} else {
					leftRightRotate(grandParent);
				}
				parent.red = false;
				grandParent.red = true;

			} else {
				//如果附节点是祖父节点的右节点
				RBTNode uncle = grandParent.left;
				if (uncle != null && uncle.red) {
					parent.red = false;
					uncle.red = false;
					grandParent.red = true;
					insertFixTree(grandParent);
					return;
				}
				if (node == parent.right) {
					leftRotate(grandParent);
				} else {
					rightLeftRotate(grandParent);
				}
				parent.red = false;
				grandParent.red = true;
			}
			return;
		}
		this.root.red = false;
	}

	private void leftRotate(RBTNode root) {
		RBTNode p = root.right;
		root.right = p.left;
		if (p.left != null) {
			p.left.parent = root;
		}

		setParentForLeftOrRightSon(root, p);
		p.left = root;
		root.parent = p;
	}

	private void rightRotate(RBTNode root) {
		RBTNode p = root.left;
		root.left = p.right;
		if (p.right != null) {
			p.right.parent = root;
		}
		setParentForLeftOrRightSon(root, p);
	}

	private void setParentForLeftOrRightSon(RBTNode root, RBTNode p) {
		if (root.parent != null) {
			RBTNode parent = root.parent;
			if (parent.left == root) {
				parent.left = p;
			} else {
				parent.right = p;
			}
			p.parent = parent;
		} else {
			this.root = p;
			this.root.parent = null;
		}
	}


	private void leftRightRotate(RBTNode root) {
		leftRotate(root.left);
		rightRotate(root);
	}

	private void rightLeftRotate(RBTNode root) {
		rightRotate((root.right));
		leftRotate(root);
	}

}
