// --== CS400 File Header Information ==--
// Name: Tate Riordan
// Email: triordan2@wisc.edu
// Team: Red
// Group: GG
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
	public List<PokemonInterface> readDataSet(Reader inputFileReader) throws FileNotFoundException, IOException, DataFormatException;
}
