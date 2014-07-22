fileStructureToJS
===================

Transform folder structure to js file.
Example:

folders
-1
--1-1
---4.txt
--1-2
---5.txt
-2
--3.txt
-1.txt
-2.txt

```
goog.provide('filelist');

constan = {
  file:'1',
  folder: '2'
};

var gg=[{type:constan.file,name:'2.txt'},{type:constan.folder,name:'1',content:[{type:constan.folder,name:'1-1',content:[{type:constan.file,name:'4.txt'}]},{type:constan.folder,name:'1-2',content:[{type:constan.file,name:'5.txt'}]}]},{type:constan.folder,name:'2',content:[{type:constan.file,name:'3.txt'}]},{type:constan.file,name:'1.txt'}];
```

### Usage
The following POM plugin configuration

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    ...
    <build>
        ...
        <plugins>
            <plugin>
                <groupId>ua.in.dej</groupId>
                <artifactId>fileStructureToJS</artifactId>
                <version>1.0-SNAPSHOT</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <!-- Optional. Default value: prepare-package. -->
                        <phase>prepare-package</phase>
                    </execution>
                </executions>
                <configuration>

                    <!-- Optional. Default value: ${project.build.directory} -->
                    <buildDirectory>
                        ${project.build.directory}/${project.build.finalName}
                    </buildDirectory>

                    <!-- Require. Folder with files -->
                    <workFolder>
                        /styles
                    </workFolder>

                    <!-- Require. Input file -->
                    <inputFile>
                        /123.js
                    </inputFile>

                    <!-- Optional. Output file. Default value: $inputFile -->
                    <outputFile>
                        /123-out.js
                    </outputFile>

                    <!-- Optional. File constant. Default value: "'file'" -->
                    <fileConst>
                        cons.file
                    </fileConst>

                    <!-- Optional. Folder constant. Default value: "'folder'" -->
                    <folderConst>
                        cons.folder
                    </folderConst>

                    <!-- Optional. Folder constant. Default value: "%CODE%" -->
                    <replaceMask>
                        %text%
                    </replaceMask>

                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
