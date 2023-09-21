package EjercicioHerencia;
// Interfaz para la base de la paleta
interface BasePaleta {
    void mostrarBase();
    void nuevoPrecio();
}

// Clase abstracta base para todas las paletas
abstract class Paleta implements BasePaleta {
    protected String sabor;
    protected double precio;
    protected boolean base;

    public Paleta(String sabor, double precio, boolean base) {
        this.sabor = sabor;
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
        this.base = base;
    }

    public void mostrarInformacion() {
        System.out.println("Sabor: " + sabor + ", precio: $" + precio);
    }

    public void paletaGrandeOChica() {
        if (precio <= 15) {
            System.out.println("Es una paleta chica.");
        } else {
            System.out.println("Es una paleta grande.");
        }
    }
}

// Clase para paletas de agua
class PaletaAgua extends Paleta {
    public PaletaAgua(String sabor, double precio, boolean base) {
        super(sabor, precio, base);
    }

    @Override
    public void mostrarBase() {
        System.out.println("Base de agua: " + (base ? "Si" : "No"));
    }

    @Override
    public void nuevoPrecio() {
        double nuevoPrecio = precio + 2;
        System.out.println("El nuevo precio es: $" + nuevoPrecio);
    }
}

// Clase para paletas de crema
class PaletaCrema extends Paleta {
    public PaletaCrema(String sabor, double precio, boolean base) {
        super(sabor, precio, base);
    }

    @Override
    public void mostrarBase() {
        System.out.println("Base de crema: " + (base ? "Si" : "No"));
    }

    @Override
    public void nuevoPrecio() {
        double nuevoPrecio = precio + 6;
        System.out.println("El nuevo precio es: $" + nuevoPrecio);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Paleta paleta1 = new PaletaAgua("Limon", 15, true);
            Paleta paleta2 = new PaletaCrema("Vainilla", 14, true);
            Paleta paleta3 = new PaletaAgua("Coco", 17, true);
            Paleta paleta4 = new PaletaCrema("Fresa", -16, true); // Intente con precio negativo

            paleta1.mostrarInformacion();
            paleta1.paletaGrandeOChica();
            paleta1.mostrarBase();
            paleta1.nuevoPrecio();

            System.out.println("-----------------------");
            paleta2.mostrarInformacion();
            paleta2.paletaGrandeOChica();
            paleta2.mostrarBase();
            paleta2.nuevoPrecio();

            System.out.println("-------------------------");
            paleta3.mostrarInformacion();
            paleta3.paletaGrandeOChica();
            paleta3.mostrarBase();
            paleta3.nuevoPrecio();

            System.out.println("---------------------------");
            paleta4.mostrarInformacion();
            paleta4.paletaGrandeOChica();
            paleta4.mostrarBase();
            paleta4.nuevoPrecio();
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}
