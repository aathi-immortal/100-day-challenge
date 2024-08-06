
class Directory {
    String name;
    Directory parent;
    static String[] location;
    static Directory trash;
    Directory[] innerDirectory;
    File innerFiles[];
    String[] parentPath;

    public Directory(String name) {
        this.name = name;
        innerDirectory = new Directory[10];
        innerFiles = new File[10];

    }

    public static Directory openCommandPrompt() {
        Directory.location = new String[100];
        Directory root = new Directory("~");
        root.innerDirectory[0] = new Directory("c:\\");
        root = root.innerDirectory[0];
        // root.location = "c:\\";
        Directory.location[0] = "c:";
        Directory.trash = new Directory("trash");
        root.innerDirectory[0] = Directory.trash;
        return root;
    }

    public void excutePresentWorkingDiretory() {
        printInString(Directory.location);
    }

    private static void printInString(String[] location) {

        for (String locationPart : location) {
            if (locationPart == null)
                break;
            System.out.print(locationPart + "\\");
        }
        System.out.println();

    }

    public Directory excuteChangeDir(String directoryName) {
        // check is give directory is in the innerDirectory array
        if (directoryName.equals("..")) {
            return excuteMoveBack();

        } else if (directoryName.equals("//")) {
            return excuteHome();
        }
        return getInnerDirectory(directoryName);

    }

    private Directory getInnerDirectory(String directoryName) {
        for (Directory directory : innerDirectory) {
            if (directory != null && directory.name.equals(directoryName)) {
                Directory.moveLocationFront(directoryName);
                return directory;
            }
        }
        System.out.println("Directory not found");
        return this;
    }

    private static void moveLocationFront(String directoryName) {
        Directory.location[getDirectoryLocationLength()] = directoryName;
    }

    public void excuteMakeDir(String directoryName) {
        // create directory object with the given name
        if (isDirectoryAlreadyPresent(directoryName)) {
            return;
        }
        Directory directory = new Directory(directoryName);

        directory.parent = this;
        this.innerDirectory[getDirectoryLength()] = directory;
        System.out.println("directory " + directory.name + " has been created");
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

    private Directory excuteMoveBack() {
        Directory.moveLocationBack();
        return this.parent;
    }

    private static void moveLocationBack() {
        Directory.location[getDirectoryLocationLength() - 1] = null;
    }

    private static int getDirectoryLocationLength() {
        int count = 0;
        for (String location : Directory.location) {
            if (location == null) {
                break;
            }
            count++;
        }
        return count;
    }

    public void excuteTouch(String fileName) {
        File file = new File(fileName);

        file.parent = this;
        this.innerFiles[getFilesLength()] = file;
    }

    private int getFilesLength() {
        int count = 0;
        for (File file : this.innerFiles) {
            if (file == null) {
                return count;
            }
            count++;
        }
        return count;
    }

    public void excuteListDir() {
        if (this.name.equals("trash")) {
            this.trashListDir();
            return;
        }
        for (Directory directory : this.innerDirectory) {
            if (directory != null) {
                Directory.location[getDirectoryLocationLength()] = directory.name;
                printInString(Directory.location);
                Directory.location[getDirectoryLocationLength() - 1] = null;
            }
        }
        for (File file : this.innerFiles) {
            if (file != null) {
                Directory.location[Directory.getDirectoryLocationLength()] = file.name;
                printInString(Directory.location);
                Directory.location[getDirectoryLocationLength() - 1] = null;
            }
        }

    }

    private void trashListDir() {
        for (Directory directory : this.innerDirectory) {
            if (directory != null) {
                System.out.println("trash:\\" + directory.name);
            }
        }
        for (File file : this.innerFiles) {
            if (file != null) {
                System.out.println("trash:\\" + file.name);
            }
        }
    }

    public Directory excuteHome() {
        Directory currentDirectory = this;
        int index = Directory.getDirectoryLocationLength() - 1;
        while (!currentDirectory.name.equals("c:\\")) {
            currentDirectory = currentDirectory.parent;
            Directory.location[index--] = null;
        }
        return currentDirectory;
    }

    // public void excuteRename(String newName) {
    // // change the current name to new Name
    // this.name = newName;
    // // this.setLocationFromParent();
    // // this.changeChildLocation();

    // }

    // private void changeChildLocation() {
    // for (Directory childDirectory : this.innerDirectory) {
    // if (childDirectory == null) {
    // return;
    // }
    // // childDirectory.setLocationFromParent();// location
    // childDirectory.changeChildLocation();
    // childDirectory.changeInnerFilesLocation();
    // }

    // }

    // private void changeInnerFilesLocation() {
    // for (File file : this.innerFiles) {
    // if (file != null) {
    // file.setLocationFromParent();
    // }

    // }
    // }

    public void excuteRenameFile(String currentFileName, String newFileName) {
        if (isFileAlreadyPresent(newFileName)) {
            return;
        }
        File file = getInnerFile(currentFileName);
        file.name = newFileName;
        // file.setLocationFromParent();
    }

    private File getInnerFile(String currentFileName) {
        for (File file : this.innerFiles) {
            if (file != null && file.name.equals(currentFileName)) {
                return file;
            }
        }
        return null;
    }

    public void excuteNano(String fileName, String content) {
        File file = getNewOrOldFile(fileName);

    }

    private File getNewOrOldFile(String fileName) {
        File file = getInnerFile(fileName);
        if (file == null) {
            excuteTouch(fileName);
            file = this.innerFiles[getFilesLength() - 1];

        }
        return file;
    }

    public void excuteCat(String fileName) {

    }

    public Directory delete() {

        Directory parentDirectory = this.parent;
        parentDirectory.removeDirectory(this.name);
        this.loadDiretoryToTrash();
        return parentDirectory;
    }

    private void loadDiretoryToTrash() {
        this.parentPath = Directory.location;
        Directory.trash.innerDirectory[trash.getDirectoryLength()] = this;

    }

    private void removeDirectory(String name) {
        int index = 0;
        for (Directory directory : this.innerDirectory) {
            if (directory != null && directory.name.equals(name)) {
                this.innerDirectory[index] = null;
            }
            index++;
        }
        Directory.location[Directory.getDirectoryLocationLength() - 1] = null;
    }

    public void excuteRename(String newName) {
        if (isDirectoryAlreadyPresent(newName)) {
            return;
        }
        this.name = newName;
        Directory.location[getDirectoryLocationLength() - 1] = newName;
    }

    private boolean isDirectoryAlreadyPresent(String newName) {
        for (Directory directory : this.innerDirectory) {
            if (directory != null && directory.name.equals(newName)) {
                System.out.println("Directory already found");
                return true;
            }

        }
        return false;
    }

    private boolean isFileAlreadyPresent(String newName) {
        for (File file : this.innerFiles) {
            if (file != null && file.name.equals(newName)) {
                System.out.println("file already found");
                return true;
            }

        }
        return false;
    }
}

class File {
    String name;
    Directory parent;
    String[] FileSystemItem;
    String parentPath;

