
public class Exercise0602 {

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

		CountDownThread cdt1 = new CountDownThread("処理1", 5);
		CountDownThread cdt2 = new CountDownThread("処理2", 10);

		Thread thread1 = new Thread(cdt1,"thread1");
		Thread thread2 = new Thread(cdt2,"thread2");
		// 処理1
		thread1.start();
		// 処理2
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}


		System.out.println("プログラムを終了します");
	}

}