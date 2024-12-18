//passo 6: verificare che la parola inserita dall'utente sia esistente.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Random r = new Random();

        String nomeFile = "280000_parole_italiane.txt";

        ArrayList<String> paroleAmmesse = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(nomeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String riga;

            while ((riga = bufferedReader.readLine()) != null)
                paroleAmmesse.add(riga.trim());

            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }

        String[] parole = { "mare", "sole", "mani", "pane", "raga", "aria", "fata", "demo", "mela", "fila" };
        String parola = "";
        int turni = 5;
        String parolaUtente = "";
        ArrayList<String> giocatore1 = new ArrayList<>();
        ArrayList<String> giocatore2 = new ArrayList<>();

        for (int i = 0; i < turni; i++) {
            System.out.println("Turno " + (i + 1) + " giocatore 1");
            parola = parole[r.nextInt(10)];

            System.out.println("Inserisci una parola che contiene: " + parola);

            long inizioTempoMillisecondi = System.currentTimeMillis();

            parolaUtente = input.nextLine();

            long fineTempoMillisecondi = System.currentTimeMillis();

            long secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);

            String[] pezziParola = parolaUtente.split(" ");

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola) && pezziParola.length == 1 && paroleAmmesse.indexOf(parolaUtente)>=0) {
                System.out.println("è contenuta");
                giocatore1.add(parolaUtente);
            } else if (pezziParola.length > 1) {
                System.out.println("Devi inserire una parola unica");
            }
            else if (paroleAmmesse.indexOf(parolaUtente)<0) {
                System.out.println("Parola non esistente");
            }
            else if (parolaUtente.equals(parola)) {
                System.out.println("Non puoi inserire la stessa parola");
            } else System.out.println("Parola non valida");

            System.out.println("Turno " + (i + 1) + " giocatore 2");
            parola = parole[r.nextInt(10)];

            System.out.println("Inserisci una parola che contiene: " + parola);

            inizioTempoMillisecondi = System.currentTimeMillis();

            parolaUtente = input.nextLine();

            fineTempoMillisecondi = System.currentTimeMillis();

            secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);
            
            pezziParola = parolaUtente.split(" ");

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola) && pezziParola.length == 1 && paroleAmmesse.indexOf(parolaUtente)>=0) {
                System.out.println("è contenuta");
                giocatore2.add(parolaUtente);
            } else if (pezziParola.length > 1) {
                System.out.println("Devi inserire una parola unica");
            }
            else if (paroleAmmesse.indexOf(parolaUtente)<0) {
                System.out.println("Parola non esistente");
            }
            else if (parolaUtente.equals(parola)) {
                System.out.println("Non puoi inserire la stessa parola");
            } else System.out.println("Parola non valida");
        }
        if (giocatore1.size() > giocatore2.size()) {
            System.out.println("Ha vinto il giocatore 1 " + giocatore1.size() + " a " + giocatore2.size());
        } else if (giocatore2.size() > giocatore1.size()) {
            System.out.println("Ha vinto il giocatore 2 " + giocatore2.size() + " a " + giocatore1.size());
        } else
            System.out.println("Pareggio " + giocatore2.size() + " a " + giocatore1.size());
        input.close();
    }
}