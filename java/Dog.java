public class Dog {

    private String name;
    private String species;

    public static String introduce (String name, String species, int price) {
        return name + " : " + species + " : " + price;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
