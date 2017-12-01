package ie.lyit.hotel;

import ie.lyit.hotel.*;

public class Singleton 
{
	private static Singleton singleInstance;
	
	private Singleton()
	{
		super();
	}
	
	public static Singleton getSingleInstance()
	{
		if(singleInstance == null)
		{
			singleInstance = new Singleton();
			System.out.println("Single object created: " + singleInstance);
		}
		
		return singleInstance;
		
	
	}
	
	public void displaySingleton()
	{
		System.out.println("Singleton Object:" + singleInstance);
	}
	
	

}
