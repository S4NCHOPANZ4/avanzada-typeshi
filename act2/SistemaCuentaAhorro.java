import java.util.Scanner;

class CuentaAhorro {
    private double saldoAhorro;                   
    private static double tasaInteresAnual;       

    public CuentaAhorro(double saldoInicial) {
        this.saldoAhorro = saldoInicial;
    }

    public void calcularInteresMensual() {
        double interesMensual = (saldoAhorro * tasaInteresAnual) / 12;
        saldoAhorro += interesMensual;
    }

    public static void modificaTasaInteres(double nuevaTasa) {
        tasaInteresAnual = nuevaTasa;
    }

    public double getSaldoAhorro() {
        return saldoAhorro;
    }

    public static double getTasaInteresAnual() {
        return tasaInteresAnual;
    }

    public void mostrarInformacion() {
        System.out.printf("Saldo actual: $%.2f\n", saldoAhorro);
        System.out.printf("Tasa de interés anual: %.1f%%\n", tasaInteresAnual * 100);
        System.out.println("------------------------");
    }
}

public class SistemaCuentaAhorro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA CUENTA DE AHORRO ===");
            System.out.println("1. Ejecutar con valores del enunciado (200000 y 300000)");
            System.out.println("2. Ingresar valores personalizados (solo enteros)");
            System.out.println("3. Salir");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    ejecutarEjercicio(200000.0, 300000.0);
                    break;
                case 2:
                    int s1 = leerEntero(sc, "Ingrese el saldo inicial del Ahorrador 1 (entero): ");
                    int s2 = leerEntero(sc, "Ingrese el saldo inicial del Ahorrador 2 (entero): ");
                    ejecutarEjercicio((double)s1, (double)s2);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema... ¡Gracias!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }

        } while (opcion != 3);

        sc.close();
    }

    private static int leerEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine(); 
                return valor;
            } else {
                System.out.println("Ingrese un número entero.");
                sc.nextLine(); 
            }
        }
    }

    private static void ejecutarEjercicio(double saldo1, double saldo2) {
        CuentaAhorro ahorrador1 = new CuentaAhorro(saldo1);
        CuentaAhorro ahorrador2 = new CuentaAhorro(saldo2);

        CuentaAhorro.modificaTasaInteres(0.04);

        ahorrador1.calcularInteresMensual();
        ahorrador2.calcularInteresMensual();

        System.out.println("\n=== SALDOS DESPUÉS DE 1 MES (4%) ===");
        System.out.println("Ahorrador 1:");
        ahorrador1.mostrarInformacion();
        System.out.println("Ahorrador 2:");
        ahorrador2.mostrarInformacion();

        CuentaAhorro.modificaTasaInteres(0.05);

        ahorrador1.calcularInteresMensual();
        ahorrador2.calcularInteresMensual();

        System.out.println("=== SALDOS DESPUÉS DE 2 MESES (ahora al 5%) ===");
        System.out.println("Ahorrador 1:");
        ahorrador1.mostrarInformacion();
        System.out.println("Ahorrador 2:");
        ahorrador2.mostrarInformacion();
    }
}
