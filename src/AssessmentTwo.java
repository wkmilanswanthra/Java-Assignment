public class AssessmentTwo {

    public static void main(String[] args) throws Exception {
        partOne();
        partTwo();
        partThree();
        partFour();
        partFive();
        partSix();
    }

    public static void partOne() throws Exception {
        Flight flight = new Flight("BAC204", "New York", "London", "Boeing 777", 234);  //Create a new flight

        flight.addPassenger(new Passenger("Adam", "adam@gmail.com", 24, "X3Q7NC", "34B", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Sam", "sam@gmail.com", 50, "X3U8BF", "01A", 20));    // Add a passenger
        flight.addPassenger(new Passenger("Kim", "kim@gmail.com", 19, "X3L9DG", "72A", 20));    // Add a passenger
        flight.addPassenger(new Passenger("Sandra", "sandra@gmail.com", 32, "X3K3WL", "16C", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Mike", "mike@gmail.com", 43, "X3U0KL", "12A", 20));  // Add a passenger

        flight.removePassenger("Kim");  //Remove passenger from flight

        System.out.println("Number of Passengers in the flight " + flight.getFlightCode() + " is " + flight.numberOfPassengers());   //Print the number of passengers in the flight

        flight.printPassengers();   //Print all the passenger data in the flight
    }

    public static void partTwo() throws Exception {
        Flight flight = new Flight("BAC204", "New York", "London", "Boeing 777", 234);  //Create a new flight object

        flight.addPassenger(new Passenger("Adam", "adam@gmail.com", 24, "X3Q7NC", "34B", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Sam", "sam@gmail.com", 50, "X3U8BF", "01A", 20));    // Add a passenger
        flight.addPassenger(new Passenger("Kim", "kim@gmail.com", 19, "X3L9DG", "72A", 20));    // Add a passenger
        flight.addPassenger(new Passenger("Sandra", "sandra@gmail.com", 32, "X3K3WL", "16C", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Mike", "mike@gmail.com", 43, "X3U0KL", "12A", 20));  // Add a passenger

        System.out.println("Passenger list before sorting");
        flight.printPassengers();   //Print all the passenger data in the flight
        flight.sort(flight.allPassengers(), new Compare());    //Sort all the passengers according to their name
        System.out.println("Passenger list after sorting");
        flight.printPassengers();   //Print all the passenger data in the flight
    }

    public static void partThree() throws Exception {
        Flight flight = new Flight("BAC204", "New York", "London", "Boeing 777", 234);   //Create a new flight

        flight.addAircrew("Pilot", new Aircrew("Max", "max@gmai.com",21, "pilot")); //Add aircrew member to the flight
        flight.addAircrew("Co-Pilot", new Aircrew("Johnson", "johnson@gmai.com",35, "pilot"));  //Add aircrew member to the flight
        flight.addAircrew("FlightAttendantOne", new Aircrew("Blake", "blake@gmai.com",26, "flight attendant")); //Add aircrew member to the flight
        flight.addAircrew("FlightAttendantTwo", new Aircrew("Claire", "claire@gmai.com",24, "flight attendant"));   //Add aircrew member to the flight
        flight.addAircrew("FlightAttendantThree", new Aircrew("Lester", "lester@gmai.com",31, "flight attendant")); //Add aircrew member to the flight

        flight.removeAircrew("FlightAttendantTwo"); // Remove Aircrew member form the flight

        flight.printAircrew();  // Print all the aircrew member data
    }

    public static void partFour() {
        Aircrew person  = new Aircrew("Loid", "email", 54, "pilot"); //Create a new aircrew object
        person.setEmail("loid@gmail.com"); // Set the email of the aircrew object with a valid email
        //person.setEmail("loid#email");   //Set the email of the aircrew object with an invalid email (This will throw an invalid argument exception)

    }

    public static void partFive() throws Exception {
        Flight flight = new Flight("BAC204", "New York", "London", "Boeing 777", 234);   //Create a new flight

        flight.addPassenger(new Passenger("Adam", "adam@gmail.com", 24, "X3Q7NC", "34B", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Sammy", "sam@gmail.com", 50, "X3U8BF", "01A", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Kim", "kim@gmail.com", 19, "X3L9DG", "72A", 20));    // Add a passenger
        flight.addPassenger(new Passenger("Sandra", "sandra@gmail.com", 32, "X3K3WL", "16C", 20));  // Add a passenger
        flight.addPassenger(new Passenger("Mike", "mike@gmail.com", 43, "X3U0KL", "12A", 20));  // Add a passenger

        flight.exportPassengerManifest(); //Export the passenger manifest
    }

    public static void partSix() throws Exception {
        Flight flight = new Flight("BAC204", "New York", "London", "Boeing 777", 234);   //Create a new flight
        flight.importPassengerManifest();   //Import the passenger manifest file data into a new flight object
        System.out.println(flight.numberOfPassengers());    // Print the number of passengers in the new flight
        flight.printPassengers();   //Print the details of the passengers in the flight
    }
}
