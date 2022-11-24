package anli01;
import java.util.Scanner;
public class Supermarket {
    /*
     * 模拟商城购物小系统：1.用户选择商品后，后台计算商品价格；
     * 2.使用 while 循环实现用户多次购买商品。
     */
    public static void main(String[] args) {
        double toothbrush = 8.8; //牙刷价格
        double towel = 10.0;     //毛巾价格
        double cup = 18.8;       //水杯价格
        double apple = 12.5;     //苹果价格
        double banana = 15.5;    //香蕉价格
        System.out.println("--- HovH小商城 ---");
        System.out.println("\033[31;4m欢迎光临HovH小商城，此店是个小黑店，黑的你倾家荡产，媳妇都跑了！ \033[0m");
        System.out.println("1.牙刷的价格为：" + toothbrush + "元");
        System.out.println("2.毛巾的价格为：" + towel + "元");
        System.out.println("3.水杯的价格为：" + cup + "元");
        System.out.println("4.苹果的价格为：" + apple + "元");
        System.out.println("5.香蕉的价格为：" + banana + "元");

        String choice = "Y";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入你需要购买商品的序列号：");
            int i = scanner.nextInt();
            int amount = 0;
            double money = 0;
            switch (i) {
                case 1:
                    System.out.print("请输入你需要购买牙刷的数量:");
                    amount = scanner.nextInt();
                    money = amount * toothbrush;
                    System.out.println("你购买了牙刷"+ amount + "支，需要花费" + money + "元");
                    System.out.println("是否继续购买商品？是（输入Y）/否（输入N）");
                    break;
                case 2:
                    System.out.print("请输入你需要购买毛巾的数量:");
                    amount = scanner.nextInt();
                    money = amount * towel;
                    System.out.println("你购买了毛巾" + amount + "条，需支付" + money + "元");
                    System.out.println("是否继续购买商品？是（输入Y）/否（输入N）");
                    break;
                case 3:
                    System.out.print("请输入你需要购买水杯的数量:");
                    amount = scanner.nextInt();
                    money = amount * cup;
                    System.out.println("你购买了水杯" + amount + "个，需支付" + money + "元");
                    System.out.println("是否继续购买商品？是（输入Y）/否（输入N）");
                    break;
                case 4:
                    System.out.print("请输入你需要购买苹果的数量:");
                    amount = scanner.nextInt();
                    money = amount * apple;
                    System.out.println("你购买了苹果"+ amount + "个,需要花费" + money + "元");
                    System.out.println("是否继续购买商品？是（输入Y）/否（输入N）");
                    break;
                case 5:
                    System.out.print("请输入你需要购买香蕉的数量:");
                    amount = scanner.nextInt();
                    money = amount * banana;
                    System.out.println("你购买了香蕉"+ amount + "个，需要花费" + money + "元");
                    System.out.println("是否继续购买商品？是（输入Y）/否（输入N）");
                    break;
            }
            System.out.print("需要继续购买请输入 Y，否则输入 N：");
            choice = scanner.next();
        } while (choice.toUpperCase().equals("Y"));
        System.out.println("期待您的下次光临！期待您再跑个媳妇！");
    } }

