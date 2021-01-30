//Write a java program to overload constructor and method

class Number {
    int num;

    Number() {
        num = 5;
    }

    Number(int a) {
        num = a;
    }

    int findMultiple() {
        return num * 10;
    }

    int findMultiple(int a) {
        return num * a;
    }
}

public class Overload {
    public static void main(String[] args) {
        Number num1 = new Number();
        Number num2 = new Number(7);

        System.out.println(num1.findMultiple());
        System.out.println(num2.findMultiple());

        System.out.println(num1.findMultiple(8));
        System.out.println(num2.findMultiple(8));

        //50 70 40 56
    }
}
