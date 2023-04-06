public class Passenger extends Person {

    private String pnr;
    private String seat;
    private int luggageCapacity;

    public Passenger(String name, String email, int age, String pnr, String seat, int luggageCapacity) {
        super(name, email, age);
        this.pnr = pnr;
        this.seat = seat;
        this.luggageCapacity = luggageCapacity;
    }

    public String getPNR() {
        return pnr;
    }

    public void setPNR(String pnr) {
        this.pnr = pnr;
    }

    public String getSeat () {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat= seat;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }
}
