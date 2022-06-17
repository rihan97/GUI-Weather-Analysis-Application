import java.awt.Color;  //Colour class used for indicating colours to components
import java.awt.event.WindowAdapter; //Enables listener objects to be created
import java.awt.event.WindowEvent; //Indicates events changing its status
import java.io.BufferedReader;  //Used to read data from the CSV and TXT files
import java.io.FileReader;		//Used for identifying a file and read data from it.
import java.io.IOException;	//Used for identifying if an error has occurred.
import java.io.FileNotFoundException;
import java.util.ArrayList; //Allows information to be stored in a list


import java.awt.*;

public class WA extends Frame{
	
	public WA() {
	}
	
	public void main2() {	
		WA w = new WA(); 	// creates object of wa class		
	}
	
	//array lists for storing data got from the file
	ArrayList year = new ArrayList();
	ArrayList max = new ArrayList();
	ArrayList min = new ArrayList();
	ArrayList avg = new ArrayList();
	
	private static String removeCharacters(String string){
		string = string.replace("*" , "");
		string = string.replace("#" , "");
		return string;
	}
	
	
	public void sheffieldcsvTMax(){
		String file = "raw/sheffielddata.csv";			//File name from where to get data
		BufferedReader br = null;		
		String line = "";
		String splitter = ",";				//comma character splitter for csv file
		String txtSplitter = " ";
		
		ArrayList yr = new ArrayList();		//yr used for storing the year values of the file
		ArrayList tmax = new ArrayList();	//tmax used for storing the temp max values of the file
		
		//Loading data from csv file to arraylist objects
		try		
		{
			br = new BufferedReader(new FileReader(file));	
			while ((line = br.readLine()) != null)
			{
				String[] x = line.split(splitter);		//x stores all fields of the record read from the file
				yr.add(x[0]);    //storing values from first column into yr
				tmax.add(x[2]);	 //storing values from third column into tmax			
			}
		}
		catch(FileNotFoundException e)					//Handling possible exceptions
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();	
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		
		//Loading Complete
		
		//Now Calculating Statistics (Max, Min and Avg)
		
		int current_year, i, count;
		float mx, mn, sm;
				
		for (i=1; i<=yr.size()-1;) //Starting from index no. 0, because index no. 0 is for heading
		{			
			current_year= Integer.parseInt(yr.get(i).toString());			//setting year
			mx = Float.parseFloat(tmax.get(i).toString());					//setting initial max value
			mn = Float.parseFloat(tmax.get(i).toString());					//setting initial min value
			
			sm=Float.parseFloat(tmax.get(i).toString());;						//setting initial value of sum
			count=1;														//setting initial value of count variable
			
			i++;	//Proceed to next record
			
			while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
			{
				if ( Float.parseFloat(tmax.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
					mx = Float.parseFloat(tmax.get(i).toString());
				if ( Float.parseFloat(tmax.get(i).toString()) < mn)
					mn = Float.parseFloat(tmax.get(i).toString());
				
				sm = sm + Float.parseFloat(tmax.get(i).toString());			//adding current tmax value to sum value
				count++;
				i++;
				
				if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
					break;
			}
			//Now saving this current_year, mx and mn to global variables year, max and min
			year.add(Integer.toString(current_year));						
			max.add(Float.toString(mx));
			min.add(Float.toString(mn));
			avg.add(Float.toString(sm/count));
			
			//If lists not finished, then proceed to next record
			if (i < yr.size()-1)
			{				
				current_year= Integer.parseInt(yr.get(i).toString());
				mx = Float.parseFloat(tmax.get(i).toString());
				mn = Float.parseFloat(tmax.get(i).toString());
			}
		}
		
		
		//Now Display Statistics
		System.out.println("Year\tMax\tMin\tAvg\n");
		for (i=0; i<=year.size()-1; i++)
		{
			System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
		}		
		
	}
	
	
	
	public void sheffieldcsvTmin(){
		String file = "raw/sheffielddata.csv";			//File name from where to get data
		BufferedReader br = null;		
		String line = "";
		String splitter = ",";				//comma character splitter for csv file
		String txtSplitter = " ";
		
		ArrayList yr = new ArrayList();		
		ArrayList tmin = new ArrayList();
		
		//Loading data from csv file to arraylist objects
		try		
		{
			br = new BufferedReader(new FileReader(file));	
			while ((line = br.readLine()) != null)
			{
				String[] x = line.split(splitter);		//x stores all fields of the record read from the file
				yr.add(x[0]);
				tmin.add(x[3]);				
			}
		}
		catch(FileNotFoundException e)					//Handling possible exceptions
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();	
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		
		//Loading Complete
		
		//Now Calculating Statistics (Max, Min and Avg)
		
		int current_year, i, count;
		float mx, mn, sm;
				
		for (i=1; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
		{			
			current_year= Integer.parseInt(yr.get(i).toString());			//setting year
			mx = Float.parseFloat(tmin.get(i).toString());					//setting initial max value
			mn = Float.parseFloat(tmin.get(i).toString());					//setting initial min value
			
			sm=Float.parseFloat(tmin.get(i).toString());;						//setting initial value of sum
			count=1;														//setting initial value of count variable
			
			i++;	//Proceed to next record
			
			while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
			{
				if ( Float.parseFloat(tmin.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
					mx = Float.parseFloat(tmin.get(i).toString());
				if ( Float.parseFloat(tmin.get(i).toString()) < mn)
					mn = Float.parseFloat(tmin.get(i).toString());
				
				sm = sm + Float.parseFloat(tmin.get(i).toString());			//adding current tmin value to sum value
				count++;
				i++;
				
				if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
					break;
			}
			//Now saving this current_year, mx and mn to global variables year, max and min
			year.add(Integer.toString(current_year));						
			max.add(Float.toString(mx));
			min.add(Float.toString(mn));
			avg.add(Float.toString(sm/count));
			
			//If lists not finished, then proceed to next record
			if (i < yr.size()-1)
			{				
				current_year= Integer.parseInt(yr.get(i).toString());
				mx = Float.parseFloat(tmin.get(i).toString());
				mn = Float.parseFloat(tmin.get(i).toString());
			}
		}
		
		
		//Now Display Statistics
		System.out.println("Year\tMax\tMin\tAvg\n");
		for (i=0; i<=year.size()-1; i++)
		{
			System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
		}		
		
	}
	
	
	
	public void sheffieldcsvAirForest(){
		String file = "raw/sheffielddata.csv";			//File name from where to get data
		BufferedReader br = null;		
		String line = "";
		String splitter = ",";				//comma character splitter for csv file
		String txtSplitter = " ";
		
		ArrayList yr = new ArrayList();		
		ArrayList af = new ArrayList();
		
		//Loading data from csv file to arraylist objects
		try		
		{
			br = new BufferedReader(new FileReader(file));	
			while ((line = br.readLine()) != null)
			{
				String[] x = line.split(splitter);		//x stores all fields of the record read from the file
				yr.add(x[0]);
				af.add(x[4]);				
			}
		}
		catch(FileNotFoundException e)					//Handling possible exceptions
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();	
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		
		//Loading Complete
		
		//Now Calculating Statistics (Max, Min and Avg)
		
		int current_year, i, count;
		float mx, mn, sm;
				
		for (i=1; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
		{			
			current_year= Integer.parseInt(yr.get(i).toString());			//setting year
			mx = Float.parseFloat(af.get(i).toString());					//setting initial max value
			mn = Float.parseFloat(af.get(i).toString());					//setting initial min value
			
			sm=Float.parseFloat(af.get(i).toString());;						//setting initial value of sum
			count=1;														//setting initial value of count variable
			
			i++;	//Proceed to next record
			
			while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
			{
				if ( Float.parseFloat(af.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
					mx = Float.parseFloat(af.get(i).toString());
				if ( Float.parseFloat(af.get(i).toString()) < mn)
					mn = Float.parseFloat(af.get(i).toString());
				
				sm = sm + Float.parseFloat(af.get(i).toString());			//adding current af value to sum value
				count++;
				i++;
				
				if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
					break;
			}
			//Now saving this current_year, mx and mn to global variables year, max and min
			year.add(Integer.toString(current_year));						
			max.add(Float.toString(mx));
			min.add(Float.toString(mn));
			avg.add(Float.toString(sm/count));
			
			//If lists not finished, then proceed to next record
			if (i < yr.size()-1)
			{				
				current_year= Integer.parseInt(yr.get(i).toString());
				mx = Float.parseFloat(af.get(i).toString());
				mn = Float.parseFloat(af.get(i).toString());
			}
		}
		
		
		//Now Display Statistics
		System.out.println("Year\tMax\tMin\tAvg\n");
		for (i=0; i<=year.size()-1; i++)
		{
			System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
		}		
		
	}
	
	
	
	public void sheffieldcsvRain(){
		
		String file = "raw/sheffielddata.csv";			//File name from where to get data
		BufferedReader br = null;		
		String line = "";
		String splitter = ",";				//comma character splitter for csv file
		String txtSplitter = " ";
		
		ArrayList yr = new ArrayList();		
		ArrayList rain = new ArrayList();
		
		//Loading data from csv file to arraylist objects
		try		
		{
			br = new BufferedReader(new FileReader(file));	
			while ((line = br.readLine()) != null)
			{
				String[] x = line.split(splitter);		//x stores all fields of the record read from the file
				yr.add(x[0]);
				rain.add(x[5]);				
			}
		}
		catch(FileNotFoundException e)					//Handling possible exceptions
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();	
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		
		//Loading Complete
		
		//Now Calculating Statistics (Max, Min and Avg)
		
		int current_year, i, count;
		float mx, mn, sm;
				
		for (i=1; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
		{			
			current_year= Integer.parseInt(yr.get(i).toString());			//setting year
			mx = Float.parseFloat(rain.get(i).toString());					//setting initial max value
			mn = Float.parseFloat(rain.get(i).toString());					//setting initial min value
			
			sm=Float.parseFloat(rain.get(i).toString());;						//setting initial value of sum
			count=1;														//setting initial value of count variable
			
			i++;	//Proceed to next record
			
			while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
			{
				if ( Float.parseFloat(rain.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
					mx = Float.parseFloat(rain.get(i).toString());
				if ( Float.parseFloat(rain.get(i).toString()) < mn)
					mn = Float.parseFloat(rain.get(i).toString());
				
				sm = sm + Float.parseFloat(rain.get(i).toString());			//adding current rain value to sum value
				count++;
				i++;
				
				if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
					break;
			}
			//Now saving this current_year, mx and mn to global variables year, max and min
			year.add(Integer.toString(current_year));						
			max.add(Float.toString(mx));
			min.add(Float.toString(mn));
			avg.add(Float.toString(sm/count));
			
			//If lists not finished, then proceed to next record
			if (i < yr.size()-1)
			{				
				current_year= Integer.parseInt(yr.get(i).toString());
				mx = Float.parseFloat(rain.get(i).toString());
				mn = Float.parseFloat(rain.get(i).toString());
			}
		}
		
		
		//Now Display Statistics
		System.out.println("Year\tMax\tMin\tAvg\n");
		for (i=0; i<=year.size()-1; i++)
		{
			System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
		}		
		
	}
	
	
	
public void sheffieldcsvSun(){
		
		String file = "raw/sheffielddata.csv";			//File name from where to get data
		BufferedReader br = null;		
		String line = "";
		String splitter = ",";				//comma character splitter for csv file
		String txtSplitter = " ";
		
		ArrayList yr = new ArrayList();		
		ArrayList sun = new ArrayList();
		
		//Loading data from csv file to arraylist objects
		try		
		{
			br = new BufferedReader(new FileReader(file));	
			while ((line = br.readLine()) != null)
			{
				String[] x = line.split(splitter);		//x stores all fields of the record read from the file
				yr.add(x[0]);
				sun.add(x[6]);				
			}
		}
		catch(FileNotFoundException e)					//Handling possible exceptions
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();	
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		
		//Loading Complete
		
		//Now Calculating Statistics (Max, Min and Avg)
		
		int current_year, i, count;
		float mx, mn, sm;
				
		for (i=1; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
		{			
			current_year= Integer.parseInt(yr.get(i).toString());			//setting year
			mx = Float.parseFloat(sun.get(i).toString());					//setting initial max value
			mn = Float.parseFloat(sun.get(i).toString());					//setting initial min value
			
			sm=Float.parseFloat(sun.get(i).toString());;						//setting initial value of sum
			count=1;														//setting initial value of count variable
			
			i++;	//Proceed to next record
			
			while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
			{
				if ( Float.parseFloat(sun.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
					mx = Float.parseFloat(sun.get(i).toString());
				if ( Float.parseFloat(sun.get(i).toString()) < mn)
					mn = Float.parseFloat(sun.get(i).toString());
				
				sm = sm + Float.parseFloat(sun.get(i).toString());			//adding current sun value to sum value
				count++;
				i++;
				
				if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
					break;
			}
			//Now saving this current_year, mx and mn to global variables year, max and min
			year.add(Integer.toString(current_year));						
			max.add(Float.toString(mx));
			min.add(Float.toString(mn));
			avg.add(Float.toString(sm/count));
			
			//If lists not finished, then proceed to next record
			if (i < yr.size()-1)
			{				
				current_year= Integer.parseInt(yr.get(i).toString());
				mx = Float.parseFloat(sun.get(i).toString());
				mn = Float.parseFloat(sun.get(i).toString());
			}
		}
		
		
		//Now Display Statistics
		System.out.println("Year\tMax\tMin\tAvg\n");
		for (i=0; i<=year.size()-1; i++)
		{
			System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
		}		
		
	}



public void bradfordTmax(){
	
	String file = "raw/bradfordata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmax = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(removeCharacters(x[0]));
			tmax.add(removeCharacters(x[2]));				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmax.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmax.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmax.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmax.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmax.get(i).toString());
			if ( Float.parseFloat(tmax.get(i).toString()) < mn)
				mn = Float.parseFloat(tmax.get(i).toString());
			
			sm = sm + Float.parseFloat(tmax.get(i).toString());			//adding current tmax value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmax.get(i).toString());
			mn = Float.parseFloat(tmax.get(i).toString());
		}
	}
}



public void bradfordTmin(){
	
	String file = "raw/bradforddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmin = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmin.add(x[3]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmin.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmin.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmin.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmin.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmin.get(i).toString());
			if ( Float.parseFloat(tmin.get(i).toString()) < mn)
				mn = Float.parseFloat(tmin.get(i).toString());
			
			sm = sm + Float.parseFloat(tmin.get(i).toString());			//adding current tmin value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmin.get(i).toString());
			mn = Float.parseFloat(tmin.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

	
public void bradfordAirForest(){
	String file = "raw/bradforddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList af = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			af.add(x[4]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(af.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(af.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(af.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(af.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(af.get(i).toString());
			if ( Float.parseFloat(af.get(i).toString()) < mn)
				mn = Float.parseFloat(af.get(i).toString());
			
			sm = sm + Float.parseFloat(af.get(i).toString());			//adding current af value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(af.get(i).toString());
			mn = Float.parseFloat(af.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}



public void bradfordRain(){
	
	String file = "raw/bradforddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList rain = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			rain.add(x[5]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(rain.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(rain.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(rain.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(rain.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(rain.get(i).toString());
			if ( Float.parseFloat(rain.get(i).toString()) < mn)
				mn = Float.parseFloat(rain.get(i).toString());
			
			sm = sm + Float.parseFloat(rain.get(i).toString());			//adding current rain value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(rain.get(i).toString());
			mn = Float.parseFloat(rain.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}



public void bradfordSun(){
	
	String file = "raw/bradforddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList sun = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			sun.add(x[6]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(sun.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(sun.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(sun.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(sun.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(sun.get(i).toString());
			if ( Float.parseFloat(sun.get(i).toString()) < mn)
				mn = Float.parseFloat(sun.get(i).toString());
			
			sm = sm + Float.parseFloat(sun.get(i).toString());			//adding current sun value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(sun.get(i).toString());
			mn = Float.parseFloat(sun.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
}
	
	

public void braemarTmax(){
	
	String file = "raw/braemardata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmax = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmax.add(x[2]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmax.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmax.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmax.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmax.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmax.get(i).toString());
			if ( Float.parseFloat(tmax.get(i).toString()) < mn)
				mn = Float.parseFloat(tmax.get(i).toString());
			
			sm = sm + Float.parseFloat(tmax.get(i).toString());			//adding current tmax value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmax.get(i).toString());
			mn = Float.parseFloat(tmax.get(i).toString());
		}
	}
}



public void braemarTmin(){
	
	String file = "raw/braemardata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmin = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmin.add(x[3]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmin.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmin.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmin.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmin.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmin.get(i).toString());
			if ( Float.parseFloat(tmin.get(i).toString()) < mn)
				mn = Float.parseFloat(tmin.get(i).toString());
			
			sm = sm + Float.parseFloat(tmin.get(i).toString());			//adding current tmin value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmin.get(i).toString());
			mn = Float.parseFloat(tmin.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

	
public void braemarAirForest(){
	String file = "raw/braemardata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList af = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			af.add(x[4]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(af.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(af.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(af.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(af.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(af.get(i).toString());
			if ( Float.parseFloat(af.get(i).toString()) < mn)
				mn = Float.parseFloat(af.get(i).toString());
			
			sm = sm + Float.parseFloat(af.get(i).toString());			//adding current af value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(af.get(i).toString());
			mn = Float.parseFloat(af.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}



public void braemarRain(){
	
	String file = "raw/braemardata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList rain = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			rain.add(x[5]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(rain.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(rain.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(rain.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(rain.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(rain.get(i).toString());
			if ( Float.parseFloat(rain.get(i).toString()) < mn)
				mn = Float.parseFloat(rain.get(i).toString());
			
			sm = sm + Float.parseFloat(rain.get(i).toString());			//adding current rain value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(rain.get(i).toString());
			mn = Float.parseFloat(rain.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

public void braemarSun(){
	
	String file = "raw/braemardata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList sun = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			sun.add(x[6]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(sun.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(sun.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(sun.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(sun.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(sun.get(i).toString());
			if ( Float.parseFloat(sun.get(i).toString()) < mn)
				mn = Float.parseFloat(sun.get(i).toString());
			
			sm = sm + Float.parseFloat(sun.get(i).toString());			//adding current sun value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(sun.get(i).toString());
			mn = Float.parseFloat(sun.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
}
	
	
	

public void camborneTmax(){
	
	String file = "raw/cambornedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmax = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmax.add(x[2]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmax.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmax.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmax.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmax.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmax.get(i).toString());
			if ( Float.parseFloat(tmax.get(i).toString()) < mn)
				mn = Float.parseFloat(tmax.get(i).toString());
			
			sm = sm + Float.parseFloat(tmax.get(i).toString());			//adding current tmax value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmax.get(i).toString());
			mn = Float.parseFloat(tmax.get(i).toString());
		}
	}
}



public void camborneTmin(){
	
	String file = "raw/cambornedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmin = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmin.add(x[3]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmin.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmin.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmin.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmin.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmin.get(i).toString());
			if ( Float.parseFloat(tmin.get(i).toString()) < mn)
				mn = Float.parseFloat(tmin.get(i).toString());
			
			sm = sm + Float.parseFloat(tmin.get(i).toString());			//adding current tmin value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmin.get(i).toString());
			mn = Float.parseFloat(tmin.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

	
public void camborneAirForest(){
	String file = "raw/cambornedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList af = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			af.add(x[4]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(af.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(af.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(af.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(af.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(af.get(i).toString());
			if ( Float.parseFloat(af.get(i).toString()) < mn)
				mn = Float.parseFloat(af.get(i).toString());
			
			sm = sm + Float.parseFloat(af.get(i).toString());			//adding current af value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(af.get(i).toString());
			mn = Float.parseFloat(af.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}



public void camborneRain(){
	
	String file = "raw/cambornedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList rain = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			rain.add(x[5]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(rain.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(rain.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(rain.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(rain.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(rain.get(i).toString());
			if ( Float.parseFloat(rain.get(i).toString()) < mn)
				mn = Float.parseFloat(rain.get(i).toString());
			
			sm = sm + Float.parseFloat(rain.get(i).toString());			//adding current rain value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(rain.get(i).toString());
			mn = Float.parseFloat(rain.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

public void camborneSun(){
	
	String file = "raw/cambornedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList sun = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			sun.add(x[6]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(sun.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(sun.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(sun.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(sun.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(sun.get(i).toString());
			if ( Float.parseFloat(sun.get(i).toString()) < mn)
				mn = Float.parseFloat(sun.get(i).toString());
			
			sm = sm + Float.parseFloat(sun.get(i).toString());			//adding current sun value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(sun.get(i).toString());
			mn = Float.parseFloat(sun.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
}
	
	


public void eastbourneTmax(){
	
	String file = "raw/eastbournedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmax = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmax.add(x[2]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmax.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmax.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmax.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmax.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmax.get(i).toString());
			if ( Float.parseFloat(tmax.get(i).toString()) < mn)
				mn = Float.parseFloat(tmax.get(i).toString());
			
			sm = sm + Float.parseFloat(tmax.get(i).toString());			//adding current tmax value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmax.get(i).toString());
			mn = Float.parseFloat(tmax.get(i).toString());
		}
	}
}



public void eastbourneTmin(){
	
	String file = "raw/eastbournedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmin = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmin.add(x[3]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmin.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmin.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmin.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmin.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmin.get(i).toString());
			if ( Float.parseFloat(tmin.get(i).toString()) < mn)
				mn = Float.parseFloat(tmin.get(i).toString());
			
			sm = sm + Float.parseFloat(tmin.get(i).toString());			//adding current tmin value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmin.get(i).toString());
			mn = Float.parseFloat(tmin.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

	
public void eastbourneAirForest(){
	String file = "raw/eastbournedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList af = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			af.add(x[4]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(af.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(af.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(af.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(af.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(af.get(i).toString());
			if ( Float.parseFloat(af.get(i).toString()) < mn)
				mn = Float.parseFloat(af.get(i).toString());
			
			sm = sm + Float.parseFloat(af.get(i).toString());			//adding current af value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(af.get(i).toString());
			mn = Float.parseFloat(af.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}



public void eastbourneRain(){
	
	String file = "raw/eastbournedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList rain = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			rain.add(x[5]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(rain.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(rain.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(rain.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(rain.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(rain.get(i).toString());
			if ( Float.parseFloat(rain.get(i).toString()) < mn)
				mn = Float.parseFloat(rain.get(i).toString());
			
			sm = sm + Float.parseFloat(rain.get(i).toString());			//adding current rain value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(rain.get(i).toString());
			mn = Float.parseFloat(rain.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

public void eastbourneSun(){
	
	String file = "raw/eastbournedata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList sun = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			sun.add(x[6]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(sun.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(sun.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(sun.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(sun.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(sun.get(i).toString());
			if ( Float.parseFloat(sun.get(i).toString()) < mn)
				mn = Float.parseFloat(sun.get(i).toString());
			
			sm = sm + Float.parseFloat(sun.get(i).toString());			//adding current sun value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(sun.get(i).toString());
			mn = Float.parseFloat(sun.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
}




public void sheffieldtxtTmax(){
	
	String file = "raw/sheffielddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmax = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmax.add(x[2]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmax.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmax.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmax.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmax.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmax.get(i).toString());
			if ( Float.parseFloat(tmax.get(i).toString()) < mn)
				mn = Float.parseFloat(tmax.get(i).toString());
			
			sm = sm + Float.parseFloat(tmax.get(i).toString());			//adding current tmax value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmax.get(i).toString());
			mn = Float.parseFloat(tmax.get(i).toString());
		}
	}
}



public void sheffieldtxtTmin(){
	
	String file = "raw/sheffielddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList tmin = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			tmin.add(x[3]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(tmin.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(tmin.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(tmin.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(tmin.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(tmin.get(i).toString());
			if ( Float.parseFloat(tmin.get(i).toString()) < mn)
				mn = Float.parseFloat(tmin.get(i).toString());
			
			sm = sm + Float.parseFloat(tmin.get(i).toString());			//adding current tmin value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(tmin.get(i).toString());
			mn = Float.parseFloat(tmin.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

	
public void sheffieldtxtAirForest(){
	String file = "raw/sheffielddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList af = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			af.add(x[4]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(af.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(af.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(af.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(af.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(af.get(i).toString());
			if ( Float.parseFloat(af.get(i).toString()) < mn)
				mn = Float.parseFloat(af.get(i).toString());
			
			sm = sm + Float.parseFloat(af.get(i).toString());			//adding current af value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(af.get(i).toString());
			mn = Float.parseFloat(af.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}



public void sheffieldtxtRain(){
	
	String file = "raw/sheffielddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList rain = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			rain.add(x[5]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(rain.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(rain.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(rain.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(rain.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(rain.get(i).toString());
			if ( Float.parseFloat(rain.get(i).toString()) < mn)
				mn = Float.parseFloat(rain.get(i).toString());
			
			sm = sm + Float.parseFloat(rain.get(i).toString());			//adding current rain value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(rain.get(i).toString());
			mn = Float.parseFloat(rain.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
	
}

public void sheffieldtxtSun(){
	
	String file = "raw/sheffielddata.txt";			//File name from where to get data
	BufferedReader br = null;		
	String line = "";
	String splitter = ",";				//comma character splitter for csv file
	String txtSplitter = " ";
	
	ArrayList yr = new ArrayList();		
	ArrayList sun = new ArrayList();
	
	//Loading data from csv file to arraylist objects
	try		
	{
		br = new BufferedReader(new FileReader(file));	
		while ((line = br.readLine()) != null)
		{
			String[] x = line.split(txtSplitter);		//x stores all fields of the record read from the file
			yr.add(x[0]);
			sun.add(x[6]);				
		}
	}
	catch(FileNotFoundException e)					//Handling possible exceptions
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (br != null)
		{
			try
			{
				br.close();	
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}			
	}
	
	//Loading Complete
	
	//Now Calculating Statistics (Max, Min and Avg)
	
	int current_year, i, count;
	float mx, mn, sm;
			
	for (i=7; i<=yr.size()-1;) //Starting from index no. 1, because index no. 0 is for heading
	{			
		current_year= Integer.parseInt(yr.get(i).toString());			//setting year
		mx = Float.parseFloat(sun.get(i).toString());					//setting initial max value
		mn = Float.parseFloat(sun.get(i).toString());					//setting initial min value
		
		sm=Float.parseFloat(sun.get(i).toString());;						//setting initial value of sum
		count=1;														//setting initial value of count variable
		
		i++;	//Proceed to next record
		
		while (Integer.parseInt(yr.get(i).toString()) == current_year)	//Whether next year read is the same year?
		{
			if ( Float.parseFloat(sun.get(i).toString()) > mx)			//if yes, then find out the updated maximum and minimum values
				mx = Float.parseFloat(sun.get(i).toString());
			if ( Float.parseFloat(sun.get(i).toString()) < mn)
				mn = Float.parseFloat(sun.get(i).toString());
			
			sm = sm + Float.parseFloat(sun.get(i).toString());			//adding current sun value to sum value
			count++;
			i++;
			
			if (i > yr.size()-1)										//is index crossed the upper bound? if yes, then break
				break;
		}
		//Now saving this current_year, mx and mn to global variables year, max and min
		year.add(Integer.toString(current_year));						
		max.add(Float.toString(mx));
		min.add(Float.toString(mn));
		avg.add(Float.toString(sm/count));
		
		//If lists not finished, then proceed to next record
		if (i < yr.size()-1)
		{				
			current_year= Integer.parseInt(yr.get(i).toString());
			mx = Float.parseFloat(sun.get(i).toString());
			mn = Float.parseFloat(sun.get(i).toString());
		}
	}
	
	
	//Now Display Statistics
	System.out.println("Year\tMax\tMin\tAvg\n");
	for (i=0; i<=year.size()-1; i++)
	{
		System.out.println(year.get(i).toString() + "\t" + max.get(i).toString() + "\t" + min.get(i).toString()  + "\t" + avg.get(i).toString());
	}		
}

	
	
	public void ChartTempMax()
	{
		add(new ChartTempMax(year, max, min, avg)); //Function responsible for creating chart
		
		//For Closing of Frame
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		setBackground(Color.pink);
		setTitle("Weather Analysis - Temperature Maximim");
		setSize(600, 600);
		
		setVisible(true);
	}
	
	
	public void ChartTempMin()
	{
		add(new ChartTempMin(year, max, min, avg));
		
		//For Closing of Frame
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		
		setBackground(Color.pink);
		setTitle("Weather Analysis - Temperature Minimum");
		setSize(600, 600);
		
		setVisible(true);
	}
	
	
	public void ChartAirForest()
	{
		add(new ChartAirForest(year, max, min, avg));
		
		//For Closing of Frame
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		
		setBackground(Color.pink);
		setTitle("Weather Analysis - Air Forest");
		setSize(600, 600);
		
		setVisible(true);
	}
	
	
	
	public void ChartRain()
	{
		add(new ChartRain(year, max, min, avg));
		
		//For Closing of Frame
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		
		setBackground(Color.pink);
		setTitle("Weather Analysis - Rainfall");
		setSize(600, 600);
		
		setVisible(true);
	}

	
	public void ChartSun()
	{
		add(new ChartSun(year, max, min, avg));
		
		//For Closing of Frame
		addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		
		setBackground(Color.pink);
		setTitle("Weather Analysis - Sun");
		setSize(600, 600);
		
		setVisible(true);
	}
	


		
	}
	
	

