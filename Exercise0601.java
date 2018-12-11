
public class Exercise0601 {

	/**
	 * カウントダウン処理
	 * @param name	処理名
	 * @param startTime	開始秒数
	 */
	public static void countDown(String name, int startTime) {
		System.out.println(name + "：カウントダウン開始！");
		for (int i = startTime; i >= 0; i--) {
			System.out.println(name + "：" + i);
			try {
				Thread.sleep(1000);	// 1秒間スリープ
			} catch (InterruptedException e) {}
		}
		System.out.println(name + "：カウントダウン終了！");
	}

	/**
	 * Example0601：カウントダウン処理1と処理2を並列実行させるように変更せよ
	 */
	public static void main(String[] args) {

		CountDownThread tread1 = new CountDownThread("処理1", 5);
		CountDownThread tread2 = new CountDownThread("処理2", 10);
		// 処理1
		tread1.start();
		// 処理2
		tread2.start();
	}

}