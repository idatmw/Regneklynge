import java.util.Arrays;

public class Rack
{   // Bruker Array for bestemt antall noder det er plass til
    private Node[] nodeliste;

    // Konstruktør som oppretter en Array-liste med plass til 12 objektelementer
    public Rack(){
        nodeliste = new Node[12];
    }

  // void betyr at man ikke returnerer noe,
  // kan forandre på void til en annen datatype om man vil returnere noe.
  public void settInn(Node node) {
    for (int i = 0; i < nodeliste.length; i++) {
      // Bruker null fordi det er snakk om et objekt. String er også er objekt(storS)
      if (nodeliste[i] == null) {
        nodeliste[i] = node;
        break;
      }
    }
  }
  // henter antall Noder
  public int antNoder() {
      int antNode = 0;
      for (Node n : nodeliste){
          // Der det ikke er objekt-elementer står det "null" i.
          if (n != null) {
              antNode++;
          }
      }
      return antNode;
  }

  public int antProsessorer() {
      int antPros = 0;
      // kan kalle elementet hva som helst, (Objekt variabelnavn)
      for (Node node : nodeliste) {
          // null brukes for Objekter.
          if (node != null) {
              antPros += node.antProsessorer();
          }
      }
      // return utenfor for-løkken for at det skal lagres
      return antPros;
    }

    public int noderMedNokMinne(int paakrevdMinne) {
        int noderMedNokMinne = 0;
        // for hvert element i lista
        for (Node node : nodeliste) {
            if (node != null) {
                if (node.hentMinne() >= paakrevdMinne) {
                    noderMedNokMinne++;
                }
            }

        }
        return noderMedNokMinne;
    }

  }
