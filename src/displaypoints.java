
import javax.swing.*;
import java.awt.*;


//Graphische Darstellung der Punkte
class displaypoints {
    public JFrame hauptframe = new JFrame();
    public JPanel hauptpanel = new JPanel();
    public static masspointgroup massepunkte;

    //Erstellen des Ersten Frames
    public displaypoints(masspointgroup punkte) {
        massepunkte = punkte;
        Fenster fenster = new Fenster();
        hauptframe.setSize(1000,1000);
        hauptframe.add(fenster);
        hauptframe.setVisible(true);

    }
    //Updaten des gesetzen Frames, Frame für Frame
    public  void setzemassepunkte(masspointgroup punkte) throws InterruptedException {
        massepunkte = punkte;
        hauptframe.repaint();
        Fenster fenster = new Fenster();
        hauptframe.add(fenster);
        hauptframe.revalidate();

    }



}
//Hier wird das Fesnter mit den Punkten gezeichnet
class Fenster extends JPanel{
    public void paint(Graphics g) {

            for (int i = 0; i < displaypoints.massepunkte.elementanzahl(); i++) {
                double[] position = displaypoints.massepunkte.returnpos(i);
                if ((1000 > Math.round(position[0])) && (1000 > Math.round(position[1])) && position[0] > 0 && position[1] > 0) {
                    g.drawLine((int) Math.round(position[0]), (int) Math.round(position[1]), (int) Math.round(position[0]), (int) Math.round(position[1]));
                }
            }
    }
}

