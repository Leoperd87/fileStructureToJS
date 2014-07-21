import org.junit.Test;
import ua.in.dej.FileAndFolderList;
import ua.in.dej.FileWorker;

/**
 * Created by fima on 21.07.14.
 */
public class MainTest {

    @Test
    public void doIt(){
        // todo
        FileAndFolderList a = new FileAndFolderList("/home/fima/BAK/torrents");

        a.setFileConstant("constan.file");
        a.setFolderConstant("constan.folder");

        String content = a.getList("gg", true);

        FileWorker fw = new FileWorker("/home/fima/tmp/123.js");

        fw.setMask("%text%");

        fw.setOutputFilePath("/home/fima/tmp/123-gg.js");

        fw.rewrite(content);
    }
}
