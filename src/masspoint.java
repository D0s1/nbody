

public class masspoint {


    //Setzen der Klassenvariablen
    public double mass;
    public double [] position = new double[2];

    public double [] momentum = {0,0};






    public void setzeposition(double x, double y){
        // Benötigt zwei integer als Positionen
        // Setzt die Position des Massepunktes
        position[0] = x;
        position[1] = y;

    }

    public void setzemomentum(double xspeed, double yspeed)
        //Benötigt zwei integer als Positionen
        // Bei den Eingaben handelt es sich immer um momentum NICHt um absolute Positionen
        //Verändert das Momentum entsprechend der Eingabe unter Betrachtung des aktuellen momentums
    {   momentum[0]= momentum[0]+(xspeed);
        momentum[1] = momentum[1]+(yspeed);





    }

    public void calculateaccelaration(masspoint punkt,double g){
        //Benötigt einen Zweiten Massepunkt und die gesetzte Gravitationskonstante
        //Gibt der Beschleunigung der Klasse aus
       /* if ((mass==0) | (punkt.mass==0)){
            return;
        }
        */
        double x = punkt.position[0];
        double y = punkt.position[1];
        double fremd_masse = punkt.mass;

        //Berechnung des Momemtums eines Punktes im bezug zum anderen

        double entfernung = Math.sqrt(Math.pow(position[0]-x,2)+Math.pow(position[1]-y,2) );
        double tempmomentum = g * fremd_masse / Math.pow(entfernung,2);
        if ((entfernung>1) ) {
            double relativespeed = (tempmomentum / entfernung);
            //relativespeed = 1;
            //System.out.println(relativespeed);
            setzemomentum(((x - position[0]) * relativespeed), ((y - position[1]) * relativespeed));
        }
        /*
        if ((entfernung<0.5)&&!(entfernung==0)){
            punkt.mass += mass;
           position[0]=20e200;
           position[1]=20e200;
        }
        */


    }

    public void updatePosition(){
        //Simuliert ein tick und berechnet die Geschwindigkeit mithilfe der beschleunigung
        setzeposition((position[0]+momentum[0]),(position[1]+momentum[1]));
    }



}


