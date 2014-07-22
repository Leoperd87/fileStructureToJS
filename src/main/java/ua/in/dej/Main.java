package ua.in.dej;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;

/**
 * Goal which touches a timestamp file.
 *
 * @goal generate
 * 
 * @phase prepare-package
 */
public class Main
    extends AbstractMojo
{
    /**
     * Location of the file.
     * @parameter expression="${project.build.directory}"
     * @required
     */
    private String buildDirectory;

    /**
     * scan folder
     *
     * @parameter default-value=null
     * @required
     */
    private String workFolder;


    /**
     * input file
     *
     * @parameter default-value=null
     * @required
     */
    private String inputFile;


    /**
     * output file
     *
     * @parameter default-value=null
     */
    private String outputFile;

    /**
     * file js constant
     *
     * @parameter default-value="'file'"
     */
    private String fileConst;


    /**
     * folder js constant
     *
     * @parameter default-value="'folder'"
     */
    private String folderConst;


    /**
     * replace text
     *
     * @parameter default-value="%CODE%"
     */
    private String replaceMask;


    private File outputDirectory;

    public void execute()
        throws MojoExecutionException
    {
        if (inputFile.equals("null") || workFolder.equals("null")) {
            System.err.println("Bad params");
            System.exit(0);
        } else {
            FileAndFolderList a = new FileAndFolderList(buildDirectory + workFolder);

            a.setFileConstant(fileConst);
            a.setFolderConstant(folderConst);

            String content = a.getList();

            FileWorker fw = new FileWorker(buildDirectory+inputFile);

            fw.setMask(replaceMask);

            if (!outputFile.equals("null")) {
                fw.setOutputFilePath(buildDirectory + outputFile);
            }

            fw.rewrite(content);
        }
    }
}
