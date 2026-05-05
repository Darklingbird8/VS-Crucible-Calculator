public class RecipeInput {
  Metal metal;
  int amount;

  public RecipeInput(Metal metal, int amount) {
    this.metal = metal;
    this.amount = amount;
  }
  
  public Metal getMetal() {
    return metal;
  }

  public int getAmount() {
    return amount;
  }
}
