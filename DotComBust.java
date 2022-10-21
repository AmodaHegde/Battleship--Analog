import java.util.*;
public class DotComBust{
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList= new ArrayList<DotCom>();
    private int numofGuess = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them with the least moves");

        for(DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter an input");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String prompt){
        numofGuess++;
        String result = "miss";
        for(int x=0;x<dotComsList.size();x++) {
            result = dotComsList.get(x).checkYourself(prompt);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComsList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Game over, guesses is "+ numofGuess);
    }

    public static void main(String [] args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
    
}