import java.util.Scanner;

////学习循环iterator、Loops
public class Unit4 {

    //for循环练习，注意所有的循环语句都是和算法复杂度大O（Big O Notation）有关了
    public void doFor(){
        //基础的for
        //打印0-9，0-10，1-10。看如何设置循环体
        int sum1 = 0;
        for (int i = 0; i <= 10; i += 2 ) {// 小于和小于等于都试一下 ，++ i , i += 2也试一下，i= 5开始也试一下
                                        // 这个例子是循环10次，i从0到9，如果改成i <= 10 ，就循环11次，从0-11
                                        //创建一个从[100-200]的循环，i += 5循环次数是多少，创建[456,123)的反循环。
            System.out.println("i = " + i + " Sum =" + (sum1 += i));      //另外一个问题，在循环里面能改i的值么？能，但是非常不推荐。
                                        //注意，for和while循环经常容易范的错误是多一行或少一行。一定要算对。
        }

        // 双参数循环也行，但是容易乱，不建议用
        for (int i = 0 , j = 5; i < 10 && j <=20 ; i ++ ,j += 2) {
            System.out.print("i = " + i);
            System.out.println(" j = " + i);
        }

        //下面的例子是有效的，是一个死循环，永远出不来
//        for( ; ;){
//            System.out.println("ok");
//        }
        //递减的for
//        for (int i = 10; i > 0; i --) {// i++的话就进入死循环了 ，死循环要避免
//            System.out.println(i);
//        }

        //题目，做一个打印100以内的偶数，2种方法，一种是O(n)复杂度，一种是O(n/2)复杂度。
//        for (int i = 0; i <= 100; i ++) {
//            if(i % 2 == 0)
//                System.out.println(i);
//        }

        //break和continue的两个语句
        //break 跳出循环体，不再循环。
        //continue 终止当前这个loop
        for (int i = 0; i <= 10; i ++) {
            if(i  == 5)
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
        System.out.println("sum = " + sum + " and factorial = " + factorial);

        //嵌套的for
        for (int i = 1; i <= 10; i ++) {
            for (int j = i; j <= 10 ; j ++) // j= 0 ,可以替换成j = i
                System.out.print(" (i"+ i + ",j" + j + ")");
            System.out.println("");
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
        //复杂度 O( n*n^1/2次方) = n^3/2
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

        //另外一种无穷循环，直到输入为0 退出循环
        do {
            System.out.print(a + " not zero.Please input a int: ");
            a = input.nextInt();
            if (a == 0)
                break;  // break和continue的用法和for一样，一个是退出全部循环，一个是结束当前循环，返回条件处
                        //唯一需要注意的是，do while循环的continue是跳过所有语句到下面。
        } while (true);


        //break和continue的练习，下面是一个continue的死循环陷阱
        value = 0;
        System.out.print(" Please input a int: ");
        value = input.nextInt();
        do{
            if(value == 5)
                break;      //break换成continue看一下效果。
            System.out.println(value);
            value ++ ; // 这种写法有问题，continue的话无法执行，就进入死循环了，注意循环变量的++一定要写在continue前面。
        }while(value < 10);
        //作业2，用while做一个乘法表


    }
}
