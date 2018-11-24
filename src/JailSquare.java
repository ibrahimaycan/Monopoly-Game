public class JailSquare extends Square {
    public JailSquare(int index) {

        super.setname("Jail Square");
        super.setlocation(index);
    }

    @Override
    public void action(Player p,int d1,int d2) {
        System.out.println("Die values are "+d1+"-"+d2);
        if(d1==d2){

            System.out.println("Player doubled,time to leave jail");
            p.setInJail(false);
            p.jailTime=0;

        }
        else
        {
            p.jailTime++;

            if(p.jailTime==4){
                p.money.dropMoney(50);
                p.setInJail(false);
                p.jailTime=0;
            }
            else
                System.out.println(p.jailTime+" turn in jail");
        }



    }
}