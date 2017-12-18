import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter level:");
        String level = scanner.nextLine();

        System.out.println(level);
        KochFractal fractal = new KochFractal();
        fractal.setLevel(Integer.valueOf(level));
    }
}
