import java.io.*;
import java.util.*;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        //ANIMALS NAME MUST BE UNIQUE BECAUSE ALL OPERATIONS ARE BASED ON THE ANIMALS NAME

        Scanner scan = new Scanner(System.in);      //declaring the input object
        Zoo zoo = new Zoo();        //declaring the zoo object to be used later
        Lion lion = null ;          //lion object
        Bear bear = null;
        Monkey monkey = null;
        Capybara capybara = null;
        Croc crocodile = null;

        int age;        //to store age of animals to be passed
        double weight;   //to store weight of animals to be passed
        String animalName;

        while(true)
        {
            System.out.println("\n");
            System.out.println("\t\t\t\t ==========================================");
            System.out.println("\t\t\t\t ||             Zoo System               ||");
            System.out.println("\t\t\t\t ==========================================");
            System.out.println("\t\t\t\t || 1. Add Animals                       ||"); //1 to Add animals
            System.out.println("\t\t\t\t || 2. Remove Animals                    ||"); //2 to Delete animals
            System.out.println("\t\t\t\t || 3. Update                            ||"); //3 to Update animals
            System.out.println("\t\t\t\t || 4. Animals Data                      ||"); //4 to View animals data
            System.out.println("\t\t\t\t || 5. View Animals                      ||"); //5 to View all animals
            System.out.println("\t\t\t\t || 0. Exit                              ||"); //0 to Exit System
            System.out.println("\t\t\t\t ==========================================");
            System.out.println("\n");
            System.out.print("Enter you choice :");
            int selection = scan.nextInt();
            scan.nextLine();
            if(selection == 1)      //if user wants to add animals
            {
                System.out.println("\n");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t     ||          Add Animals        ||");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t || 1. Lion                             ||");
                System.out.println("\t\t\t\t || 2. Bear                             ||");
                System.out.println("\t\t\t\t || 3. Monkey                           ||");
                System.out.println("\t\t\t\t || 4. Capybara                         ||");
                System.out.println("\t\t\t\t || 5. Crocodile                        ||");
                System.out.println("\t\t\t\t || 0. Exit                             ||");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\n");
                System.out.print("Enter animal choice : ");
                int animalType = scan.nextInt();
                scan.nextLine();
                if(animalType == 1)     //if user wants to add lion
                {
                    System.out.println("What is its name?");        // ask the name of the animal
                    animalName = scan.nextLine();
                    while (true) {
                        System.out.println("How old is the lion?");     //ask age of animal
                        String input = scan.nextLine();
                        try {
                            age = Integer.parseInt(input);
                            // continue with the program
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                    System.out.println("How much does the Lion weigh?(Kilograms)");       //ask weight of animal
                    weight = scan.nextDouble();
                    scan.nextLine();
                    lion = new Lion(animalName,"Lion", age ,weight, "Predator");
                    try {
                        zoo.addAnimals(lion);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());         //error message in case user input same name for the animals
                    }
                }
                else if(animalType == 2)
                {
                    System.out.println("What is its name?");
                    animalName = scan.nextLine();
                    System.out.println("How old is the bear?");
                    age = scan.nextInt();
                    scan.nextLine();
                    System.out.println("How much does the bear weight? (Kilograms)");
                    weight = scan.nextDouble();
                    scan.nextLine();
                    bear = new Bear(animalName, "Bear", age ,weight, "Predator");
                    try {
                        zoo.addAnimals(bear);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else if( animalType == 3)
                {
                    System.out.print("What is its name :");
                    animalName = scan.nextLine();
                    System.out.print("How old is the monkey :");
                    age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("How much does the monkey weight :");
                    weight = scan.nextDouble();
                    scan.nextLine();
                    System.out.print("What color is the monkey? (Kilograms) :");
                    String color = scan.nextLine();
                    //monkey = new Monkey(animalName, "Monkey", age ,weight, "Omnivore",color);
                    try {
                        zoo.addAnimals(monkey);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else if( animalType == 4)
                {
                    System.out.print("What is its name?");
                    animalName = scan.nextLine();
                    System.out.print("How old is the capybara :");
                    age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("How much does the capybara weight? (Kilograms) :");
                    weight = scan.nextDouble();
                    scan.nextLine();
                    capybara = new Capybara(animalName, "Capybara", age ,weight, "Herbivore");
                    try {
                        zoo.addAnimals(capybara);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else if( animalType == 5)
                {
                    System.out.println("What is its name :");
                    animalName = scan.nextLine();
                    System.out.print("How old is the croc :");
                    age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("How much does the croc weight? (Kilograms) :");
                    weight = scan.nextDouble();
                    scan.nextLine();
                    crocodile = new Croc(animalName, "Croc", age ,weight, "Predator");
                    try {
                        zoo.addAnimals(crocodile);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if( selection == 2) {
                System.out.println("\n");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t     ||          Remove Animals        ||");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t || 1. Lion                               ||"); //1 to Add Order To Cart
                System.out.println("\t\t\t\t || 2. Bear                               ||"); //2 to Delete Order From Cart
                System.out.println("\t\t\t\t || 3. Monkey                             ||"); //3 to View Cart
                System.out.println("\t\t\t\t || 4. Capybara                           ||"); //4 to Check Out
                System.out.println("\t\t\t\t || 5. Crocodile                          ||"); //5 to View Receipt
                System.out.println("\t\t\t\t || 0. Exit                               ||"); //0 to Exit Food Ordering System for Customer
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\n");
                System.out.print("Enter animal to be removed : ");
                int delete = scan.nextInt();
                scan.nextLine();
                if (delete == 1) {
                    if (zoo.countAnimalsByType("lion") != 0)     //check if there is the specific type of animal
                    {
                        zoo.listAnimals(lion);      //list the specific animals
                        System.out.print("Enter name of the animal to be removed :");  //prompt user to input the name of animals to be deleted
                        animalName = scan.nextLine();
                        try {
                            zoo.deleteAnimal(animalName, "Lion");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());     //if there is no name display error
                        }
                    } else {
                        System.out.println("=====Animals not available!======");
                    }
                } else if (delete == 2) {
                    if (zoo.countAnimalsByType("bear") != 0) {
                        zoo.listAnimals(bear);
                        System.out.print("Enter name of the animal to be removed :");
                        animalName = scan.nextLine();
                        try {
                            zoo.deleteAnimal(animalName, "Bear");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("=====Animals not available!======");
                    }
                } else if (delete == 3) {
                    if (zoo.countAnimalsByType("monkey") != 0) {
                        zoo.listAnimals(monkey);
                        System.out.print("Enter name of the animal to be removed :");
                        animalName = scan.nextLine();
                        try {
                            zoo.deleteAnimal(animalName, "Monkey");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("=====Animals not available!======");
                    }
                } else if (delete == 4) {
                    if (zoo.countAnimalsByType("capybara") != 0) {
                        zoo.listAnimals(capybara);
                        System.out.print("Enter name of the animal to be removed :");
                        animalName = scan.nextLine();
                        try {
                            zoo.deleteAnimal(animalName, "Capybara");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("=====Animals not available!======");
                    }
                } else if (delete == 5) {
                    if (zoo.countAnimalsByType("crocodile") != 0) {
                        zoo.listAnimals(crocodile);
                        System.out.print("Enter name of the animal to be removed :");
                        animalName = scan.nextLine();
                        try {
                            zoo.deleteAnimal(animalName, "Crocodile");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("=====Animals not available!======");
                    }
                }
            }
            else if( selection == 3)        //to update
            {
                System.out.println("\n");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t      ||         Update Animals        ||");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t || 1. Lion                               ||");
                System.out.println("\t\t\t\t || 2. Bear                               ||");
                System.out.println("\t\t\t\t || 3. Monkey                             ||");
                System.out.println("\t\t\t\t || 4. Capybara                           ||");
                System.out.println("\t\t\t\t || 5. Crocodile                          ||");
                System.out.println("\t\t\t\t || 0. Exit                               ||");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\n");
                int update = scan.nextInt();
                System.out.print("Enter your choice : ");
                scan.nextLine();
                switch(update)
                {
                    case 1 :
                        zoo.listAnimals(lion);      //list animals based on animal type
                        break;
                    case 2 :
                        zoo.listAnimals(bear);
                        break;
                    case 3 :
                        zoo.listAnimals(monkey);
                        break;
                    case 4 :
                        zoo.listAnimals(capybara);
                        break;
                    case 5 :
                        zoo.listAnimals(crocodile);
                        break;
                    default:
                        System.out.println("Ok!");
                        break;
                }
                if(update != 0)
                {
                    System.out.print("Enter the name of the animal to be updated:");       //enter the name of animals to be updated
                    animalName = scan.nextLine();
                    while(zoo.checkAvailability(animalName)!= 1)    //check if there is an animal with the name
                    {
                        if(zoo.checkAvailability(animalName)== 0)       //if there is no animal with the name
                        {
                            System.out.println("There is no such animal with that name!");
                            System.out.println("Please enter the correct name!");
                            System.out.print("Enter the name of the animal to be updated:");
                            animalName = scan.nextLine();
                        }
                    }
                    System.out.println("\t\t\t\t ==========================================");
                    System.out.println("\t\t\t\t         ||         Update        ||");
                    System.out.println("\t\t\t\t ==========================================");
                    System.out.println("\t\t\t\t || 1. Name                               ||"); //1 update name
                    System.out.println("\t\t\t\t || 2. Age                                ||"); //2 update age
                    System.out.println("\t\t\t\t || 3. Weight                             ||"); //3 update weight
                    System.out.println("\t\t\t\t ==========================================");
                    System.out.println("\n");
                    System.out.print("Enter your choice : ");
                    update = scan.nextInt();
                    scan.nextLine();
                    if(update == 1)
                    {
                        System.out.print("Enter the new name of the animal:"); //enter animals name to be updated
                        String newName = scan.nextLine();
                        zoo.updateAnimals(animalName, "name", newName);    //pass the old animal name ,variable to be updated, and the new name
                    }
                    else if(update == 2)
                    {
                        System.out.print("Enter the new age of the animal:");
                        int newAge = scan.nextInt();
                        scan.nextLine();
                        zoo.updateAnimals(animalName, "age", newAge);
                    }
                    else if( update == 3)
                    {
                        System.out.print("Enter the new weight of the animal :");
                        double newWeight = scan.nextDouble();
                        zoo.updateAnimals(animalName, "weight", newWeight);
                    }
                }
            }
            else if( selection == 4)
            {
                System.out.println("\n");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t      ||          Animals Data       ||");
                System.out.println("\t\t\t\t ==========================================");
                System.out.println("\t\t\t\t || 1. Number of animals                  ||"); //1 print number of animals
                System.out.println("\t\t\t\t || 2. Number of animals by type          ||"); //2 print number of animals by type
                System.out.println("\t\t\t\t || 3. Average age                        ||"); //3 print average age of animals
                System.out.println("\t\t\t\t || 4. Average weight                     ||"); //4 print average weight of animals
                System.out.println("\t\t\t\t || 5. Oldest to youngest                 ||");
                System.out.println("\t\t\t\t || 0. Exit                               ||"); //0 to Exit
                System.out.println("\t\t\t\t ==========================================");
                System.out.print("Enter your choice:");
                int animalsData = scan.nextInt();
                scan.nextLine();
                switch (animalsData) {
                    case 1 -> System.out.println("Number of animals is " +
                            zoo.countAnimals());    //print number of animals
                    case 2 -> {
                        System.out.print("Enter the type of animal:");
                        String typeOfAnimals = scan.nextLine();
                        System.out.println("Number of " + typeOfAnimals + " is " +
                                zoo.countAnimalsByType(typeOfAnimals)); //print number of animals by type
                    }
                    case 3 ->
                            System.out.println("The average age of the animals are " + zoo.averageAge());    //print average age
                    case 4 ->
                            System.out.println("The average weight of the animals are " + zoo.calculateAvgWeight()); //print average weight
                    case 5 ->
                        zoo.sortArray();

                }
            }
            else if( selection == 5)    //view all animals
            {
                System.out.println("\n");
                System.out.println("\t\t\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\t\t\t                               Animal List ");
                System.out.println("\t\t\t     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println ("\t\t\t\t     Type \t\t\t\tName \t\t\tAge\t\t\tWeight\t\t\tDiet");
                zoo.listAnimals();
            }
            else if( selection == 0)       //exit system
            {
                System.out.println("Do you wish to save the files? [1. Yes || 2. No]"); //ask user whether or not to delete
                int saveFile = scan.nextInt();
                scan.nextLine();
                if(saveFile == 1)
                {
                   zoo.saveFile();      //to save file
                }
                System.out.println("Thank you for using our system!");
                return;
            }
        }
    }
}