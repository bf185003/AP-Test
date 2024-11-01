public class Unit6 {

    public void doArray(){
        int[] intArray1 = new int[10];   //创建一个空的10个元素的array，索引从0开始，0-9
        double[] doubleArray = {1.2,2.4,3.6,4.1};   //直接赋值也是可以的
        char[]  charArray = {'D','a','l','l','a','s'};
        int[] intArray2 ;               //创建一个数组定义，不设置大小和赋值也行

        intArray2 = new int[20];    //也可以先定义数组类型，后分配大小，Array一旦分配完大小，就不能再改了。
                                    //array的缺省值，int，double类型的为0，char为\0，boolean类型是false

        System.out.println(intArray1.length);   //获取Array长度

        for (int i = 0; i < intArray1.length; i++) {
            intArray1[i] = i;
            System.out.println("intArray1[" + i + "] = " + intArray1[i]);
        }
        System.out.println(charArray);//可以直接打印数组，是逐条打印出来的
    }
}

