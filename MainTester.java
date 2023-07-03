public class MainTester {
    public static void main(String[] args) throws Exception {
        Lion lion;
        Bear bear;
        Zoo zoo = new Zoo();
        lion = new Lion("Anas","Lion",23,100,"Predator");
        zoo.addAnimals(lion);
        lion = new Lion("Amir","Lion",30,432,"Predator");
        zoo.addAnimals(lion);
        bear = new Bear("Camam","Bear",30,432,"Predator");
        zoo.addAnimals(bear);



        zoo.listAnimals();
        new viewAnimal(zoo);
    }
}
