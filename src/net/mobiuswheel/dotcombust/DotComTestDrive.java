package net.mobiuswheel.dotcombust;

import java.util.ArrayList;

public class DotComTestDrive
{
	public static void main(String[] args)
	{
		ArrayList<String> testArrayList = new ArrayList<String>();
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("4");
		locations.add("5");
		locations.add("6");
		
		DotCom dot = new DotCom(locations);
		
		String guess = "4";
		String result = dot.checkYourself(guess);
		
		testArrayList.add(checkResult(result, "hit"));
		
		guess = "4";
		result = dot.checkYourself(guess);
		testArrayList.add(checkResult(result, "miss"));
		
		guess = "5";
		result = dot.checkYourself(guess);
		testArrayList.add(checkResult(result, "hit"));
		
		guess = "6";
		result = dot.checkYourself(guess);
		testArrayList.add(checkResult(result, "kill"));
		
		testArrayList.forEach(System.out::println);
	}
	/**
	 * Compares the value returned from DotCom.checkYourself with the expected result. 
	 * @param resultReturned
	 * @param expectedResult
	 * @return String value of failed or passed
	 */
	public static String checkResult(String resultReturned, String expectedResult)
	{
		String testResult = "failed";
		if(resultReturned.equals(expectedResult))
		{
			testResult ="passed";
		}
		return testResult;
	}
}
