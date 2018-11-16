
import java.util.Scanner;

public class StartGame {
    public void start() {
        int totaldice;
        int playerid;
        int winnercode=1;
        Player p= new Player();

        Die m1= new Die();
        Die m2=new Die();
        Board b=new Board();
        Scanner input = new Scanner(System.in);
        int playernumber;
        while(true){
            System.out.println("Enter the number of players");
            playernumber=input.nextInt();
            if(playernumber>=2&&playernumber<=8)
                break;
            System.out.println("You can play this game at least 2 player and at most 8 player");

        }

        b.setSquares();
        b.setPlayers(playernumber);
        int ax;
        while(true) {
            playerid=0;
            s=b.squareArr.get(10);
            System.out.println(s.getname());
            for(int i=0;i<playernumber;i++) {
                p = b.playerArr.get(playerid);

                System.out.println(p.name+"'s turn");
                System.out.println("Dice is rolling");
                totaldice=m1.getFaceValue()+m2.getFaceValue();
                System.out.println("total dice value is "+totaldice);
                System.out.println(p.name+" moves from "+p.getCurrentplace()+" to "+(p.getCurrentplace()+totaldice)+"\n");
                p.setCurrentplace(p.getCurrentplace()+totaldice);
                playerid++;
                System.out.println(ax);
                if(p.getCurrentplace()>=20) {
                    System.out.println("\n\n------------------------\n"+p.name + " WINSSSSS "+"\n------------------------");
                    winnercode=0;
                    break;
                }
            }
            if(winnercode==0) {
                break;
            }
        }
        input.close();
    }
}
