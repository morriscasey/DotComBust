package net.mobiuswheel.dotcombust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper
{
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public String getUserInput(String prompt)
	{
		
		String inputLine = null;
		System.out.print(prompt + " ");
		try
		{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0) return null;
			
		}
		catch(IOException e)
		{
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}
	
	public ArrayList<String> placeDotCom(int comSize)
	{
		ArrayList<String> alphaCells = new ArrayList<String>();
		
		String temp = null;
		int[] coords = new int[comSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		
		comCount++;
		int incr = 1;
		if((comCount % 2) == 1)
		{
			incr = gridLength;
		}
		
		while(!success & attempts++ < 200)
		{
			location = (int)(Math.random() * gridSize);
			int x = 0;
			success = true;
			while(success && x < comSize)
			{
				if(grid[location] == 0)
				{
					coords[x++] = location;
					location += incr;
					if(location >= gridSize)
					{
						success = false;
					}
					if(x>0 && (location % gridLength == 0))
					{
						success = false;
					}
				}
				else
				{
					success = false;
				}
			}
			int x1 = 0;
			int row = 0;
			int column = 0;
			while(x1 < comSize)
			{
				grid[coords[x1]] = 1;
				row = (int)(coords[x1] / gridLength);
				column = coords[x1] % gridLength;
				temp = String.valueOf(alphabet.charAt(column));
				alphaCells.add(temp.concat(Integer.toString(row)));
				x1++;
				System.out.print(" coord "+ x+ " = " + alphaCells.get(x1-1));
			}		
		}
		return alphaCells;
	}
}
