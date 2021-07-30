package advanced.rbtree;

import java.util.Scanner;

/**
 * @Classname: RBTreeTest
 * @Author: zhanghua
 * @Date: 2021/7/30 11:55 下午
 */
public class RBTreeTest {

	public static void main(String[] args) {
		RBTree<Integer, Object> rbt = new RBTree();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入key:");
			Integer key = sc.nextInt();

			rbt.put(key, null);
			RBTreeOperation.show(rbt.root);
		}
	}

}
