import java.io.*;
import java.util.*;
public class Zoo {
    protected Animals[] animals;  //declare array of animal
    private int numAnimals;     //declare variable to track the number of animals

    public Zoo() {      //constructor is used to initialize animals array and number of animals
        animals = new Animals[10];
        numAnimals = 0;
    }

    public void addAnimals(Animals animal) throws Exception {   //to add animal into the array of animals
        if (isNameExist(animal.getName()))   //check wheter or not there is animals in the same name
            throw new Exception("Name already exist");      //if name already exist show name
        else
            this.animals[numAnimals++] = animal;        //else compiler can add animal into the array
    }

    public void listAnimals() {     //to list animals into the array
        for (int i = 0; i < numAnimals; i++) {  //access each elements in the array
            System.out.println(animals[i]); //print out each elements
        }
    }

    public void listAnimals(Animals animal)     //list animals based on the specific animal type
    {
        System.out.println("\n");
        System.out.println("\t\t\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t                           " + animal.getType());
        System.out.println("\t\t\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t     Type \t\t\t\tName \t\t\tAge\t\t\tWeight\t\t\tDiet");

        for (int i = 0; i < numAnimals; i++)       //to iterate through all elements in the array of animals
        {
            if (animals[i].getType().equals(animal.getType()))   //if found the same type
            {
                System.out.println(animals[i]);     //print the details
            }
        }
    }

    public int checkAvailability(String name) {
        if (numAnimals == 0) {
            return 0; // Return 0 if the array is empty
        }

        for (int i = 0; i < numAnimals; i++) {
            if (animals[i].getName().equalsIgnoreCase(name)) {
                return 1; // Return 1 if an animal with the same name is found
            }
        }

        return 0; // Return 0 if no animal with the same name is found
    }


    public double calculateAvgWeight() {        //calculate average weight of the animals
        double totalWeight = 0;     //track total weight of animals
        for (int i = 0; i < numAnimals; i++) {      //iterate through all the array
            totalWeight += animals[i].getWeight();     //add all the total weight
        }
        return totalWeight / numAnimals;    //return totalweight divided by the number of animals
    }

    public int countAnimals()       //to count the number of animals in the array
    {
        int numOfAnimals = 0;        //track the number of animals
        for (Animals a : animals)      //iterate through each object inside the array of animals
        {
            if (a != null)     //if the array is occupied with data
            {
                numOfAnimals++;     //then add the num of animals
            }
        }
        return numOfAnimals;        //return the number of animals
    }

    public int countAnimalsByType(String type) {        //count the number of animals by type
        int count = 0;  //track the number of animals
        for (int i = 0; i < numAnimals; i++) {      //iterate through each elements inside the array
            if ((animals[i].getType().equalsIgnoreCase(type)) && animals[i] != null) {      //if animal have same type & the array is occupied
                count++;        //add the number of animals by 1;
            }
        }
        return count;   //return the number of animals
    }

    public void deleteAnimal(String name, String type) throws Exception {       //to delete animals
        if (isNameExist(name)) {     //check if there is the same animals name inside the array
            for (int i = 0; i < numAnimals; i++) {      //iterate through each elements of the array
                if ((animals[i].getType().equalsIgnoreCase(type)) &&
                        (animals[i].getName().equalsIgnoreCase(name))) {    //if animal type and animal name is the same
                    for (int j = i; j < numAnimals - 1; j++) {
                        animals[j] = animals[j + 1];    //shift the array to delete the position with that the user wants to delete
                    }
                    numAnimals--;       //decrease the number of elements inside the array by 1
                    break;
                }
            }
        } else
            throw new Exception("=====Name does not exist bro=====");      //if there is no name
    }

    public void updateAnimals(String name, String attribute, Object newValue) {     //to update animals details
        for (int i = 0; i < numAnimals; i++) {  //iterate through each elemnts of the array
            if (animals[i].getName().equalsIgnoreCase(name)) {  //if the same name is found
                switch (attribute.toLowerCase()) {  //change attribute to lowercase
                    case "name":
                        animals[i].setName((String) newValue);     //set name
                        break;
                    case "age":
                        animals[i].setAge((int) newValue);      //set age
                        break;
                    case "weight":
                        animals[i].setWeight((double) newValue);    //set new weight
                        break;
                    case "type":
                        animals[i].setType((String) newValue);      //set new value for type
                        break;
                    default:
                        System.out.println("Invalid attribute. Available attributes are: name, age, weight and type.");
                }
                break;
            }
        }
    }

    public void saveFile()      //to save file
    {
        try {
            FileWriter writer = new FileWriter("animals.txt");      //declare a new file named animals.txt

            for (int i = 0; i < numAnimals; i++) {    //iterate through each elements of the array
                System.out.println(animals[i]);     //print out each elements inside the array
                writer.write("Name: " + animals[i].getName() + "\n");       //save the name inside the file
                writer.write("Age: " + animals[i].getAge() + "\n");
                writer.write("Type: " + animals[i].getType() + "\n");
                writer.write("Behavior: " + animals[i].getDiet() + "\n");
                writer.write("\n");
            }
            writer.close();     //close the file writer
            System.out.println("Animals information saved to animals.txt file");
        } catch (IOException e) {
            e.printStackTrace();        //if failed display error message
        }
    }

    public int averageAge()     //display average age
    {
        int totalAge = 0;       //track total age of animals
        for (int i = 0; i < numAnimals; i++)  //iterate through each elements of the array
        {
            totalAge = totalAge + animals[i].getAge();      //add all age
        }
        return totalAge / numAnimals;       //return average age
    }

    public boolean isNameExist(String name) {       //to check if the name exist
        for (int i = 0; i < numAnimals; i++) {      //iterate through each elements of the array
            if (animals[i].getName().equalsIgnoreCase(name)) {  //if found the same name inside the array
                return true;        //return true
            }
        }
        return false; //return false if there is no element with the same name inside the array
    }

    public void sortArray() {
        //
        System.out.println("\n");
        System.out.println("\t\t\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t                     Ascending Order Based on Age");
        System.out.println("\t\t\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t\t\t\t     Type \t\t\t\tName \t\t\tAge\t\t\tWeight\t\t\tDiet");
        copyAndSortArray();
    }

    public void copyAndSortArray() {
        // copy the original array to a new array
        Animals[] copiedArray = Arrays.copyOf(animals, animals.length);
        int n = copiedArray.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n-i-1 ; j++) {
                if (copiedArray[j + 1] == null) {
                    break;
                }
                if (copiedArray[j].getAge() < copiedArray[j + 1].getAge()) {
                    // swap arr[j+1] and arr[i]
                    Animals temp = copiedArray[j];
                    copiedArray[j] = copiedArray[j + 1];
                    copiedArray[j + 1] = temp;
                }
            }
        for (int i = 0; i < copiedArray.length; i++) {

            System.out.println(copiedArray[i]);
            if(copiedArray[i+1] == null)
            {
                break;
            }
        }
    }

    public Animals[] getAnimals() {
        return animals;
    }
}