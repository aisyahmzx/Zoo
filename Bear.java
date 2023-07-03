public class Bear extends Animals { //bear inherit attributes and methods of animal
    Bear(String animalName,String type, int age,double weight,String diet)
    {
        super(animalName,type,age,weight,diet);
    }
    public void forage()
    {
        System.out.println("He is foraging...");
    }
}
