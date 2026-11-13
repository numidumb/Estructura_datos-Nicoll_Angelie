public class comparacionAlgoritmos {
    public static void main(String[] args) {
        int[] tamanos = {100, 1_000, 5_000, 10_000};

        System.out.println("n\tO(n) ns\t\tO(n²) ns\tO(log n) ns\tO(n log n) ns");

        for (int n : tamanos) {
            // O(n)
            long inicioLineal = System.nanoTime();
            algoritmoLineal(n);
            long tiempoLineal = System.nanoTime() - inicioLineal;

            // O(n²)
            long inicioCuadratico = System.nanoTime();
            algoritmoCuadratico(n);
            long tiempoCuadratico = System.nanoTime() - inicioCuadratico;

            // O(log n)
            long inicioLog = System.nanoTime();
            algoritmoLogaritmico(n);
            long tiempoLog = System.nanoTime() - inicioLog;

            // O(n log n)
            long inicioNLogN = System.nanoTime();
            algoritmoNLogN(n);
            long tiempoNLogN = System.nanoTime() - inicioNLogN;

            System.out.println(
                n + "\t" + tiempoLineal + "\t\t" + tiempoCuadratico + "\t" + tiempoLog + "\t\t" + tiempoNLogN
            );
        }
    }

    public static long algoritmoLineal(int n) {
        long contador = 0;
        for (int i = 0; i < n; i++) {
            contador++;
        }
        return contador;
    }

    public static long algoritmoCuadratico(int n) {
        long contador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                contador++;
            }
        }
        return contador;
    }

    // O(log n): divide entre 2 hasta llegar a 1
    public static long algoritmoLogaritmico(int n) {
        long contador = 0;
        int j = n;
        while (j > 1) {
            j = j / 2;
            contador++;
        }
        return contador;
    }

    // O(n log n): ciclo de n vueltas, y dentro una reducción a la mitad
    public static long algoritmoNLogN(int n) {
        long contador = 0;
        for (int i = 0; i < n; i++) {
            int j = n;
            while (j > 1) {
                j = j / 2;
                contador++;
            }
        }
        return contador;
    }
}
