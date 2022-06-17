import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class ChartRain extends Canvas{
	
	

	//array lists for storing data
	ArrayList gYears = new ArrayList();
	ArrayList gMax = new ArrayList();
	ArrayList gMin = new ArrayList();
	ArrayList gAvg = new ArrayList();
	
	
	//Constructor for getting data
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public ChartRain(ArrayList yr, ArrayList mx, ArrayList mn, ArrayList av)
	{
		this.gYears = yr;
		this.gMax = mx;
		this.gMin = mn;
		this.gAvg = av;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 * 
	 */
	
	
	public void paint(Graphics g)
	{
		
		//A 400 x 400 Chart Area
		
		//Scaling Lines
		//Getting minimum and maximum year and Rain(MM) values
		int mxYear, mnYear, i;
		float mxRain, mnRain, mxMax, mnMax;
		mxYear = Integer.parseInt(gYears.get(0).toString());	//setting initial value of maxYear
		mnYear = Integer.parseInt(gYears.get(0).toString());	//setting initial value of minYear
		
		mxRain = Float.parseFloat(gMax.get(0).toString());		//setting initial value of maxRainInMM
		mnRain = Float.parseFloat(gMin.get(0).toString());		//setting initial value of minRainInMM
		
		mxMax = Float.parseFloat(gMax.get(0).toString());
		mnMax = Float.parseFloat(gMax.get(0).toString());	
		
		
		//Now comparing the initial values of maxYar, minYear, maxMM and minMM with rest of the records
		for (i=1; i<=gYears.size()-1; i++)
		{
			if ( Integer.parseInt(gYears.get(i).toString()) > mxYear )
				mxYear = Integer.parseInt(gYears.get(i).toString());
			if ( Integer.parseInt(gYears.get(i).toString()) < mnYear )
				mnYear = Integer.parseInt(gYears.get(i).toString());
			
			if ( Float.parseFloat(gMax.get(i).toString()) > mxRain )
				mxRain = Float.parseFloat(gMax.get(i).toString());			
			if ( Float.parseFloat(gMin.get(i).toString()) < mnRain )
				mnRain = Float.parseFloat(gMin.get(i).toString());
			
			if ( Float.parseFloat(gMax.get(i).toString()) > mxMax )
				mxMax = Float.parseFloat(gMax.get(i).toString());
			if ( Float.parseFloat(gMax.get(i).toString()) > mnMax )
				mnMax = Float.parseFloat(gMax.get(i).toString());	
		}
		
		//Printing Chart Title
		g.drawString("Weather Analysis", 250, 20);
		
		//Printing Legend
		g.drawString("Key: Green=Maximum Values, Blue=Average Values, Red=Minimum Values", 100, 40);
		
		//Now Drawing Year Scale Line
		g.setColor(Color.black);
		g.drawLine(100, 500, 500, 500);
		g.drawString("Years", 250, 540);
		//Drawing Year Scale 
		float stepX, startX=100;	//stepX for horizontal axis step, startX for pixel no. from where to start drawing
		int j;
		stepX = (float)400.0 / (mxYear - mnYear);		//calculating stepX
		for (i=mnYear, j=1; i<=mxYear; i++, j++)
		{
			if ( j%15 == 0 )							//Drawing horizontal axis line at suitable distance
			{
				g.drawLine((int)startX, 495, (int)startX, 505);
				g.drawString(Integer.toString(i), (int)startX-15, 520);
			}
			startX = startX + stepX;
		}
		
		
		//Now Drawing Rain(mm) Scale Line
		g.drawLine(100,  500,  100,  100);
		g.drawString("Rain(mm)", 10, 300);
		//Drawing Rain(mm) Scale 
		float stepY, startY=500;
		stepY = 400 / (mxRain - mnRain);
		for (i=(int)mnRain, j=1; i<=mxRain; i++, j++)
		{
			if ( j%15==0 )
			{
				g.drawLine(95, (int)startY, 105, (int)startY);
				g.drawString(Integer.toString(i), 70, (int)startY+5);
			}			
			startY = startY - stepY;
		}
		
		//Scales Drawing Complete
		
		//Now Plotting the Values of Maximum Values
		int cx; 		//Current X
		float cy; 		//Current Y
		int px, py;		//Current Point
		int npx, npy;	//New Point
		
		//Loading first point
		cx = Integer.parseInt(gYears.get(0).toString());
		cy = Float.parseFloat(gMax.get(0).toString());
		
		px = ((cx-mnYear)*(int)stepX)+100;
		py = 500 - (int)((cy-mnRain)*stepY);
		
		g.setColor(Color.green);
		for (i=1; i<=gYears.size()-1; i++)
		{			
			cx = Integer.parseInt(gYears.get(i).toString());		//Getting Next (New) Point
			cy = Float.parseFloat(gMax.get(i).toString());
			
			npx = ((cx-mnYear)*(int)stepX)+100;
			npy = 500 - (int)((cy-mnRain)*stepY);
			
			//Now drawing line from current point to new point
			g.drawLine(px, py, npx, npy);
			
			//Now assigning new point to current point
			px = npx;
			py = npy;			
		}
		
		//Now Plotting the Values of Minimum Values
	
		//Loading first point
		cx = Integer.parseInt(gYears.get(0).toString());
		cy = Float.parseFloat(gMin.get(0).toString());
		
		px = ((cx-mnYear)*(int)stepX)+100;
		py = 500 - (int)((cy-mnRain)*stepY);
		
		g.setColor(Color.red);
		for (i=1; i<=gYears.size()-1; i++)
		{			
			cx = Integer.parseInt(gYears.get(i).toString());
			cy = Float.parseFloat(gMin.get(i).toString());
			
			npx = ((cx-mnYear)*(int)stepX)+100;
			npy = 500 - (int)((cy-mnRain)*stepY);
			
			//Now drawing line from current point to new point
			g.drawLine(px, py, npx, npy);
			
			//Now assigning new point to current point
			px = npx;
			py = npy;			
		}
		
		//Now Plotting the Values of Average Values
		
		//Loading first point
		cx = Integer.parseInt(gYears.get(0).toString());
		cy = Float.parseFloat(gAvg.get(0).toString());
		
		px = ((cx-mnYear)*(int)stepX)+100;
		py = 500 - (int)((cy-mnRain)*stepY);
		
		g.setColor(Color.blue);
		for (i=1; i<=gYears.size()-1; i++)
		{			
			cx = Integer.parseInt(gYears.get(i).toString());
			cy = Float.parseFloat(gAvg.get(i).toString());
			
			npx = ((cx-mnYear)*(int)stepX)+100;
			npy = 500 - (int)((cy-mnRain)*stepY);
			
			//Now drawing line from current point to new point
			g.drawLine(px, py, npx, npy);
			
			//Now assigning new point to current point
			px = npx;
			py = npy;			
		}		
		

	}
	
	
}
