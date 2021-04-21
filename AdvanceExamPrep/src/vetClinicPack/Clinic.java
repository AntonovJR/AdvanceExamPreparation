package vetClinicPack;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(obj -> obj.getName().equals(name));

    }

    public Pet getOldestPet() {
        int max = -1;
        Pet oldestPet = null;

        for (Pet pet : data) {
            if (pet.getAge() > max) {
                max = pet.getAge();
                oldestPet = pet;
            }

        }

        return oldestPet;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }

        }

        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(String.format("%s %s%n",pet.getName(),pet.getOwner()));

        }

        return sb.toString();
    }

}





