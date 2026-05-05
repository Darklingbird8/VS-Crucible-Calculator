import java.util.List;

public class Recipe {
  String name;
  List<RecipeInput> inputs;
  Metal output;

  public Recipe(String name, List<RecipeInput> inputs, Metal output) {
    this.name = name;
    this.inputs = inputs;
    this.output = output;
  }

  public String getName() {
    return name;
  }

  public List<RecipeInput> getInputs() {
    return inputs;
  }
  
  public Metal getOutput() {
    return output;
  }
}
