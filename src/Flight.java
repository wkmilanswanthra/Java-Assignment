import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Flight {

    private String flightCode;
    private String origin;
    private String destination;
    private String aircraftType;
    private int numberOfSeats; // number of available seats
    private LinkedList<Passenger> passengers = new LinkedList<>();     //LinkedList of passengers
    private  HashMap<String, Aircrew> crew = new HashMap<>();   //Hashmap containing the aircrew data
    private static Lock lock = new ReentrantLock();

    public Flight(String flightCode, String origin, String destination, String aircraftType, int numberOfSeats) {
        this.flightCode = flightCode;
        this.origin = origin;
        this.destination = destination;
        this.aircraftType = aircraftType;
        this.numberOfSeats = numberOfSeats;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    /**
    *
    * Method to add passengers to the flight
    * */
    public void addPassenger(Passenger passenger) {
        lock.lock();
        try {
            synchronized (this){
                if (!(this.passengers.size() >= this.numberOfSeats))
                    this.passengers.push(passenger);
                else
                    System.out.println("The flight is fully booked. No available seat anymore");
            }
        } catch (Exception e){
            System.out.println("An error occurred when adding a passenger ");
        } finally {
            lock.unlock();
        }
    }

    /**
     *
     * Method to remove passengers from the flight using their name
     * */
    public void removePassenger(String name) {
        lock.lock();
        try {
            synchronized (this){
                this.passengers.removeIf(e -> Objects.equals(e.getName(), name));
            }
        } catch (Exception e){
            System.out.println("An error occurred when removing a passenger ");
        }finally {
            lock.unlock();
        }
    }

    /*
     *
     * Method to get the number of passengers in a flight
     * */
    public int numberOfPassengers(){
        return this.passengers.size();
    }

    /**
     *
     * Method to print passengers in a plane
     * */
    public void printPassengers() throws Exception {
        if (this.passengers.isEmpty())
            throw new Exception("Passenger data of this flight is not available");
        this.passengers.forEach((e)->{
            System.out.println("Details of Passenger : " +e.getPNR());
            System.out.println("\tName:\t\t\t\t"+e.getName());
            System.out.println("\tAge:\t\t\t\t"+e.getAge());
            System.out.println("\tEmail:\t\t\t\t"+e.getEmail());
            System.out.println("\tSeat number:\t\t"+e.getSeat());
            System.out.println("\tLuggage Capacity:\t"+e.getLuggageCapacity()+"kg");
            System.out.println("");
        });
    }

    /**
     *
     * Return a LinkedList with all the passengers in a flight
     * */
    public  LinkedList<Passenger> allPassengers(){
        return this.passengers;
    }

    /**
     *
     * Method to sort all the passengers in a flight 
     * */
    public void sort(List list, Compare comp) throws Exception {
        lock.lock();
        if (list.isEmpty())
            throw new Exception("Passenger data of this flight is not available");
        try {
            synchronized (this){
                Collections.sort(list,comp);
            }
        } catch (Exception e) {
            System.out.println("An error occurred when sorting passengers ");
        } finally {
            lock.unlock();
        }
    }

    /**
     *
     * Add aircrew members to thr flight
     * */
    public void addAircrew(String role, Aircrew aircrew){
        lock.lock();
        try {
            synchronized (this){
                crew.put(role, aircrew);
            }
        } catch (Exception e) {
            System.out.println("An error occurred when adding a crew member");
        } finally {
            lock.unlock();
        }
    }

    /**
     *
     * Remove aircrew from the flight using their role
     * */
    public void removeAircrew(String role) throws Exception {
        lock.lock();
        try {
            synchronized (this){
                crew.remove(role);
            }
        } catch (Exception e) {
            throw new Exception("Passenger data of this flight is not available");
        }finally {
            lock.unlock();
        }
    }

    /**
     *
     * Print all the aircrew members in a flight
     * */
    public void printAircrew() throws Exception {
        if (crew.isEmpty())
            throw new Exception("Crew data of this flight is not available");

        crew.forEach((k,v)->{
            System.out.println("Details of Crew member : " +k);
            System.out.println("\tName:\t\t\t\t"+v.getName());
            System.out.println("\tAge:\t\t\t\t"+v.getAge());
            System.out.println("\tEmail:\t\t\t\t"+v.getEmail());
            System.out.println("\tPosition:\t\t\t"+v.getPosition());
        } );
    }

    /**
     *
     * Export a text file containing  all the passenger data
     * */
    public  void exportPassengerManifest() throws Exception{
        FileWriter file = new FileWriter("Passenger_Manifest.txt");
        try{
            passengers.forEach(passenger -> {
                StringJoiner stringBuilder = new StringJoiner(",");
                stringBuilder.add(passenger.getName()).add(passenger.getEmail()).add(String.valueOf(passenger.getAge())).add(passenger.getPNR()).add((!Objects.equals(passenger.getSeat(), ""))? passenger.getSeat():"000").add((passenger.getLuggageCapacity())+"kg\n");
                System.out.println(stringBuilder);
                try {
                    file.write(String.valueOf(stringBuilder));
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to file");
                }
            });
            file.close();
        }catch (IOException e){
            System.out.println("An error occurred while writing to file");
        }
    }

    /**
     *
     * Import the passenger data from the passenger manifest
     * */
    public  void importPassengerManifest() throws Exception{
        Scanner scanner = new  Scanner(new File("Passenger_Manifest.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] string = line.split(",");
            addPassenger(new Passenger(string[0], string[1], Integer.valueOf(string[2]), string[3], string[4], Integer.valueOf(string[5].substring(0, string[5].length() - 2))));
        }
    }

}