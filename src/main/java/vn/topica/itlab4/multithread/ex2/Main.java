package vn.topica.itlab4.multithread.ex2;
/*
 * Author: Le Tien Thinh ITlab4.
 * Mentor: Nguyen Trung
 * Exercise Multi-Thread: Lamp has 3 status : ON, OFF, REPAIR
 * Thread 1: Create random number Lamp and status from 1-20 and add to Store.
 * Thread 2: Remove and Save to Store the Lamp having Status OFF and REPAIR.
 * Thread 3: Check status of Lamp in Trash: 
  			If REPAIR status, remove from Trash and add to Store
			If OFF status, random 0 or 1,
 				Case 0: Remove this lamp out of Trash
  				Case 1: Change OFF to REPAIR status, after that add to Store.
 */
public class Main {

	public static void main(String[] args) throws InterruptedException  {
		
		//Create object of 2 thread
		Store store = new Store();
		Trash trash = new Trash();
		
		//Thread 1: CreateLamp
		Thread CreateLamp = new Thread(new CreateLamp(store));
		CreateLamp.start();
		
		//Thread 2: RemoveLamp
		Thread RemoveLamp = new Thread(new RemoveLamp(store,trash));
		RemoveLamp.start();
		
		//Thread 3: RepairLamp
		Thread RepairLamp = new Thread(new RepairLamp(store,trash));
		RepairLamp.start();
	}


}
