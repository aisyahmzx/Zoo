public class Lion extends Animals {     //lion inherit attributes and methods of animal
    Lion(String animalName ,String type, int age,double weight,String diet)     //constructor for the lion
    {
        super(animalName, type , age , weight , diet);
    }
    public void hunt()
    {
        System.out.println("Hunting for this prey...");
    }
    public void roar()
    {
        System.out.println("Roaring...");
    }
}
