class FreeParkingSquare extends Square {
    public FreeParkingSquare(int index) {

        super.setname("Free Parking Square");
        super.setlocation(index);
    }
    @Override
    public void action(Player p,int d1,int d2){
        System.out.println("Waiting for the next turn");
    }

}
