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

public class Frontend implements PokedexInterface{

    public Pokemon getPokemon(Backend backend, int id) {

        return backend.lookUp(id);

    }

    public boolean addPokemon(Backend backend, Pokemon pokemon) {

        if (pokemon == null) return false;

        backend.add(pokemon);

        return true;

    }

    public static void displayRange(Backend backend, int start, int end) {

        ArrayList<Pokemon> foo =backend.displayAllInRange(start, end);
        String s= "";
        for(int i = 0; i<foo.size();i++){
            s+=foo.get(i).toString()+"\n";
        }
        System.out.println(s);

    }

    public static void main(String[] args) throws IllegalArgumentException, NoSuchElementException {

        Backend backend = new Backend();

        int menuInput = 0;

        do {
            System.out.println("Welcome to the Pokedex");
            System.out.println("[1] Add new Pokemon");
            System.out.println("[2] Look up Pokemon");
            System.out.println("[3] Display all Pokemon");
            System.out.println("[4] Display a specific range of Pokemon");
            System.out.println("[5] Exit the program \n");

            System.out.println("Enter a number to continue");

            Scanner input = new Scanner(System.in);

            menuInput = input.nextInt();

            if (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5) {

                System.out.println("Please enter an integer between 1 and 5 \n");

                throw new IllegalArgumentException();

            }

            if (menuInput == 1) {

                System.out.println("\nEnter the ID number of the Pokemon to be added");

                int id = input.nextInt();

                if(!backend.add(id)) {

                    System.out.println("Error: Pokemon # " + id + " could not be added \n");

                }

            }

            if (menuInput == 2) {

                System.out.println("\nEnter the Pokemon's ID number");

                int id = input.nextInt();

                if (1 > id || 807 < id) System.out.println("\nError: ID number must be between 1 and 807 \n");

                else {

                    try {

                      Pokemon p = backend.lookUp(id);
                      System.out.println(p.toString());

                    } catch (Exception e) {
                      System.out.println("\nThe Pokemon with the ID number " + id + " has not yet been added to the Pokedex \n");
                    }

                }

            }

            if (menuInput == 3) {

                System.out.println("\nPokemon in this Pokedex: \n");

                displayRange(backend, 1, 807);

            }

            if (menuInput == 4) {

                System.out.println("\nEnter the first number in the desired range:");

                int start = input.nextInt();

                System.out.println("Enter the last number in the desired range:");

                int end = input.nextInt();

                if (start < 1 || end < 1 || start > 807 || end > 807) System.out.println("\nError: indices must be between 1 and 807 \n");

                else if (start > end) System.out.println("\nError: Starting index must be smaller or equal to ending index \n");

                else{

                    System.out.println("\nPokemon in this Pokedex in the range " + start + " - " + end + ":");

                    displayRange(backend, start, end);

                }

            }

            if (menuInput == 5) {

                System.exit(0);

            }

        } while (menuInput != 5);

    }

}
