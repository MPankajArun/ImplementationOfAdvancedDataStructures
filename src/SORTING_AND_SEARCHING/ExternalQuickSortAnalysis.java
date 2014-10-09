/**
 * 
 */
package SORTING_AND_SEARCHING;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import ARRAYS_AND_STRINGS.MergeSortAnalysis;

/**
 * @author Dany
 *
 */
public class ExternalQuickSortAnalysis {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new ExternalQuickSortAnalysis().processInOutFile("/users/dany/downloads/input131072.txt", "/users/dany/downloads/mergesort_outputinput131072.txt");
	}
	
	public void processInOutFile(String inFile, String outFile) throws FileNotFoundException
	{
		File infile=new File(inFile);
		File outPutFile = new File(outFile);   
		File outPutTemp1 = new File("/users/dany/documents/Fall_2013_Courses/Imp_Data_structures/Source_Code/input/temp-file-1");
		PrintWriter pwInput = new PrintWriter(outPutTemp1);
		String tempFileAppender="";
        
		try{
			Scanner scanner=new Scanner(infile);
			int arrSize=scanner.nextInt();
			int[] inpuArr=new int[arrSize];
			int[] auxArray=new int[arrSize];
			int sortedBegin,sortedEnd;
			while(scanner.hasNext())
			{
					inpuArr=new int[arrSize];
					for(int j=0;j<arrSize;j++)
						{
							inpuArr[j]=scanner.nextInt();
							//System.out.println("Array : "+inpuArr[j]);
						}
					long inTime=System.currentTimeMillis();
					//new MergeSort().mergeSort(inpuArr, 0, inpuArr.length-1);
					//new MergeSortAuxilary().mergeSort(inpuArr, auxArray, 0, inpuArr.length-1);
					//mergeSortAlternateMerge.mergeSort(inpuArr, auxArray, 0, inpuArr.length-1);
					new QuickSort().quickSort(inpuArr, 0, inpuArr.length-1);
					sortedBegin=inpuArr[0];
					sortedEnd=inpuArr[inpuArr.length-1];
					if((file1StartRange<=sortedBegin))
					{
						
					}
					for(int p=0;p<inpuArr.length;p++)
					{
					pwInput.println(inpuArr[p]);
					}
					long pTime=System.currentTimeMillis();
					String outLine="Time in Secs "+(pTime-inTime);
					pwInput.println(outLine);		        
			}
			
			pwInput.close();
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
	}

}
