// passo 2: mostrare il turno e il giocatore corrente.
//Per ogni turno devono giocare entrambi i giocatori. Ripetere per 5 turni

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        String[] parole = { "mare", "sole", "mani", "pane", "raga", "aria", "fata", "demo", "mela", "fila" };
        String parola = "";
        int turni = 5;
        String parolaUtente="";

        for (int i = 0; i < turni; i++) 
        {
            System.out.println("Turno "+(i+1)+" giocatore 1");
            parola = parole[r.nextInt(10)];

            System.out.println("Inserisci una parola che contiene: " + parola);

            parolaUtente = input.nextLine();

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola))
                System.out.println("è contenuta");
            else
                System.out.println("non è contenuta");

            System.out.println("Turno "+(i+1)+" giocatore 2");
            parola = parole[r.nextInt(10)];
    
            System.out.println("Inserisci una parola che contiene: " + parola);
    
            parolaUtente = input.nextLine();

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola))
                System.out.println("è contenuta");
            else
                System.out.println("non è contenuta");

        }

        

        input.close();
    }
}