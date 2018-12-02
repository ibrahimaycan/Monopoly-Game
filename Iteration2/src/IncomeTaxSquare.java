import java.awt.desktop.SystemEventListener;

class IncomeTaxSquare extends Square {
    public IncomeTaxSquare(int index) {

        super.setname("Income Tax Square");
        super.setlocation(index);
    }

    @Override
    public void action(Player p,int d1,int d2){
        int tax;
            System.out.println("You must %10 of your total cash");
            tax =p.money.getAmount()/10;
            p.money.dropMoney(tax);



    }
}
