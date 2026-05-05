public class Metal extends Item {

  int meltingPoint;
  boolean isAlloy;
  
  public Metal(String name, int quantity, int maxQuantity, int meltingPoint, boolean isAlloy) {
    super(name, quantity, maxQuantity);
    this.meltingPoint = meltingPoint;
    this.isAlloy = isAlloy;
  }

  public int getMeltingPoint() {
    return meltingPoint;
  }

  public boolean isAlloy() {
    return isAlloy;
  }
}
