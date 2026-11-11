public abstract class Vehicle{
    private String vehicleId;
    private String brand;
    private String model;
    private String type;
    private double dailyRate;
    private boolean available;

    public Vehicle(String vehicleId, String brand, String model, String type, double dailyRate) {
        setVehicleId(vehicleId);
        setBrand(brand);
        setModel(model);
        setType(type);
        setDailyRate(dailyRate);
        this.available = true;
    }

    public final void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        this.vehicleId = vehicleId;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
 
    public final void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty.");
        }
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public final void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public final void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty.");
        }
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public final void setDailyRate(double dailyRate) {
        if (dailyRate <= 0) {
            throw new IllegalArgumentException("Daily rate must be greater than zero.");
        }
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    private void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public abstract double calculateRentalCost(int days);

    public boolean rentVehicle() {
        if (!available) return false;
        setAvailable(false);
        return true;
    }

    public boolean returnVehicle() {
        if (available) return false;
        setAvailable(true);
        return true;
    }

    public void displayCostBreakdown(int days) {
        System.out.printf("\tTotal Rental Cost: PHP %,.2f%n", calculateRentalCost(days));
    }

    public void displayVehicleDetails() {
        System.out.println("\tVehicle ID: " + getVehicleId());
        System.out.println("\tBrand: " + getBrand());
        System.out.println("\tModel: " + getModel());
        System.out.println("\tVehicle Type: " + getType());
    }
}