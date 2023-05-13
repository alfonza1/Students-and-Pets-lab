

package comparablePets;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         System.out.println("How many pets do you have?");

        int numPets = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Pet> pets = new ArrayList<Pet>();

        for (int i = 0; i < numPets; i++) {
           System.out.println("What type of animal is your first pet?");
            String petType = scanner.nextLine();

            System.out.println("What is its name?");
            String petName = scanner.nextLine();

            if (petType.equalsIgnoreCase("dog")) {
                pets.add(new Dog(petName));
            } else if (petType.equalsIgnoreCase("cat")) {
                pets.add(new Cat(petName));
            } else if (petType.equalsIgnoreCase("snake")) {
                pets.add(new Snake(petName));
            }
        }

        Collections.sort(pets);

        PetComparator petComparator = new PetComparator();
        Collections.sort(pets, petComparator);

        System.out.println("\nSorting Pets by type and name...");
        for (Pet pet : pets) {
            System.out.println(pet.getClass().getSimpleName() + " named " + pet.getName() + " says " + pet.speak());
        }
    }
}


