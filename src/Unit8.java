
//二维数组 two-dimensional array.
public class Unit8 {

    //AP考试的2维数组，每一行的列数都是相等的。其实2维数组可以每一行长度不一样。

    //这种是一种定义方式
    int[][] twodArray = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12}
                       };
    //这是定义一个空的二维数组，3行4列，注意第一个是行，第二个是列
    int[][] twodArray2 = new int[3][4];

    public void do2dArray(){
        //two dimensional array的length是 行数，这里是3
        System.out.println("row is :" + twodArray.length);
        //某一个行的长度，就是列数
        System.out.println("col is :" + twodArray[0].length);

        //查找某个数组元素
        System.out.println(twodArray[1][2]);//注意index都是从0开始，不论是行还是列。这是打印第2行的第3列

        //给2维数组赋值
        twodArray[1][2] = 10;

        //for的方式循环遍历数组，先遍历行，再遍历列
        for (int i = 0; i < twodArray.length; i++) {
            for (int j = 0; j < twodArray[i].length; j++) {
                System.out.print(" " + twodArray[i][j]);
            }
            System.out.println();
        }

        //for each的方式遍历数组，同理，for each的基础类型不能修改，只能读
        for (int[] arr1 : twodArray) {
            for (int x : arr1){
                System.out.print(" " + x);
            }
            System.out.println();
        }

        //看08-07练习题。

    }


}
