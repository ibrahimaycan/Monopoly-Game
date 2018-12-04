
import java.util.ArrayList;
import java.util.*;
import java.io.*;
public class Board {
    private static Scanner input = null;
    public static final int SIZE = 40;
    public ArrayList<Player> playerArr;
    public ArrayList<Square> squareArr;
    private int [][] lotsArr = new int[22][3];

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



        ArrayList<String> square_names = new ArrayList<String>();
        // String instructions[]= new String[100];
        try {
            input = new Scanner(new File("square_names.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error, file could not found.");
            System.exit(1);
        }
        try {
            while (input.hasNext()) ///Reading from file
            {
                for (int i = 0; input.hasNext(); i++) {
                    square_names.add(input.nextLine());

                       //System.out.println(i+":"+square_names.get(i));
                }
            }


        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }

        //--------------------------------

        readLots();







        int k=0;
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
            else if(i==lotsArr[k][0]){
                //System.out.println(i+"  "+lotsArr[k][0]+"   "+lotsArr[k][1]+"  "+lotsArr[k][2]);
                squareArr.add(new LotSquare(square_names.get(i),i,lotsArr[k][1],lotsArr[k][2]));
                k++;
            }
            else{
                squareArr.add(new RegularSquare(i,square_names.get(i)));
            }


        }

    }

    public Square move(Player player, int face) {
        int newPosition = player.getCurrentplace() + face;
        player.setCurrentplace(newPosition);
        return squareArr.get(newPosition);
    }

    private void readLots(){
        String []temp;
        try {
            input = new Scanner(new File("LotsSquare.csv"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error, file could not found.");
            System.exit(1);
        }
        try
        {
            int i=0;
            String line;
            line=input.nextLine();
            while (input.hasNext()) ///Reading from file
            {
                line=input.nextLine();
                temp=line.split(";");
                for (int j=0;j<=2;j++){
                    lotsArr[i][j]=Integer.parseInt(temp[j]);
                }
               // System.out.println(i+":"+lotsArr[i][0]+"   "+lotsArr[i][1]+"  "+lotsArr[i][2]);
                i++;

            }


        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }




    }








}
