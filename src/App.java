//passo 5: calcolare il tempo impiegato da un giocatore per dare la risposta.
//Utilizzare l' istruzione System.currentTimeMillis come nel seguente esempio:

import java.util.ArrayList;
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
        ArrayList <String> giocatore1=new ArrayList<>();
        ArrayList <String> giocatore2=new ArrayList<>();

        for (int i = 0; i < turni; i++) 
        {
            System.out.println("Turno "+(i+1)+" giocatore 1");
            parola = parole[r.nextInt(10)];

            System.out.println("Inserisci una parola che contiene: " + parola);

            long inizioTempoMillisecondi = System.currentTimeMillis();

            parolaUtente = input.nextLine();

            long fineTempoMillisecondi = System.currentTimeMillis();

            long secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);

            String[] pezziParola=parolaUtente.split(" ");
            if (pezziParola.length>1) 
            {
                System.out.println("Devi inserire una parola unica");
            }

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola) && pezziParola.length==1)
            {
                System.out.println("è contenuta");
                giocatore1.add(parolaUtente);
            }
            else
                System.out.println("non è contenuta");

            System.out.println("Turno "+(i+1)+" giocatore 2");
            parola = parole[r.nextInt(10)];
    
            System.out.println("Inserisci una parola che contiene: " + parola);
            
            inizioTempoMillisecondi = System.currentTimeMillis();

            parolaUtente = input.nextLine();

            fineTempoMillisecondi = System.currentTimeMillis();

            secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);   
            
            if (pezziParola.length>1) 
            {
                System.out.println("Devi inserire una parola unica");
            }

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola) && pezziParola.length==1)
            {
                System.out.println("è contenuta");
                giocatore2.add(parolaUtente);
            }
            else
                System.out.println("non è contenuta");
        }
        if (giocatore1.size()>giocatore2.size()) 
        {
            System.out.println("Ha vinto il giocatore 1 "+giocatore1.size()+" a "+giocatore2.size());
        }
        else if (giocatore2.size()>giocatore1.size()) 
        {
            System.out.println("Ha vinto il giocatore 2 "+giocatore2.size()+" a "+giocatore1.size());
        }
        else System.out.println("Pareggio "+giocatore2.size()+" a "+giocatore1.size());
        input.close();
    }
}