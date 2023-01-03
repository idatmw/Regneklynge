import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Regneklynge {
    private ArrayList<Rack> rackliste;
    protected int noderPerRack;

    // Bestemte meg for å legge disse variablene i det lokale virkeområdet istedenfor, for å spare plass i minnet.
    //protected int genererAntNoder;
    //protected int minnePNode;
    //protected int antProsPerNode;

    public Regneklynge(String filnavn) {
        rackliste = new ArrayList<Rack>();

        Scanner innFil = null;
        try {
            File fil = new File(filnavn);
            innFil = new Scanner(fil);
        } catch (FileNotFoundException e) {

        }
        // Max antall noder per rack
        // AntallNoder MinnePerNode AntallProsessorerPerNode
        // AntallNoder MinnePerNode AntallProsessorerPerNode

        // 12
        // 650 64 1
        // 16 1024 2
        // Leser oeverste linje

        String linje1 = innFil.nextLine();
        noderPerRack = Integer.parseInt(linje1);

        while (innFil.hasNextLine()) {
            String linje2 = innFil.nextLine();
            String[] deler = linje2.split(" ");
            int genererAntNoder = Integer.parseInt(deler[0]);
            int minnePNode = Integer.parseInt(deler[1]);
            int antProsPerNode = Integer.parseInt(deler[2]);
            // Må skrives innenfor if-løkken, fordi disse kun er lokale variabler!
            // Dersom de ligger utenfor har ikke disse variablene noen verdi.
            Node node = new Node(minnePNode, antProsPerNode);
            this.fyllMedNoder(node, genererAntNoder);
        }
    }

    public Regneklynge(int nodePerRack) {
        noderPerRack = nodePerRack;
        rackliste = new ArrayList<Rack>();

    }

    // .size() for ArrayList
    // Dersom racklista er 0, opprett nytt rack hvis ikke, hopp til neste>
    public void fyllMedNoder(Node node, int genererAntNoder) {
        for (int i = 0; i < genererAntNoder; i++) {
            this.settInnNode(node);
        }
    }

    public void settInnNode(Node node) {
        if (rackliste.size() == 0) {
            Rack rack = new Rack();
            rackliste.add(rack);
        }
        //Dersom antall noder er lik norderPerRack opprettes det nytt rack!
        // Hvis ikke, sett inn node
        // Sjekker siste elementet i lista
        if(rackliste.get(rackliste.size() - 1).antNoder() == noderPerRack) {
        	rackliste.add(new Rack());
        }

        rackliste.get(rackliste.size() - 1).settInn(node);
    }

    public int noderMedNokMinne(int paakrevdMinne){
        int noderMedNokMinne = 0;
        // for hvert element i lista.
        for (Rack rack : rackliste){
            // rack.noderMedNokMinne tar en for-each sjekk i nodelista.
            noderMedNokMinne += rack.noderMedNokMinne(paakrevdMinne);
                }
        return noderMedNokMinne;
    }

    public int antNoder(){
        int antNoder = 0;
        for (Rack r : rackliste) {
            antNoder += r.antNoder();
        }
        return antNoder;
    }

    public int antProsessorer() {
        int antPros = 0;
        for (Rack rack : rackliste) {
            antPros += rack.antProsessorer();
        }
        return antPros;
    }

    public int antRacks(){
        return rackliste.size();
    }

}
