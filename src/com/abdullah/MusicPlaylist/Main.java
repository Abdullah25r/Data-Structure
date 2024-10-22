package com.abdullah.MusicPlaylist;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Blinding lights", "The Weekend");
        playlist.addSong("Bad guy", "Billie Eilish");
        playlist.addSong("why not", "Talha anjum");
        playlist.addSong("Brown Mundy", "Ap dillon");
        playlist.displayPlaylist();
        System.out.println();
        playlist.playNext();
        playlist.playNext();
        playlist.playPrevious();
        playlist.displayPlaylist();

    }
}
