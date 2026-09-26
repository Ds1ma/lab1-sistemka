import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Process> procs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Приложение: ");
            Process p = new ProcessBuilder(sc.nextLine().trim()).start();
            procs.add(p);
            System.out.println("PID: " + p.pid());
        }
        System.out.println("\nСписок PID:");
        for (Process p : procs) System.out.println(p.pid());
        for (Process p : procs) {
            System.out.print("Завершить " + p.pid() + "? (да/нет): ");
            if (sc.nextLine().trim().equalsIgnoreCase("да")) {
                p.destroyForcibly();
                System.out.println("Завершён");
            }
        }
    }
}