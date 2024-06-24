import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner captura = new Scanner(System.in);
        float saldo = 250000.0f;
        int opcion;
        float cantidad;
        int pin = 1234;
        boolean z = true;
        int intentos = 0;
        int maximointentos = 3;

        do {
            System.out.print("Ingrese su PIN: ");
            int pinIngresado = captura.nextInt();
            intentos++;

            if (pinIngresado != pin) {
                if (intentos >= maximointentos) {
                    System.out.println("PIN incorrecto. Ha alcanzado el número máximo de intentos. Acceso bloqueado.");
                    return;
                } else {
                    System.out.println("PIN incorrecto. Intente de nuevo.");
                }
            } else {
                while (z) {
                    System.out.println("Bienvenido, por favor seleccione una de las siguientes opciones:");
                    System.out.println("1. Depositar dinero");
                    System.out.println("2. Retirar dinero");
                    System.out.println("3. Consultar saldo");
                    System.out.println("4. Realizar una donación");
                    System.out.println("5. Pagar un recibo");
                    System.out.println("6. Cancelar");

                    System.out.print("Seleccione una opción: ");
                    opcion = captura.nextInt();

                    if (opcion == 1) {
                        System.out.println("Vas a depositar dinero");
                        System.out.print("Ingresa la cantidad que quieres depositar: ");
                        cantidad = captura.nextFloat();
                        saldo += cantidad;
                        System.out.println("Has depositado" + cantidad);

                    } else if (opcion == 2) {
                        System.out.println("Vas a retirar dinero");
                        System.out.print("Ingresa la cantidad que quieres retirar: ");
                        cantidad = captura.nextFloat();
                        if (cantidad <= saldo) {
                            saldo -= cantidad;
                            System.out.println("Has retirado " + cantidad);
                        } else {
                            System.out.println("Saldo insuficiente. Tu saldo actual es: " + saldo);
                        }

                    } else if (opcion == 3) {
                        System.out.println("Tu saldo actual es: " + saldo);

                    } else if (opcion == 4) {
                        System.out.println("Vas a realizar una donación");
                        System.out.print("Ingresa la cantidad que quieres donar: ");
                        cantidad = captura.nextFloat();
                        if (cantidad <= saldo) {
                            saldo -= cantidad;
                            System.out.println("Has donado " + cantidad);
                        } else {
                            System.out.println("Saldo insuficiente para donar. Tu saldo actual es: " + saldo);
                        }

                    } else if (opcion == 5) {
                        System.out.println("Que recibo quieres pagar");
                        System.out.println("1.Luz");
                        System.out.println("2.Agua");
                        System.out.println("3.Gas");
                        opcion = captura.nextInt();
                        System.out.print("Ingresa la cantidad a pagar del recibo: ");
                        cantidad = captura.nextFloat();
                        if (cantidad <= saldo) {
                            saldo -= cantidad;
                            System.out.println("Has pagado un recibo de " + cantidad);
                        } else {
                            System.out.println("Saldo insuficiente para pagar el recibo. Tu saldo actual es: " + saldo);
                        }

                    } else if (opcion == 6) {
                        System.out.println("Hasta luego");
                        z = false;
                    } else {
                        System.out.println("Opción no válida. Por favor seleccione una opción del 1 al 6.");
                    }
                }
            }
        } while (z);
    }
}
