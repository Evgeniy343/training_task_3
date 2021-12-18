package second_extended_path;

import java.util.Objects;

public class Allergy {
    private final String allergyName;

    public Allergy(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getAllergyName() {
        return allergyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergy allergy = (Allergy) o;
        return Objects.equals(allergyName, allergy.allergyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allergyName);
    }

    @Override
    public String toString() {
        return "Allergy{" +
                "allergyName='" + allergyName + '\'' +
                '}';
    }
}
