public class Anonymous {
    public static void main(String[] args) {
        Rectangle a = new Rectangle();

        Shape anonymous = new Shape() {
            int depth = 40;

            @Override
            public int get() {
                return width * height * depth;
            }

        };
        System.out.println("a.get() = " + a.get());
        System.out.println("anonymous.get() = " + anonymous.get());

    }

}

class Rectangle implements Shape{
    int depth = 40;

    @Override
    public int get() {
        return width * height * depth;
    }
}

interface Shape {
    int width = 10;
    int height = 20;

    int get();
}
