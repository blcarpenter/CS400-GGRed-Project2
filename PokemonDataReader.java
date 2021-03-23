// --== CS400 File Header Information ==--
// Name: Tate Riordan
// Email: triordan2@wisc.edu
// Team: Red
// Group: GG
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: n/a
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * This method will help read the data file
 * @author Tate Riordan
 *
 */
public class PokemonDataReader implements PokemonDataReaderInterface {

	/**
	 * This reads the data file in and separates out the qualities we need
	 */
	@Override
	public List<PokemonInterface> readDataSet(Reader inputFileReader)
			throws FileNotFoundException, IOException, DataFormatException {
		// TODO Auto-generated method stub
		List<PokemonInterface> helper = new ArrayList<PokemonInterface>();
		String line = "";
		String split = ",";
		// this creates the arraylist of the different pokemon
		try {
			BufferedReader reader = new BufferedReader(inputFileReader);
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] entireLine = line.split(split);
				Integer id = Integer.parseInt(entireLine[0]);
				String name = entireLine[1];
				//name = name.replace("\"", "");
				String type = entireLine[2];
				Integer weight = Integer.parseInt(entireLine[3]);
				Integer height = Integer.parseInt(entireLine[4]);
				Pokemon poke = new Pokemon(id,name,type,weight,height);
				helper.add(poke);
			}
			return helper;
			// catches the exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return helper;
	}

}
