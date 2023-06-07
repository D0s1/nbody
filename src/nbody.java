public class nbody {

    public static void main(String[] args) throws InterruptedException {
        //Erstellen neuer Massepunkte
        masspointgroup massepunkte = new masspointgroup(300);
        //Erstellen eines Frames mit den Massepunkten
        displaypoints display = new displaypoints(massepunkte);



        //Hier wird die Position geupdatet, und jeder 100 Simulationsdurchlauf Graphisch geupdatet
        int i = 0;
        while (true){
            i++;
            massepunkte.calculatepos();

            if (i%100==0){
                display.setzemassepunkte(massepunkte);
                Thread.sleep(40);
            }


        }



    }


}
