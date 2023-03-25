package org.example;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookOperations {
    Scanner sc = new Scanner(System.in);
    List<Address> addressList = new ArrayList<>();

    public void readDetails() {
        boolean addContact = true;
        while (addContact) {
            Address address1 = new Address();
            Scanner sc1 = new Scanner(System.in);

            System.out.println("Enter contact detail:");
            System.out.println("Enter First Name:");
            address1.setFirstName(sc1.nextLine());

            System.out.println("Enter Last Name:");
            address1.setLastName(sc1.nextLine());

            System.out.println("Enter Phone Number:");
            address1.setPhoneNumber(sc1.nextLong());

            sc1.nextLine();
            System.out.println("Enter EmailID:");
            address1.setEMail(sc1.nextLine());

            System.out.println("Enter Address");
            address1.setAddress(sc1.nextLine());

            System.out.println("Enter City:");
            address1.setCity(sc1.nextLine());

            System.out.println("Enter State:");
            address1.setState(sc1.nextLine());

            System.out.println("Enter PinCode:");
            address1.setPinCode(sc1.nextInt());

            boolean present = true;

            for (Address tempAddress : addressList) {
                if (tempAddress.getFirstName().equalsIgnoreCase(address1.getFirstName()) && tempAddress.getLastName().equalsIgnoreCase(address1.getLastName())) {
                    System.out.println("Contact person already exist!");
                    present = false;
                }
            }
            if (present) {
                Address address2 = new Address(address1.getFirstName(), address1.getLastName(), address1.getPhoneNumber(),
                        address1.getEMail(), address1.getAddress(), address1.getCity(), address1.getState(),
                        address1.getPinCode());
                addressList.add(address2);
            }
            System.out.println("If you want add another contact enter add or else enter exit:-");
            String choice = sc.next();
            addContact = choice.equalsIgnoreCase("add");
        }
    }

    public void editDetails() {
        final int FIRST_NAME = 1;
        final int LAST_NAME = 2;
        final int PHONE_NUMBER = 3;
        final int EMAIL = 4;
        final int ADDRESS = 5;
        final int CITY = 6;
        final int STATE = 7;
        final int PIN_CODE = 8;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter First Name:-");
        String firstName = sc2.nextLine();
        System.out.println("Enter Last Name:-");
        String lastName = sc2.nextLine();
        boolean loop = true;
        while (loop) {
            for (Address x : addressList) {
                if (x.getFirstName().equalsIgnoreCase(firstName) && x.getLastName().equalsIgnoreCase(lastName)) {
                    System.out.println("Choose which detail you want to change:-");
                    System.out.println("1.First name\n2.Last Name\n3.Phone Number\n4.EMail\n5.Address\n6.City\n7.State\n8.PinCode");
                    int choice = sc2.nextInt();
                    sc2.nextLine();
                    switch (choice) {
                        case FIRST_NAME -> {
                            System.out.println("Enter the New First Name:-");
                            x.setFirstName(sc2.nextLine());
                        }
                        case LAST_NAME -> {
                            System.out.println("Enter the New Last Name:-");
                            x.setLastName(sc2.nextLine());
                        }
                        case PHONE_NUMBER -> {
                            System.out.println("Enter the New Phone Number:-");
                            x.setPhoneNumber(sc2.nextLong());
                        }
                        case EMAIL -> {
                            System.out.println("Enter the New Email ID:-");
                            x.setEMail(sc2.nextLine());
                        }
                        case ADDRESS -> {
                            System.out.println("Enter the New Address:-");
                            x.setAddress(sc2.nextLine());
                        }
                        case CITY -> {
                            System.out.println("Enter the New City:-");
                            x.setCity(sc2.nextLine());
                        }
                        case STATE -> {
                            System.out.println("Enter the new state:-");
                            x.setState(sc2.nextLine());
                        }
                        case PIN_CODE -> {
                            System.out.println("Enter New PinCode");
                            x.setPinCode(sc2.nextInt());
                        }
                    }
                    updatedContactDetail(x);
                }
                firstName = x.getFirstName();
                lastName = x.getLastName();
            }
            System.out.println("If you want to change any other details of this contact enter edit:-");
            String editContact = sc.next();
            loop = editContact.equalsIgnoreCase("edit");
        }
    }

    public void updatedContactDetail(Address address) {
        System.out.println("Updated Details of contact");
        System.out.println("Name:-" + address.getFirstName() + " " + address.getLastName());
        System.out.println("Phone Number:-" + address.getPhoneNumber());
        System.out.println("EMail:-" + address.getEMail());
        System.out.println("Address:-" + address.getAddress());
        System.out.println("City:-" + address.getCity());
        System.out.println("State:-" + address.getState());
        System.out.println("PinCode:-" + address.getPinCode());
    }

    public void deleteContact() {
        sc.nextLine();
        System.out.println("Enter the First name of the person whose details you want delete:-");
        String firstName = sc.nextLine();
        System.out.println("Enter the Last name of the person whose details you want delete:-");
        String lastName = sc.nextLine();
        addressList.removeIf(x -> x.getFirstName().equalsIgnoreCase(firstName) && x.getLastName().equalsIgnoreCase(lastName));
    }

    public void printDetails() {
        for (Address x : addressList) {
            System.out.println("Details for Person");
            System.out.println("Name:-" + x.getFirstName() + " " + x.getLastName());
            System.out.println("Phone Number:-" + x.getPhoneNumber());
            System.out.println("EMail:-" + x.getEMail());
            System.out.println("Address:-" + x.getAddress());
            System.out.println("City:-" + x.getCity());
            System.out.println("State:-" + x.getState());
            System.out.println("PinCode:-" + x.getPinCode());
            System.out.println();
        }
    }

    public void addressBook(String bookName, AddressBookOperations addressBookOperations) {
        final int ADD_CONTACT = 1;
        final int EDIT_CONTACT = 2;
        final int PRINT_CONTACT = 3;
        final int DELETE_CONTACT = 4;
        final int EXIT = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to " + bookName + " Address Book");
        boolean loop = true;
        while (loop) {
            System.out.println("Enter the choice:-\n1.Add a new contact\n2.Edit Contact Details\n3.Display the Contacts\n4.Delete a contact\n5.To exit");
            int choice = sc.nextInt();
            switch (choice) {
                case ADD_CONTACT -> addressBookOperations.readDetails();
                case EDIT_CONTACT -> addressBookOperations.editDetails();
                case PRINT_CONTACT -> addressBookOperations.printDetails();
                case DELETE_CONTACT -> addressBookOperations.deleteContact();
                case EXIT -> loop = false;
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public void createAddressBooks(HashMap<String, AddressBookOperations> addressDictionary) {

        System.out.println("Enter address book name:-");
        String addressBookName = sc.nextLine();

        if (addressDictionary.containsKey(addressBookName)) {
            System.out.println("Address book already exits");
            return;
        }

        AddressBookOperations addressBookOperations = new AddressBookOperations();
        addressBookOperations.addressBook(addressBookName, addressBookOperations);
        addressDictionary.put(addressBookName, addressBookOperations);
    }

    public void editBooks(HashMap<String, AddressBookOperations> addressDictionary) {
        System.out.println("Enter the address book name you want to edit:-");
        String addressBookName = sc.nextLine();
        if (addressDictionary.containsKey(addressBookName)) {
            System.out.println("Address book already exits");
            AddressBookOperations addressBookOperations = addressDictionary.get(addressBookName);
            addressBookOperations.addressBook(addressBookName, addressBookOperations);
        } else {
            System.out.println(addressBookName + "Address book doesn't\nAdd Address book first");
            AddressBookOperations addressBookOperations = new AddressBookOperations();
            addressBookOperations.createAddressBooks(addressDictionary);
        }
    }

    public void deleteBook(HashMap<String, AddressBookOperations> addressDictionary) {
        System.out.println("Enter the address book name you want to delete:-");
        String addressBookName = sc.nextLine();
        if (addressDictionary.containsKey(addressBookName)) {
            addressDictionary.remove(addressBookName);
            System.out.println("Address book deleted successfully");
        } else {
            System.out.println("Address book doesn't exist");
        }
    }

    public void printBooks(HashMap<String, AddressBookOperations> addressDictionary) {
        for (Map.Entry<String, AddressBookOperations> addressBook : addressDictionary.entrySet()) {
            System.out.println(addressBook.getKey());
            addressBook.getValue().printDetails();
        }
    }

    public List<Address> searchByState(String state, HashMap<String, AddressBookOperations> addressDictionary) {
        return addressDictionary.values().stream().flatMap(p -> p.addressList.stream()).filter(p -> p.getCity().equalsIgnoreCase(state)).collect(Collectors.toList());
    }

    public List<Address> searchByCity(String city, HashMap<String, AddressBookOperations> addressDictionary) {
        return addressDictionary.values().stream().flatMap(p -> p.addressList.stream()).filter(p -> p.getState().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    public List<Address> sortContactByName(HashMap<String, AddressBookOperations> addressDictionary) {
        return addressDictionary.values().stream().flatMap(p -> p.addressList.stream()).sorted(Comparator.comparing(Address::getFirstName)).collect(Collectors.toList());
    }
    public List<Address> sortContactByCity(HashMap<String, AddressBookOperations> addressDictionary){
        return addressDictionary.values().stream().flatMap(p->p.addressList.stream()).sorted(Comparator.comparing(Address::getCity)).collect(Collectors.toList());
    }
    public List<Address> sortContactByZipCode(HashMap<String, AddressBookOperations> addressDictionary){
        return addressDictionary.values().stream().flatMap(p->p.addressList.stream()).sorted(Comparator.comparing(Address::getPinCode)).collect(Collectors.toList());
    }
    public List<Address> sortContactByState(HashMap<String, AddressBookOperations> addressDictionary){
        return addressDictionary.values().stream().flatMap(p->p.addressList.stream()).sorted(Comparator.comparing(Address::getState)).collect(Collectors.toList());
    }
    public void sortContacts(AddressBookOperations addressBookOperations,HashMap<String, AddressBookOperations> addressDictionary){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter choice for sorting:-\n1.Name\n2.City\n3.State\n4.ZipCode");
        int choice=scanner.nextInt();
        switch (choice){
            case 1-> System.out.println(addressBookOperations.sortContactByName(addressDictionary));
            case 2-> System.out.println(addressBookOperations.sortContactByCity(addressDictionary));
            case 3-> System.out.println(addressBookOperations.sortContactByState(addressDictionary));
            case 4-> System.out.println(addressBookOperations.sortContactByZipCode(addressDictionary));
        }
    }

    public void writeToCSVFile(HashMap<String, AddressBookOperations> addressDictionary) {
        try {
            String csvPath="src/main/resources/Contact.csv";
            List<String[]> csvDataList=new LinkedList<>();
            List<Address> sortedList=addressDictionary.values().stream().flatMap(p->p.addressList.stream()).toList();
            FileOutputStream fileOutputStream=new FileOutputStream(csvPath);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            CSVWriter write=new CSVWriter(outputStreamWriter);
            for (Address contact:sortedList) {
                String[] csvData={contact.toString()};
                csvDataList.add(csvData);
            }
            for (String[] data:csvDataList) {
                write.writeNext(data);
            }
            outputStreamWriter.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeToFile(HashMap<String, AddressBookOperations> addressDictionary, AddressBookOperations addressBookOperations) throws IOException {
        String filePath="src/main/resources/Contact.txt";
        StringBuilder stringBuilder=new StringBuilder();
        List<Address> contactList=addressBookOperations.sortContactByName(addressDictionary);
        contactList.forEach(p->{
            String contactData=p.toString().concat("\n");
            stringBuilder.append(contactData);
        });
        try {
            Files.write(Paths.get(filePath),stringBuilder.toString().getBytes());
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public void readIOFile(){
        String filePath="src/main/resources/Contact.txt";
        try {
            Files.lines(new File(filePath).toPath()).map(String::trim).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}