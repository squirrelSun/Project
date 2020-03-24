package Recursive;

//八皇后问题
public class TestEightQueue {

	int max = 8;
	int[] array = new int[max];
	static int count = 0;//保存皇后放置位置的结果
	static int judgeCount = 0;

	public static void main(String[] args) {
		TestEightQueue queue8 = new TestEightQueue();
		queue8.check(0);
		System.out.printf("一共有%d解法", count);
		System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w

	}

	// 放置第n个皇后
	// check 是 每一次递归时，进入到check中都有 for(int i = 0; i < max; i++)，因此会有回溯
	private void check(int n) {
		if (n == max) { // n = 8 , 其实8个皇后就既然放好
			print();
			return;
		}
		// 依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			// 先把当前这个皇后 n , 放到该行的第1列
			array[n] = i;
			// 判断当放置第n个皇后到i列时，是否冲突
			if (judge(n)) { // 不冲突
				// 接着放n+1个皇后,即开始递归
				check(n + 1); //
			}
			// 如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
		}
	}

	// 查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	// 将皇后摆放的位置输出
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
