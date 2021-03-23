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

        System.out.println("Welcome to the Pokedex");
        System.out.println("[1] Add new Pokemon");
        System.out.println("[2] Look up Pokemon");
        System.out.println("[3] Display all Pokemon");
        System.out.println("[4] Display a specific range of Pokemon");
        System.out.println("[5] Exit the program");

        System.out.println("Enter a number to continue");

        Scanner input = new Scanner(System.in);

        int menuInput = input.nextInt();

        if (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5) {

            System.out.println("Please enter an integer between 1 and 5");

            throw new IllegalArgumentException();

        }

        if (menuInput == 1) {

            System.out.println("");

        }

        if (menuInput == 2) {

            System.out.println("Enter the ID number of the Pokemon");

            int id = input.nextInt();

            Pokemon p = backend.lookUp(id);

            System.out.println(p.toString());

        }

        if (menuInput == 3) {

            System.out.println("Pokemon in this Pokedex:");

            displayRange(backend, 1, 807);


        }

        if (menuInput == 4) {

            System.out.println("Enter the first number in the desired range:");

            int start = input.nextInt();

            System.out.println("Enter the last number in the desired range:");

            int end = input.nextInt();

            System.out.println("Pokemon in the range " + start + " - " + end + ":");

            displayRange(backend, start, end);

        }

        if (menuInput == 5) {

            System.exit(0);

        }

    }

}


