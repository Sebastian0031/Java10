import java.util.Scanner;

public class MaquinaExpendedora {
    static String[] productos = {"Coca Cola", "Agua", "Snacks", "Chicles"};
    static double[] precios = {3000, 2500, 500, 250};
    static int[] cantidades = {5, 5, 5, 5};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            System.out.print("Ingrese el nombre del producto (o 'salir' para terminar): ");
            String productoSeleccionado = scanner.nextLine();
            if (productoSeleccionado.equalsIgnoreCase("salir")) {
                break;
            }
            int indiceProducto = seleccionarProducto(productoSeleccionado);
            if (indiceProducto != -1) {
                System.out.print("Ingrese la cantidad de dinero: ");
                double dineroIngresado = scanner.nextDouble();
                scanner.nextLine();
                if (verificarPago(indiceProducto, dineroIngresado)) {
                    entregarProducto(indiceProducto);
                    double cambio = calcularCambio(indiceProducto, dineroIngresado);
                    System.out.printf("Cambio devuelto: %.2f\n", cambio);
                } else {
                    System.out.println("Pago insuficiente. Intente de nuevo.");
                }
            } else {
                System.out.println("Producto no disponible.");
            }
        }
        scanner.close();
    }
    static void mostrarMenu() {
        System.out.println("Menú de Productos:");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%s - Precio: %.2f (Cantidad disponible: %d)\n", productos[i], precios[i], cantidades[i]);
        }
    }

    static int seleccionarProducto(String nombreProducto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].equalsIgnoreCase(nombreProducto)) {
                return i;
            }
        }
        return -1;
    }
    static boolean verificarPago(int indice, double dinero) {
        return dinero >= precios[indice];
    }
    static double calcularCambio(int indice, double dinero) {
        return dinero - precios[indice];
    }

    static void entregarProducto(int indice) {
        if (cantidades[indice] > 0) {
            cantidades[indice]--;
            System.out.printf("Producto entregado: %s\n", productos[indice]);
        } else {
            System.out.println("No hay stock disponible para este producto.");
        }
    }
}