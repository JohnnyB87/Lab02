package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfWinners {
    private List<Winner> winners;
    private File file = new File("Winners.txt");

    public ListOfWinners(){
        this.winners = new ArrayList<>();
    }

    public void add(Winner winner){
        this.winners.add(winner);
    }

    public void remove(Winner winner){
        this.winners.remove(winner);
    }

    public void loadFromFile(){
        System.out.println("LOADING...");
        try{
            FileReader fr;
            if(this.file.exists()) {
                fr = new FileReader(this.file);
                BufferedReader br = new BufferedReader(fr);
                String str = br.readLine();
                while(str != null){
                    String[] list = str.split(" ");
                    String fn = list[0];
                    String ln = list[1];
                    int n = Integer.parseInt(list[2]);
                    Winner w = new Winner(fn,ln,n);
                    this.winners.add(w);
                    str = br.readLine();
                }
                br.close();
            }
        }catch(IOException IOE){}
    }

    public void addToFile(Winner w){
        System.out.println("PRINTING...");
        try{
            FileWriter fw;
            if(this.file.exists())
                fw = new FileWriter(this.file,true);
            else
                fw = new FileWriter(this.file);
            BufferedWriter bw = new BufferedWriter(fw);
            String str = String.format("%s %s %d%n",w.getfName(),w.getlName(),w.getPrizeValue());
            bw.append(str);
            bw.close();
        }catch(IOException IOE){}
        this.add(w);
    }

    public Winner get(String fName, String lName){
        for(Winner w : this.winners){
            if(w.getfName().equalsIgnoreCase(fName)
                    && w.getlName().equalsIgnoreCase(lName)){
                return w;
            }
        }
        System.out.println("No winner by this name.");
        return null;
    }
}
