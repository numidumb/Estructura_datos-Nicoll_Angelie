public class Main {

    public static void main(String[] args) {

        int semestre = 3;
        double notaMinima = 3.0;
        boolean activo = true;

        
        Estudiante estudiante1 =
                new Estudiante("Laura", 20, 4.2);

        Estudiante estudiante2 =
                new Estudiante("Carlos", 22, 3.8);


        Estudiante copia = estudiante1;
        copia.setPromedio(4.8);

        System.out.println("Promedio estudiante1: "
                + estudiante1.getPromedio());
        System.out.println("Promedio copia: "
                + copia.getPromedio());

        procesarEstudiante(estudiante2);

        estudiante1 = null;
        copia = null;

        System.gc();

        System.out.println("Programa finalizado.");

        retoProductos();
    }

    public static void procesarEstudiante(Estudiante estudiante) {
        int puntosExtra = 1;
        double nuevoPromedio = estudiante.getPromedio() + 0.2;
        estudiante.setPromedio(nuevoPromedio);
        estudiante.mostrarDatos();
        System.out.println("Puntos extra: " + puntosExtra);
    }

    public static void retoProductos() {
        System.out.println("\n--- Reto: Productos ---");

        Producto producto1 = new Producto(101, "Portátil", 2500000);
        Producto producto2 = new Producto(102, "Mouse", 45000);
        Producto producto3 = new Producto(103, "Teclado", 120000);

        Producto alias = producto1;

        alias.setPrecio(2300000);

        System.out.println("Precio vía producto1: " + producto1.getPrecio());
        System.out.println("Precio vía alias:     " + alias.getPrecio());

        actualizarPrecio(producto2, 5000);
        producto2.mostrarDatos();
        producto3.mostrarDatos();

        producto1 = null;
        alias = null;

        System.gc();
        System.out.println("Producto 1 sin referencias alcanzables.");
    }

    public static void actualizarPrecio(Producto producto, double aumento) {
        double precioAnterior = producto.getPrecio();
        double nuevoPrecio = precioAnterior + aumento;
        producto.setPrecio(nuevoPrecio);
        System.out.println("Precio actualizado: " + precioAnterior
                + " -> " + nuevoPrecio);
    }
}
