// --== CS400 File Header Information ==--
// Name: Tate Riordan
// Email: triordan2@wisc.edu
// Team: GG Red
// Role: Data Wrangler
// TA: Surabhi
// Lecturer: Gary Dahl
// Notes to Grader: n/a
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.zip.DataFormatException;


public interface PokemonDataReaderInterface {
	public List<Pokemon> readDataSet(Reader inputFileReader) throws FileNotFoundException, IOException, DataFormatException;
}
