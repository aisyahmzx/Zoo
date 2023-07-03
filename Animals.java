public class Animals {
        protected String animalName;
        protected String type;
        protected int age;
        protected double weight;
        protected String diet;
        Animals(String animalName, String type, int age, double weight, String diet)           //constructor to initialize elements of the object
        {
                this.animalName = animalName;
                this.type = type;
                this.age = age;
                this.weight = weight;
                this.diet = diet;
        }
        public void eat()
        {
            System.out.println("Animal is eating..");
        }       //behaviors of the animals
        public void sleep()
        {
            System.out.println("Animal is sleeping...");
        }
        public String getType()
        {
                return type;
        }               //to get the type of animals ex:lion,bear
        public double getWeight()
        {
                return weight;
        }               //to get the weight of the animals
        public String getName()
        {
                return animalName;
        }
        public int getAge()
        {
                return age;
        }
        public String getDiet()
        {
                return diet;
        }
        public void setName(String animalName)
        {
                this.animalName = animalName;
        }       //to change the name of the animal
        public void setAge(int age)
        {
                this.age = age;
        }       //to change the age of the animals
        public void setWeight(double weight)
        {
                this.weight = weight;
        }       // to change the weight of the animals
        public void setType(String type)
        {
                this.type = type;
        }               //to change the type of the animals
        public String toString()                //to print the elements of the object in string form=
        {
               return "\t\t\t\t     "+getType()+" \t\t\t\t"+getName()+" \t\t\t"+getAge()+
                "\t\t\t"+getWeight()+ "\t\t\t" +getDiet();
        }
}
