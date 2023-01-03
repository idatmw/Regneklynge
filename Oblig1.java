class Oblig1 {
    public static void main(String[] args) {

        Regneklynge abelf = new Regneklynge("regneklynge.txt");
        // System.out.println(abelf.noderPerRack);

        System.out.println("Noder med minst 32 GB: " + abelf.noderMedNokMinne(32));
        System.out.println("Noder med minst 64 GB: " + abelf.noderMedNokMinne(64));
        System.out.println("Noder med minst 128 GB: " + abelf.noderMedNokMinne(128));

        System.out.println("Antall prosessorer: " + abelf.antProsessorer());
        System.out.println("Antall racks: " + abelf.antRacks() + "\n");



        Regneklynge abel = new Regneklynge(12);
        Node node = new Node(64, 1);
        Node node2 = new Node(1024, 2);

        abel.fyllMedNoder(node, 650);
        abel.fyllMedNoder(node2, 16);

        System.out.println("Noder med minst 32GB: " + abel.noderMedNokMinne(32));
        System.out.println("Noder med minst 64 GB: " + abel.noderMedNokMinne(64));
        System.out.println("Noder med minst 128 GB: " + abel.noderMedNokMinne(128));

        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall racks: " + abel.antRacks());
    }

}

/*
Test
Rack rack = new Rack();
rack.settInn(node);
rack.settInn(node);
System.out.println("rack metoder false: " + rack.sjekkNodeListefull());
System.out.println("rack metoder 5: " + rack.antProsessorer());
System.out.println("rack metoder 1: " + rack.noderMedNokMinne(10));
System.out.println("rack metoder 0: " + rack.noderMedNokMinne(29));

System.out.println("node metoder: " + node.antProsessorer());
System.out.println("node metoder: " + node.hentMinne());
System.out.println("node metoder: " + node.nokMinne(15));
System.out.println("node metoder: " + node.nokMinne(18));

System.out.println("Atall prosessorer: " + abel.antProsessorer());
System.out.println("Antall noder med nok minne: " + abel.noderMedNokMinne(10));
System.out.println("Antall Racks : " + abel.antRacks());
System.out.println("Antall Noder i rack: " + abel.antNoder());

 */
