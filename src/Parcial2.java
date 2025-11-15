import java.util.Scanner;
//cd 192622 Skarik Barbosa
public class Parcial2 {

    
    private static final int MIN_N = 5;
    private static final int MAX_N = 50;

    public static int[] leerArreglo(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] arreglo = new int[n];
        
        System.out.println("Ingresar " + n + " numeros");

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento [" + i + "] ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida");
                scanner.next();
            }
            arreglo[i] = scanner.nextInt();
        }
        
        return arreglo;
    }
    
    
    public static int[] sumaElementoElemento(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return null;
        }

        int n = a.length;
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i];
        }

        return c;
    }


    public static int productoEscalar(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return -1;
        }

        int n = a.length;
        int producto = 0;

        for (int i = 0; i < n; i++) {
            producto += a[i] * b[i];
        }

        return producto;
    }


   
    public static int rotacionDerechaDeAParaObtenerB(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length || a.length == 0) {
            if (a != null && b != null && a.length == 0) return 0; 
            return -1;
        }

        int n = a.length;

        for (int k = 0; k < n; k++) {
            boolean coincide = true;
            for (int i = 0; i < n; i++) {
                int indiceA = (i + n - k) % n;
                
                if (a[indiceA] != b[i]) {
                    coincide = false;
                    break; 
                }
            }

            if (coincide) {
                return k; 
            }
        }

        return -1; 
    }

    public static boolean mismosElementosComoMulticonjunto(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false; 
        }
        int n = a.length;
        if (n == 0) return true; 

        boolean[] usadoB = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean encontrado = false;
            for (int j = 0; j < n; j++) {
                if (!usadoB[j] && a[i] == b[j]) {
                    usadoB[j] = true; 
                    encontrado = true;
                    break; 
                }
            }

            if (!encontrado) {
                return false; 
            }
        }

        return true;
    }

 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        

        while (n < MIN_N || n > MAX_N) {
            System.out.print("Ingresar el tamaño de arreglo (" + MIN_N + " <= n <= " + MAX_N + "): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n < MIN_N || n > MAX_N) {
                    System.out.println("n debe estar entre " + MIN_N + " y " + MAX_N + ".");
                }
            } else {
                System.out.println("Entrada invalida. ");
                scanner.next(); 
            }
        }
        
        scanner.nextLine(); 

        int[] arregloA = leerArreglo(n);
        
        int[] arregloB = leerArreglo(n);

        
        int[] arregloSuma = sumaElementoElemento(arregloA, arregloB);
        if (arregloSuma != null) {
            System.out.print("Suma Elemento al x2 [");
            for (int i = 0; i < arregloSuma.length; i++) {
                System.out.print(arregloSuma[i] + (i < arregloSuma.length - 1 ? ", " : ""));
            }
            System.out.println("]");
        } else {
            System.out.println("Error de tamaño.");
        }

        int producto = productoEscalar(arregloA, arregloB);
        System.out.println(" Producto escalar: " + producto);

        int rotacion = rotacionDerechaDeAParaObtenerB(arregloA, arregloB);
        if (rotacion != -1) {
            System.out.println("El arreglo b se obtiene rotando a " + rotacion );
        } else {
            System.out.println("b NO es una rotación a la derecha de a ");
        }
        
        boolean multiconjunto = mismosElementosComoMulticonjunto(arregloA, arregloB);
        if (multiconjunto) {
            System.out.println("Son el mismo multiconjunto ");
        } else {
            System.out.println("NO son el mismo multiconjunto");
        }
        

        scanner.close();
    }
}

