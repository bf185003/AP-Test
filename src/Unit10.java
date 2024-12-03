import java.util.Arrays;

//recursive递归和排序
public class Unit10 {
    private int[] searchList = new int[1000]; //1000个int数组，用来做递归折半查找用

    public void doUnit() {

        System.out.println(factorial(10)); // 10的阶乘
        System.out.println(Fibonacci(10));//斐波那契数列，10代

        //练习递归折半查找，先做一个数组。
        for (int i = 0; i < searchList.length; i++) {//遍历数组
            searchList[i] = 1 + (int) (Math.random() * 1000); //给一个1-1000之间的随机数
        }
        Arrays.sort(searchList);//给他排序，这里是内置好的排序算法。所有的数组必须是先排序才能查找。

        System.out.println(recursiveBinarySearch(searchList, 456, 0, searchList.length - 1)); //查找456
    }

    //recursive method 递归函数1：阶乘
    //递归2个注意事项
    //1:是函数自己调用自己才叫递归。
    //2:必须要有退出机制，否则死循环了。
    //递归和循环类似，但递归代码比较简洁，但是难以理解。
    //另外，递归能做树和图的遍历
    public long factorial(int n) {
        if (n == 0) {
            return 1; //注意这里就是退出机制，就是递归的最后一个值，要考虑到。
        } else {
            return n * factorial(n - 1);
        }
    }

    //计算：求和 1/i,例如： 1 + 1/2 + 1/3 + 1/4
    public double function1(double i) {
        if (i == 1) // Base case
            return 1;
        else
            return  1 / i + function1(i - 1); // Recursive call
    }

    //计算： 求和 i /( 2i + 1) 。例如：1/3 + 2/5 + 3/7 。。。。
    public double function2(double i){
        if (i == 0)
            return 0;
        else
            return i / (2 * i + 1) + function2(i - 1);
    }


    //Fibonacci斐波那契数，双递归，比较特殊。
    //繁殖兔子例子
    //Fibonacci值： 0 1 1 2 3 5 8 13 21 34
    //索引：        0 1 2 3 4 5 6  7  8  9
    public long Fibonacci(long index) {
        if (index == 0)
            return 0;
        else if (index == 1)
            return 1;
        else
            return Fibonacci(index - 1) + Fibonacci(index - 2);
    }



    //递归的折半查找，和前面while的折半查找对比一下。
    public int recursiveBinarySearch(int[] list, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (low > high) //没找到
            return -low - 1;

        if (key < list[middle]) {
            return recursiveBinarySearch(list, key, low, middle - 1);
        } else if (key == list[middle]) {
            return middle;
        } else {
            return recursiveBinarySearch(list, key, middle + 1, high);
        }
    }
}