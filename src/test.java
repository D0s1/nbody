public class test {
    private int a=2;
    public  int zahl(int num)
    {
        return (num*a);

    }
    public void setzea(int number)
    { a = number;

    }
    public int[] sortier(int[] liste){
        while (!(istsortiert(liste))){
            for (int i = 1; i < liste.length; i++) {
                if (liste[i] < liste[i - 1]) {

                    int temp = liste[i];
                    liste[i] = liste[i - 1];
                    liste[i - 1] = temp;
                }

            }
        }

      return (liste);
    }
    public int[] sortierrec(int[] liste){
            for (int i = 1; i < liste.length; i++) {
                if (liste[i] < liste[i - 1]) {

                    int temp = liste[i];
                    liste[i] = liste[i - 1];
                    liste[i - 1] = temp;
                }

            }
            if (!(istsortiert(liste))){return sortierrec(liste);}
            else{return (liste);}


    }

    public int[] testmerge(int[] liste) {
        if (liste.length < 2) {
            return liste;
        }
        int[] templiste = new int[liste.length];
        int vergleich = liste[0];
        int kleiner = 0;
        int grosser = 0;
        int[] tempkleiner = new int[liste.length];
        int[] tempgrosser = new int[liste.length];
        for (int i = 1; i < liste.length; i++) {
            if (liste[i] > vergleich) {
                tempgrosser[grosser] = liste[i];
                grosser++;

            } else {
                tempkleiner[kleiner] = liste[i];
                kleiner++;
            }
        }
        int [] cpylist = {vergleich};
        int[] kleinerliste = new int[kleiner];
        int[] grosserliste = new int[grosser];
        System.arraycopy(tempkleiner,0,kleinerliste,0,kleinerliste.length);
        System.arraycopy(tempgrosser,0,grosserliste,0, grosserliste.length);
        System.arraycopy(testmerge(kleinerliste),0,liste,0,kleinerliste.length);
        System.arraycopy(cpylist,0,liste,kleinerliste.length,1);
        System.arraycopy(testmerge(grosserliste),0,liste,(kleinerliste.length+1),grosserliste.length);
        return liste;
    }




    public boolean istsortiert(int[] liste){
        boolean sortiert = true;
        for (int i=1; i<liste.length;i++){
            if (liste[i]<liste[i-1]){
                sortiert=false;
                break;}
        }
        return sortiert;
    }
}


