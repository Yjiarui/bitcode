public class Java0519{
	public static int max(int[] array){
		int maxValue=0;
		//for(int item:array)
		for(int i=0;i<array.length;i++)
		{
			if(array[i]>maxValue)
				maxValue=array[i];
		}
		return maxValue;
	} 
	public static int indexOf(int[] array,int key){
		for(int i=0;i<array.length;i++){
			if(key==array[i]){
				return i;
		    }
		}
		return -1;
	}
	public static double average(int[] scores){
		int maxScore=scores[0];
		int minScore=scores[0];
		int average=0;
		for(int i=1;i<scores.length;i++)
		{
			average+=scores.length;
			if(scores[i]>maxScore)
			{
				maxScore=scores[i];
			}
			else if(scores[i]<minScore)
			{
				minScore=scores[i];
			}
		}
		return average;
	}
public static void main(String[] args){
	int[] array={1,2,3,4,5,6,7};
	
	int maxValue=max(array);
	System.out.println("最大值是 "+ maxValue);
	
	int index=indexOf(array,5);
	System.out.println("5的下标是 "+ index);
	
	double averageScore=average(array);
	System.out.println("平均分是 "+ averageScore);
  }
}
