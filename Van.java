public class Van extends Vehicle {
    private int seatingCapacity;
    private double cargoCapacity;

    public Van(String vehicleId, String brand, String model, String type, double dailyRate, int seatingCapacity, double cargoCapacity) {
        super(vehicleId, brand, model, type, dailyRate);
        setSeatingCapacity(seatingCapacity);
        setCargoCapacity(cargoCapacity);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getDailyRate() * days) + (getDailyRate() * days * 0.1);
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public final void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be greater than zero.");
        }
        this.cargoCapacity = cargoCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public final void setSeatingCapacity(int seatingCapacity) {
        if (seatingCapacity <= 0) {
            throw new IllegalArgumentException("Seating capacity must be greater than zero.");
        }
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void displayCostBreakdown(int days) {
        double base = getDailyRate() * days;
        double surcharge = base * 0.10;
        System.out.printf("\tBase Rental Cost: PHP %,.2f%n", base);
        System.out.printf("\tVan Surcharge (10%%): PHP %,.2f%n", surcharge);
        super.displayCostBreakdown(days);
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.printf("\tCargo Capacity: %,.2f kg%n", getCargoCapacity());
        System.out.println("\tSeating Capacity: " + getSeatingCapacity() + " passengers");
        System.out.println();
        System.out.printf("\tDaily Rate: PHP %,.2f%n", getDailyRate());
        System.out.println("\tVehicle Availability: " + (super.getAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
    }
}
