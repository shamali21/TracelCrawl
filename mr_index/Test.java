/**
 * 
 */

/**
 * @author prati
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Scanner;
import org.apache.commons.text.StringEscapeUtils;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		PrintWriter pw;
		StringBuilder sb;
		try {
			pw = new PrintWriter(new File("final2.csv"));
			sb = new StringBuilder();
			// 1st coulmnn name
			sb.append("id");
			sb.append(',');
			// 2nd column name
			sb.append("Title");
			sb.append(',');

			// 3rd coulmn name
			sb.append("URL");
			sb.append(',');

			sb.append("Description");
			sb.append(',');

			sb.append("Count");
			sb.append('\n');

			String dirName = "C:\\Users\\prati\\Downloads\\more_recipes\\more_recipes";
			File dir = new File(dirName);
			BufferedReader TSVFile = null;

			for (File file : dir.listFiles()) {
				TSVFile = new BufferedReader(new FileReader(file));
				String dataRow = TSVFile.readLine();
				while (dataRow != null) {
					String[] dataArray = dataRow.split("\\t");
					for (String item : dataArray) {
						sb.append(StringEscapeUtils.escapeCsv(item));
						sb.append(',');

					}
					sb.append('\n');
					dataRow = TSVFile.readLine(); // Read next line of data.
				}
				// Close the file once all data has been read.
				TSVFile.close();

			}
			pw.write(sb.toString());

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
