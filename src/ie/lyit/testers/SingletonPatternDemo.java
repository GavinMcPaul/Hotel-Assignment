package ie.lyit.testers;
import ie.lyit.hotel.*;

public class SingletonPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Singleton.getSingleInstance().displaySingleton();
		System.out.println();
	    Singleton.getSingleInstance().displaySingleton();


	}

}
