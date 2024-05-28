package model;

public class Song implements Comparable<Song> {

    private String name;
    private String artist;
    private Integer year;

    public Song(String name, String artist, Integer year) {
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song [name=" + name + ", artist=" + artist + ", year=" + year + "]";
    }

    @Override
    public int compareTo(Song anotherSong) {
        return this.getName().compareTo(anotherSong.getName());
    }

}
