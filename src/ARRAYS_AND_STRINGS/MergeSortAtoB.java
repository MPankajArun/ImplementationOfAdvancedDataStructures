/**
 * 
 */
package ARRAYS_AND_STRINGS;

/**
 * @author Dany
 *
 */
public class MergeSortAtoB {

	/**
	 * @param args
	 */
	static int count=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inArr={5,4,7,9,3,2};
		int[] auxArray=new int[inArr.length];
		auxArray=inArr;
		
		new MergeSortAtoB().mergeSort(inArr, auxArray, 0, inArr.length-1, 1);
		}
	
	public void mergeSort(int[] inputArr, int[] auxArray,int firstIndex, int lastIndex,int count)
	{
		if(firstIndex<lastIndex)
		{
			count++;
			int midIndex=(firstIndex+lastIndex)/2;
			mergeSort(inputArr, auxArray, firstIndex, midIndex, count);
			mergeSort(inputArr, auxArray, midIndex+1, lastIndex, count);
			
			if(((count&1)==1))
			{
				sortAndMerge(inputArr,auxArray, firstIndex,midIndex,lastIndex, count);
				
			}else
			{
				
				sortAndMerge(auxArray, inputArr, firstIndex,midIndex,lastIndex, count);
			}
			
			
		}
	}
	
	public void sortAndMerge(int[] inputArr, int[] auxArray, int firstIndex, int midIndex, int lastIndex, int count)
	{
	
		/*for(int i=firstIndex;i<=lastIndex;i++)
		{
			auxArray[i]=inputArr[i];
		}*/
		
		System.out.println("Aux array length : "+auxArray.length);
		
		int rightStartIndex=midIndex+1;
		int startIndex=firstIndex;
		int currentIndex=firstIndex;
		
		while((startIndex<=midIndex)&&(rightStartIndex<=lastIndex))
		{
			
			if(auxArray[startIndex]<=auxArray[rightStartIndex])
			{
				inputArr[currentIndex++]=auxArray[startIndex++];
				
			}
			else if(auxArray[startIndex]>auxArray[rightStartIndex])
			{
				inputArr[currentIndex++]=auxArray[rightStartIndex++];
				
			}
			}
		//To copy the other elements from the array
			while (startIndex <= midIndex) {
		      inputArr[currentIndex++] = auxArray[startIndex++];
		     
		    }
			
			//For Testing
		for(int j=0;j<inputArr.length;j++)
		{
		System.out.println("Sorted order:");
		System.out.println(inputArr[j]);
		System.out.println("Count :"+count);
		}
		
	}


}
