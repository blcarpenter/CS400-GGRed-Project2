public interface PokedexInterface {

  public Pokemon getPokemon(Backend backend, int id);
  public boolean addPokemon(Backend backend, Pokemon pokemon);
  public String displayRange(Backend backend, int start, int end);

}
