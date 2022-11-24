import java.util.Scanner;
/*此代码是switch语句练习代码，学习练习switch语句语法结构
switch中case不能重复
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("1. 周一 2.周二 3.周三 4.周四 5.周五 6.周六 7.周末");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入序号：");
        int a = scanner.nextInt();
       /* switch (a) {
            case 1:
                System.out.println("周1");
                break;
            case 2:
                System.out.println("周2");
                break;
            case 3:
                System.out.println("周3");
                break;
            case 4:
                System.out.println("周4");
                break;
            case 5:
                System.out.println("周5");
                break;
            case 6:
                System.out.println("周6");
                break;
            case 7:
                System.out.println("周天");
                break;
            default:
                System.out.println("输入错误，请重新输入");
        }
        此语句可替换为语句更简单的switch语句
        */

        switch (a) {
            case 1 -> System.out.println("周一");
            case 2 -> System.out.println("周二");
            case 3 -> System.out.println("周三");
            case 4 -> System.out.println("周四");
            case 5 -> System.out.println("周五");
            case 6 -> System.out.println("周六");
            case 7 -> System.out.println("周末");
            default -> System.out.println("输入错误，请重新输入！");
        }
    }
}