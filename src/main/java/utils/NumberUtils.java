package utils;

public class NumberUtils {

    /**
     * Genera un numero aleatorio positivo con un tope maximo
     *
     * @param tope
     * @return numero aleatorio entero
     */
    public static int generarNumeroAleatorio(int tope) {
        return (int) (Math.random() * (double) tope);
    }
}
