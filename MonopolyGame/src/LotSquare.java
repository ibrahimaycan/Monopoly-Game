public class LotSquare extends Square {

    private int price;
    private int rent;
    private Player owner = null;
    private int hasOwner=0;


    public LotSquare(String name,int index,int price,int rent){
        super.setname(name);
        super.setlocation(index);
        this.price=price;
        this.rent=rent;
    }
    @Override
    public void action(Player p,int d1,int d2){
        if(hasOwner==0){
            if(p.money.getAmount()>=getPrice()) {
                p.money.dropMoney(getPrice());
                setOwner(p);
                setHasOwner();
                System.out.println(getname() + " bought by " + p.getName());
            }
            else{
                p.money.dropMoney(getRent());
            }
        }
        else if(p==getOwner()){
            System.out.println(p.getName()+" is owner of this place");
        }
        else{
            Player p2=getOwner();
            p.money.dropMoney(getRent());
            p2.money.addMoney(getRent());
            System.out.println(p.getName()+" has paid to "+ p2.getName()+" $"+rent+" for rent");
        }


    }
    private void setHasOwner(){
        this.hasOwner=1;
    }

    private Player getOwner(){
        return owner;
    }

    private int getPrice() {
        return price;
    }

    private void setOwner(Player p) {

        owner = p;
    }
    private int getRent(){
        return rent;
    }
}
