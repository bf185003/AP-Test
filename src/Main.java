import sampleClass.*;

public class Main {

    public static void main(String[] args) {

     //   Unit6 unit = new Unit6();
     //   unit.do2dArray3();
//        double totalIncome = 0.0;
//        for (int i = 1; i < 11; i++) {
//            totalIncome += investmentIncome(500,500,0);
//            System.out.println("今年是第 "+ i + " 年，投资总收入是："+ totalIncome);
//            System.out.println();
//        }

        Person p = new Person();
        //p.method1(); 不能调用protected的方法


//        StopWatch sw = new StopWatch();
//        sw.start();
//        unit.doArray();
//
//        sw.stop();
//        sw.printElapsedTime();


//          Unit5 unit2 = new Unit5();
          //System.out.println(Unit5);34
//          Unit5 unit1 = new Unit5();
//          System.out.println(Unit5.attrPublicStatic);
//        Unit5 unit = new Unit5(213);//谁是Class定义 ,谁是instance？？
//        unit.attrPublic = 101;
//        Unit5.attrPublicStatic = 123;
//        Unit5.miniClass.miniMethod();
//        unit.attrPublicStatic = 1222;
//        System.out.println(unit.attrPublicStatic);
//        unit.method_public(5);//它会怎么打印？
//        int a = unit.method_public(7) + 4;//a等于多少？

        //Unit5 unit2;// 注意：当你声明一个对象引用但不对其进行初始化（即没有使用 new 创建实例或赋值为已有对象），它的默认值是 null。
    }

    private static double investmentIncome(int lowRisk, int middleRisk, int highRisk){
        double riskRate = Math.random();
        double lowRiskIncome,middleRiskIncome,highRiskIncome;
        //低风险收入
        if (riskRate < 0.05)
            lowRiskIncome = lowRisk *  -0.05;
        else
            lowRiskIncome = lowRisk * 0.05;

        //中风险收入
        riskRate = Math.random();
        if (riskRate < 0.2)
            middleRiskIncome = middleRisk * -0.2;
        else
            middleRiskIncome = middleRisk * 0.2;

        //高风险收入
        riskRate = Math.random();
        if (riskRate < 0.4)
            highRiskIncome = highRisk * -0.4;
        else
            highRiskIncome = highRisk * 0.4;

        System.out.println("您投资组合，低风险投资：" + lowRisk + "万元，中风险投资：" + middleRisk + "万元，高风险投资："+highRisk);
        System.out.print("您今年收益是：" + (lowRiskIncome + middleRiskIncome + highRiskIncome));
        System.out.println(" , 其中低风险投资收益："+lowRiskIncome + "万元, 中风险收益：" + middleRiskIncome + "万元，高风险投资收益：" + highRiskIncome);

        return lowRiskIncome + middleRiskIncome + highRiskIncome;
    }

}