package net.mobiuswheel.dotcombust;

import java.util.ArrayList;

public class DotCom
{
	private ArrayList<String> locationCells;
	
	public DotCom(ArrayList<String>locations)
	{
		this.locationCells = locations;		
	}
	
	public String checkYourself(String userInput)
	{
		
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if(index >= 0)
		{
			locationCells.remove(index);
			if(locationCells.isEmpty())
				result = "kill";
			else
				result = "hit";
		}
		return result;
	}
}
