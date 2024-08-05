/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Directory root = Directory.openCMD();
        root.md("newFolder");
        root = root.cd("newFolder");
        root.pwd();
        root.list();
        root = root.upward();
        root = root.home();
        root.touch();

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

    public void touch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'touch'");
    }

    public Directory home() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'home'");
    }

    public Directory upward() {
        return null;
    }

    public void list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    public void pwd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pwd'");
    }

    public Directory cd(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cd'");
    }

    public void md(String directoryName) {
        Directory directory = new Directory(directoryName);
        directory.parent = this;
        directory.location = this.location + directoryName;

        int lastIndexOfSubDirectory = this.getLastIndex();

        this.subDirectory[lastIndexOfSubDirectory] = directory;
    }

    private int getLastIndex() {
        for (int ind = 0; ind < this.subDirectory.length; ind++) {
            if (subDirectory[ind] == null) {
                return ind;
            }
        }
        return -1;
    }

    public static Directory openCMD() {
        Directory root = new Directory("C:\\");
        root.location = "C:\\";
        return root;
    }

}

class File {
    Directory Parent;
    String name;
    String content;
    String location;
}