
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); // запускаем сканер
        while (true) {         // цикл while
            System.out.println("Введите выражение:"); // выводим сообщеие
            String c = scanner.nextLine();  // определяем написаное в строку с
            Calc calc = new Calc();  // выполняем метод калк
            System.out.println("Ответ: " + calc.math(c) + "\n"); // выводим результат
        }
    }
}

class Calc {
    int a;
    int b;

    public String math(String c) throws Exception {
        String[] parts = new String[0]; // кидаем написанное в стринг с в масив
        if (c.contains("+")) { // Ищем в масиве +
                parts = c.split("\\+"); // вырезаем плюс
            if (parts.length<=2) {     // проверка на 2 числа
                if (isRoman0(parts) && isRoman1(parts)) {
                    return RomanPlus(parts);
                }
                return new String(String.valueOf(plus(parts))); // перекидываем два значения массива в plus(parts)
            }else {
                System.out.println("Больше двух значений");
            }

            }

        if (c.contains("-")) {
            parts = c.split("-");
            if (parts.length<=2) {
                if (isRoman0(parts) && isRoman1(parts)) {
                return RomanMinus(parts);
            }
            return new String("" + minus(parts));
            }else {
                System.out.println("Больше двух значений");
            }
        }
        if (c.contains("/")) {
            parts = c.split("/");
            if (parts.length<=2) {
            if (isRoman0(parts) && isRoman1(parts)) {
                return RomanDel(parts);
            }
            return new String("" + del(parts));
        }else {
            System.out.println("Больше двух значений");
        }
        }
        if (c.contains("*")) {
            parts = c.split("\\*");
            if (parts.length<=2) {
            if (isRoman0(parts) && isRoman1(parts)) {
                return RomanZv(parts);
            }
            return new String("" + zv(parts));
            }else {
                System.out.println("Больше двух значений");
            }
        }
        throw new Exception();
    }
    public int plus(String[] parts) throws Exception {
        a = parseInt(parts[0]); // переводим в число и иницилизируем а и б
        b = parseInt(parts[1]);
        if (checker(a,b)){
            throw new Exception();
        } else {
            return a+b;
        }
    }

    public int minus(String[] parts) throws Exception {
        a = parseInt(parts[0]);
        b = parseInt(parts[1]);
        if (checker(a,b)){
            throw new Exception();
        } else {
            return a-b;
        }
    }

    public int del(String[] parts) throws Exception {
        a = parseInt(parts[0]);
        b = parseInt(parts[1]);
        if (checker(a,b)){
            throw new Exception();
        } else {
            return a/b;
        }
    }

    public int zv(String[] parts) throws Exception {
        a = parseInt(parts[0]);
        b = parseInt(parts[1]);
        if (checker(a,b)){
            throw new Exception();
        } else {
            return a*b;
        }
    }
    public boolean checker(int a, int b){
        return a <=0 || a > 10 || b <=0 || b > 10;
    }
    public boolean isRoman0(String[] parts) {
        for (Roman r0 : Roman.values()) {
            if (r0.name().equals(parts[0])) {
                return true;
            }
        }
        return false;
    }

    public boolean isRoman1(String[] parts) {
        for (Roman r1 : Roman.values()) {
            if (r1.name().equals(parts[1])) {
                return true;
            }
        }
        return false;
    }

    public int convertToArabic0(String[] parts) {
        Enum.valueOf(Roman.class, parts[0]);
        Roman roman0 = Roman.valueOf(Roman.class, parts[0]);
        return roman0.getArabic();
    }

    public int convertToArabic1(String[] parts) {
        Enum.valueOf(Roman.class, parts[1]);
        Roman roman1 = Roman.valueOf(Roman.class, parts[1]);
        return roman1.getArabic();
    }

    public String RomanPlus(String[] parts) throws Exception {
        int a = convertToArabic0(parts);
        int b = convertToArabic1(parts);
        if (!checker(a, b)) {
            int result = a + b;
            if (result > 0) {
                for (Roman roman : Roman.values()) {
                    if (roman.getArabic() == result) {
                        return roman.name();
                    }
                }
            } else throw new Exception();
        }
        throw new Exception();
    }
    public String RomanMinus(String[] parts) throws Exception {
        int a = convertToArabic0(parts);
        int b = convertToArabic1(parts);
        if (!checker(a, b)) {
            int result = a - b;
            if (result > 0) {
                for (Roman roman : Roman.values()) {
                    if (roman.getArabic() == result) {
                        return roman.name();
                    }
                }
            } else throw new Exception();
        }
        throw new Exception();
    }

    public String RomanZv(String[] parts) throws Exception {
        int a = convertToArabic0(parts);
        int b = convertToArabic1(parts);
        if (!checker(a, b)) {
            int result = a * b;
            if (result > 0) {
                for (Roman roman : Roman.values()) {
                    if (roman.getArabic() == result) {
                        return roman.name();
                    }
                }
            } else throw new Exception();
        }
        throw new Exception();
    }

    public String RomanDel(String[] parts) throws Exception {
        int a = convertToArabic0(parts);
        int b = convertToArabic1(parts);
        if (!checker(a, b)) {
            int result = a / b;
            if (result > 0) {
                for (Roman roman : Roman.values()) {
                    if (roman.getArabic() == result) {
                        return roman.name();
                    }
                }
            } else throw new Exception();
        }
        throw new Exception();
    }
}
enum Roman {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10),
    XI(11), XII(12), XIII(13), XIV(14), XV(15),
    XVI(16), XVII(17), XVIII(18), XIX(19), XX(20),
    XXX(30), XL(40), L(50), LX(60), LXX(70), LXXX(80), XC(90), C(100);

    private final int arabic;

    Roman(int arabic) {
        this.arabic = arabic;
    }

    public int getArabic() {
        return arabic;
    }
}