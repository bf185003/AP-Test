import java.util.ArrayList;
import java.util.Arrays;

//练习排序，选择排序Selection，插入排序Insertion，冒泡排序Bubble，归并排序Merge，快速排序Quick。五个排序都要背下来
//注意，除了快速排序之外的其他排序都是两层循环，归并排序和快速排序用递归作为第二层循环。
//插入、冒泡、选择的时间复杂度是一样的，最坏情况复杂度是O(n^2)
//归并和快速会快一些,复杂度O（n log n），快速排序就不讲了，AP不考。
//分两次课教，第一节课做一个时钟，教前两个排序，第二课教后两个排序
public class Unit11 {
    int[] searchlist0 = {2,9,5,4,8,1,6,7}; //用来测试排序用的
    int[] searchList1 = new int[10]; //先从10个开始学习，然后用10w，20w，30w，50w，100w个排序，看一下时间
    int[] searchList2 = new int[10]; //复制一个数组，用来对比排序速度用

    public void doSearch(){
        selectionSort(searchlist0); //可以先用测试数组用来学习各种排序算法

        //下面用来比速度
        initList();
        searchList2 = searchList1.clone(); //直接复制第一个数组，用来给第二个排序用
    }

    //把查询列表灌随机数
    private void initList(){
        for (int i = 0; i < searchList1.length; i++) {
             searchList1[i] = ((int)(Math.random() * 11)); //给一个1-10之间的随机数，后面如果加大数组，再加范围
        }
    }

    //把样例的Array打印出来
    private void printArray(){
        for(int i:searchlist0) {
           System.out.print(" " + i);
        }
        System.out.println();
    }

    //选择排序  书的第7.11章节
    //从未排序的部分中，把最小值找出来，循环直到末尾。时间复杂度是O(n^2)
    //速度不快,复杂度O(n^2)，容易理解。
    private void selectionSort(int[] list){
        int minIndex; //最小值的位置
        int temp; //用来存放临时值

        for (int i = 0; i < list.length - 1; i++) { //第一层循环全部
            minIndex = i;
            for (int j = i + 1; j < list.length; j++) {  //第二层从前往后逐个筛选
                if (list[j] < list[minIndex]) { //每次把比当前小的index取出来，直到在未排序的部分中，找到最小值
                    minIndex = j;
                }
            }
            temp = list[minIndex]; //把找到的最小值和当前位置互换一下，这三句是两个值互换。
            list[minIndex] = list[i];
            list[i] = temp;
            printArray();
        }
    }


    //Insertion Sort插入排序，第23.2章节
    //和抓扑克牌一一样，把数组，从前往后，逐个插入到一个已经排好序的list中。时间复杂度是O(n^2)
    //速度不快,复杂度O(n^2)，但是非常简单，容易理解
    private void insertionSort(int[] list){
        int currentElement;
        int j;

        for (int i = 1; i < list.length; i++) { //第一层，注意i是从1开始，表示从第二个元素开始和第一个元素比。
            currentElement = list[i]; // 一开始这是第二个元素，后面是往后的逐个的元素
            j = i - 1;

            while (j >= 0 && list[j] > currentElement) { //第二层，这块是要点，倒着循环查找，只要当前值比数组小，就往前挪一位
                list[j + 1] = list[j]; // 把当前位置往前挪一个
                j--;
            }

            list[j + 1] = currentElement; //都比完了，空出一个位置，放到这里，注意这里的j比上面的j的最后一次要小1的。
            printArray();
        }
    }

    //冒泡排序
    //每一轮从头把最大值互相交换，直至推到最后，每一轮少推一位。时间复杂度是O(n^2)
    //相当于每次把最大值像气泡一样逐步冒到顶部。因此得名。
    private void bubbleSort(int[] list){
        boolean swapped = true;
        int temp;

        for (int i = 1; i < list.length  && swapped; i++) { //外层循环，注意，这里也是从1开始
            swapped = false;                                // 如果这一轮从来没有交换过，swapped = false，则证明list已经排好序，不需要再循环了。

            for (int j = 0; j < list.length - i ; j++) {    //内层循环，注意这里每次循环少最后一位。
                if (list[j] > list[j + 1]) { //只要前后两个值大小相反，就互换
                    temp = list[j];         //下面3句是互换
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;     //true表示本轮交换过，证明list还没排好序
                }
            }
            printArray();
        }
    }

    //优点：1:稳定排序算法，适用于链表排序。2:时间复杂度稳定，适用于大数据集。
    //缺点：1:需要额外的空间，空间复杂度较高。2:数组较小时，性能不如简单排序（如插入排序）。
    public void mergeSort(int[] list){
        if (list == null || list.length <= 1){ //空数组，或只有一个数组，不需要排序，注意，只有归并排序有这个，因为这是递归退出条件。
            return;
        }

        int middle = list.length / 2;
        int[] left = Arrays.copyOfRange(list, 0, middle);
        int[] right = Arrays.copyOfRange(list, middle, list.length);

        mergeSort(left); //注意这里是递归，拆左边的数组，直到1个元素。
        mergeSort(right); //这是拆右边的数组，直到1个元素

        //下面打印的语句在pk速度时候去掉。
        System.out.print(" list length " + list.length + " . "); //注意这里递归到最后的list不是开始的list，是left或right

        merge(list,left,right);
    }

    //这个是将两个排序好的array，合并到最后的list中
    private void merge(int[] list, int[] left, int[] right){
        int i = 0, j = 0, k = 0;

        // 比较左右数组的元素，按顺序合并到 arr 中
        while (i < left.length && j < right.length) {  //把任何一个数组遍历完即可
            if (left[i] <= right[j]) {  //left的较小
                list[k++] = left[i++];  //那就把left的放入list，并且left ++ 一位
            } else {
                list[k++] = right[j++]; //right的较小，把right的放入list，并且right ++ 一位
            }
        }

        // 将某个数组比剩余元素放入 list 中
        while (i < left.length) {
            list[k++] = left[i++];
        }
        while (j < right.length) {
            list[k++] = right[j++];
        }


        //下面打印的语句在pk速度时候去掉。
        for (int l = 0; l < list.length; l++) { //把排序后的打出来
            System.out.print(" " + list[l]);
        }
        System.out.println();
    }


    //介绍快速排序，快速排序和归并排序虽然都是分治法（Divide and Conquer）的典型应用，但两者在实现和性能特点上存在较大区别。
    //快速排序：先分区，再排序。在分区时就已经将数组拆分成左右两部分，左侧小于基准，右侧大于基准。每次分区都会改变原数组的顺序。
    //归并排序：先排序，再合并。先将数组拆分成小的子数组，分别排序，最后合并时将有序子数组归并成一个完整的有序数组。分割时并不改变原数组的顺序，合并时才做调整。


}
