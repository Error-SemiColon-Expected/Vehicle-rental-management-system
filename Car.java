public class Car extends Vehicle {
    private int numberOfSeats;
    private String transmissionType;

    public Car(String vehicleId, String brand, String model, String type, double dailyRate, int numberOfSeats, String transmissionType) {
        super(vehicleId, brand, model, type, dailyRate);
        setNumberOfSeats(numberOfSeats);
        setTransmissionType(transmissionType);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getDailyRate() * days;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public final void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than zero.");
        }
        this.numberOfSeats = numberOfSeats;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public final void setTransmissionType(String transmissionType) {
        if (transmissionType == null || transmissionType.trim().isEmpty()) {
            throw new IllegalArgumentException("Transmission type cannot be null or empty.");
        }
        this.transmissionType = transmissionType;
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.println("\tNumber of Seats: " + getNumberOfSeats());
        System.out.println("\tTransmission: " + getTransmissionType());
        System.out.println();
        System.out.printf("\tDaily Rate: PHP %,.2f%n", getDailyRate());
        System.out.println("\tVehicle Availability: " + (super.getAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
    }
}
