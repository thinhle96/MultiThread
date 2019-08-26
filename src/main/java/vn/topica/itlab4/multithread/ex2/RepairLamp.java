package vn.topica.itlab4.multithread.ex2;
import java.util.Random;

public class RepairLamp implements Runnable {
	Store store;
	Trash trash;

	public RepairLamp(Store st, Trash tr) {
		this.store = st;
		this.trash = tr;
	}

	public void run() {
		while (true) {
			try {
				for (int i = 0; i < trash.size(); i++) {
					Random rd = new Random();
					int n = rd.nextInt(1);
					if (trash.get(i).status.equals(Lamp.Status.REPAIR)) {
						store.addLamp(trash.get(i));
						System.out.println("Thread 3: " + trash.get(i).status + " " + "remove to Trash and add to Store " + trash.get(i).index);
						trash.deleteLamp(store.get(i));
						
					}else if (trash.get(i).status.equals(Lamp.Status.OFF)) {
						if (n == 0) {
							System.out.println("Thread 3: " + trash.get(i).status + " "+ " remove to Trash and doesn't add to Store " + trash.get(i).index);
							trash.deleteLamp(trash.get(i));
						} else {
							trash.get(i).status = Lamp.Status.REPAIR;
							store.addLamp(trash.get(i));
							trash.deleteLamp(trash.get(i));
							System.out.println("Thread 3: " + trash.get(i).status + " " + " remove to Trash and add to Store " + trash.get(i).index);
						}
					}
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
