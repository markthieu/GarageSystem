package tft_garits.Stock;

public class Part {

    private int part_no;
    private int quantity;
    private String vehicleType;
    private String manufacturer;
    private String part_name;
    private String description;
    private float price;
    private double traderPrice;
    private double sellingPrice;

    /**
     * 
     * @param partId
     */
    public Part retrieve(int partId) {
            // TODO - implement Part.retrieve
            throw new UnsupportedOperationException("Part.retrieve() needs implementation");
    }

    /**
     * 
     * @param name
     * @param manu
     * @param vehType
     * @param qty
     */
    public Part(int part_no, int quantity, String part_name, String description, float price) {
        this.part_no = part_no;
        this.quantity = quantity;
        this.part_name = part_name;
        this.description = description;
        this.price = price;
    }

    public int getPart_no() {
        return part_no;
    }

    public void setPart_no(int part_no) {
        this.part_no = part_no;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void addAmount(int aInt) {
        quantity = quantity + aInt;
    }

    
}