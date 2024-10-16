import java.util.Scanner;

public class Unit3 {

    //if练习 1
    public void doif() {
        //注意写if的时候可以画流程图。

        //单行，可以不带大括号
        if(true) //这里一定是true/false的表达式，如果为true才执行里面，注意直接写boolean变量是可以的，也可以写表达式，注意浮点数不能用 == 判断
            System.out.println("True");
        //多行
        if(true) {
            System.out.println("True1");
            System.out.println("True2");
        }
        //带一个else
        if(true) {
            System.out.println("true");
        }else{
            System.out.println("False");
        }
        //带多个else，输入成绩，返回结果，注意数据从大到小，如果反过来，就不对了。
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the student score: ");
        int a = input.nextInt();
        if(a >= 90) {
            System.out.print("The student score:" + a + " is grade D! ");
        }
        else if (a >= 80) {
            System.out.print("The student score:" + a + " is grade B! ");
        }
        else if (a >= 70) {
            System.out.print("The student score:" + a + " is grade C! ");
        }
        else if (a >= 60) {
            System.out.print("The student score:" + a + " is grade A! ");
        }
        else{
            System.out.print("The student score:" + a + " is grade E! ");
        }
    }

    public void doIf2(){

        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Generate three random integers
        int digit1 = (int)(Math.random() * 10);
        int digit2 = (int)(Math.random() * 10);
        int digit3 = (int)(Math.random() * 10);

        // Prompt user to enter the sum of three integers
        System.out.print(
                "What is " + digit1 + " + " + digit2 + " + " + digit3 + "? ");
        int answer = input.nextInt();

        if((digit1 + digit2 + digit3 == answer))
        {
            System.out.println("You are right, " +
                    digit1 + " + " + digit2 + " + " + digit3 + " = " + answer + " is " + answer);
        }else
        {
            System.out.println("You are wrong, " +
                    digit1 + " + " + digit2 + " + " + digit3 + " = " + answer + " is "
                    + (digit1 + digit2 + digit3));

        }

        System.out.print("Please input the a,b,c of Quadratic: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        QuadraticRoot(a,b,c);
    }

    //if练习
    //解二次方程的两个根练习，输入a，b，c，输出x1，x2
    //注意有1个根，2个根，没有根三种情况
    public void QuadraticRoot(double a, double b, double c) {

        double delta = Math.pow(b,2) - 4 * a * c;

        if(delta > 0){
            System.out.println("There are two real roots for : a = "
                    + a + " ,B = " + b + " ,C = " + c);
            System.out.println("X1 = " + ( (- b + Math.sqrt(delta)) / 2 * a));
            System.out.println("X1 = " + ( (- b - Math.sqrt(delta)) / 2 * a));
        } else if (delta == 0) {
            System.out.println("There are one real root for : a = "
                    + a + " ,B = " + b + " ,C = " + c + " ,the root is " + (- b / 2 * a));
        }else {
            System.out.println("There are no real root for : a = " + a + " ,B = " + b + " ,C = " + c);
        }

    }

    //留个作业，上述的用户的函数，输入一个x，求y

    //switch练习
    public void DoSwitch() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a letter: ");
        String s = input.nextLine();

        switch(s)
            {
                case "A":
                case "a":
                case "E":
                case "e":
                case "I":
                case "i":
                case "0":
                case "o":
                case "U":
                case "u": System.out.println(s + " is a vowel"); break;
                default : System.out.println(s + " is a consonant");
            }


        int month = (int)((Math.random() * 12) + 1);

        // Display the English month name
        switch (month)
        {
            case 1: System.out.println("January"); break;
            case 2: System.out.println("February"); break;
            case 3: System.out.println("March"); break;
            case 4: System.out.println("April"); break;
            case 5: System.out.println("May"); break;
            case 6: System.out.println("June"); break;
            case 7: System.out.println("July"); break;
            case 8: System.out.println("August"); break;
            case 9: System.out.println("September"); break;
            case 10: System.out.println("October"); break;
            case 11: System.out.println("November"); break;
            case 12: System.out.println("December");
        }
    }
    //for循环练习，注意所有的循环语句都是和算法复杂度大O（Big O Notation）有关了
    public void doFor(){
        //基础的for
        for (int i = 0; i < 10; i ++) {// 小于和小于等于都试一下 ，i++,i += 2也试一下，i= 5开始也试一下
            System.out.println(i);
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
        //题目，做一个打印1-100的求和
        int sum = 0;
        for (int i = 0; i <= 100; i ++) {
            sum += i;
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

        //作业，高级题目，打印100以内质数，需要2个循环
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true; // 标记是否为质数
            // 检查 i 是否能被 2 到 i-1 之间的任一数整除
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false; // 不是质数，退出内层循环
                    break;//break跳出当前的循环语句，for和while都会跳出
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

        //break和continue的两个语句


        //把一个字符串倒过来显示
    }

    //嵌套循环
}