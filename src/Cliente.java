import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    private Cliente() {}
    public static void main(String[] args) {
	String host = (args.length < 1) ? null : args[0];
	try {
	    Registry registry = LocateRegistry.getRegistry(host);	
            //también puedes usar getRegistry(String host, int port)
            Calculadora stub = (Calculadora) registry.lookup("Calculadora");
            float x,y,result;
            int opc=0;
            Scanner sc = new Scanner(System.in);
            while (opc<5) {
                System.out.println("\nT 3.2 Calculadora distribuida con RMI");
                System.out.println("Seleccione la opción a realizar:");
                System.out.println("1. Suma\n2. Resta\n3.Multiplicacion\n4.Division\n5.Salir");
                opc = sc.nextInt();
                System.out.println("Escriba el numero 1:");
                x = sc.nextFloat();
                System.out.println("Escriba el numero 2:");
                y = sc.nextFloat();
                switch (opc) {
                    case 1:
                        result = stub.suma(x, y);
                        System.out.println("El resultado de la suma de " + x + "+" + y + " es: " + result +  "\n");                    
                        break;
                    case 2:
                        result = stub.resta(x, y);
                        System.out.println("El resultado de la resta de " + x + "-" + y + " es: " + result +  "\n");                    
                        break;
                    case 3:
                        result = stub.multiplicacion(x, y);
                        System.out.println("El resultado de la multiplicacion de " + x + "*" + y + " es: " + result +  "\n");                    
                        break;
                    case 4:
                        result = stub.division(x, y);
                        System.out.println("El resultado de la division de " + x + "/" + y + " es: " + result +  "\n");                    
                        break;
                    default:
                        break;
                }
            }
            


        } catch (Exception e) {
            System.err.println("Excepción del cliente: " +
                             e.toString());
            e.printStackTrace();
        }
        }
    }
    