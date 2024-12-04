import java.util.ArrayList;

//练习排序，插入排序Insertion，选择排序Selection，冒泡排序Bubble，归并排序Merge，快速排序Quick。五个排序都要背下来
//注意，除了快速排序之外的其他排序都是两层循环，归并排序用递归作为第二层循环。
//插入、冒泡、选择的时间复杂度是一样的，归并和快速会快一些
public class Unit11 {
    int[] searchList1 = new int[10]; //先从10个开始学习，然后用100w个排序，看一下时间
    int[] searchList2 = new int[10]; //复制一个数组，用来对比排序速度用

    public void doSearch(){
        initList();
    }

    //把查询列表灌随机数
    private void initList(){
        for (int i = 0; i < searchList1.length; i++) {
             searchList1[i] = ((int)(Math.random() * 11)); //给一个1-10之间的随机数，后面如果加大数组，再加范围
        }
    }

    //选择排序  书的第7.8章节
    //从未排序的部分中，把最小值找出来，循环直到末尾
    //速度不快,复杂度O(n^2)，容易理解。
    private void selectionSort(int[] list){
        int minIndex; //最小值的位置
        int temp; //用来存放临时值

        for (int i = 0; i < list.length - 1; i++) { //第一层循环全部
            minIndex = i;
            for (int j = i + 1; j < list.length; j++) {  //第二层从前往后逐个筛选
                if (list[j] < list[minIndex]) { //不断找，直到在未排序的部分中，找到最小值
                    minIndex = j;
                }
            }
            temp = list[minIndex]; //把找到的最小值和当前位置互换一下
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }


    //Insertion Sort插入排序，第23.2章节
    //和抓扑克牌一一样，把数组，从前往后，逐个插入到一个已经排好序的list中。
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

        }
    }

}
