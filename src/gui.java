import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseChronology;

public class gui {
    private static String pfad;
    public static void main(String args[]){
        JFrame rahmen = new JFrame("TEST");
        rahmen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rahmen.setSize(500,200);
        JButton knopf = new JButton("Drück");
        rahmen.getContentPane().add(knopf);
        rahmen.getContentPane().add(new JButton("Drücke"));







        //Define bottom label
        JLabel label_unten = new JLabel("Beispiel Label");


        //Define inner panel
        JPanel inner_panel = new JPanel();

        //Setze in inner Frame ein


        fileclass filemanager = new fileclass();

        String currentpath = ("C:\\Users\\Domin");
        pfad = currentpath;
        JPanel panel = new JPanel();
        //Fügt Datieen als Knöpfe ien
        AddButton(inner_panel,filemanager.getListofFiles("C:\\Users\\Domin"),currentpath,panel);

        //Scrollen mit Mausraus
        JScrollPane scrollPane = new JScrollPane(inner_panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);



        //GroupLayout
        //GroupLayout inner_layout = new GroupLayout(inner_panel);
        //inner_layout.setHorizontalGroup(inner_layout.createSequentialGroup()
          //      .addGroup(inner_layout.createParallelGroup().addComponent(knopf1).addComponent(knopf2)));
        //inner_layout.setVerticalGroup(inner_layout.createSequentialGroup().addComponent(knopf1).addComponent(knopf2));


        //inner_panel.setLayout(inner_layout);

        // Define Main Panel

        inner_panel.setLayout(new BoxLayout(inner_panel,BoxLayout.Y_AXIS));




        JButton jb1 = new JButton("Hoch");

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(pfad);
                if (null != pfad && pfad.length() > 0 )
                {
                    int endIndex = pfad.lastIndexOf("\\");
                    System.out.println(endIndex);
                    if (endIndex != -1)
                    {
                        pfad = pfad.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
                    }
                    System.out.println(pfad);
                }
                changegui(inner_panel,pfad,"",panel,false);
            }
        });
        panel.setLayout(new BorderLayout());
        panel.add(jb1, BorderLayout.NORTH);
        panel.add(label_unten, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        rahmen.getContentPane().add(panel);
        rahmen.pack();
        rahmen.setVisible(true);

    }

    public static void AddButton(JPanel Panel,String[] array,String currentpath,JPanel mainpanel) {
        for (int i = 0; i < array.length; i++) {
            AddSpecificButton(Panel,array[i],currentpath,mainpanel);

        }
    }
    public static void AddSpecificButton(JPanel Panel, String inhalt,String currentpath,JPanel mainpanel)
    {
         JButton knopf = new JButton(inhalt);
         knopf.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 changegui(Panel,currentpath,inhalt,mainpanel,true);
             }
         });
         Panel.add(knopf);
    }

    public static void changegui(JPanel Panel,String currentpath,String inhalt,JPanel mainpanel,Boolean fwd){
        //Define inner panel
        System.out.println(fwd);
       System.out.println("test");

        JPanel neuespanel = new JPanel();

        //Setze in inner Frame ein
        BorderLayout layout = (BorderLayout)mainpanel.getLayout();

        mainpanel.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        Panel.removeAll();


        fileclass filemanager = new fileclass();
        System.out.println((currentpath+"\\"+inhalt));
        String richtung ="";
        if (fwd == true){
            richtung ="\\";
        }
        System.out.println(fwd);
        System.out.println(richtung);
        String tempfad = pfad;

        pfad = (currentpath+richtung+inhalt);
        if (!(filemanager.getListofFiles((currentpath+richtung+inhalt))==null)) {
            AddButton(Panel, filemanager.getListofFiles((currentpath + richtung + inhalt)), (currentpath + richtung + inhalt), mainpanel);
        }
        else {filemanager.open(currentpath+richtung+inhalt);
            AddButton(Panel, filemanager.getListofFiles(currentpath), currentpath, mainpanel);
            pfad = tempfad;};

        JScrollPane scrollPane = new JScrollPane(Panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        mainpanel.add(scrollPane, BorderLayout.CENTER);
        mainpanel.updateUI();

    };
}
