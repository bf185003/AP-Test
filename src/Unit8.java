import java.util.Scanner;

//二维数组 two-dimensional array.
public class Unit8 {

    //二维数组，是由多个一维数组组成。第一个是行，第二个是列。index都是从0开始
    //AP考试的2维数组，每一行的列数都是相等的。其实2维数组可以每一行长度不一样。

    //这种是一种定义方式
    int[][] twodArray = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12}
                       };
    //这是定义一个空的二维数组，3行4列，注意第一个是行，第二个是列
    int[][] twodArray2 = new int[3][4]; //注意new必须给出行的固定长度，new int[3][]是可以的。new int[][]是错的
    int[][] twoArray3;//只声明declare，不创建new，是可以的，Java所有的Variables都可以先声明，不定义

    public void do2dArray(){
        //two dimensional array的length是 行数，这里是3
        System.out.println("row is :" + twodArray.length);
        //某一个行的长度，就是列数
        System.out.println("col is :" + twodArray[0].length);

        //查找某个数组元素
        System.out.println(twodArray[1][2]);//注意index都是从0开始，不论是行还是列。这是打印第2行的第3列
                                            //注意不要写成twodArray[1,2]

        //给2维数组赋值
        twodArray[1][2] = 10;

        //2层嵌套for循环的方式遍历数组，先遍历行，再遍历列
        for (int i = 0; i < twodArray.length; i++) {
            for (int j = 0; j < twodArray[i].length; j++) {
                System.out.print(" " + twodArray[i][j]);
            }
            System.out.println();
        }

        //for each的方式遍历数组，同理，for each的基础类型不能修改，只能读
        for (int[] arr1 : twodArray) {//注意第一个for each的元素是一维数组
            for (int x : arr1){
                System.out.print(" " + x);
            }
            System.out.println();
        }


        //旋转数组，
        for (int i = 0; i < twodArray[0].length; i++) {//我这里一开始写称twoArray[i]，这样是不对的，判断最后一圈的时候就报错了。
            for (int j = 0; j < twodArray.length; j++) {
                System.out.print(" " + twodArray[j][i]);
            }
            System.out.println();
        }


        //找到二维数组中的最大最小值
        // 初始化最大值和最小值，假设第一个元素是最大值和最小值
        int maxValue = twodArray[0][0];
        int minValue = twodArray[0][0];
        int maxRow = 0, maxCol = 0; // 最大值的位置
        int minRow = 0, minCol = 0; // 最小值的位置

        // 遍历整个二维数组，找到最大值和最小值
        for (int i = 0; i < twodArray.length; i++) { // 遍历行
            for (int j = 0; j < twodArray[i].length; j++) { // 遍历列
                if (twodArray[i][j] > maxValue) {//判断当前值和最大值谁大
                    maxValue = twodArray[i][j];
                    maxRow = i; // 记录最大值所在的行
                    maxCol = j; // 记录最大值所在的列
                }
                if (twodArray[i][j] < minValue) {
                    minValue = twodArray[i][j];
                    minRow = i; // 记录最小值所在的行
                    minCol = j; // 记录最小值所在的列
                }
            }
        }

        // 输出最大值和最小值及其位置
        System.out.println("最大值是: " + maxValue + "，位置: (" + maxRow + ", " + maxCol + ")");
        System.out.println("最小值是: " + minValue + "，位置: (" + minRow + ", " + minCol + ")");


        //分别求行和列的和
        int sumRow = 0;
        // 存储每列的和，用一维数组存储
        int[] colSums = new int[twodArray[0].length];

        System.out.println("\n每行的和：");
        for (int i = 0; i < twodArray.length; i++) {//我这里一开始写称twoArray[i]，这样是不对的，判断最后一圈的时候就报错了。
            for (int j = 0; j < twodArray[0].length; j++) {
                sumRow += twodArray[i][j];
                colSums[j] += twodArray[i][j];  // 计算列的和
            }
            System.out.println("第 " + (i + 1) + " 行的和: " + sumRow);
        }
        // 输出每列的和
        System.out.println("\n每列的和：");
        for (int j = 0; j < colSums.length; j++) {
            System.out.println("第 " + (j + 1) + " 列的和: " + colSums[j]);
        }


        //看08-07练习题。

    }

    //二维数组练习，在一个大数组中寻找小数组
    //这个是图像识别、游戏规划路径、机器人寻路径、生物分析中经常用到的算法
    public void do2dArray2(){
        // 创建一个 100x100 的二维数组
        int[][] array = new int[30][30]; //要查找的数组
        int[][] arrayTaget = {{0,1,0},  //目标数组  , 机器学习中的张量用计算机就是数组，2维张量就是2维数组，
                         {1,0,1},
                         {0,1,0}};

        // 填充数组（示例：随机生成0或1）
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                array[i][j] = Math.random() < 0.5 ? 0 : 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // 查找 3x3 的子数组中所有元素为 0 或 1 的位置
        for (int i = 0; i < 28; i++) {  // 需要到 99，防止越界
            for (int j = 0; j < 28; j++) {
                // 查找 3x3 的区域
                if (arrayTaget[0][0] == array[i][j] &&
                    arrayTaget[0][1] == array[i][j + 1] &&
                    arrayTaget[0][2] == array[i][j + 2] &&
                    arrayTaget[1][0] == array[i + 1][j] &&
                    arrayTaget[1][1] == array[i + 1][j + 1]  &&
                    arrayTaget[1][2] == array[i + 1][j + 2]  &&
                    arrayTaget[2][0] == array[i + 2][j]  &&
                    arrayTaget[2][1] == array[i + 2][j + 1] &&
                    arrayTaget[2][2] == array[i + 2][j + 2]
                ) {
                    System.out.println("发现匹配的 3x3 区域：(" + i + "," + j + ")");
                }
            }
        }

    }

    //二维数组练习，空间中找最近的点，可以是3维，或者更高维度，chatGPT是数万亿维，这叫最近邻搜索
    //这种算法也经常用，比如导航和定位、游戏引擎中判断物体是否碰撞、光影效果、物体捕捉，此外在机器学习中用来做k-means、大模型等
    public void do2dArray3(){
        int[][] array = new int[10][3]; //10个3维空间中的点
        // 填充数组（示例：每个点的坐标是0-100的立方体中的位置）
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = (int)(Math.random() * 101); //生成0-100的位置
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Please input the point coordinate (x,y,z) : ");
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        double minDistance = Double.MAX_VALUE ,distance = 0 ;
        int pos = 0;

        for (int i = 0; i < array.length; i++) {
            distance = Math.sqrt(Math.pow(array[i][0] - x , 2) + Math.pow(array[i][1] - y , 2) + Math.pow(array[i][2] - z , 2));
            if (distance < minDistance) {
                minDistance = distance;
                pos = i + 1;
            }
        }
        System.out.println("最近的点的是第" + pos + "行的点。");
    }

}
