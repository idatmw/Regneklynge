public class Node {
  //Instansvariabler bør holdes private, slik at de ikke blir endret på.
  private int minne = 0;
  private int antPros = 0;

  // Metoder bør holdes public med mindre man ikke vil at andre skal bruke metoden.
  // bruker variabelnavn som ikke er lik de som ble opprettet i instansen.
  // må skrive this.minne dersom man vil bruke samme variabelnavn.
  public Node(int nodensMinne, int nodensAntPros) {
    minne = nodensMinne;
    antPros = nodensAntPros;
  }

  public int antProsessorer() {
      return antPros;
  }

  public int hentMinne() {
      return minne;
  }

  public boolean nokMinne(int paakrevdMinne)  {
      if (minne >= paakrevdMinne) {
          return true;
      } else  {
          return false;
    }
  }

}