    public File(String fileName) {
        this.name = fileName;
    }

}

public class PlayWithDirectory {

    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        Directory root = Directory.openCommandPrompt();
        // normalTest(root);
        // reNameTesting(root);
        removeTesting(root);
    }

    private static void removeTesting(Directory root) {
        root.excuteMakeDir("challenge");
        root = root.excuteChangeDir("challenge");

        root.excuteMakeDir("100-day-challenge");
        root.excuteMakeDir("chatApp");
        root.excuteMakeDir("designPattern");
        root.excuteMakeDir("designPattern");
        root.excuteMakeDir("Iot");
        root = root.excuteChangeDir("100-day-challenge");
        // root.excutePresentWorkingDiretory();
        root.excuteMakeDir("zoho-day-1");
        root.excuteMakeDir("zoho-day-2");
        // // root.excuteListDir();
        // root = root.excuteChangeDir("..");
        // root = root.excuteChangeDir("..");
        root = root.excuteChangeDir("zoho-day-1");
        // root.excutePresentWorkingDiretory();
        root.excuteTouch("a.java");
        root.excuteTouch("b.java");
        root.excuteTouch("c.java");
        root.excutePresentWorkingDiretory();
        // root.excuteListDir();
        // System.out.println("parent" + root.parent.name);
        root = root.delete();

        // root.excutePresentWorkingDiretory();
        // Directory.trash.excuteListDir();

        // root.excutePresentWorkingDiretory();
        System.out.println("list of trash");
        // root.excuteListDir();
        root = root.excuteChangeDir("..");
        root = root.excuteChangeDir("..");
        root = root.excuteChangeDir("trash");
        root.excuteListDir();
    }

    private static void normalTest(Directory root) {
        root.excutePresentWorkingDiretory();

        root.excuteMakeDir("wild Animal");
        root = root.excuteChangeDir("wild Animal");

        root.excutePresentWorkingDiretory();

        root.excuteTouch("aa.java");
        root.excuteListDir();

        // root.excuteMakeDir("animal");
        // root.excuteMakeDir("bird");
        // root = root.excuteChangeDir("bird");
        // root.excuteMakeDir("mountainBirds");
        // root.excuteMakeDir("domestic birds");
        // root = root.excuteChangeDir("mountainBirds");
        // root.excuteMakeDir("pretator");
        // root = root.excuteChangeDir("pretator");

        // root = root.excuteChangeDir("..");
        // root = root.excuteChangeDir("..");
        // root.excuteRename("bird advance");
        // root = root.excuteChangeDir("mountainBirds");
        // root.excuteRename("mountainBirdsAdvance");
        // root = root.excuteChangeDir("pretator");
        // root.excutePresentWorkingDiretory();

        // root = root.excuteChangeDir("snaks");
        // root = root.excuteChangeDir("animal");
        // root.excuteTouch("a.py");
        // root.excutePresentWorkingDiretory();
        // root.excuteListDir();

        // root = root.excuteHome();
        // root.excutePresentWorkingDiretory();
    }

    private static void reNameTesting(Directory root) {
        root.excuteMakeDir("challenge");
        root = root.excuteChangeDir("challenge");

        root.excuteMakeDir("100-day-challenge");
        root.excuteMakeDir("chatApp");
        root.excuteMakeDir("designPattern");
        root.excuteMakeDir("designPattern");
        root.excuteMakeDir("Iot");
        root = root.excuteChangeDir("100-day-challenge");
        root.excuteMakeDir("zoho-day-1");
        root.excuteMakeDir("zoho-day-2");
        root = root.excuteChangeDir("zoho-day-1");
        root.excuteTouch("a.java");
        root.excuteTouch("b.java");
        root.excuteTouch("c.java");
        root.excuteListDir();
        root = root.excuteChangeDir("..");
        root = root.excuteChangeDir("..");

        root.excuteRename("challengeAdvance");

        System.out.println("after rename");
        root = root.excuteChangeDir("100-day-challenge");
        // System.out.println(root.location);
        root = root.excuteChangeDir("zoho-day-1");
        // root.excutePresentWorkingDiretory();
        root.excuteListDir();
        root.excuteRenameFile("a.java", "b.java");
        System.out.println("after file rename");
        root.excuteListDir();

        // root.excuteNano("aa.java", "vanakkam");
        // root.excuteCat("aa.java");

    }

}
