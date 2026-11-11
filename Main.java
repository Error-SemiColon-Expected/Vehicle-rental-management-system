import java.util.*;
public class Main {
    static String vehicleId, yesOrNo, input, type;
    static int days, choice;
    static final Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Vehicle selectedVehicle;
    static boolean onLoop = true;
    
    public static void main(String[] args) {
        vehicles.add(new Car("CAR-001", "Ford", "Fiesta", "Car", 1600.00, 5, "Automatic"));
        vehicles.add(new Car("CAR-002", "VinFast", "VF 5", "Car", 1800.00, 5, "Automatic"));
        vehicles.add(new Car("CAR-003", "Renault", "Clio", "Car", 1400.00, 5, "Manual"));

        vehicles.add(new Van("VAN-001", "Toyota", "HiAce", "Van", 3000.00, 15, 1000.00));
        vehicles.add(new Van("VAN-002", "Mazda", "Bongo Friendee", "Van", 2500.00, 8, 600.00));
        vehicles.add(new Van("VAN-003", "Hyundai", "Starex", "Van", 2800.00, 9, 700.00));

        vehicles.add(new Motorcycle("MOTO-001", "Yamaha", "Mio i 125", "Motorcycle", 600.00, 125, true));
        vehicles.add(new Motorcycle("MOTO-002", "Rusi", "Macho 150", "Motorcycle",650.00, 150, false));
        vehicles.add(new Motorcycle("MOTO-003", "KTM", "Duke 200", "Motorcycle",1200.00, 200, true));
        
        vehicles.add(new LuxuryCar("LUX-001", "BMW", "5 Series", "Luxury Car",5500.00, 5, "Automatic"));
        vehicles.add(new LuxuryCar("LUX-002", "Nissan", "Skyline GT-R R34", "Luxury Car",8500.00, 4, "Manual"));
        vehicles.add(new LuxuryCar("LUX-003", "Ferrari", "488 GTB", "Luxury Car",45000.00, 2, "Automatic"));


        System.out.println("\tRICHARD GWAPO VEHICLE RENTALS");
        System.out.println("===============================================");

        do {
            menu(); 
        } while (onLoop);

        scanner.close();
        System.exit(0);
    }

    public static void menu() {
        System.out.println("\t\tMAIN MENU");
        System.out.println("\t1. View vehicles by type");
        System.out.println("\t2. Rent a vehicle");
        System.out.println("\t3. Return a vehicle");
        System.out.println("\t4. Exit");
        choice();
    }

