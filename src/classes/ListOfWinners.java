package classes;

import java.util.List;

public class ListOfWinners {
    private List<Winner> winners;

    public void add(Winner winner){
        this.winners.add(winner);
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
