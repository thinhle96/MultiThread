package vn.topica.itlab4.multithread.ex1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trash {
	List<Lamp> trashList = Collections.synchronizedList(new ArrayList<Lamp>());
	
	public Lamp get(int index) {
		return this.trashList.get(index) ;
	}
	
	public void addLamp(Lamp lamp) {
		this.trashList.add(lamp);
	}
	
	public void readLamp(Lamp lamp) {
		for (Lamp obj: trashList) {
			System.out.println(obj.toString());
		}
	}
	public void deleteLamp(Lamp lamp) {
		this.trashList.remove(lamp);
		
	}
}