    public static void choice() {
        System.out.println("-----------------------------------------------");
        System.out.print("\tEnter Choice: ");
        
       try {
            choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                case 1:
                    System.out.println("===============================================");
                    System.out.println("\t\tREGISTERED VEHICLES");
                    System.out.println("===============================================");
                    display();
                    break;
    
                case 2:
                    System.out.println("===============================================");
                    System.out.println("\t\tVEHICLE RENTALS");
                    System.out.println("===============================================");
                    rent();
                    break;
                    
                case 3:
                    System.out.println("===============================================");
                    System.out.println("\t\tVEHICLE RETURNS");
                    System.out.println("===============================================");
                    returnVehicle();
                    break;  
                
                case 4:
                    System.out.println("\tThank you for using RGVR");
                    onLoop = false;
                    break;
                default:
                    System.out.println("\t\tNO SUCH OPTION");
                    System.out.println("\tPLEASE ENTER A VALID CHOICE");
                }
       } catch (NumberFormatException e) {
            System.out.println("\t\tINVALID INPUT");
            System.out.println("\tPLEASE ENTER A VALID CHOICE");
       } catch (NoSuchElementException e) {
            onLoop = false;
       }
    }

    public static void display() {
        System.out.println("\t(CAR | VAN | MOTO | LUX)");
        System.out.print("\tEnter vehicle type: ");
        input = scanner.nextLine().trim();

        findVehicleByType(input);
    }

    public static void rent() {
        System.out.print("\tEnter vehicle ID: ");

        vehicleId = scanner.nextLine().trim();

        selectedVehicle = findVehicleId(vehicleId);

        if (selectedVehicle == null) {
            System.out.println("\tNO SUCH VEHICLE WITH ID EXISTS");
            System.out.println("\tPLEASE ENTER A VALID CHOICE");
            System.out.println("-----------------------------------------------");
            return;
        }

        if (!selectedVehicle.getAvailable()) {
            System.out.println("\t\tVehicle unavailable");
            System.out.println("\tPlease choose an available vehicle");
            System.out.println("-----------------------------------------------");
            return;
        } 

        while (true) {
            System.out.print("\tEnter number of rental days: ");    

            try {
                days = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\t\tINVALID INPUT");
                System.out.println("\tPLEASE ENTER A VALID NUMBER OF DAYS");
                continue;
            }
            
            if (days <= 0) {
                System.out.println("-----------------------------------------------");
                System.out.println("\tRENTAL DAYS MUST BE GREATER THAN ZERO!");
                continue;
            }
            break;
        }

        selectedVehicle.displayVehicleDetails();
        System.out.println("\tRental Days: " + days);
        selectedVehicle.displayCostBreakdown(days);
        System.out.println("-----------------------------------------------");
        confirmRent();
    }
    
    public static void confirmRent() {
        while (true) {
            System.out.print("\tConfirm Transaction? (Y/N): ");
            yesOrNo = scanner.nextLine().trim();
            if (yesOrNo.equalsIgnoreCase("Y")) {
                if (selectedVehicle.rentVehicle()) {
                    System.out.println("\tRental Status: SUCCESSFUL");
                    System.out.println("\tVehicle Availability: " + (selectedVehicle.getAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
                } else {
                    System.out.println("\tTransaction Failed: vehicle is no longer available");
                    System.out.println("\tVehicle Availability: " + (selectedVehicle.getAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
                }
                System.out.println("-----------------------------------------------");
                return;
            } else if (yesOrNo.equalsIgnoreCase("N")) {
                System.out.println("\tTransaction Cancelled");
                System.out.println("-----------------------------------------------");
                return;
            } else {
                System.out.println("\t\tINVALID INPUT");
                System.out.println("\tPLEASE ENTER A VALID CHOICE");
                System.out.println("-----------------------------------------------");
            }
        }
    }

    public static void returnVehicle() {
        System.out.print("\tEnter vehicle ID: ");

        vehicleId = scanner.nextLine().trim();

        selectedVehicle = findVehicleId(vehicleId);

        if (selectedVehicle == null) {
            System.out.println("\tNO SUCH VEHICLE WITH ID EXISTS");
            System.out.println("\tPLEASE ENTER A VALID CHOICE");
            System.out.println("-----------------------------------------------");
            return;
        }

        if (!selectedVehicle.getAvailable()) {
            while (true) {
            System.out.print("\tConfirm Return? (Y/N): ");
            yesOrNo = scanner.nextLine().trim();
            if (yesOrNo.equalsIgnoreCase("Y")) {
                if (selectedVehicle.returnVehicle()) {
                    System.out.println("\tReturn Status: SUCCESSFUL");
                } else {
                    System.out.println("\tReturn Failed: vehicle is already available");
                }
                System.out.println("\tVehicle Availability: " + (selectedVehicle.getAvailable() ? "AVAILABLE" : "NOT AVAILABLE"));
                System.out.println("-----------------------------------------------");
                return;
            } else if (yesOrNo.equalsIgnoreCase("N")) {
                System.out.println("\tTransaction Cancelled");
                System.out.println("-----------------------------------------------");
                return;
            } else {
                System.out.println("\t\tINVALID INPUT");
                System.out.println("\tPLEASE ENTER A VALID CHOICE");
                System.out.println("-----------------------------------------------");
            }
            }
        } else {
            System.out.println("\tVEHICLE IS ALREADY AVAILABLE");
            System.out.println("-----------------------------------------------");
        }
    }

    public static Vehicle findVehicleId(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public static void findVehicleByType(String input) {
        switch (input.toUpperCase()) {
            case "CAR":
            type = "Car";
            System.out.println("===============================================");
            System.out.println("\t\tREGISTERED CARS");
            System.out.println("===============================================");
            break;
        case "VAN":
            type = "Van";
            System.out.println("===============================================");
            System.out.println("\t\tREGISTERED VANS");
            System.out.println("===============================================");
            break;
        case "MOTO":
            type = "Motorcycle";
            System.out.println("===============================================");
            System.out.println("\t\tREGISTERED MOTORCYCLES");
            System.out.println("===============================================");
            break;
        case "LUX":
            type = "Luxury Car";
            System.out.println("===============================================");
            System.out.println("\t\tREGISTERED LUXURY CARS");
            System.out.println("===============================================");
            break;
        default:
            System.out.println("\tNO SUCH VEHICLE TYPE");
            System.out.println("\tPLEASE ENTER A VALID TYPE");
            System.out.println("-----------------------------------------------");
            return;
    }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                vehicle.displayVehicleDetails();
                System.out.println("-----------------------------------------------");
            }
        }
    }
}
