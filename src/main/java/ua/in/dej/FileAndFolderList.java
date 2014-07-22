package ua.in.dej;

import java.io.File;

/**
 * Created by fima on 21.07.14.
 */
public class FileAndFolderList {
    String filePath;
    String separator = File.separator;
    String fileConstant = "'file'";
    String folderConstant = "'folder'";

    public FileAndFolderList(String fp) {
        this.filePath = fp + separator;
    }

    public String getList() {
        return  getFilesAndFolder("");
    }

    public void setFileConstant(String fileConstant) {
        this.fileConstant = fileConstant;
    }

    public void setFolderConstant(String folderConstant) {
        this.folderConstant = folderConstant;
    }

    private String getFilesAndFolder(String fp) {
        String result = "[";
        File folder = new File(filePath + fp);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            boolean last = i == listOfFiles.length - 1;
            if (listOfFiles[i].isFile()) {
                result += "{type:" + fileConstant + ",name:'" + ekran(listOfFiles[i].getName()) + "'}" + (!last ? "," : "");
//                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                result += "{type:" + folderConstant + ",name:'" + ekran(listOfFiles[i].getName()) + "',content:" + getFilesAndFolder(fp + separator + listOfFiles[i].getName()) + "}" + (!last ? "," : "");
//                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        result += "]";
        return result;
    }

    private String ekran(String in) {
        return in.replaceAll("'", "\\\\'");
    }
}
