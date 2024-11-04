import java.util.Arrays;

public class Unit6 {
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "Jack", "Queen", "King"};
    private int[] searchList = new int[1000]; //1000个int数组，用来做折半查找用

    public void doArray(){
        //arrary是长度固定的、同类型的组合
        int[] intArray1 = new int[10];  //创建一个空的10个元素的array，索引从0开始，0-9。长度一旦确定，就不能改了。
                                        //注意前后的中括号不要遗漏。
                                        //array的缺省值，int，double类型的为0，char为\0，boolean类型是false，String是Null
        double[] doubleArray = {1.2,2.4,3.6,4.1};   //直接赋值也是可以的，注意是用中括号括起来，注意这种赋值的不需要写new
        char[]  charArray = {'D','a','l','l','a','s'};
        String[] session = {"Spring","Summer","Fall","Winter"}; //同一类的array也可以创建
        int[] intArray2 ;               //创建一个数组定义，不设置大小和赋值也行
        intArray2 = new int[20];    //也可以先定义数组类型，后分配大小，Array一旦分配完大小，就不能再改了。

        System.out.println(intArray1.length);   //获取Array长度，这个length是不加括号！！是一个variable
        System.out.println(session[0]);         //通过中括号，可以获取array中的某个值。
        session[2] = "Autumn";                  //也可以给他赋值，和修改值
                                                //注意index也是从0开始，和String一样的

        for (int i = 0; i < intArray1.length; i++) {
            intArray1[i] = i;   //array数据可以赋值，也可以取值
            System.out.println("intArray1[" + i + "] = " + intArray1[i]);
        }
        System.out.println(charArray);//char可以直接打印数组，是逐个char打印出来的，int和double的不能直接打印

        for(int i = 0; i < doubleArray.length; i++) {//遍历打印一个array
            System.out.println(doubleArray[i]);
            doubleArray[i] = i; //for循环可以修改array的值
        }

        //针对array的一种特殊的for each循环，每次循环array中的一个元素，和上面的相等，这种写法比较简单，也不需要了解array的长度
        //注意！！！for each循环，不能修改array其中的值！！！但是非内置Class（Integer之类的），可以通过引用方式修改，比如Person
        for(double e : doubleArray){    //注意这里是冒号，不是分号。同时注意，这个e是元素，不是索引
            System.out.println(e);      //打印的方式不一样
        }


        //数组切记不要超过范围，否则会有runtime报错
        //System.out.println(intArray1[11]);

        //复制数组到另外一个中，把第一个array的5个元素（从3开始）复制到另外一个array中（从2开始）
        //注意arraycopy这个系统函数命名不对，C应该大写
        System.arraycopy(intArray1,3,intArray2,2,5); //
        for(int e : intArray2){
            System.out.println(e);
        }

        Person p1 = new Person("Nancy",15,150,"female");
        Person p2 = new Person("Bob",55,170,"male");
        Person[] pList = new Person[2];
        pList[0] = p1;
        pList[1] = p2;
        for(Person p : pList){
            p.grow(); //可以修改非内置Class的值
        }

        for(int i = 0; i < intArray1.length; i++) {//遍历打印一个array
            intArray1[i] = (int)(Math.random() * 11); //给一个0-10的随机数
            System.out.println(intArray1[i]);
        }

        Arrays.sort(intArray1);//对数组进行排序

        for (int i : intArray1){//排序后的数组
            System.out.println(i);
        }

        for(int i = 0; i < searchList.length; i++) {//遍历打印一个array
            searchList[i] = 1 + (int)(Math.random() * 1000); //给一个1-1000之间的随机数
        }
        Arrays.sort(searchList);//给他排序
        int index = arrayBinarySearch(searchList , 34); //例如随机查找34
        if (index == -1)
            System.out.println("not found!");
        else
            System.out.println("founded,At index:" + index);
    }

    //做一个数组折半查找函数
    //折半查找必须对已经排好序的数组进行查找，返回找到的数据的index，-1是没找到
    public int arrayBinarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;
        int middle = 0;

        while(high >= low){
            middle = (low + high) / 2;
            if (key < list[middle])
                high = middle - 1;  //
            else if (key > list[middle])
                low = middle + 1;
            else //key = list[middle]
                return middle;
        }

        return -1; //没找到
    }

    //洗牌程序
    // 我们初始化deck的Card numbers 0 to 12, Spades
    //              13 to 25, Hearts
    //              26 to 38, Diamonds
    //              39 to 51，Clubs

    public void doArray2Card(){
        int[] deck = new int[52];

        // Initialize the cards ,初始化一副新牌
        for (int i = 0; i < deck.length; i++)
            deck[i] = i;
        //显示前13张牌
        displayCard(deck,13);

        //洗牌
        shuffleCard(deck);

        // Display the first four cards，显示前四张牌
        displayCard(deck,4);
    }

    //洗牌函数，注意array是传递引用
    public void shuffleCard(int[] deck){
        // Shuffle the cards，随机洗牌
        for (int i = 0; i < deck.length; i++) {
            // Generate an index randomly，产生一个随机数，进行牌的对调
            int index = (int)(Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }

    //显示牌的函数，可以显示牌的前多少张，注意array是传递引用，不是传递值。
    public void displayCard(int[] deck,int number){
        for (int i = 0; i < number; i++) {
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            System.out.println("Card number " + deck[i] + ": "
                    + rank + " of " + suit);
        }
    }
}

