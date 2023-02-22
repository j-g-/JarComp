package tim.jarcomp;

import java.io.File;

/**
 * Jar comparer tool
 * Copyright activityworkshop.net
 * Please see http://activityworkshop.net/software/ for more information
 */
public class JarComp
{
	private static void runCli(File f1, File f2){
		System.out.println(Comparer.compare(f1, f2, true));
	}
	private static void runWindow(File f1, File f2){

		CompareWindow window = new CompareWindow();
		window.startCompare(f1, f2, false);
	}
	/** Version number of tool */
	public static final String VERSION_NUMBER = "2";
	/** Build number */
	public static final String BUILD_NUMBER = "009";

	/**
	 * Main entry point to Jar comparer tool
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{
		// Parse command line arguments, extract two files if available
		File f1 = null, f2 = null;
		try {
			if ( args.length == 0 ) {
				runWindow(f1, f2 );
			} else if ( args[0].equals("-c")) {
				f1 = new File(args[1]);
				f2 = new File(args[2]);
				runCli(f1, f2);
			} else if (args.length == 2 ) {
				f1 = new File(args[0]);
				f2 = new File(args[1]);
				runWindow( f1, f2);
				// Pass two files to start with, or instruct to prompt
			} else {
				System.err.println("Usage: \n");
				System.err.println("java -jar jarcomp.jar  [-c] file1 file2 \n");
				System.err.println("	-c show only text output");
			}
		} catch (ArrayIndexOutOfBoundsException ex ) {
			System.err.println(ex);
			System.err.println("Invalid arguments");
		}
	}
}

