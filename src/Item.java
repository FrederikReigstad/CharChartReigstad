import java.util.HashMap;

public class Item{
    private String itemDescription;
    private String name;
    private int itemWeight;

    public Item(String name, String itemDescription, int itemWeight){
        this.name = name;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;

  }

    public String getName() {
        return name;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public String getItemDescription() {
        return itemDescription;
    }



}
