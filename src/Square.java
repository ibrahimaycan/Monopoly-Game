public abstract class Square {
    private String name;
    private int location=0;


    public void setname(String name ){
        this.name =name;

    }
    public String getname(){
        return this.name;
    }

    public void setlocation(int location ){

        this.location =location;

    }
    public int getLocation(){

        return this.location;
    }

    public abstract void action(Player p, int Die1,int Die2) ;


}
