package classes;

import java.io.*;
import java.util.*;

public class ListOfWinners{
    private List<Winner> winners;
    private File file = new File("Winners.txt");
    private int length;

    public ListOfWinners(){
        this.winners = new ArrayList<>();
        this.length = 0;
        loadFromFile();
        System.out.println("Size: " + this.winners.size());
    }

    public void add(Winner winner){
        this.winners.add(winner);
        this.length++;
    }

    public void remove(Winner winner){
        this.winners.remove(winner);
        this.length--;
    }

    public void loadFromFile(){
        System.out.println("\nLOADING...");
        try{
            FileReader fr;
            if(this.file.exists()) {
                fr = new FileReader(this.file);
                BufferedReader br = new BufferedReader(fr);
                String str = br.readLine();
                while(str != null){
                    String[] list = str.split(",");
                    String fn = list[0];
                    String ln = list[1];
                    int n = Integer.parseInt(list[2]);
                    Winner w = new Winner(fn,ln,n);
                    this.winners.add(w);
                    System.out.println("Added " + str);
                    str = br.readLine();
                }
                br.close();
            }
        }catch(IOException IOE){}
    }

    public void addToFile(Winner w){
        System.out.println("\nPRINTING...");
        String str = "";
        try{
            FileWriter fw;
            if(this.file.exists())
                fw = new FileWriter(this.file,true);
            else
                fw = new FileWriter(this.file);
            BufferedWriter bw = new BufferedWriter(fw);
            str = String.format("%s,%s,%d%n",w.getFName(),w.getLName(),w.getPrizeValue());
            bw.append(str);
            bw.close();
        }catch(IOException IOE){}
        this.add(w);
        System.out.println("Added " + str);
    }

    public Winner get(String fName, String lName){
        for(Winner w : this.winners){
            if(w.getFName().equalsIgnoreCase(fName)
                    && w.getLName().equalsIgnoreCase(lName)){
                return w;
            }
        }
        System.out.println("No winner by this name.");
        return null;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.winners == null || this.length == 0;
    }

    public Object[] toArray() {
        if(this.length == 0 || this.winners == null)
            return null;
        Object[] oa = new Object[this.length];
        for(int i=0;i<this.length;i++){
            oa[i] = this.winners.get(i);
        }
        return oa;
    }


    public Winner get(int i){
        if(this.winners != null || this.length > 0)
            return this.winners.get(i);
        return null;
    }

    public List<Winner> getWinners(){
        return this.winners;
    }
}
