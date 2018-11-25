class LuxuryTaxSquare extends Square {
    public LuxuryTaxSquare(int index) {

        super.setname("LuxuryTaxSquare");
        super.setlocation(index);
    }

    @Override
    public void action(Player p,int d1,int d2){
        System.out.println("You must pay 75$ to the bank");
        p.money.dropMoney(75);
    }
}

