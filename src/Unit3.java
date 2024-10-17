import java.util.Scanner;

public class Unit3 {

    public void doOperators(){
        //复习一下以前的功课，
        //1,生成一个 -50<= 到 < 50之间的数字 ，0<到<=10的数字，
        // 如果想生成 0<到<=1之间的随机数字呢？不含0，包含1，反过来的？ if判断一下，生成0就改成1
        //2、检查求二次方程的根的作业

        //Step1 算数表达式的优先级
        //3、13 - 3 * 6 / 4 % 3  等于？12
        //如果+-的优先级（precedence）高于乘除的优先级下面的式子等于多少？
        // 2 + 3 * 12 / 7 - 4 + 8  ? 5

        // 注意 i ++ 和 ++ i不一样，同理--也是如此
        int i = 10;
        int j = 4;
        System.out.println( i++ );
        System.out.println( ++i );
        System.out.println( i-- + --j + ++i);

        //Step2 boolean表达式
        //注意,操作符的优先级顺序是 () ！ && ||
        boolean a = true;
        boolean b = !a;
        boolean c = a;
        boolean d = false;
        System.out.println(!a); //求反的场景，注意求反的优先级是所有
        System.out.println(a && b);//画一个4 * 4矩阵，讲清楚 && 和 ||
        System.out.println(a || b);

        System.out.println(!a || b && c);
        System.out.println((a && !b) || (c && d));
        System.out.println(!(a && (b || c)) || d);


        //下面分别是多少？ 把&&换成 ||呢？
        a = (5 < 3) && ( 6 != 7); //注意 如果&&前面就是false了，直接返回false。同理，||操作符第一个是true，后面也不用看了。
        a = (5 == 5) && (6 <= 7);
        a = (5 <= 5) && (10 >= 3);


    }

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

    public  void doIf3(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年龄(1 - 100)：");
        int age = input.nextInt();
        System.out.print("请输入性别(man / woman)：");
        String gender = input.next();
        System.out.print("您是否是学生(true/false)：");
        boolean isStudent = input.nextBoolean();


        //1:年龄小于 18岁的，不论男女40%折扣
        //2:年龄 > 18 < 60的，男士10%折扣，女士 20%折扣
        //3:年龄 > 60 的，不论男女，30%折扣
        //4：只要是学生身份，不论年龄性别，一律再+20%的学生折扣
         int discount = 0
        if ( age <= 18){
            discount = 40;
        }else if (age <= 60){
            if (gender == "man"){
                discount = 10;
            }else{
                discount = 20;
            }
        } else {
            discount = 30;
        }
        if(isStudent)
            System.out.println(discount + 20);
        else
            System.out.println(discount);
    }
    //if 作业1，看明白03-08这个排数字顺序的题目
    //if 作业2，实现下面的函数，输入a b c三个数值，找出里面的最大值
    public int findMax(int a, int b, int c){

      return 0;//这句先放这里不报错，改
    }


    //这个就不用教了
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

        //QuadraticRoot(a,b,c);
    }

    //if练习，上次课的作业
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

    //switch练习
    public void DoSwitch() {
        Scanner input = new Scanner(System.in);

        int month = (int)((Math.random() * 12) + 1); //练习随机生成12个月

        // Display the English month name
        switch (month)
        {
            case 1:
                System.out.println("January");//注意case语句是：结束，case里面不要忘了break语句跳出switch，如果不加还会往下执行
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            default:
                System.out.println("Other"); //最后一个不需要break
        }

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
                case "u": System.out.println(s + " is a vowel"); break; //可以多个case组合在一起，用if的 || 可以替代
                default : System.out.println(s + " is a consonant");//类似if的else
            }

    }

    //作业1，看一下github练习题03-17，石头剪刀布的例子
    //作业2，用switch做一个计算器
    public void SimpleCalculator {
            Scanner scanner = new Scanner(System.in);

            System.out.println("请输入第一个数字：");
            double num1 = scanner.nextDouble();

            System.out.print("请输入第二个数字：");
            double num2 = scanner.nextDouble();

            System.out.print("请输入运算符 (+, -, *, /)：");
            String operator = scanner.next();

            double result;

            //switch 代码写在这下面

    }


}