package ua.in.dej;

import java.io.*;

/**
 * Created by fima on 21.07.14.
 */
public class FileWorker {

    String mask = "%CODE%";
    String filePath;
    String outputFilePath = null;

    public FileWorker(String filePath) {
        this.filePath = filePath;
    }

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void rewrite(String content) {
        String fileContent = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            fileContent = getStringFromInputStream(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        if (fileContent instanceof String) {
            fileContent = fileContent.replace(mask, content);

            try {
                PrintWriter writer = new PrintWriter((outputFilePath instanceof String ? outputFilePath : filePath), "UTF-8");
                writer.println(fileContent);
                writer.close();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

    }
}
