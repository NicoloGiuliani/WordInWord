//passo 1: estrarre una parola in maniera casuale, 
//visualizzarla all'utente e chiedere di inserire la sua risposta. 
//Mostrare se la risposta è esatta o errata (utilizzare la funzione indexOf delle stringhe)

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner input = new Scanner(System.in);
        Random r= new Random();
        
        String[] parole = {"mare", "sole", "mani", "pane", "raga", "aria", "fata", "demo", "mela", "fila"};
        String parola = parole[r.nextInt(10)];
        
        System.out.println("Inserisci una parola che contiene: "+parola);
        
        String parolaUtente=input.nextLine();
        
        //indexOf restistuisce la posizione della parolaUtente all'interno di parola, oppure -1 se non è contenuta
        if (parolaUtente.indexOf(parola)>=0 && !parolaUtente.equals(parola))
            System.out.println(parolaUtente+ " è contenuta");
        else
            System.out.println("non è contenuta");

        input.close();
    }
}
