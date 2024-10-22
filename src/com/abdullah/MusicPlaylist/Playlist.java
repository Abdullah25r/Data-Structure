package com.abdullah.MusicPlaylist;

import java.util.Objects;

public class Playlist {
    Node head;
    Node tail;
    Node current;
    int size;
    public Playlist() {
        head = null;
        tail = null;
        current = null;
    }
    // add song
    public void addSong(String songName, String artistName) {
        Node newNode = new Node(songName, artistName);
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
            size++;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    //remove song
    public void removeSong(String songName) {
        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }
        Node temp = head;
        if(Objects.equals(temp.songTitle, songName)) {
            head = head.next;
            head.prev = null;
            System.out.println(songName + " removed successfully.");
            return;
        }
        while (temp.next != null) {
            if(Objects.equals(songName, temp.songTitle)){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                System.out.println(songName+" removed successfully.");
                size--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("song does not exist");
    }
    public void playNext(){
        if(current == null){
            System.out.println("Playlist is empty");
            return;
        }

        if(current.next == null){
            System.out.println("you are already at the last song: " + current.songTitle);
        }else{
            System.out.println("Current playing: "+ current.songTitle);
            current = current.next;

        }
    }
    public void playPrevious(){
        if(current == null){
            System.out.println("Playlist is empty");
            return;
        }
        if(current.prev == null){
            System.out.println("you are already at the first song: " + current.songTitle);
        }else {
            current = current.prev.prev;
            System.out.println("Current playing: "+ current.songTitle);
        }
    }


    public void displayPlaylist() {
        System.out.println("Forward: ");
        displayForward(current);
        System.out.println("Backward: ");
        displayBackward(current);
    }
        public void displayForward(Node current){
            if(current.next == null){
                System.out.println("No more songs");
                return;
            }
            Node temp = current;
            while (temp != null){
                System.out.println(temp.songTitle + " by " + temp.artistName);
                temp = temp.next;
            }
        }
        public void displayBackward(Node current){
        if(current.prev == null){
            System.out.println("No more songs");
            return;
        }
        Node temp = current.prev;
        while (temp != null){
            System.out.println(temp.songTitle + " by " + temp.artistName);
            temp = temp.prev;
        }
        }




    static class Node{
        String songTitle;
        String artistName;
        Node next;
        Node prev;
        public Node(String songTitle, String artistName) {
            this.songTitle = songTitle;
            this.artistName = artistName;
        }
    }
}
