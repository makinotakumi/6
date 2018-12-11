
public class CountDownThread implements Runnable{
	private int startTime;

	/**
	 * 指定した名前と開始秒数で初期化するコンストラクタ
	 * @param name	スレッド名
	 * @param startTime	開始秒数
	 */
	public CountDownThread(String name, int startTime) {
		// スレッド名を設定
		Thread.currentThread().setName(name);
		// 開始秒数を設定
		setStartTime(startTime);
	}

	/**
	 * 開始秒数を設定するセッター
	 * @param startTime	開始秒数
	 */
	public void setStartTime(int startTime) {
		if (startTime <= 0) {
			throw new IllegalArgumentException("不正な値：" + startTime);
		}
		this.startTime = startTime;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "：カウントダウン開始！");
		for (int i = startTime; i >= 0; i--) {
			System.out.println(Thread.currentThread().getName() + "：" + i);
			try {
				Thread.sleep(1000);	// 1秒間スリープ
			} catch (InterruptedException e) {}
		}
		System.out.println(Thread.currentThread().getName() + "：カウントダウン終了！");
	}

}