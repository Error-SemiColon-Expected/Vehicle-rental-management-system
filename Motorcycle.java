public class Motorcycle extends Vehicle {
    private int engineDisplacement;
    private boolean helmetIncluded;

    public Motorcycle(String vehicleId, String brand, String model, String type, double dailyRate, int engineDisplacement, boolean helmetIncluded) {
        super(vehicleId, brand, model, type, dailyRate);
        setEngineDisplacement(engineDisplacement);
        setHelmetIncluded(helmetIncluded);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getDailyRate() * days;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public final void setEngineDisplacement(int engineDisplacement) {
        if (engineDisplacement <= 0) {
            throw new IllegalArgumentException("Engine displacement must be greater than zero.");
        }
        this.engineDisplacement = engineDisplacement;
    }

    public boolean isHelmetIncluded() {
        return helmetIncluded;
    }

    public final void setHelmetIncluded(boolean helmetIncluded) {
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public void displayVehicleDetails() {
        super.displayVehicleDetails();
        System.out.printf("\tEngine Displacement: %d cc%n", getEngineDisplacement());
        System.out.println("\tHelmet Included: " + (isHelmetIncluded() ? "Yes" : "No"));
        System.out.println();
        System.out.printf("\tDaily Rate: PHP %,.2f%n", getDailyRate());
        System.out.println("\tVehicle Availability: " + (super.getAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
    }
}
