/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorapolacainversa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author estudiantes
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int z=0;
        Scanner sc = new Scanner(System.in);
        int numeroDatos = sc.nextInt(); //Lee la siguiente linea ingresada como los datos a operar
        System.out.println("Numeros:");
        String[] datos = new String[(numeroDatos*2)-1];
        for (int x=0;x<numeroDatos;x++){
           datos[x] = Integer.toString((int) (Math.random()*20)+1);
           z++;
           
           System.out.print(datos[x]+",");
        }
        System.out.println("");
        System.out.println("Operadores:");
        String[] Op = {"+", "-", "*","/"};
        for (int i = z; i < (numeroDatos*2)-1; i++) {
          datos[i] = Op[(int) (Math.random() * 4)];    
          
          System.out.print(datos[i]+",");
            
        }
        System.out.println("");
        int k = 0;

        for (String dato : datos) {
            if (dato.matches("[0-9]+")) {
                k++;
            }
        }
        //Crea el array de numeros, donde unicamente estaran los numeros aparte de las operaciones
        double[] numeros = new double[k];
        k = 0; //Se crea una variable que llevara la cuenta del espacio donde se encuentra actualmente el ultimo numero del array de numeros en revision
        for (String dato : datos) { //Se procede a revisar espacio por espacio del vector
            if (dato.matches("[0-9]+")) { //Si se encuentra un numero lo mete al array de numeros
                numeros[k] = Integer.valueOf(dato);
                k++;
            }
            /*Si se encuentra un operador, toma los dos valores numericos anteriores, realiza la operacion
            y devuelve el apuntador de posicion k una posicion hacia atras (Teniendo en cuenta que al hacer
            una operacion desaparece el ultimo numero del vector)*/
            switch (dato) {
                case "+":
                    numeros[k - 2] = numeros[k - 2] + numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    break;
                case "-":
                    numeros[k - 2] = numeros[k - 2] - numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    break;
                case "*":
                    numeros[k - 2] = numeros[k - 2] * numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    break;
                case "/":
                    numeros[k - 2] = numeros[k - 2] / numeros[k - 1];
                    numeros[k - 1] = 0;
                    k--;
                    break;
                default: //Caera a default si el valor de dicho espacio en el vector es un numero
                    break;
            }
        }
        //Imprime el valor del primer espacio del array de numeros, que, al acabar el proceso, deberia ser el unico numero existente del vector
        System.out.print("Resultado:\n");
        if (numeros.length != datos.length - (numeros.length - 1)) {
            System.out.print("[");
            for (int j = 0; j < k; j++) {
                System.out.print(numeros[j]);
                if (j!=k-1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println(numeros[0]);
        }
    }
}
