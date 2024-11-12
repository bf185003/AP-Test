import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

//学习数组列表 ArrayList
public class Unit7 {
    //Arraylist可以添加和删除、插入。arrayList的长度是可以改变的。
    //另外，ArrayList在编译时候做了类型检查，比较安全，对象的数组，如 Object[]是运行时检查类型，容易运行时报错。
    //缺点是：1 只能用来存对象（Object/Instance），不能用基础类型（可以用Integer、String）。2：速度比array慢
    //使用ArrayList，必须在Class前面引入util包，可以用import java.util.*;，也可以写import java.util.ArrayList

    ArrayList<String> sList = new ArrayList<String>();  //注意1，不是方括号了[]，是尖括号
                                                        //注意2，不要忘了new
                                                        //如果不写数量，默认是10个
    ArrayList<String> sList2 = new ArrayList<String>(5); //如果写了数量，就是5个
    ArrayList<String> sList3 = new ArrayList<String>(Arrays.asList("one","two","three","one")); //这么赋值也可以
    ArrayList<Integer> intlist = new ArrayList<>();


    public void doArrayList(){

        //Step 1 尾部追加对象
        //ArrayList添加元素，从尾部添加。
        //注意，这个返回值是boolean的，如果内存不够的话有可能返回false，但是ap考试不用关注。
        sList.add("Apple");
        sList.add("Orange");
        sList.add("Water Mellon");
        sList.add("Lemon");

        //Step 2 从index位置插入对象
        sList.add(1,"Pear"); //添加到index位置，现有index往后挪一个，Apple已经变1了，注意index不能超过末尾index + 1
        //sList.add(6,"Banana");这样就超出了，就错了。

        //Step 3 获取某个位置的对象
        System.out.println(sList.get(1));

        //Step 4 修改某个位置的对象，注意set是返回对象的set之前的object
        String s = sList.set(0,"Banana");
        System.out.println(s + " has be replaced. the new object on index 0 is " + sList.get(0));

        //Step 5 移除某个index位置的对象，注意remove有返回值，是对象的object
        s = sList.remove(1);
        System.out.println(s + " has be moved. the new object on index 1 is " + sList.get(1));

        //Step 6 下面是移除某个指定的对象，注意，这里的返回值是boolean，和上面不一样，别混了
        boolean delSuccess = sList.remove("Lemon");
        if (delSuccess)
            System.out.println("Lemon has be moved.");

        printArrayListString(sList);

        sList2.add("Carrot");
        sList2.add("Tomato");
        sList2.add("Potato");

        //Step 7 addAll，是把两个ArrayList拼起来
        //两种给拼接方法，一种是后面，一种是在index位置拼接
        sList.addAll(sList2);
        sList.addAll(0,sList2);

        printArrayListString(sList);

        //Step 8 查找某个对象,返回boolean
        boolean isFound = sList.contains("Carrot");
        if(isFound)
            System.out.println("Carrot founded.");

        //Step 9 获取某个对象的索引，如果有多个类似的对象，返回首次出现的
        int index = sList.indexOf("Carrot");
        System.out.println("The Carrot first index is " + index);

        //Step 10,反转一个列表
        Collections.reverse(sList);
        printArrayListString(sList);

        //Step 11, 排序一个列表
        Collections.sort(sList);
        printArrayListString(sList);

        //Step 12 清空列表中的所有对象
        sList.clear();
        printArrayListString(sList);

        //Step 11 判断数组列表是否是空的
        boolean isEmpty = sList.isEmpty();
        if(isEmpty)
            System.out.println("sList is Empty!");

    }

    public void printArrayListString(ArrayList<String> theList ){
        //ArrayList获取大小，是size函数，注意和Array的length属性是不一样的
        //siz()函数返回int，说明arrayList的size最大多少？
        System.out.println("Start Print list element....");
        for (int i = 0; i < theList.size(); i++) {
            System.out.println("index " + i + " is " + theList.get(i) + " , string length is " + theList.get(i).length()); //注意，这里还能继续点点，调用对象的方法和属性，可以测试
        }
        System.out.println("End Print list element....");
    }

    //重载一个方法
    public void printArrayListInt(ArrayList<Integer> theList ){
        //ArrayList获取大小，是size函数，注意和Array的length属性是不一样的
        //siz()函数返回int，说明arrayList的size最大多少？
        System.out.println("Start Print list element....");
        for (int i = 0; i < theList.size(); i++) {
            System.out.println("index " + i + " is " + theList.get(i)); //注意，这里还能继续点点，调用对象的方法和属性，可以测试
        }
        System.out.println("End Print list element....");
    }

    //数据的遍历方法练习,查找和删除重复元素
    public void doArrayList2(){
        printArrayListString((ArrayList<String>) sList3);
        sList3 = (ArrayList<String>) sList3.stream()
                     .distinct()
                     .collect(Collectors.toList());

        printArrayListString(sList3);
    }

    //练习各种排序
    public void sortList(){
        intlist.add(3);
        intlist.add(1);
        intlist.add(5);
        intlist.add(4);
        intlist.add(2);
        int temp , key,j;

        // 插入排序
        for (int i = 1; i < intlist.size(); i++) {
            key = intlist.get(i);
            j = i - 1;
            // 向前移动元素
            while (j >= 0 && intlist.get(j) > key) {
                intlist.set(j + 1, intlist.get(j));
                j--;
            }
            intlist.set(j + 1, key);
        }
        printArrayListInt(intlist);


        // 选择排序
        for (int i = 0; i < intlist.size() - 1; i++) {
            int minIndex = i;
            for (j = i + 1; j < intlist.size(); j++) {
                if (intlist.get(j) < intlist.get(minIndex)) {
                    minIndex = j;
                }
            }
            // 交换最小元素到当前的位置
            temp = intlist.get(i);
            intlist.set(i, intlist.get(minIndex));
            intlist.set(minIndex, temp);
        }
        printArrayListInt(intlist);

        // 冒泡排序
        for (int i = 0; i < intlist.size() - 1; i++) {
            for (j = 0; j < intlist.size() - 1 - i; j++) {
                if (intlist.get(j) > intlist.get(j + 1)) {
                    // 交换
                    temp = intlist.get(j);
                    intlist.set(j, intlist.get(j + 1));
                    intlist.set(j + 1, temp);
                }
            }
        }
        printArrayListInt(intlist);


    }
}
