package FileSystem;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Directory root = Directory.openCMD();
        root.md("newFolder");
        root = root.cd("newFolder");
        root.pwd();
        root.md("Manoj");
        root = root.cd("Manoj");
        root.pwd();
        root = root.upward();
        root.pwd();
        root = root.home();
        root.pwd();
        root.touch("sample.txt");
        root.touch("sample1.txt");
        root.touch("sample3.txt");
        root.touch("sample4.txt");
        root.list();
        root = root.cd("newFolder");
        root.pwd();

    }
}

class Directory {
    String name;
    Directory parent;
    Directory[] subDirectory;
    File[] filesList;
    String location;

    public Directory(String name) {
        this.name = name;
        this.subDirectory = new Directory[10];
        this.filesList = new File[10];
    }

    public void touch(String filename) {
        File newFile = new File(filename);
        newFile.parent = this;

        int lastIndexOfFiles = this.getFileInsertPosition();

        this.filesList[lastIndexOfFiles] = newFile;

    }

    private int getFileInsertPosition() {
        for (int ind = 0; ind < this.filesList.length; ind++) {
            if (filesList[ind] == null) {
                return ind;
            }
        }
        return -1;
    }

    public Directory home() {
        Directory curDirectory = this;
        while (true) {
            curDirectory = curDirectory.upward();
            if (curDirectory.location.equals("C:")) {
                return curDirectory;
            }
        }
    }

    public Directory upward() {
        return this.parent;
    }

    public void list() {
        for (File file : this.filesList) {
            if (file != null) {
                System.out.println(file.name);
            }
        }
    }

    public void pwd() {
        System.out.println("\n");
        System.out.println(this.location);
    }

    public Directory cd(String directoryName) {
        for (Directory directory : this.subDirectory) {
            if (directory != null && directory.name.equals(directoryName)) {
                return directory;
            }
        }
        System.out.println("No Directory found!");
        return null;
    }

    public void md(String directoryName) {
        Directory directory = new Directory(directoryName);
        directory.parent = this;
        directory.location = this.location + "\\" + directoryName;

        int lastIndexOfSubDirectory = this.directoryInsertPosition();

        this.subDirectory[lastIndexOfSubDirectory] = directory;
    }

    private int directoryInsertPosition() {
        for (int ind = 0; ind < this.subDirectory.length; ind++) {
            if (subDirectory[ind] == null) {
                return ind;
            }
        }
        return -1;
    }

    public static Directory openCMD() {
        Directory root = new Directory("C:\\");
        root.location = "C:";
        return root;
    }

}

class File {
    Directory parent;
    String name;
    String content;

    File(String filename) {
        this.name = filename;
    }
}