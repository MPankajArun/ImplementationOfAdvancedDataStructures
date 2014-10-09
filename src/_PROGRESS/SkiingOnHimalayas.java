/**
 * 
 */
package _PROGRESS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.AllPermission;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hp
 *
 */
public class SkiingOnHimalayas {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		int[][] iPeaks=new int[5][5];
		iPeaks[0][0]=1;
		iPeaks[0][1]=2;
		iPeaks[0][2]=3;
		iPeaks[0][3]=4;
		iPeaks[0][4]=5;
		iPeaks[1][0]=16;
		iPeaks[1][1]=17;
		iPeaks[1][2]=18;
		iPeaks[1][3]=19;
		iPeaks[1][4]=6;
		iPeaks[2][0]=15;
		iPeaks[2][1]=24;
		iPeaks[2][2]=25;
		iPeaks[2][3]=20;
		iPeaks[2][4]=7;
		iPeaks[3][0]=14;
		iPeaks[3][1]=23;
		iPeaks[3][2]=22;
		iPeaks[3][3]=21;
		iPeaks[3][4]=8;
		iPeaks[4][0]=13;
		iPeaks[4][1]=12;
		iPeaks[4][2]=11;
		iPeaks[4][3]=10;
		iPeaks[4][4]=9;
	
	/*	
		int[][] iPeaks=new int[3][3];
		iPeaks[0][0]=5;
		iPeaks[0][1]=4;
		iPeaks[0][2]=7;
		iPeaks[1][0]=9;
		iPeaks[1][1]=3;
		iPeaks[1][2]=8;
		iPeaks[2][0]=2;
		iPeaks[2][1]=4;
		iPeaks[2][2]=6;	
		*/		
		
		System.out.println("Starts");			
		
		new SkiingOnHimalayas().processInAndOutFile("/users/dany/downloads/input.txt", "/users/dany/downloads/outputTest.txt");
				
		
		//int res=new SkiingOnHimalayas().findMaxPeakCounts(iPeaks);
		//System.out.println("Maximun count: "+res);
		/*
		for(int i=0;i<iPeaks.length;i++)
		{
			for(int j=0;j<iPeaks[0].length;j++)
			{
				int res=new SkiingOnHimalayas().findMaxSkiing1(iPeaks, i, j, 0, 0);				
				System.out.println("Maximun count: "+res);
				mMaxHeight.put(iPeaks[i][j], res);
			}
		}
		
		for(int res:mMaxHeight.keySet())
		{
		System.out.println("MAX COUNT FINAL FOR "+res+" VALUE "+mMaxHeight.get(res));
		}
		*/
		
	}
	

	public void processInAndOutFile(String inFile, String outFile) throws FileNotFoundException
	{
		File infile=new File(inFile);
		File outPutFile = new File(outFile);        
        PrintWriter pwInput = new PrintWriter(outPutFile);
        int nTotal=0;
        String outLineTotal="";
        
		try{
			Scanner scanner=new Scanner(infile);
			while(scanner.hasNext())
			{
				String sName="";
				if(!(Character.isDigit((sName=scanner.next()).charAt(0))))
				{
					System.out.println("Peak name : "+sName);
					int rowlen=scanner.nextInt();
					int colLen=scanner.nextInt();
					
					nTotal=nTotal+(rowlen*colLen);
					System.out.println("row "+rowlen+" col "+colLen);
					
					int[][] inpuArr=new int[rowlen][colLen];
					for(int i=0;i<rowlen;i++)
					{
						for(int j=0;j<colLen;j++)
						{
							inpuArr[i][j]=scanner.nextInt();
							System.out.println("Input Value : "+inpuArr[i][j]);
						}
					}
					int maxCount=new SkiingOnHimalayas().findMaxPeakCounts(inpuArr);
					String outLine=sName+": "+maxCount;
					outLineTotal="Total elements tested : "+nTotal;
					
					pwInput.println(outLine);		        
					
				}
			}
			pwInput.println(outLineTotal);
			pwInput.close();
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
	}
	
	//This is for all elements in the array
	public int findMaxPeakCounts(int[][] iPeaks)
	{
		int maxCount=0;
	
		for(int i=0;i<iPeaks.length;i++)
		{
			for(int j=0;j<iPeaks[0].length;j++)
			{
				int res=new SkiingOnHimalayas().findMaxSkiing1(iPeaks, i, j, 0, 0);
				if(res>maxCount)
					maxCount=res;
			}
		}
		return maxCount;
	}
	
	//This is for each element's left, right, top, bottom 
	public int findMaxSkiing1(int[][] iPeaks, int i, int j, int count, int maxCount)
	{
		System.out.println("Present Value: "+iPeaks[i][j]);
		System.out.println("Find error i value: "+i+" j value: "+j+" Count: "+count+" max Count: "+maxCount);
		int rowLen=iPeaks.length;
		int colLen=iPeaks[0].length;
		if(!((i>=0)&&(i<rowLen)&&(j>=0)&&(j<colLen)))
		{
			return 0;
		}		
		count++;
		//left traversal
		if(j-1>=0)
		{
			
		if((j>=0)&&(j<colLen)&&(iPeaks[i][j]>iPeaks[i][j-1]))
		{
			System.out.println("Inside left");
			//count++;			
			int leftCount= findMaxSkiing1(iPeaks, i, j-1, count, maxCount);
			
			if(leftCount>maxCount)
			{
				maxCount=leftCount;
				
			}
			//count=0;
		}
		}
		//right traversal
		if(j+1<colLen)
		{
			
		if((j>=0)&&(j<colLen)&&(iPeaks[i][j]>iPeaks[i][j+1]))
		{
			System.out.println("Inside right");
			//count++;			
			int rightCount= findMaxSkiing1(iPeaks, i, j+1, count, maxCount);
			if(rightCount>maxCount)
			{
				maxCount=rightCount;
			
			}
			//count=0;
			
		}
		}
		//top traversal
		if(i-1>=0)
		{
			
		if((i>=0)&&(i<rowLen)&&(iPeaks[i][j]>iPeaks[i-1][j]))
		{
			System.out.println("Inside top");
			//count++;			
			int topCount= findMaxSkiing1(iPeaks, i-1, j, count, maxCount);
			if(topCount>maxCount)
			{
				maxCount=topCount;
				
			}
			//count=0;
			
		}
		}
		//bottom traversal
		if(i+1<rowLen)
		{
			
		if((i>=0)&&(i<rowLen)&&(iPeaks[i][j]>iPeaks[i+1][j]))
		{
			System.out.println("Inside bottom");
			//count++;		
			int bottomCount= findMaxSkiing1(iPeaks, i+1, j, count, maxCount);
			if(bottomCount>maxCount)
			{
				maxCount=bottomCount;
				
			}	
			//count=0;
			
			}
		}
		//count++;
		if(count>maxCount)
		maxCount=count;
		count=0;	
		
		return maxCount;
	}
	
}
