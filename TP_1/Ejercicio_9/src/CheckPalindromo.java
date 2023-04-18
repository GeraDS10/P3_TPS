public class CheckPalindromo {

    public CheckPalindromo(){

    }

    public boolean checkPalindromo(String uno){
        int i = 0;
        char inicio = 0;
        int posInicio = 0;
        char fin = 0;
        int posFin = uno.length() -1;
        while (( i < uno.length() / 2 )&&(inicio == fin)){
            inicio = uno.charAt(posInicio);
            fin = uno.charAt(posFin);
            posInicio ++;
            posFin --;
            i++;
        }
        if (inicio == fin){
            return true;
        }
        else {
            return false;
        }
    }
}
