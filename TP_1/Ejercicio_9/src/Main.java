import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        CheckPalindromo ck = new CheckPalindromo();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String palabra;
        char c = 1;
        try{
            while (c != 0){
                System.out.println("ingrese una palabra para determinar si es un palindromo");
                palabra = entrada.readLine();
                if (ck.checkPalindromo(palabra)){
                    System.out.println(palabra.toUpperCase() + " es un palindromo");
                }
                else{
                    System.out.println(palabra.toUpperCase() + " NO es un palindromo");
                }
                System.out.println("Ingrese 0 para salir, cualquier otro caracter para continuar");
                c = entrada.readLine().charAt(0);
                if (c == '0'){
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
