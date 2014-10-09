/**
 * 
 */
package PROJECT_1;

/**
 * @author Dany
 *
 */
public class MergeSortAuxilary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inArr={5,4,7,9,3,2,45,3,454,66,564,54,767,3434,7675354,67564,546,5,4545,57,55,345,7547,657,6765,7,56765375,76,777,87,87,87,876,86786};
		int[] auxArray=new int[inArr.length];
		new MergeSortAuxilary().mergeSort(inArr, auxArray, 0, inArr.length-1);
		//For Testing
		for(int j=0;j<inArr.length;j++)
		{
			System.out.print(" "+inArr[j]);
		}
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
			
		
	}


}
