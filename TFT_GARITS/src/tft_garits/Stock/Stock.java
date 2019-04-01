package tft_garits.Stock;

public class Stock {
        
    private final int part_no;
    private final String part_name;
    private final String part_desc;
    private int amount;
    private final float cost;
    private float total;

    public Stock(int part_no, String part_name, String part_desc, float cost) {
        this.part_no = part_no;
        this.part_name = part_name;
        this.part_desc = part_desc;
        this.cost = cost;
        this.amount = 1;
        calcTotal();
    }
    
    public void add(int inc){
        amount = amount + inc;
        calcTotal();
    }
    
    public void add(){
        amount = amount + 1;
        calcTotal();
    }
    
    public void sub(){
        amount = amount - 1;
        calcTotal();
    }
    
    private void calcTotal(){
        total = cost*amount;
    }
    
    @Override
    public String toString(){
        if (amount == 1) return part_name + ", £" + cost;
        return part_name + ", " + amount + " x £" + cost;
    }

    public float getTotal() {
        return total;
    }
    
    public int getNo(){
        return part_no;
    }
    
    public int getAmount(){
        return amount;
    }

    public String getName() {
        return part_name;
    }
    
    public String getDesc() {
        return part_desc;
    }

    public float getCost() {
        return cost;
    }
}