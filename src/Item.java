public class Item {
  private String name;
  private int quantity;
  private int maxQuantity;

  public Item(String name, int quantity, int maxQuantity) {
    this.name = name;
    this.quantity = quantity;
    this.maxQuantity = maxQuantity;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getMaxQuantity() {
    return maxQuantity;
  }
}
