// --== CS400 File Header Information ==--
// Name: Ben Carpenter
// Email: blcarpenter@wisc.edu
// Team: GG Red
// Role: Frontend Developer
// TA: Surabhi
// Lecturer: Gary
// Notes to Grader:

public interface PokedexInterface {

  public Pokemon getPokemon(Backend backend, int id);
  public boolean addPokemon(Backend backend, Pokemon pokemon);
  public static String displayRange(Backend backend, int start, int end) {

      return backend.displayAllInRange(start, end).toString();

  };

}
