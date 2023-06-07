import java.util.Random;

public class masspointgroup {

    //Klasse die Alle massepunkte verwaltet
    Random rand = new Random();
    masspoint[] massepunkte;


   //Wird beim initialisieren ausgeführt
    public masspointgroup(int anzahl){
        this.massepunkte = createpoints(anzahl);

    }
    //Erschaffe neue massepunkte
    public masspoint[] createpoints(int amount){
        masspoint[] create_massepunkte =  new masspoint[amount];

        for (int i = 0; i< create_massepunkte.length;i++){
            create_massepunkte[i] = new masspoint();


            //Erschaft masse Punkte im Bereich x,y 300-700
            create_massepunkte[i].setzeposition(rand.nextDouble(300,700),rand.nextDouble(300,700));
            //Masse zwischen 0-20
            create_massepunkte[i].mass =rand.nextDouble(20);
        }
        return create_massepunkte;
    }
    public void calculatepos(){
        //Berechnet die neuen Positionen der Massepunkte
        for (masspoint masspoint : massepunkte) {
            for (masspoint value : massepunkte) {

                masspoint.calculateaccelaration(value, 1.2e-5);

            }
        }
        for (masspoint masspoint : massepunkte) {
            masspoint.updatePosition();
        }


    }

    //Gibt dir Koordinaten eines Punktes aus
    public double[] returnpos(int index){
        return massepunkte[index].position;
    }

    //Gibt die Anzahl der Massepunkte aus
    public int elementanzahl(){
        return massepunkte.length;
    }
}
