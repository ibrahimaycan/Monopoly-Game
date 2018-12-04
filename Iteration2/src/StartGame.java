
import java.util.Scanner;

public class StartGame {

    private static Die die1 = new Die();
    private static Die die2 = new Die();
    private static int totaldice;
    private static int playerid;
    private static int turn = 0;
    private static Player p = new Player();
    private static Board b = new Board();
    private static int playernumber;
    private static int numberofturns;

    public void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the number of players");
            playernumber = input.nextInt();
            if (playernumber >= 1 && playernumber <= 8)
                break;
            System.out.println("You can play this game at least 2 player and at most 8 player");
        }
        while(true){
            System.out.println("Enter the turn number you want to play ");
            numberofturns=input.nextInt();
            if(numberofturns > 0){
                break;
            }
            System.out.println("please enter positive number");
        }


        b.setSquares();
        b.setPlayers(playernumber);

        while (true) {
            playerid = 0;
            turn++;
            for (int i = 0; i < playernumber; i++) {/// this is where game is playing
                p = b.playerArr.get(playerid);
                die1.setFace();
                die2.setFace();
                System.out.println("\nTurn :" + turn);
                System.out.println(p.getName() + "'s turn");
                System.out.println("Dice is rolling");
                if (p.isInJail() == true) {
                    b.squareArr.get(10).action(p, die1.getFaceValue(), die2.getFaceValue());
                    if (p.isInJail() == true)
                        break;

                }
                totaldice = die1.getFaceValue() + die2.getFaceValue();
                System.out.println("Total dice value is " + totaldice);

//---------------------------------------------------------------------------------------------
                if ((p.getCurrentplace() + totaldice >= 40)) {
                    p.money.addMoney(200);
                    ///player complates one tour
                    System.out.println("Player " + p.getName() + " compleated 1 tour.Take $200 from the bank");
                    p.setCurrentplace(p.getCurrentplace() - 40);
                    System.out.println(p.getName() + " moves from " + b.squareArr.get(p.getCurrentplace() + 40).getname() + " to " + b.squareArr.get(p.getCurrentplace()
                            + totaldice).getname());
                    b.move(p, totaldice);
                } else
                    {
                    System.out.println(p.getName() + " moves from " + b.squareArr.get(p.getCurrentplace()).getname() + " to " + b.squareArr.get(p.getCurrentplace()
                            + totaldice).getname());
                    b.move(p, totaldice);
                }
//---------------------------------------------------------------------------------------------

                if (p.getCurrentplace() == 10) {     //if player is in jail then waits 3 turn
                    p.setInJail(true);
                }
                else
                b.squareArr.get(p.getCurrentplace()).action(p,die1.getFaceValue(),die2.getFaceValue());

                System.out.println("Total cash is $" + p.money.getAmount());

                playerid++;
            }
            input.close();
            if (turn == numberofturns)
                break;

        }
        System.out.println("\n\nGAME OVER");
        for (int j =0;j<playernumber;j++){
            p = b.playerArr.get(j);
            System.out.println(p.getName()+" has "+p.money.getAmount()+" cash. ");
        }

    }
}