// --== CS400 File Header Information ==--
// Name: Tate Riordan
// Email: triordan2@wisc.edu
// Team: Red
// Group: GG
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: n/a
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DataWranglerTester {

//	public static void main(String[] args) {
//		System.out.println("Test 1 ")
//	}
//	
//	
	
	PokemonDataReaderInterface reader;
	/**
	 * This test will ensure that when we try to read the file in,
	 * the file will be read in properly with no exceptions thrown.
	 */
	@Test
	public void test1() {
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		reader = new PokemonDataReader();
		try {
			pokemonList = reader.readDataSet(new StringReader("id,name,type,height,weight\n"
					+"1,bulbasaur,grass,7,69\n" + "2,ivysaur,grass,10,130\n"));
			//System.out.println(pokemonList.get(0).getName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("This data could not be read.");
		}
		assertEquals(2, pokemonList.size());
		
	}
	
	/**
	 * This test will make sure that our getName() method returns the correct
	 * value to our node that is created for the pokemon with that
	 * name
	 */
	@Test
	public void test2() {
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		reader = new PokemonDataReader();
		try {
			pokemonList = reader.readDataSet(new StringReader("id,name,type,height,weight\n"
					+"1,bulbasaur,grass,7,69\n" + "2,ivysaur,grass,10,130\n"));
		} catch (Exception e) {
			fail("This data could not be read.");
		}
		assertEquals("bulbasaur", pokemonList.get(0).getName());
	}
	
	/**
	 * This test will make sure that our getType() method returns the correct base experience value
	 * to our node that is created for the pokemon with that base experience.
	 */
	@Test
	public void test3() {
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		reader = new PokemonDataReader();
		try {
			pokemonList = reader.readDataSet(new StringReader("id,name,type,height,weight\n"
					+"1,bulbasaur,grass,7,69\n" + "2,ivysaur,grass,10,130\n"));
		} catch (Exception e) {
			fail("This data could not be read.");
		}
		assertEquals("grass", pokemonList.get(0).getType());
	}
	
	/**
	 * This test will be used to make sure that the getWeight() method returns
	 * the correct weight for the pokemon that we are finding the weight
	 * for.
	 */
	@Test
	public void test4() {
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		reader = new PokemonDataReader();
		try {
			pokemonList = reader.readDataSet(new StringReader("id,name,type,height,weight\n"
					+"1,bulbasaur,grass,7,69\n" + "2,ivysaur,grass,10,130\n"));
		} catch (Exception e) {
			fail("This data could not be read.");
		}
		assertEquals(130, pokemonList.get(1).getWeight());
	}
	/**
	 * This test will be used to make sure that the getHeight() method returns
	 * the correct height for the pokemon that we are finding the height
	 * for.
	 */
	@Test
	public void test5() {
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		reader = new PokemonDataReader();
		try {
			pokemonList = reader.readDataSet(new StringReader("id,name,type,height,weight\n"
					+"1,bulbasaur,grass,7,69\n" + "2,ivysaur,grass,10,130\n"));
		} catch (Exception e) {
			fail("This data could not be read.");
		}
		assertEquals(7, pokemonList.get(0).getHeight());
	}
}
