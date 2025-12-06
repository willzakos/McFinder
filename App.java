//The purpose of this program is to find the nearest Mcdonald's to the user.
// This program only works with users located within the united states.
// Data is sourced from a CSV which can be found here https://www.kaggle.com/datasets/jacopomazzoni/mcdonalds-locations-2025?resource=download
// The data is open source and public domain.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        //Imports file
        String file = "mcdonalds_locations.csv";
        //Creates array list using CreateMcObjects()
        List<McDonalds> McObjectList = createMcObjects(file);
        //Scanner for user input
        Scanner myScanner = new Scanner(System.in);
        //User input prompts
        System.out.println("Welcome to McFinder! To find your nearest McDonald's location please enter the following information!");
        System.out.println("Please enter the 2 character abbreviation for your state");
        String state = myScanner.nextLine();
        System.out.println("Please enter your City");
        String city = myScanner.nextLine();
        System.out.println("Please enter your zip code");
        String zip = myScanner.nextLine();
        //Calls FindNearest() with user input
        FindNearest(McObjectList, city, state, zip);
        myScanner.close();

    }

    //Creates a Mcdonald's object for every Mcdonalds in the csv file
    public static List<McDonalds> createMcObjects(String file) {
        //Array list of Arraylists for each row
        List<List<String>> rowList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            //Skips header
            String line;
            br.readLine();
            //Iterates through CSV and splits values to a temporary array using comma's, adds values as a list to form the "Rows"
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                rowList.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            System.out.println("IO ERROR");
        }
        //Value for total size of rowlist
        int totalSize = rowList.size();
        //List for finished McDonald's objects
        List<McDonalds> McObjectList = new ArrayList<McDonalds>();
        //Iterates through row list and turns each row into a McDonald's object
        for (int i = 0; i < totalSize; i++) {
            //Removes current row from rowList
            List<String> currentRow = rowList.remove(rowList.size() - 1);
            String storeID = currentRow.get(0);
            String address = currentRow.get(2);
            String city = currentRow.get(3);
            String state = currentRow.get(4);
            String zip = currentRow.get(5);
            String phoneNumber = currentRow.get(6);
            String lat = currentRow.get(7);
            String lon = currentRow.get(8);
            McObjectList.add(new McDonalds(storeID, address, city, state, zip, phoneNumber, lat, lon));

        }
        return McObjectList;

    }

    //Find's the nearest Location or Location's based on users inputted information
    public static void FindNearest(List<McDonalds> list, String city, String state, String zip) {
        //ArrayLists for locations found in state, city, and zip code
        List<McDonalds> inState = new ArrayList<McDonalds>();
        List<McDonalds> inCity = new ArrayList<McDonalds>();
        List<McDonalds> inZip = new ArrayList<McDonalds>();
        //Formats user data to comply with CSV
        String userState = state.trim().toUpperCase();
        String userCity = city.trim().toUpperCase();
        String userZip = zip.trim();
        //Filters data from list by State
        for (McDonalds mcDonalds : list) {
            String mcState = mcDonalds.getState().trim().toUpperCase();
            if (mcState.equals(userState)) {
                inState.add(mcDonalds);

            }
        }
        //Filters user data from State to City
        for (McDonalds mcDonalds : inState) {
            String mcCity = mcDonalds.getCity().trim().toUpperCase();
            if (mcCity.equals(userCity)) {
                inCity.add(mcDonalds);
            }
        }
        //Filters user data from City to Zip code
        for (McDonalds mcDonalds : inCity) {
            String mcZip = mcDonalds.getZip().trim();
            if (mcZip.equals(userZip)) {
                inZip.add(mcDonalds);
            }
        }
        //Displays all Mcdonalds found in zip code if applicable
        if (inZip.isEmpty() == false) {
            for (McDonalds mcDonalds : inZip) {
                mcDonalds.Display();
            }

            //Displays all McDonald's in city if none are within the zip code
        } else if (inZip.isEmpty() && inCity.isEmpty() == false) {
            System.out.println("Unable to find McDonald's in your zip code, but they are in your city!");
            for (McDonalds mcDonalds : inCity) {
                mcDonalds.Display();
            }
            //Displays all McDonald's found within users state if none are found within the city
        } else if (inCity.isEmpty() && inState.isEmpty() == false) {
            for (McDonalds mcDonalds : inState) {
                mcDonalds.Display();
            }
        } else {
            //Prints if no suitable location is found
            System.out.println("We could not find a suitable location.");
        }
    }

}
