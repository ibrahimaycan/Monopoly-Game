
import java.util.ArrayList;
import java.util.Scanner;
public class Board {

    public ArrayList<Player> playerArr;
    public ArrayList<Square> squareArr;

    public Board(){
        playerArr=new ArrayList<Player>();
        squareArr=new ArrayList<Square>();
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

    public void setSquares(){
        for(int i=0;i<40;i++){
            if(i==0){
               squareArr.add(new GoSquare(i));
            }
            else if (i==10){
                squareArr.add(new JailSquare(i));
            }
            else{
                squareArr.add(new RegularSquare(i));
            }


        }

    }


}
