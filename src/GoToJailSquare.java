class GoToJailSquare extends Square {
    public GoToJailSquare(int index) {

        super.setname("Go To Jail Square");
        super.setlocation(index);
    }
    @Override
    public void action(Player p,int d1,int d2){
        p.setCurrentplace(10);
        p.setInJail(true);
    }
}
