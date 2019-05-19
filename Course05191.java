public class Course05191{
public static int binarySearch(int[] array,int key)//二分查找 index指下标
  {
	int left=0;
	int right=array.length;
	int mid=left+(right-left)/2;//防止越界 不能使用（left+right）/2  可能会溢出
	while(left<right)
	{
       if(key==array[mid])     	
	  {
		return mid;
   	  }
	  else if(key<array[mid])
	  {
		right=mid;
	  }
	  else if(key>array[mid])
	  {
	    left=mid+1;
	  }
	}
	return -1;
  }
  //交换array数组的i和j下标位置的数
  public static void  swap(int[] array,int i,int j){
	  int t=array[i];
	  array[i]=array[j];
	  array[j]=t;
  }
  //冒泡排序
  public static  void bubbleSort(int[] array){
	  
	  for(int i=0;i<array.length;i++)
	  {
		  boolean isSwapped=false;
		 
		for(int j=0;j<array.length-i-1;j+=2)
			  {
				  if(array[j]>array[j+1]){
					  swap(array,j,j+1);
					  isSwapped=true;
			  }
		  }
	  }
  }
public static void main(String[] args){
	int[] array={1,2,3,4,5,6,7,8};
	
	int index2=binarySearch(array,5);
	System.out.println("下标是 "+ index2);
	
	int[] array1=new int[]{2,3,1,4,5,8,6,7};
	bubbleSort(array1);
	System.out.println(array1);
  }
}