package vn.topica.itlab4.multithread.ex1;

/*
 * Author: Le Tien Thinh ITlab4.
 * Exercise Multi-Thread: Lamp has 2 status : ON, OFF.
 * Thread 1: Create random number Lamps and status from 1-20 and add to Store.
 * Thread 2: Remove and Save to Store the Lamp having Status OFF.
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
		
	}
}
