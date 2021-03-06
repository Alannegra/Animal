
/**
 * Clase CodeCracker: Contiene un metodo con el objetivo de eliminar la primera palabra indicada de un string.
 */
public class CodeCracker
{
    /**
     * Metodo recorte: Se encarga de recortar un string pasado por paramatero quitandole la palabra indicada por parametro
     * @param a Frase que deseamos recortar
     * @param b Palabra que deseamos quitar de la frase
     * @return Devuelve el String deseado sin la palabra indicada
     */
    public String recorte(String a, String b){
        String str, word;
        int strLen, wordLen, i, temp, j, k=0;

        //System.out.print("Enter the String: ");
        str = a;
       // System.out.print("Enter the Word to Remove: ");
        word = b;

        strLen = str.length();
        wordLen = word.length();

        char[] strChars = new char[strLen];
        char[] wordChars = new char[wordLen];

        strChars = str.toCharArray();
        wordChars = word.toCharArray();
        for(i=0; i<strLen; i++)
        {
            temp = i;
            for(j=0; j<wordLen; j++)
            {
                if(strChars[i]==wordChars[j])
                    i++;
            }
            k = i-temp;
            if(k==wordLen)
            {
                for(j=temp; j<(strLen-wordLen); j++)
                    strChars[j] = strChars[j+wordLen];
                strLen = strLen-wordLen;
            }
        }

        //System.out.print("\nThe new string is: ");
        String r = "";
        for(i=0; i<strLen; i++){
            r+=strChars[i];
            //System.out.print(strChars[i]);
        }
        return r;
    }
}
