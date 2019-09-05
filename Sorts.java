//排序
import java.util.Arrays;
import java.util.Random;

public class Sorts {
    //插入排序
    public static void insertSortV1(int[] array){
        for(int i = 0;i < array.length;i++){
            //有序区间  [0,i]
            //无序区间  [i + 1,array.length)
            //待插入的数据是array[i+1]
            //插入过程在有序区间内查找

            int key = array[i+1];
            int j;
            for(j = i; j >= 0; j--){
                if(key >= array[j]){
                    break;
                }
            }
            //j + 1 放key的位置
            for(int k = i;k > j;k--){
                array[k + 1] =array[k];
            }
            array[j + 1] = key;
        }
    }
    public static void insertSort(int[] array){
        for(int i = 0;i < array.length;i++){
            //有序区间  [0,i]
            int key = array[i+1];
            int j;
            for(j = i; j >= 0 && key < array[j]; j--){
              array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
    private static void  insertSortWithGap(int[] array,int gap){
        for(int i = 0; i < array.length - gap;i++){
            int key = array[i + gap];
            int j;
            for(j = i; j >= 0 && key < array[j]; j -= gap){
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }
    //希尔排序
    public static void shellSort1(int[] array,int gap){
        for(int i = 0;i < array.length - gap ;i++){
            int key = array[i + gap];
            int j;
            for(j = i;j >= 0 && key < array[j]; j -= gap){
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }
    public  static void shellSort2(int[] array){
        int gap = array.length;
        while(true){
            gap = gap / 3 + 1;
            insertSortWithGap(array,gap);
            if(gap == 1){
                return;
            }
        }
    }
    public static int[] buildSortedArray(int n){
        int[] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i] = i;
        }
        return array;
    }
    public static int[] buildReversedSortedArray(int n){
        int[] array = new int[n];
        for(int i = 0;i < n;i++){
            array[i] = n - 1;
        }
        return array;
    }
    private static int[] buildRandomArray(int n){
        Random random = new Random(20190828);
        int[] array = new int[n];
        for(int i = 0; i < n;i++){
            array[i] = random.nextInt(n);
        }
        return array;
    }
    private static int[] buildEqualsArray(int n){
        int[] array = new int[n];
        for(int i = 0;i < n; i++){
            array[i] = n;
        }
        return array;
    }
    //选择排序
    public static void selectSort(int[] array){
    //每次选最大的数
        for(int i = 0;i < array.length - 1;i++){
            //无序区间  [0,array.length - i)
            //有序区间  [array.length - i, array.length]
            int max = 0;
            for(int j = 1;j < array.length - i;j++){
                if(array[j] >= array[max]){
                    max = j;
                }
            }
            //交换最大的数和无序区间的最后一个数
            swap(array,max,array.length - i - 1);
        }
    }
    private static void swap(int[] array,int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    //堆排
    public static void createHeap(int[] array,int size){
        /*int last = size - 1;
        while(true) {
            int lastparent = (last - 1) / 2;
            if (array[last] >= array[lastparent]) {
                swap(array, last, lastparent);
            }
            last = lastparent;
        }*/
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, size, i);
        }
    }
    public static void heapify(int[] array,int size,int index){
        while(true) {
            //判断是否为叶子
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }

            int max = left;
            if(left + 1 < size){
                if(array[left + 1] > array[left]){
                    max = left + 1;
                }
            }
            if(array[index] >= array[max]){
                return;
            }

            swap(array,index,max);

            index = max;
        }
    }
    public static void heapSort(int[] array){
       createHeap(array,array.length);
       for(int i = 0; i < array.length - 1;i++){
           //无序[0,array.length - i)
           swap(array,0,array.length - i - 1);
           //无序 [0,array.length - i - 1)
           //无序区间长度：array.length - i - 1
           heapify(array,array.length - i - 1,0);
       }
    }

    public static void main(String[] args) {
        //有序|无序|随机值|完全相等的
        int[] array;
        //array = buildReversedSortedArray(1000000);
        //array = buildSortedArray(1000000);
        array = buildRandomArray(10);
        //array = buildEqualsArray(10);
        System.out.println(Arrays.toString(array));
        long begin = System.nanoTime();//纳秒
        //insertSort(array);
        //shellSort(array);
        selectSort(array);
        long end = System.nanoTime();
        System.out.println(end - begin);
        System.out.println(Arrays.toString(array));
    }
}