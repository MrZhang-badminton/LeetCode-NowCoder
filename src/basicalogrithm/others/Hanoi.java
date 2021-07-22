package basicalogrithm.others;


import java.util.Scanner;

public class Hanoi {

	/**
	 * 移动次数
	 */
	static int m = 0;

	/**
	 * 移动函数
	 *
	 * @param disks
	 * @param N
	 * @param M
	 */
	public static void move(int disks, char N, char M) {
		System.out.println("第" + (++m) + " 次移动 : " + " 把 " + disks + " 号圆盘从 " + N + " ->移到->  " + M);
	}

	/**
	 * 实现汉诺塔的函数
	 *
	 * @param n
	 * @param A
	 * @param B
	 * @param C
	 */
	public static void hanoi(int n, char A, char B, char C) {

		if (n == 1) {// 圆盘只有一个时，只需将其从A塔移到C塔
			Hanoi.move(1, A, C);// 将编b号为1的圆盘从A移到C
		} else {
			// 否则
			hanoi(n - 1, A, C, B);// 递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
			Hanoi.move(n, A, C);// 把A塔上编号为n的圆盘移到C上
			hanoi(n - 1, B, A, C);// 递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		char A = 'A';
		char B = 'B';
		char C = 'C';

		System.out.println("******************************************************************************************");
		System.out.println("汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去---山东科技大学昝道广");
		System.out.println("******************************************************************************************");
		System.out.print("请输入圆盘的个数：");
		int n = in.nextInt();

		Hanoi.hanoi(n, A, B, C);

		System.out.println(">>移动了" + m + "次，把A上的圆盘都移动到了C上");
		in.close();
	}

}