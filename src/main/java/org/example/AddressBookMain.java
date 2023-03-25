package org.example;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static final int ADD_ADDRESS_BOOK = 1;
    public static final int DELETE_ADDRESS_BOOK = 2;
    private static final int EDIT_ADDRESS_BOOK = 3;
    private static final int PRINT_ADDRESS_BOOK = 4;
    private static final int SEARCH_BY_CITY_STATE = 5;
    private static final int SORTED_CONTACT_LIST = 6;
    private static final int WRITE_IO_FILE = 7;
    private static final int READ_IO_FILE = 8;
    public static final int EXIT = 0;

    public static void main(String[] args) {
        try {
            HashMap<String, AddressBookOperations> address_Dictionary = new HashMap<>();
            int countOfPersonsCity;
            int countOfPersonsState;
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Address Book");
            AddressBookOperations addressBookOperations = new AddressBookOperations();
            boolean loop = true;
            while (loop) {
                System.out.println("Enter the choice:-\n1.Add a new Address Book\n2.Edit Address Book\n" +
                        "3.Delete Address Book\n4.Print Address Books\n5.Search by city or state" +
                        "\n6.Sort Contacts by First Name\n7.Write to IO file\n8.Read from IO file\n9.Write into CSV file\n0.To exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case ADD_ADDRESS_BOOK -> addressBookOperations.createAddressBooks(address_Dictionary);
                    case EDIT_ADDRESS_BOOK -> addressBookOperations.editBooks(address_Dictionary);
                    case DELETE_ADDRESS_BOOK -> addressBookOperations.deleteBook(address_Dictionary);
                    case PRINT_ADDRESS_BOOK -> addressBookOperations.printBooks(address_Dictionary);
                    case SEARCH_BY_CITY_STATE -> {
                        Scanner scanner = new Scanner(System.in);
                        Map<String, List<Address>> cityHashMap = new HashMap<>();
                        Map<String, List<Address>> stateHashMap = new HashMap<>();
                        System.out.println("Enter choice of search:-\n1.City\n2.State");
                        int option = scanner.nextInt();
                        scanner.nextLine();
                        switch (option) {
                            case 1 -> {
                                System.out.println("Enter city name:-");
                                String city = scanner.nextLine();
                                countOfPersonsCity = addressBookOperations.searchByCity(city, address_Dictionary).size();
                                cityHashMap.put(city, addressBookOperations.searchByCity(city, address_Dictionary));
                                System.out.println("Number of persons living in " + city + " is:-" + countOfPersonsCity);
                                System.out.println(cityHashMap);
                            }
                            case 2 -> {
                                System.out.println("Enter State name:-");
                                String state = scanner.nextLine();
                                countOfPersonsState = addressBookOperations.searchByState(state, address_Dictionary).size();
                                stateHashMap.put(state, addressBookOperations.searchByState(state, address_Dictionary));
                                System.out.println("Number of persons living in " + state + " is:-" + countOfPersonsState);
                                System.out.println(stateHashMap);
                            }
                        }
                    }
                    case SORTED_CONTACT_LIST ->addressBookOperations.sortContacts(addressBookOperations,address_Dictionary);
                    case WRITE_IO_FILE -> addressBookOperations.writeToFile(address_Dictionary,addressBookOperations);
                    case READ_IO_FILE -> addressBookOperations.readIOFile();
                    case EXIT -> loop = false;
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}