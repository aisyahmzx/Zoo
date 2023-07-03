public class Monkey extends Animals {//monkey inherit attributes and methods of animal
    private String color;

    public Monkey(String animalName, String type, int age, double weight, String diet) {
        super(animalName, type, age, weight,diet);
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String behavior() {
        return "Monkeys are known for their playful and curious nature.";
    }
}