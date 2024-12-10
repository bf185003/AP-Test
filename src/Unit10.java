import java.util.Arrays;

//recursive递归
//递归的优点，代码比较简洁，有的时候用循环不好实现。
//缺点，慢，消耗内存。
//递归只会出现在选择题中，不会出现在大题中。
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

    //俄罗斯套娃，做一个递归的测试
    public void matryoshka(int n){
        if (n == 0){ // 最后的判断条件一定放在递归方法的开头。
            System.out.println("套娃没了");
            return;
        }

        matryoshka(n - 1);
        System.out.println("我是第" + n + " 层套娃"); //这个语句和上面的语句颠倒一下试一试
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
            long i = n * factorial(n - 1); //按理说应该放在return语句，放在这里可以看一下具体的值
            System.out.println(i); //具体计算的时候可以去掉。
            return i;
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


    //Fibonacci斐波那契数，双递归，比较特殊。这种递归是比较耗时的，因为调用了两次，好多数都会计算多遍
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