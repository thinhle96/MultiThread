package vn.topica.itlab4.multithread.ex1;

import java.util.concurrent.atomic.AtomicInteger;

public class Lamp {
	
	//Create Enum status
	public enum Status {
		ON, OFF;
	}
	//Create auto-increase variable index
	public static final AtomicInteger count = new AtomicInteger(0);
	int index;
	Status status;
	
	//Constructor
	public Status getStatus() {
		return status;
	}

	public Lamp(Status status) {
		index = count.incrementAndGet();
		this.status = status;
	}
	
	
}
