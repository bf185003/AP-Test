import java.util.Scanner;

public class Unit4 {

    //for循环练习，注意所有的循环语句都是和算法复杂度大O（Big O Notation）有关了
    public void doFor(){
        //基础的for
        for (int i = 0; i < 10; i ++) {// 小于和小于等于都试一下 ，i++,i += 2也试一下，i= 5开始也试一下
            System.out.println(i);      //另外一个问题，在循环里面能改i的值么？能，但是非常不推荐。
        }

        // 双参数循环也行，但是容易乱，不建议用
        for (int i = 0 , j = 5; i < 10 && j <=20 ; i ++ ,j += 2) {
            System.out.print("i = " + i);
            System.out.println(" j = " + i);
        }

        //递减的for
        for (int i = 10; i > 0; i --) {// i++的话就进入死循环了 ，死循环要避免
            System.out.println(i);
        }

        //题目，做一个打印100以内的偶数，2种方法，一种是O(n)复杂度，一种是O(n/2)复杂度。
        for (int i = 0; i <= 100; i ++) {
            if(i % 2 == 0)
                System.out.println(i);
        }

        //break和continue的两个语句
        //break 跳出循环体，不再循环
        //continue 终止当前这个loop
        for (int i = 0; i <= 100; i ++) {
            if(i  == 10)
                break;      //break换成continue看一下效果。
            System.out.println(i);
        }

        //题目，做一个打印1-100的求和,和 阶乘
        int sum = 0;
        long factorial = 1;
        for (int i = 1; i <= 100; i ++) {
            sum += i;           //求和
            factorial *= i;     //阶乘
        }
        System.out.println(sum);

        //嵌套的for
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 5 ; j ++) // j= 0 ,可以替换成j = i
                System.out.println("i = "+ i + " j= " + j);
        }

        //高级题目，打印 9 * 9 乘法表，算法复杂度O(n!)
        String str = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i ; j ++) // j= 0 ,可以替换成j = i
                System.out.print(j + " * " + i + " = " + (i * j) + "   ");

            System.out.println("");
            str = "";
        }

        //作业1，看一下github的05-05练习，双参数for循环
        //作业2，高级题目，打印100以内质数，需要2个循环
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true; // 标记是否为质数
            // 检查 i 是否能被 2 到 i-1 之间的任一数整除
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false; // 不是质数，退出内层循环
                    break;//break跳出当前的循环语句，for、while、switch都会跳出
                }
            }
            // 如果 i 是质数，则打印出来
            if (isPrime)
                System.out.print(i + " ");
        }
    }

    //while练习，通常是不知道具体数量的
    public void doWhile(){
        //基础while, 请问value 是多少？
        int count = 1;
        int value = 31;
        while (value >= 10){
            value = value - count;
            count = count + 3;
        }
        System.out.println(value);

        //获取用户输入数字，直到输入0
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a int: ");
        int a = input.nextInt();

        while(a != 0){
            System.out.print(a + " not zero.Please input a int: ");
            a = input.nextInt();
        }

        //while倒过来，就是do while，这样就能第一次就不需要判断了。
        do{
            System.out.print("Please input a int: ");
            a = input.nextInt();
        } while(a != 0);//注意，这里有分号，dowhile有分号的，和其他循环不一样




        //作业2，用while做一个乘法表


    }
}
