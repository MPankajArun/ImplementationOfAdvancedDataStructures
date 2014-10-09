/**
 * 
 */
package PROJECT_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import SORTING_AND_SEARCHING.QuickSort;

/**
 * @author Dany
 *
 */
public class MergeSortAnalysis {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		new MergeSortAnalysis().processInAndOutFile("/users/dany/downloads/input131072.txt", "/users/dany/downloads/mergesort_outputinput131072.txt");
	}
	
	public void processInAndOutFile(String inFile, String outFile) throws FileNotFoundException
	{
		File infile=new File(inFile);
		File outPutFile = new File(outFile);        
        PrintWriter pwInput = new PrintWriter(outPutFile);
        
		try{
			Scanner scanner=new Scanner(infile);
			int arrSize=scanner.nextInt();
			int[] inpuArr=new int[arrSize];
			int[] auxArray=new int[arrSize];
			while(scanner.hasNext())
			{
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
