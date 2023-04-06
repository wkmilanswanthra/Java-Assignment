public class Aircrew extends Person {

    private String position;    // can be “pilot”, “flight attendant”

    public Aircrew (String name, String email, int age, String position){
        super(name, email, age);
        this.position= position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
