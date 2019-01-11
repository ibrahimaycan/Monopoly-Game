public class Money {
    private int amount;

    public Money(){
        this.amount=1500;

    }
    public void setAmount(int amount){
        this.amount=amount;

    }

    public int getAmount() {
        return this.amount;
    }
    public void addMoney(int amount){
        this.amount+=amount;

    }

    public void dropMoney(int amount){
        this.amount-=amount;
    }

}



