package clusterstuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateSub
{
	private static int countNum = 0;

	public static final File RDP_RUN_DIR = new File("/net/fantasia/home/maoxuanl/git/clusterstuff/run");

	public static void main(String[] args) throws Exception
	{
		List<File> allShFiles = new ArrayList<File>();
		for (int x = 0; x < 50; x++)
		{
			countNum++;
			File runFile = new File(RDP_RUN_DIR.getAbsoluteFile() + File.separator + "run_" + countNum + ".sh");

			BufferedWriter writer = new BufferedWriter(new FileWriter(runFile));
			writer.write("cd /net/fantasia/home/maoxuanl/git/clusterstuff/src\n");
			writer.write("java clusterstuff/CreateFactorSub\n");

			writer.flush();
			writer.close();

			allShFiles.add(runFile);

		}

		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File(RDP_RUN_DIR.getAbsoluteFile() + File.separator + "runAll.sh")));

		for (File f : allShFiles)
		{
			writer.write("qsub " + f.getAbsolutePath() + "\n");
		}

		writer.flush();
		writer.close();
	}

}