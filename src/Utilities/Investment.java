package Utilities;

public class Investment {
    double totalIncome = 0.0; //投资收入

    //投资多少年
    public void doInvestment(int years,int lowRisk,int middleRisk, int highRish){
        for (int i = 1; i < years; i++) {
          totalIncome += investmentIncome(lowRisk,middleRisk,highRish);
          System.out.println("今年是第 "+ i + " 年，投资总收入是："+ totalIncome);
          System.out.println();
        }
    }

    //投资组合，然后计算当年产生的收入和风险损失
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
