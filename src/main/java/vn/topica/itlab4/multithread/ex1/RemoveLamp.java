package vn.topica.itlab4.multithread.ex1;


public class RemoveLamp implements Runnable {
	Store store;
	Trash trash;
	
	//Constructor RemoveLamp Class
	public RemoveLamp(Store st, Trash tr) {
		this.store = st;
		this.trash = tr;
	}
	//Thread 2 : Remove Lamp OFF from Store
	public void run() {
		//Infinite Loop
		while (true) {
			try {
				for (int i = 0; i < store.size(); i++) {
					
					//If lamp is off, add lamp to Trash
					if (store.get(i).status.equals(Lamp.Status.OFF)) {
						trash.addLamp(store.get(i));
						System.out.println("Thread 2: " + store.get(i).status+ " " + " deleted " + store.get(i).index);
						
						//Delete Lamp OFF in Store
						store.deleteLamp(store.get(i));
						
						//Let thread 2 sleep for each Lamp OFF removed
						
					}
					Thread.sleep(200);
				}
			} catch (InterruptedException e) {
			}
		}
	}
}