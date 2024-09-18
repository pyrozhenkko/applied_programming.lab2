package main;

import java.util.LinkedList;
import java.util.Scanner;
import show.Car;

public class Main {
    public static void main(String[] args) {
        LinkedList<Car> car_list = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

//        Car.Registr_number reg1 = new Car().new Registr_number();
//        reg1.set_region_code("AB");
//        reg1.set_number("1234");
//        reg1.set_series_code("CD");
//
//        Car.Registr_number reg2 = new Car().new Registr_number();
//        reg2.set_region_code("XY");
//        reg2.set_number("5678");
//        reg2.set_series_code("ZA");
//
//        Car.Registr_number reg3 = new Car().new Registr_number();
//        reg3.set_region_code("GH");
//        reg3.set_number("9101");
//        reg3.set_series_code("JK");
//
//        Car car1 = new Car("Toyota", 2010, 8000.0, reg1);
//        Car car2 = new Car("BMW", 2018, 20000.0, reg2);
//        Car car3 = new Car("Mercedes", 2020, 35000.0, reg3);
//
//        car_list.add(car1);
//        car_list.add(car2);
//        car_list.add(car3);
        boolean exit = false;

        while (!exit) {
            menu();
            System.out.println("Enter your choice:");
            int choice = scan.nextInt();
            scan.nextLine();  // Очищення буферу

            switch (choice) {
                case 1:
                    show_all_cars(car_list);
                    break;
                case 2:
                    Car car = check_car();
                    add_car(car_list, car);
                    break;
                case 3:
                    System.out.println("Enter the ID of the car to delete:");
                    int id = scan.nextInt();
                    delete_car_by_id(car_list, id);
                    break;
                case 4: {
                    System.out.println("Enter the model of the car to search:");
                    String model = scan.nextLine();
                    System.out.println("Enter the age:");
                    int age = scan.nextInt();
                    show_model_more_than_year(car_list, model, age);
                    break;
                }
                case 5: {
                    System.out.println("Enter the Year of the car to search:");
                    int year = scan.nextInt();
                    System.out.println("Enter the price you want to find car with higher one:");
                    double price = scan.nextDouble();
                    show_model_more_than_price(car_list, year, price);
                    break;

                }
                case 6: {
                    System.out.println("Enter the model of the car to search:");
                    String model = scan.nextLine();
                    show_model(car_list, model);
                    break;
                    }
                case 7:
                    exit = true;
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static boolean is_alphabetic(String str) {
        return str.matches("[a-zA-Z]+");
    }

    public static boolean isNumeric(String str) {
        return str.matches("[0-9]+");
    }

    public static Car check_car() {
        Scanner scan = new Scanner(System.in);
        Car car = new Car();
        int year;
        String model, region_code, series_code, numbers;
        double price;
        boolean temp = true;

        do {
            if (temp) {
                System.out.println("Enter model of the car:");
            } else {
                System.out.println("Please enter a valid model (model must be alphabetic and have 3-20 symbols):");
            }
            model = scan.nextLine();
            car.setModel(model);
            temp = false;
        } while (model.length() > 20 || model.length() < 2 || !is_alphabetic(model));

        temp = true;
        do {
            if (temp) {
                System.out.println("Enter year of the car:");
            } else {
                System.out.println("Please enter a valid year (from 1900 to 2024):");
            }
            year = scan.nextInt();
            scan.nextLine();
            car.setYear(year);
            temp = false;
        } while (year < 1900 || year > 2024);

        temp = true;
        do {
            if (temp) {
                System.out.println("Enter price of the car:");
            } else {
                System.out.println("Please enter a valid price (must be more than 0 and numeric):");
            }
            price = scan.nextDouble();
            scan.nextLine();
            car.setPrice(price);
            temp = false;
        } while (price < 0);

        Car.Registr_number registr_number = car.getRegistr_Number();

        temp = true;
        do {
            if (temp) {
                System.out.println("Enter region code of the car:");
            } else {
                System.out.println("Please enter a valid region code (at least 2 alphabetic symbols):");
            }
            region_code = scan.nextLine();
            registr_number.set_region_code(region_code);
            temp = false;
        } while (!is_alphabetic(region_code) || region_code.length() != 2);

        temp = true;
        do {
            if (temp) {
                System.out.println("Enter code-number of the car:");
            } else {
                System.out.println("Please enter a valid code-number (4 numeric symbols):");
            }
            numbers = scan.nextLine();
            registr_number.set_number(numbers);
            temp = false;
        } while (numbers.length() != 4 || !isNumeric(numbers));

        temp = true;
        do {
            if (temp) {
                System.out.println("Enter series code of the car:");
            } else {
                System.out.println("Please enter a valid series code (at least 2 alphabetic symbols):");
            }
            series_code = scan.nextLine();
            registr_number.set_series_code(series_code);
            temp = false;
        } while (!is_alphabetic(series_code) || series_code.length() != 2);

        car.setRegistr_Number(registr_number);
        return car;
    }

    public static void add_car(LinkedList<Car> car_list, Car car) {
        car_list.add(car);
        System.out.println("Car added successfully:");
        car.show();
    }


    public static void delete_car_by_id(LinkedList<Car> car_list, int id) {
        Car toRemove = null;
        for (Car car : car_list) {
            if (car.getId() == id) {
                toRemove = car;
                break;
            }
        }

        if (toRemove != null) {
            car_list.remove(toRemove);
            System.out.println("Car with ID " + id + " deleted.");
        } else {
            System.out.println("Car with ID " + id + " not found.");
        }
    }

    public static void show_model(LinkedList<Car> car_list, String current_model) {
        boolean found = false;
        for (Car car : car_list) {
            if (car.getModel().equals(current_model)) {
                car.show();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars found with model " + current_model);
        }
    }

    public static void show_model_more_than_year(LinkedList<Car> car_list,String current_model, int years) {
        boolean found_model = false;
        for (Car car : car_list) {
            if (car.getModel().equals(current_model)) {
                if (car.getYear() <= 2024 - years) {
                    found_model = true;
                    car.show();
                }
            }
        }
        if(!found_model){
                System.out.println("No cars found with your request");
        }
    }
    public static void show_model_more_than_price(LinkedList<Car> car_list,int year, double price) {
        boolean found = false;
        for (Car car : car_list) {
            if (year == car.getYear()){
                if (car.getPrice() >= price) {
                    found = true;
                    car.show();
                }
            }
        }
        if(!found){
            System.out.println("No cars found with price higher than " + price);
        }

    }

    public static void show_all_cars(LinkedList<Car> car_list) {
        if (car_list.isEmpty()) {
            System.out.println("No cars in the list.");
        } else {
            for (Car car : car_list) {
                car.show();
            }
        }
    }

    public static void menu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Show all cars");
        System.out.println("2 - Add a car");
        System.out.println("3 - Remove a car by ID");
        System.out.println("4 - List of cars of the model, which have been operated for more than n years");
        System.out.println("5 - List of cars of the year, the price of which is higher than yours");
        System.out.println("6 - Search for a car by model");
        System.out.println("7 - Exit");
    }
}
