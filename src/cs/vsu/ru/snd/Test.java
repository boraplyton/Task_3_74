package cs.vsu.ru.snd;

import java.util.Locale;
import java.util.Scanner;

public class Test {

    public static final HorizontalParabola HP = new HorizontalParabola(2, 3, 1);

    public static final VerticalParabola VPL = new VerticalParabola(-6, 0 , -0.5);

    public static final VerticalParabola VPU = new VerticalParabola(-3, -6, 0.125);

    public static SimpleColor getColor(double x, double y){
        if (VPU.inParabola(x, y) && (HP.isPointRightOfParabola(x, y) || !VPL.inParabola(x,y))){
            return SimpleColor.WHITE;
        }
        if (!VPL.inParabola(x,y) && !VPU.inParabola(x,y)){
            return SimpleColor.BLUE;
        }
        if (VPL.inParabola(x,y) && !VPU.inParabola(x,y) && x < -8){
            return SimpleColor.GRAY;
        }
        if (!HP.isPointRightOfParabola(x,y) && !VPU.inParabola(x,y) && y > 5){
            return SimpleColor.GREEN;
        }
        return SimpleColor.ORANGE;
    }
    public static void printColorForPoint(double x, double y){
        System.out.printf("(%.3f, %.3f) -> %s%n", x, y, getColor(x, y));
    }
    public static void test(){
        printColorForPoint(-1, -1); // ORANGE
        printColorForPoint(5, 3); // WHITE
        printColorForPoint(-6, -2); // WHITE
        printColorForPoint(5, -5); // ORANGE
        printColorForPoint(8, 6); // GREEN
        printColorForPoint(-6, -10); // BLUE
        printColorForPoint(8, 3); // ORANGE
        printColorForPoint(-10, -2); // GRAY
        printColorForPoint(-6, 0); // WHITE or ORANGE
        printColorForPoint(-3, -6); // WHITE or BLUE
        printColorForPoint(2, 3); // ORANGE or WHITE
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        test();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите х");
        double x = scanner.nextDouble();

        System.out.println("Введите y");
        double y = scanner.nextDouble();

        printColorForPoint(x, y);
    }
}