
class Directory {
    public Directory(String name) {
        this.name = name;
        innerDirectory = new Directory[10];
        innerFiles = new File[10];

    }

    String name;
    Directory parent;
    Directory[] innerDirectory;
    File innerFiles[];
    String location;

    public static Directory openCommandPrompt() {
        Directory root = new Directory("~");
        root.innerDirectory[0] = new Directory("c:\\");
        root = root.innerDirectory[0];
        root.location = "c:\\";
        return root;
    }

    public void excutePresentWorkingDiretory() {
        System.out.println(this.location);
    }

    public Directory excuteChangeDir(String directoryName) {
        // check is give directory is in the innerDirectory array
        return getInnerDirectory(directoryName);

    }

    private Directory getInnerDirectory(String directoryName) {
        for (Directory directory : innerDirectory) {
            if (directory.name.equals(directoryName)) {
                return directory;
            }
        }
        return null;
    }

    public void excuteMakeDir(String directoryName) {
        // create directory object with the given name
        Directory directory = new Directory(directoryName);
        directory.location = this.location + directoryName;
        directory.parent = this;
        this.innerDirectory[getDirectoryLength()] = directory;
    }

    private int getDirectoryLength() {
        int count = 0;
        for (Directory directory : innerDirectory) {
            if (directory == null) {
                return count;
            }
            count++;
        }
        return count;
    }

    public Directory excuteMoveBack() {
        return this.parent;
    }

    public void excuteTouch(String fileName) {
        File file = new File(fileName);
        file.location = this.location + fileName;
        file.parent = this;

    }

    public void excuteListDir() {
        for (Directory directory : innerDirectory) {
            if (directory != null) {
                System.out.println(directory.location);
            }
        }
        for (File file : innerFiles) {
            if (file != null) {
                System.out.println(file.location);
            }
        }
    }

}

class File {
    public File(String fileName) {
        this.name = fileName;
    }

    String name;
    Directory parent;
    String[] content;
    String location;
}

public class PlayWithDirectory {

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        Directory root = Directory.openCommandPrompt();
        // root.excutePWD();

        // root.excuteMD("wild Animal");
        // root.excuteMoveBack();
        // root.excuteTouch("fileName");
        // root.excuteListDir();
        // }
        root.excuteMakeDir("animal");
        root.excuteMakeDir("lion");
        // root = root.excuteChangeDir("animal");
        root.excuteTouch("a.py");
        root.excutePresentWorkingDiretory();
        root.excuteListDir();
    }

}
