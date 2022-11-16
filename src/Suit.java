public class Suit {
    private String name, color;

    public Suit(){}

    public Suit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean matches(Suit suit){
        boolean isNameMatching = this.name.equalsIgnoreCase(suit.getName());
        boolean isColorMatching = this.color.equalsIgnoreCase(suit.getColor());

        return isNameMatching && isColorMatching;
    }

}
