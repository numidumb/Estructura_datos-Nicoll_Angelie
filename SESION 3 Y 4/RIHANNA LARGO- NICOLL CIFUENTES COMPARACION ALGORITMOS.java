import java.util.Arrays;
import java.util.Random;

public class ComparacionAlgoritmos {

    // O(1)
    static int primerElemento(int[] a) {
        return a[0];
    }

    // O(log n)
    static int busquedaBinaria(int[] a, int objetivo) {
        int ini = 0, fin = a.length - 1;
        while (ini <= fin) {
            int mid = (ini + fin) / 2;
            if (a[mid] == objetivo) return mid;
            if (a[mid] < objetivo) ini = mid + 1;
            else fin = mid - 1;
        }
        return -1;
    }

    // O(n)
    static int busquedaLineal(int[] a, int objetivo) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == objetivo) return i;
        }
        return -1;
    }

    // O(n log n)
    static void mergeSort(int[] a) {
        if (a.length < 2) return;
        int mid = a.length / 2;
        int[] izq = Arrays.copyOfRange(a, 0, mid);
        int[] der = Arrays.copyOfRange(a, mid, a.length);
        mergeSort(izq);
        mergeSort(der);
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            a[k++] = (izq[i] <= der[j]) ? izq[i++] : der[j++];
        }
        while (i < izq.length) a[k++] = izq[i++];
        while (j < der.length) a[k++] = der[j++];
    }

    // O(n^2)
    static void burbuja(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }


    static int[] generar(int n) {
        Random r = new Random(42);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(n * 10);
        return a;
    }

    public static void main(String[] args) {
        int[] tamanos = {1000, 5000, 10000, 20000, 50000};

        System.out.println("Comparacion: Burbuja O(n^2) vs Merge Sort O(n log n)");
        System.out.printf("%-10s %-20s %-20s%n", "n", "Burbuja (ms)", "MergeSort (ms)");

        for (int n : tamanos) {
            int[] base = generar(n);

            int[] c1 = base.clone();
            long t1 = System.nanoTime();
            burbuja(c1);
            double msBurbuja = (System.nanoTime() - t1) / 1_000_000.0;

            int[] c2 = base.clone();
            long t2 = System.nanoTime();
            mergeSort(c2);
            double msMerge = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.printf("%-10d %-20.3f %-20.3f%n", n, msBurbuja, msMerge);
        }

        System.out.println();
        System.out.println("Bonus: Busqueda lineal O(n) vs binaria O(log n)");
        System.out.printf("%-10s %-20s %-20s%n", "n", "Lineal (ns)", "Binaria (ns)");

        for (int n : tamanos) {
            int[] a = generar(n);
            Arrays.sort(a);
            int objetivo = a[n - 1]; // peor caso para la lineal

            long t1 = System.nanoTime();
            busquedaLineal(a, objetivo);
            long nsLineal = System.nanoTime() - t1;

            long t2 = System.nanoTime();
            busquedaBinaria(a, objetivo);
            long nsBinaria = System.nanoTime() - t2;

            System.out.printf("%-10d %-20d %-20d%n", n, nsLineal, nsBinaria);
        }
    }
}
