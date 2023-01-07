import java.io.BufferedReader;
import java.io.FileReader;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;

	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;

	String adjectivesFile;
	String nounsFile;

	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		this.adjectivesFile = adjectivesFile;
		this.nounsFile = nounsFile;
	}

	public void loadAdjectives() {
		adjectives = this.loadTxt(adjectivesFile);
		adjectivesLoaded = true;
	}

	public void loadNouns() {
		 nouns = this.loadTxt(nounsFile);
		 nounsLoaded = true;
	}

	/**
	 * Randomly generates and returns a band name that consists of an adjective followed by a noun.
	 * Returns "UNINITIALIZED" if the adjectives or nouns were not (correctly) loaded. 
	 * @return The generated band name
	 */
	public String generate() {
		//Math.random() returns values greater than 0.0 to less than 1.0
		
		int adjectivecount = adjectives.length;
		int nouncount = nouns.length;
		
		//int randn = (int) Math.random();

		int randomNumNoun = (int)(Math.random()*nouncount);
		int randomNumAdjective = (int)(Math.random()*adjectivecount);
		
		return adjectives[randomNumAdjective] + " " + nouns[randomNumNoun];
	}
	
	/**
	 * We have not discussed I/O (reading/writing files) yet, so you can use this
	 * function to load the adjectives and nouns text files.
	 * 
	 * @param file: a String that contains the name of the file you want to read. 
	 * @return
	 */
	private String[] loadTxt(String file) {
		// Initialize the data we will return to a real array so our compiler won't complain.
		// Don't worry - later in the course we will look at better ways to do this. 
		String[] data = new String[0];
		
		// We did not talk about exceptions yet but for now read the following part as follows:
		// If an error occurs during the execution of the code in the try block, the program will 
		// execute the code in the catch block, otherwise it will skip the catch block. 
		try {
			// Create a stream to read from the file
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			// The first line of the file contains an integer that represents the number of rows,
			// the rest of the file contains one word on every line
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			// Read the file and store it in the data that we will return
			while ((line = in.readLine()) != null) {
				data[i] = line;
				i++;

			}
			// Only execute the following block if a problem occurred during reading the file
		} catch (Exception e) {
			// Print some details that should help you solve the problem.
			System.err.println("Problem while reading the data for file: " + file);
			e.printStackTrace();
		}
		return data;
	}

	

	/**
	 * Run the program and randomly generate 20 (no more, no less) band names every time you execute it.
	 * The names may be different across runs. 
	 * @param args
	 */
	public static void main(String [] argu) {
		
		String adjPath = "D:\\UOFA COURSES\\ECE 325\\LAB\\BandNameGenerator\\adjectives.txt";
		String nounPath = "D:\\UOFA COURSES\\ECE 325\\LAB\\BandNameGenerator\\nouns.txt";
		BandNameGenerator Fahrin1 = new BandNameGenerator(adjPath,nounPath);
		
		Fahrin1.loadAdjectives();
		Fahrin1.loadNouns();
		if(Fahrin1.adjectivesLoaded == false && Fahrin1.nounsLoaded == false){
			System.out.println("uninitialized");
		}
		else {
			int i = 0;
			while(i < 20){
				
				String data = Fahrin1.generate();
				System.out.println(data);
				i = i + 1;
			}	
		}
	}
}
		

	
//for (int i = 0;i < 20; i++) {
//	String data = Fahrin1.generate();
//	System.out.println(data);
//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

