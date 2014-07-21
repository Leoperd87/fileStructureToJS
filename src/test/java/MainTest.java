import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import ua.in.dej.FileAndFolderList;
import ua.in.dej.FileWorker;

import java.io.IOException;

/**
 * Created by fima on 21.07.14.
 */
public class MainTest {

    @Test
    public void doIt(){
        String testPath = getClass().getResource("").getPath();

        FileAndFolderList a = new FileAndFolderList(testPath + "folders");

        a.setFileConstant("constan.file");
        a.setFolderConstant("constan.folder");

        String content = a.getList("gg", true);

        FileWorker fw = new FileWorker(testPath+"123.js");

        fw.setMask("%text%");

        fw.setOutputFilePath(testPath+"123-out.js");

        fw.rewrite(content);

        try {
            Assert.assertEquals(FileUtils.fileRead(testPath + "123-exp.js"), FileUtils.fileRead(testPath + "123-out.js"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
