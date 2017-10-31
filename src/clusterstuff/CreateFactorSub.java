package clusterstuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateFactorSub
{
	private static int countNum = 0;

	public static final File RDP_OUT_DIR = new File("/net/fantasia/home/maoxuanl/git/clusterstuff/result");
	// public static final File RDP_RUN_DIR = new
	// File("/net/fantasia/home/maoxuanl/git/clusterstuff/run");

	public static final String RDP_SUFFIX = ".txt";

	public static void main(String[] args) throws Exception
	{

		for (int x = 0; x < 100; x++)
		{
			long startTime = System.currentTimeMillis();
			countNum++;
			Random r = new Random();
			List<Long> factors = new ArrayList<Long>();
			int numberToFactor = Math.abs(r.nextInt());
			int half = numberToFactor / 2 + 1;

			for (long i = 2; i < half; i++)
				if (numberToFactor % i == 0)
				{
					factors.add(i);
				}

			long millis = System.currentTimeMillis();
			File rdpOutFile = new File(
					RDP_OUT_DIR.getAbsolutePath() + File.separator + countNum + File.separator + millis + RDP_SUFFIX);
			BufferedWriter writer = new BufferedWriter(new FileWriter(rdpOutFile));
			writer.write(numberToFactor + " ");

			if (factors.size() == 0)
				writer.write(" prime ");
			else
				writer.write(factors.toString());

			writer.write("Total time : " + (System.currentTimeMillis() - startTime) / 1000f);

			writer.flush();
			writer.close();

		}

	}
}
