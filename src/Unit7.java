import java.util.ArrayList;

//学习数组列表 ArrayList
public class Unit7 {
    //Arraylist可以添加和删除、插入。arrayList的长度是可以改变的。
    //缺点是：1 只能用来存对象（Object/Instance），不能用基础类型（可以用Integer、String）。2：速度比array慢
    ArrayList<String> sList = new ArrayList<String>();  //注意，不是方括号了[]，是尖括号
                                                        //不要忘了new

    public void doArrayList(){

        //Step 1 尾部追加对象
        //ArrayList添加元素，从尾部添加。
        //注意，这个返回值是boolean的，如果内存不够的话有可能返回false，但是ap考试不用关注。
        sList.add("Apple");
        sList.add("Orange");
        sList.add("Mellon");
        sList.add("Lemon");

        //从index位置插入对象
        sList.add(1,"Pear"); //添加到index位置，现有index往后挪一个，Apple已经变1了，注意index不能超过末尾index + 1
        //sList.add(6,"Banana");这样就超出了，就错了。

        //获取某个位置的对象
        System.out.println(sList.get(1));

        //修改某个位置的对象，注意set是返回对象的set之前的object
        String s = sList.set(0,"Banana");
        System.out.println(s + " has be replaced. the new object on index 0 is " + sList.get(0));

        //移除某个位置的对象，注意remove有返回值，是对象的object
        s = sList.remove(1);
        System.out.println(s + " has be moved. the new object on index 1 is " + sList.get(1));

    }
}
