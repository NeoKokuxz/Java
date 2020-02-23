import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ContactList<Contact> ContactList1 = new ContactList<>();
        Scanner s = new Scanner(System.in);
        //Set default data to contactlist
        Contact dafaultData = new Contact();
        ContactList1.add(dafaultData);
        Contact A1 = new Contact("a", "a", "a");
        ContactList1.add(A1);
        ContactList1.add(A1);
        ContactList1.add(A1);
        //System.out.println("How many contact you want to enter?");
        //int lengthI = s.nextInt();
        //Above is preset for ask input for arraylist length
        int select = 1;
        while (select != 0 && select <= 10) {
            System.out.println();
            mainMenu();
            select = s.nextInt();
            switch (select) {
                case 1:
                    addContact(ContactList1);
                    break;
                case 2:
                    for(Iterator<Contact> it = ContactList1.iterator(); it.hasNext(); )
                    {
                        System.out.println(it.next());
                    }
                    /*
                    for(Contact con : ContactList1)
                    {
                        System.out.println(con);
                    }
                    for(int num=0; num<ContactList1.size(); num++)
                    {
                        System.out.println(ContactList1.get(num));
                    } */

                    break;
                case 3:
                    //Remove contact from list
                    System.out.println("please enter the index to delete");
                    int num = s.nextInt();
                    num= num-1;
                    ContactList1.remove(num);
                    break;
                case 4:
                    //Function Search by phone number
                    searchByPhone(ContactList1);
                    break;
                case 5:
                    //Function Search by Last Name
                    searchByName(ContactList1);
                    break;
                case 6:
                    //Function Search By Any Letter in Last name
                    searchByParticularLetter(ContactList1);
                    break;
                case 7:
                    //Function Search By City
                    searchByCity(ContactList1);
                    break;
                case 8:
                    //Return size of ContactList
                    System.out.println("The size of contact book is " + ContactList1.size());
                    break;
                case 9:
                    //Return index of search
                    System.out.println("please enter the index u want to search for");
                    num = s.nextInt();
                    num = num-1;
                    System.out.println(ContactList1.get(num));
                    break;
                case 10:
                    //override
                    //Remove duplicates
                    ContactList1 = removeDuplicate(ContactList1);
                    break;
            }
        }
    }
    //MainMenu
    public static void mainMenu()
    {
        System.out.println("1. to add contact");
        System.out.println("2. to view contact");
        System.out.println("3. to remove contact");
        System.out.println("4. to search by phone number");
        System.out.println("5. to search by last name");
        System.out.println("6. to search last name by particular letter");
        System.out.println("7. to search by city");
        System.out.println("8. to check the size of the contact book");
        System.out.println("9. to search contact in index");
        System.out.println("10. to check if duplicate");
        System.out.println("11. Any other key to quit the program!");
    }

    public static void addContact(ContactList<Contact> con1)
    {
        String firstN;
        String lastN;
        String phoneN;
        String streetAddress;
        String cityN;
        String stateN;
        Scanner s = new Scanner(System.in);
        //Ask user input to compare or entry
        System.out.println("Please enter your First Name!");
        firstN = s.nextLine();
        System.out.println("Please enter your Last Name!");
        lastN = s.nextLine();
        System.out.println(("Please enter your Phone Number"));
        phoneN = s.nextLine();
        System.out.println("Please enter your Street Address");
        streetAddress = s.nextLine();
        System.out.println("Please enter your City Name");
        cityN = s.nextLine();
        System.out.println("Please enter your State Name");
        stateN = s.nextLine();
        Contact entry = new Contact(firstN,lastN,phoneN,streetAddress,cityN,stateN);
        //Show user entry
        System.out.println(entry);
        int matchNum = 0;
        //Search for duplicate in the ArrayList
        for(Contact contact : con1)
        {
            if(contact.getCityN().equals(cityN) && contact.getFirstN().equals(firstN) &&
                    contact.getLastN().equals(lastN) && contact.getPhoneN().equals(phoneN) &&
                    contact.getStreetAddress().equals(stateN) && contact.getStateN().equals(stateN) )
            {
                //Instant break out if duplicate found
                matchNum = 1;
                break;
            }
        }
        if(matchNum == 0 )
        {
            System.out.println("No Duplicate found! Data entered!");
            con1.add(entry);
        }
        else
        {
            System.out.println("Duplicate Found! No entry");
        }
    }
    public static void searchByPhone(ContactList<Contact> con1)
    {
        System.out.println("Please enter the phone number you want to search");
        Scanner s = new Scanner(System.in);
        String phoneN = s.nextLine();
        int notFound = 1;
        for(Contact contact : con1)
        {
            if(contact.getPhoneN().equals(phoneN))
            {
                System.out.println("Found it");
                System.out.println(contact);
                notFound = 0;
            }
        }
        if(notFound ==1)
        {
            System.out.println("Not Found~");
        }
    }
    public static void searchByName(ContactList<Contact> con1)
    {
        int notFound = 1;
        System.out.println("Please enter the last name you want to search");
        Scanner s = new Scanner(System.in);
        String lastN = s.nextLine();
        for(Contact contact : con1)
        {
            if(contact.getLastN().equals(lastN))
            {
                System.out.println("Found it");
                System.out.println(contact);
                notFound = 0;
            }
        }
        if(notFound ==1)
        {
            System.out.println("Not Found~");
        }
    }
    public static void searchByCity(ContactList<Contact> con1)
    {
        int notFound = 1;
        System.out.println("Please enter the city you want to search");
        Scanner s = new Scanner(System.in);
        String cityN = s.nextLine();
        for(Contact contact : con1)
        {
            if(contact.getCityN().equals(cityN))
            {
                System.out.println("Found it");
                System.out.println(contact);
                notFound = 0;
            }
        }
        if(notFound ==1)
        {
            System.out.println("Not Found~");

        }
    }
    public static void searchByParticularLetter (ContactList<Contact> con1)
    {
        int notFound = 1;
        System.out.println("Please enter the letter you want to search");
        Scanner s = new Scanner(System.in);
        String letter = s.nextLine();
        for(Contact contact : con1)
        {
            if(contact.getLastN().indexOf(letter) != -1 )
            {
                System.out.println("Found it");
                System.out.println(contact);
                notFound = 0;
            }
        }
        if(notFound ==1)
        {
            System.out.println("Not Found~");
            System.out.println();

        }
    }
    //Make the data from old arraylist to new one, but without duplicate
    public static ContactList<Contact> removeDuplicate(ContactList<Contact> con1)
    {
        ContactList<Contact> newList = ContactList.removeDuplicates(con1);
        System.out.println("before remove");
        System.out.println(con1);
        System.out.println();
        System.out.println("after remove");
        System.out.println(newList);
        return newList;
    }
}