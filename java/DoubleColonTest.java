public class DoubleColonTest {

    public static void main(String[] args) {

        StringToDog stringToDog1 = (name, species, price) -> Dog.introduce(name, species, price);
        StringToDog stringToDog2 = Dog::introduce;

        System.out.println(stringToDog1.convert("개똥이", "믹스", 100));
        System.out.println(stringToDog2.convert("누렁이", "믹스", 1000));

    }
}
