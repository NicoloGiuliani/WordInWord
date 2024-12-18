//passo 7: verificare che la parola inserita dall'utente non sia già stata data precedentemente

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
        int tempoTotaleGiocatore1 = 0;
        int tempoTotaleGiocatore2 = 0;
        System.out.println("Inserisci il nome del primo giocatore");
        String nomeGiocatore1 = input.nextLine();
        System.out.println();
        System.out.println("Inserisci il nome del secondo giocatore");
        String nomeGiocatore2 = input.nextLine();

        for (int i = 0; i < turni; i++) {
            System.out.println("Turno " + (i + 1) +" "+nomeGiocatore1);
            parola = parole[r.nextInt(10)];

            System.out.println("Inserisci una parola che contiene: " + parola);

            long inizioTempoMillisecondi = System.currentTimeMillis();

            parolaUtente = input.nextLine();

            long fineTempoMillisecondi = System.currentTimeMillis();

            long secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);
            tempoTotaleGiocatore1+=secondiTrascorsi;

            String[] pezziParola = parolaUtente.split(" ");

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola) && pezziParola.length == 1 && paroleAmmesse.indexOf(parolaUtente)>=0 && !(giocatore2.contains(parolaUtente)) && !(giocatore1.contains(parolaUtente)) && secondiTrascorsi<=10) {
                System.out.println("è contenuta");
                giocatore1.add(parolaUtente);
            } else if (pezziParola.length > 1) {
                System.out.println("Devi inserire una parola unica");
            }
            else if (parolaUtente.equals(parola)) {
                System.out.println("Non puoi inserire la stessa parola");
            }
            else if (paroleAmmesse.indexOf(parolaUtente)<0) {
                System.out.println("Parola non esistente");
            }
            else if ((giocatore2.contains(parolaUtente)) || (giocatore1.contains(parolaUtente))) {
                System.out.println("Parola già inserita");
            }
            else if (secondiTrascorsi>10) {
                System.out.println("Tempo scaduto, hai massimo 10 secondi");
            }
            else System.out.println("Parola non valida");
            
            System.out.println();
            System.out.println("Turno " + (i + 1) +" "+nomeGiocatore2);
            parola = parole[r.nextInt(10)];

            System.out.println("Inserisci una parola che contiene: " + parola);

            inizioTempoMillisecondi = System.currentTimeMillis();

            parolaUtente = input.nextLine();

            fineTempoMillisecondi = System.currentTimeMillis();

            secondiTrascorsi = (fineTempoMillisecondi - inizioTempoMillisecondi) / 1000;
            
            System.out.println("Secondi trascorsi: " + secondiTrascorsi);
            tempoTotaleGiocatore2+=secondiTrascorsi;
            
            pezziParola = parolaUtente.split(" ");

            // indexOf restistuisce la posizione della parolaUtente all'interno di parola,
            // oppure -1 se non è contenuta
            if (parolaUtente.indexOf(parola) >= 0 && !parolaUtente.equals(parola) && pezziParola.length == 1 && paroleAmmesse.indexOf(parolaUtente)>=0 && !(giocatore2.contains(parolaUtente)) && !(giocatore1.contains(parolaUtente)) && secondiTrascorsi<=10) {
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
            }
            else if ((giocatore2.contains(parolaUtente)) || (giocatore1.contains(parolaUtente))) {
                System.out.println("Parola già inserita");
            }
            else if (secondiTrascorsi>10) {
                System.out.println("Tempo scaduto, hai massimo 10 secondi");
            }
            else System.out.println("Parola non valida");
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Le parole inserite correttamente da "+nomeGiocatore1+" sono: "+giocatore1.toString());
        System.out.println("Secondi trascorsi "+tempoTotaleGiocatore1);
        System.out.println();
        System.out.println("Le parole inserite correttamente da "+nomeGiocatore2+" sono: "+giocatore2.toString());
        System.out.println("Secondi trascorsi "+tempoTotaleGiocatore2);
        System.out.println();

        if (giocatore1.size() > giocatore2.size()) {
            System.out.println("Ha vinto "+nomeGiocatore1+" "+ giocatore1.size() + " a " + giocatore2.size());
        } else if (giocatore2.size() > giocatore1.size()) {
            System.out.println("Ha vinto "+nomeGiocatore2+" "+ giocatore2.size() + " a " + giocatore1.size());
        } else {
            System.out.println("Pareggio " + giocatore2.size() + " a " + giocatore1.size());
            if (tempoTotaleGiocatore1<tempoTotaleGiocatore2) {
                System.out.println("Ha vinto "+nomeGiocatore1+" con "+(tempoTotaleGiocatore2-tempoTotaleGiocatore1)+" secondi di vantaggio");
            }else System.out.println("Ha vinto "+nomeGiocatore2+" con "+(tempoTotaleGiocatore1-tempoTotaleGiocatore2)+" secondi di vantaggio");
        }
        input.close();
    }
}