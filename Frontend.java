// --== CS400 File Header Information ==--
// Name: Ben Carpenter
// Email: blcarpenter@wisc.edu
// Team: GG Red
// Role: Frontend Developer
// TA: Surabhi
// Lecturer: Gary
// Notes to Grader:


import java.net.PortUnreachableException;
import java.util.*;
import java.lang.Exception;
import java.io.File;

/**
 * The Frontend class acts as a medium between the backend and the user by
 * printing an interactable menu that allows users to store and display
 * Pokemon objects in a Red Black Tree.
 *
 * @author Ben Carpenter
 */
public class Frontend implements PokedexInterface{


    /**
    *  Retrieves the Pokemon corresponding to the given id number using the
    *  Backend lookUp method
    */
    public Pokemon getPokemon(Backend backend, int id) {
        return backend.lookUp(id);
    }

    /**
    *  Adds a Pokemon to the Red Black Tree using the Backend add method
    */
    public boolean addPokemon(Backend backend, Pokemon pokemon) {

        //
        if (pokemon == null) return false;
        backend.add(pokemon);

        return true;

    }

    /**
    *  Displays all of the Pokemon data stored in the Pokedex using the Backend
    *  displayAllInRange method
    */
    public static void displayRange(Backend backend, int start, int end) {

        ArrayList<Pokemon> foo =backend.displayAllInRange(start, end);
        String s= "";
        for(int i = 0; i<foo.size();i++){
            s+=foo.get(i).toString()+"\n";
        }
        System.out.println(s);

    }

    /**
    *  Main method that runs the menu interface
    */
    public static void main(String[] args) throws IllegalArgumentException, NoSuchElementException {

        // Backend constructor that passes method arguments to the backend
        Backend backend = new Backend(args);

        // variable that tracks user input
        int menuInput = 0;

        // loop that keeps the program running until the user chooses to exit
        do {

            // displays main menu
            System.out.println("Welcome to the Pokedex");
            System.out.println("[1] Add new Pokemon");
            System.out.println("[2] Look up Pokemon");
            System.out.println("[3] Display all Pokemon");
            System.out.println("[4] Display a specific range of Pokemon");
            System.out.println("[5] Exit the program \n");

            System.out.println("Enter a number to continue");

            // Scanner object to register and store user input
            Scanner input = new Scanner(System.in);
            menuInput = input.nextInt();

            // check for valid input
            if (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5) {
                throw new IllegalArgumentException("Please enter an integer between 1 and 5 \n");
            }

            // routine for option 1: adding new Pokemon
            if (menuInput == 1) {

                System.out.println("\nEnter the ID number of the Pokemon to be added");

                int id = input.nextInt();

                // add the Pokemon and verify that it is added successfully
                if(!backend.add(id)) {
                    System.out.println("Error: Pokemon # " + id + " could not be added \n");
                }

            }

            // routine for option 2: looking up a Pokemon
            if (menuInput == 2) {

                System.out.println("\nEnter the Pokemon's ID number");

                int id = input.nextInt();

                // check for valid input
                if (1 > id || 807 < id) {
                  System.out.println("\nError: ID number must be between 1 and 807 \n");
                }

                else {
                    // search Pokedex for Pokemon, return if found, else display
                    // failed search message
                    try {
                      Pokemon p = backend.lookUp(id);
                      System.out.println(p.toString());
                    } catch (Exception e) {
                      System.out.println("\nThe Pokemon with the ID number " + id + " has not yet been added to the Pokedex \n");
                    }
                }

            }

            // routine for option 3: displaying the complete contents of the Pokedex
            if (menuInput == 3) {

                System.out.println("\nPokemon in this Pokedex: \n");

                // display every Pokemon between the first and last possible indices,
                // i.e. every Pokemon stored in the Pokedex
                displayRange(backend, 1, 807);

            }

            // routine for option 4: displaying Pokemon whose ID numbers fall
            // within a given range
            if (menuInput == 4) {

                System.out.println("\nEnter the first number in the desired range:");

                int start = input.nextInt();

                System.out.println("Enter the last number in the desired range:");

                int end = input.nextInt();

                // check for valid input
                if (start < 1 || end < 1 || start > 807 || end > 807) {
                    System.out.println("\nError: indices must be between 1 and 807 \n");
                }
                else if (start > end) {
                    System.out.println("\nError: Starting index must be smaller or equal to ending index \n");
                }

                else{

                    System.out.println("\nPokemon in this Pokedex in the range " + start + " - " + end + ":");

                    // display every Pokemon with ID numbers between start and end
                    displayRange(backend, start, end);

                }

            }

            // routine for option 5: exit the program
            if (menuInput == 5) {

                System.exit(0);

            }

        } while (menuInput != 5); // end do-while loop

    }

}


