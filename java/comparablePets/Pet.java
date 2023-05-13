package comparablePets;

public abstract class Pet implements Comparable<Pet> {
    private String name;

    public Pet(String name) { this.name = name; }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    public abstract String speak();

    @Override
    public int compareTo(Pet pet) {
        int nameComparison = this.name.compareTo(pet.getName());
        if (nameComparison != 0) {
            return nameComparison;
        } else {
            return this.getClass().getName().compareTo(pet.getClass().getName());
        }
    }
}