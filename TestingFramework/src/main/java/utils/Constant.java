package utils;

public class Constant {

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String USER_DIRECTORY = System.getProperty("user.dir");
	public static final String RESOURCE_FOLDER = USER_DIRECTORY + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "test"
			+ FILE_SEPARATOR + "resources";

	public static final String DRIVER_PATH = RESOURCE_FOLDER + FILE_SEPARATOR + "chromedriver.exe";

	public static final String AMAZONE_URL = "https://www.amazon.in";

	public static final String UI_GRID_URL = "https://generic-ui.com/demo";

	public static final String FLIPKART_URL = "https://www.flipkart.com";

}
