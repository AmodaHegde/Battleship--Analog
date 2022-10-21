import java.util.*;
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs){
        locationCells=locs;
    }

    public void setName(String prompt){
        name = prompt;
    }

    public String checkYourself(String userinput){
        String result = "miss";
        int index = locationCells.indexOf(userinput);
        if(index>=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
                System.out.println("You sunk "+ name+ " ");
            }
            else{
                result = "hit";
            }
        }
        return result;
        
    }
}
