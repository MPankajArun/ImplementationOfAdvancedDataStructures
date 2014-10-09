/**
 * 
 */
package ARRAYS_AND_STRINGS;

/**
 * @author Dinesh
 *
 */
public class MatrixMakeZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=new int[2][2];
		arr[0][0]=2;
		arr[0][1]=0;
		arr[1][0]=4;
		arr[1][1]=5;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.println("Result Arr "+ i +"   "+j+ "  "+arr[i][j]);
			}
		}
		
		int[][] res=new MatrixMakeZero().makeZero(arr);
		for(int i=0;i<res.length;i++)
		{
			for(int j=0;j<res[0].length;j++)
			{
				System.out.println("Result Res"+ i +"   "+j+ "  "+res[i][j]);
			}
		}
	

	}
	
	
	public int[][] makeZero(int[][] arr)
	{
		int rowLen=arr.length;
		int colLen=arr[0].length;
		boolean[] row=new boolean[rowLen];
		boolean[] col=new boolean[colLen];
		
		for(int i=0;i<rowLen;i++)
		{
			for(int j=0;j<colLen;j++)
			{
				if(arr[i][j]==0)
				{
					row[i]=true;
					col[j]=true;
				}
			}
		}
		for(int i=0;i<rowLen;i++)
		{
			for(int j=0;j<colLen;j++)
			{
				if(row[i]||col[j])
				{
					arr[i][j]=0;
				}
			}
		}
		return arr;
		
	}
}
