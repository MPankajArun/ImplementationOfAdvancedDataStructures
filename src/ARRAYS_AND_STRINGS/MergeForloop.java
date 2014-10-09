/**
 * 
 */
package ARRAYS_AND_STRINGS;

/**
 * @author Dany
 *
 */
public class MergeForloop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] inArr={1,11,12,2,8,9};
		int[] inArr={5,4,7,9,3,2};
		int[] auxArray=new int[inArr.length];
		new MergeForloop().mergeSort(inArr, auxArray, 0, inArr.length-1);
		
		
		
	}
	
	public void mergeSort(int[] inputArr, int[] auxArray,int firstIndex, int lastIndex)
	{
		if(firstIndex<lastIndex)
		{
			int midIndex=(firstIndex+lastIndex)/2;
			mergeSort(inputArr, auxArray, firstIndex, midIndex);
			mergeSort(inputArr, auxArray, midIndex+1, lastIndex);
			sortAndMerge(inputArr,auxArray, firstIndex,midIndex,lastIndex);
		}
	}
	
	public void sortAndMerge(int[] inputArr, int[] auxArray, int firstIndex, int midIndex, int lastIndex)
	{
		for(int i=firstIndex;i<=lastIndex;i++)
		{
			auxArray[i]=inputArr[i];
		}
		
		System.out.println("Aux array length : "+auxArray.length);
		
		int rightStartIndex=midIndex+1;
		int startIndex=firstIndex;
		int currentIndex=firstIndex;
		
		
		
		while((startIndex<=midIndex)&&(rightStartIndex<=lastIndex))
		{
			
			if(auxArray[startIndex]<=auxArray[rightStartIndex])
			{
				System.out.println("Left : "+inputArr[startIndex]);
				inputArr[currentIndex++]=auxArray[startIndex++];
				
			}
			else if(auxArray[startIndex]>auxArray[rightStartIndex])
			{
				System.out.println("Right : "+auxArray[rightStartIndex]);
				inputArr[currentIndex++]=auxArray[rightStartIndex++];
			}
		 }
			
		
		
		
		
		/*for(int m=startIndex;m<=midIndex;m++)
		{
			for(int n=rightStartIndex;n<=lastIndex;n++)
			{
				if(auxArray[m]<=auxArray[n])
				{
					System.out.println("Left : "+inputArr[m]);
					inputArr[currentIndex++]=auxArray[m];
					//rightStartIndex=n+1;
					break;
				}
	    	else if(auxArray[m]>auxArray[n])
				{
	    		System.out.println("m n value :"+auxArray[m]+"  "+auxArray[m+1]);
					System.out.println("Right : "+auxArray[n]);
					inputArr[currentIndex++]=auxArray[n];
					rightStartIndex=n+1;
					startIndex=m--;
				    break;
						
			    }
				}
			
			}
		*/
		if(startIndex!=midIndex)
		{
		for(int p=startIndex;p<=midIndex;p++)
		{
			inputArr[currentIndex++]=auxArray[p];
		}
		}
		if(rightStartIndex!=lastIndex)
		{
			for(int q=rightStartIndex;q<=lastIndex;q++)
			{
				inputArr[currentIndex++]=auxArray[q];
			}
		}
				
		
		
		
		
		
		
	    	/*	if((n==lastIndex)&&(m!=midIndex))
				{
				System.out.println("last m : "+auxArray[m]);
				inputArr[currentIndex++]=auxArray[m];
				startIndex=m+2;
				break;
				}
		*/
		
		
		
	
		System.out.println("Test");
		
		//For Testing
		for(int j=0;j<inputArr.length;j++)
		{
		System.out.println("Sorted order:");
		System.out.println(inputArr[j]);
		}
		
	}


}
