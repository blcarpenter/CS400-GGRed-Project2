// --== CS400 File Header Information ==--
// Name: Tate Riordan
// Email: triordan2@wisc.edu
// Team: Red
// Group: GG
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: n/a
public interface PokemonInterface extends Comparable<PokemonInterface> {
	public Integer getID();
	public String getName();
	public String getType();
	public Integer getWeight();
	public Integer getHeight();
	public int compareTo(PokemonInterface otherPokemon);
}
