public class Capybara extends Animals {//capybara inherit attributes and methods of animal
    public Capybara(String animalName, String type, int age, double weight, String diet) {
        super(animalName, type, age, weight,diet);
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String behavior() {
        return "Capybaras are social and peaceful animals, they spend most of their time in or near water.";
    }
}