
public class Player {

    private String name;
    private int currentplace;
    public Money money;
    int jailTime=0;
    private boolean inJail = false;

    public Player(){
        money=new Money();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isInJail(){
        return inJail;
    }
    public void setInJail(boolean inJail){
        this.inJail=inJail;
    }



    public int getCurrentplace() {
        return currentplace;
    }
    public void setCurrentplace(int currentplace) {
        this.currentplace = currentplace;
    }
}
