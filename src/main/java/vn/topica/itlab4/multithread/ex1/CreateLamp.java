package vn.topica.itlab4.multithread.ex1;

import java.util.Random;

//Create Thread using Implement
public class CreateLamp implements Runnable {

	Store store;

	public CreateLamp(Store st) {
		this.store = st;
	}
	
	//Thread 1 Create Lamp 1-20
	public void run() {
		//random 1-20 to create number of Lamp
		Random rd = new Random();
		int n = 1 + rd.nextInt(19);
		//infinite Loop
		while (true) {
			try {
				for (int i = 0; i < n; i++) {
					//random Enum value from Class Lamp
					Lamp.Status randomLamp = Lamp.Status.values()[rd.nextInt(Lamp.Status.values().length)];
					
					//Create object lamp and add to Store
					Lamp lamp = new Lamp(randomLamp);
					store.addLamp(lamp);
					System.out.println("Thread 1: " + lamp.status + " " + lamp.index);
					
					//Let thread sleep for each lamp created
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
			}
		}

	}

}
