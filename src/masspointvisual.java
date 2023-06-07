import java.awt.*;
import java.lang.Math.*;
import javax.swing.*;

public class masspointvisual {
    private static String[] ausgabestringarray = new String[2500];



    public static void setzeEingabe(masspointgroup massepunkte)
    {
        ausgabestringarray = new String[2500];
        for (int i = 0; i< massepunkte.elementanzahl();i++){
            double [] position = massepunkte.returnpos(i);
            if ((50>Math.round(position[0]/10)) && (40> Math.round(position[1]/10)) && position[0]>0 && position[1]>0) {
                ausgabestringarray[Math.round(Math.round(position[0] / 10) + Math.round(position[1] / 10) * 50)] = "o";
            }
        }
    }

    public static void ausgabe(){

        String ausgabestring = "";
        for (int i = 0; i<30;i++){
            ausgabestring+="\n";
        }

        for (int i = 0; i<ausgabestringarray.length;i++){
            if (i%100==1){
                ausgabestring+="\n";
            }
            if (ausgabestringarray[i]=="o") {
                ausgabestring += "o";

            }
            else {
                ausgabestring+=" ";
            }
        }
        System.out.println(ausgabestring);
    }

    public void display(Graphics g){
        Graphics2D Graphics2D;



    }
}
