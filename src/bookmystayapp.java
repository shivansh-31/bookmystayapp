/**
 * Book My Stay App
 * Hotel Booking Management System
 * @author SHIVANSH DHINGRA
 * @version 7.0
 */

import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class AddOnService {
    String serviceName;
    int price;

    AddOnService(String serviceName, int price) {
        this.serviceName = serviceName;
        this.price = price;
    }
}

class AddOnServiceManager {

    HashMap<String, List<AddOnService>> reservationServices;

    AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    void addService(Reservation r, AddOnService service) {

        reservationServices.putIfAbsent(r.guestName, new ArrayList<>());
        reservationServices.get(r.guestName).add(service);

        System.out.println("Service Added for " + r.guestName);
        System.out.println("Service: " + service.serviceName);
        System.out.println("Cost: " + service.price);
        System.out.println();
    }

    void calculateTotalCost(Reservation r) {

        List<AddOnService> services = reservationServices.get(r.guestName);

        if (services == null) {
            System.out.println("No add-on services selected for " + r.guestName);
            System.out.println();
            return;
        }

        int total = 0;

        for (AddOnService s : services) {
            total += s.price;
        }

        System.out.println("Guest: " + r.guestName);
        System.out.println("Total Add-On Cost: " + total);
        System.out.println();
    }
}

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {

        System.out.println("Book My Stay");
        System.out.println("Hotel Booking Management System");
        System.out.println("Version 7.0");

        Reservation r1 = new Reservation("Aman", "Single Room");
        Reservation r2 = new Reservation("Neha", "Double Room");

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService(r1, new AddOnService("Breakfast", 500));
        manager.addService(r1, new AddOnService("Airport Pickup", 1200));

        manager.addService(r2, new AddOnService("Spa Service", 2000));

        manager.calculateTotalCost(r1);
        manager.calculateTotalCost(r2);
    }
}