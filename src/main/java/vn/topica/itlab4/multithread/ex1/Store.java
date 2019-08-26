package vn.topica.itlab4.multithread.ex1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store  {
	
	List<Lamp> storeList = Collections.synchronizedList(new ArrayList<Lamp>());
	
	//Constructor Store Class
	public Lamp get(int index) {
		return this.storeList.get(index) ;
	}
	
	public void addLamp(Lamp lamp) {
		this.storeList.add(lamp);
	}
	
	public void readLamp() {
		for (Lamp status : storeList) {
			System.out.println(status.toString());
		}
	}
	
	public void deleteLamp(Lamp lamp) {
		this.storeList.remove(lamp);
		
	}
	public int size() {
		return this.storeList.size();
	}
	
}
