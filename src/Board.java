
import java.util.ArrayList;
import java.util.Scanner;
public class Board {

    public ArrayList<Player> playerArr;
    public Board(){
        playerArr=new ArrayList<Player>();
        System.out.println(playerArr);
    }
    public void setPlayers(int numOfPlayers){
        String name;
        Player p=new Player();
        Scanner input=new Scanner(System.in);
        for(int i=1;i<=numOfPlayers;i++){
            System.out.println("Enter"+i+". player name:");
            name=input.nextLine();
            playerArr.add(new Player());
            p=playerArr.get(i-1);
            p.name=name;
        }
        input.close();
    }

}
