public class LuxuryCar extends Car {
    public LuxuryCar(String vehicleId, String brand, String model, String type, double dailyRate, int numberOfSeats, String transmissionType) {
        super(vehicleId, brand, model, type, dailyRate, numberOfSeats, transmissionType);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getDailyRate() * days) + (getDailyRate() * days * 0.15);
    }
    
    @Override 
    public void displayCostBreakdown(int days) {
        double base = getDailyRate() * days;
        double surcharge = base * 0.15;
        System.out.printf("\tBase Rental Cost: PHP %,.2f%n", base);
        System.out.printf("\tLuxury Car Surcharge (15%%): PHP %,.2f%n", surcharge);
        super.displayCostBreakdown(days);
    }
}
