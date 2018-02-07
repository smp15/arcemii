public class GameHandler {

	public Player player;
	public Level level;
	public Connection connection = new Connection();
	
	public void start() {
		Thread draw = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						Main.frame.screen.drawAll(level);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		draw.start();
		Thread u = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
						if (level.update.data.length > 0) {
							connection.output(level.update);
							level.update = new Update();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		u.start();
	}

	public void setLevel(Level l) {
		this.level = l;
	}

	public void output(Object o) {
		connection.output(o);
	}

}
