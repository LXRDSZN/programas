import java.util.Scanner;

public class mezcla {
    public void mezcla() {
        // Definimos el tamaño del arreglo
        Scanner sc = new Scanner(System.in);
        System.out.print("┌─[Define La Cantidad De Numeros Que Tendra La Lista]─[~]\n└──╼  ");
        int arraySize = sc.nextInt();
        // Inicio del arreglo
        int[] numeros = new int[arraySize];
        // Definicion de los numeros del arreglo
        System.out.print("┌─[Define Los Numeros del arreglo]─[~]\n└──╼  ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        // Mostramos el arreglo original en una sola línea con formato
        System.out.println("=========================================================");
        System.out.println("               L I S T A   O R I G I N A L               ");
        System.out.print("\n[");
        for (int i = 0; i < numeros.length; i++) {
        System.out.print(numeros[i]);

        // Imprimir espacio después de cada número (excepto el último)
        if (i < numeros.length - 1) {
        System.out.print(" ");
            }
        }
        System.out.println("]");
        //inicio de ordenamiento del la lista por el algoritmo de mezca directa
        System.out.println("\n=========================================================");
        System.out.println("               L I S T A   O R D E N A D A               "); 
       // Llamada al método mergeSort para ordenar el arreglo
       mergeSort(numeros);

       // Mostrar el arreglo ordenado
       System.out.print("\n[");
       for (int i = 0; i < numeros.length; i++) {
           System.out.print(numeros[i]);
           
           if (i < numeros.length - 1) {
               System.out.print(" ");
           }
       }
       System.out.println("]");


    }

 
    // Método para implementar el algoritmo de mezcla directa (merge sort)
    public static void mergeSort(int[] numeros) {
        if (numeros.length > 1) {
             // División del arreglo
            int mid = numeros.length / 2;
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[numeros.length - mid];
            System.arraycopy(numeros, 0, leftHalf, 0, mid);
            System.arraycopy(numeros, mid, rightHalf, 0, numeros.length - mid);
            // Paso 2: Ordenación recursiva
            mergeSort(leftHalf);
            mergeSort(rightHalf);
            // Paso 3: Mezcla
            merge(numeros, leftHalf, rightHalf);
        }
    }

    // Método para combinar dos arreglos ordenados en uno solo
    public static void merge(int[] numeros, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                numeros[k] = left[i];
                i++;
            } else {
                numeros[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            numeros[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            numeros[k] = right[j];
            j++;
            k++;
        }
    }
}