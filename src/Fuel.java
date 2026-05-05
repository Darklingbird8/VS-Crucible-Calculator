public class Fuel extends Item {
  int maxTemp;

  public Fuel(String name, int quantity, int maxQuantity, int maxTemp) {
    super(name, quantity, maxQuantity);
    this.maxTemp = maxTemp;
  }

  public int getFuelValue() {
    return maxTemp;
  }
}
