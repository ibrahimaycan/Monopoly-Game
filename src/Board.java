
import java.util.ArrayList;
import java.util.Scanner;
public class Board {
    public static final int SIZE = 40;
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
        for(int i=0;i<numOfPlayers;i++){
            System.out.println("Enter"+(i+1)+". player name:");
            name=input.nextLine();
            playerArr.add(new Player());
            p=playerArr.get(i);
            p.setName(name);
        }
        input.close();
    }

    public void setSquares(){
        for(int i=0;i<40;i++){
            if(i==0){
               squareArr.add(new GoSquare(i));
            }
            else if(i==4){
                squareArr.add(new IncomeTaxSquare(i));
            }
            else if (i==10){
                squareArr.add(new JailSquare(i));
            }
            else if(i==20){
                squareArr.add(new FreeParkingSquare(i));
            }

            else if(i==30){
                squareArr.add(new GoToJailSquare(i));
            }

            else if(i==38){
                squareArr.add(new LuxuryTaxSquare(i));
            }
            else{
                squareArr.add(new RegularSquare(i));
            }


        }

    }

    public Square move(Player player, int face) {
        int newPosition = player.getCurrentplace() + face;
        player.setCurrentplace(newPosition);
        return squareArr.get(newPosition);
    }








}
