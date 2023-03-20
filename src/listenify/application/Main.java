package listenify.application;

import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album = new Album("New Hindi Songs","Arijit Singh");

        album.addSongToAlbum("Kesariya",4.28);
        album.addSongToAlbum("Naina",3.56);
        album.addSongToAlbum("Channa Mereya",4.50);

        albums.add(album);

        album = new Album("Old Hindi Songs","Kishore Kumar");

        album.addSongToAlbum("Mere Sapno ki Rani",5.0);
        album.addSongToAlbum("Yeh Sham Mastani",4.36);
        album.addSongToAlbum("Bheegi Bheegi Raaton Mein",3.48);

        albums.add(album);

        LinkedList<Songs> playList_1 = new LinkedList<>();
        albums.get(0).addSongToPlayList("Kesariya",playList_1);
        albums.get(0).addSongToPlayList("Naina",playList_1);
        albums.get(1).addSongToPlayList("Yeh Sham Mastani",playList_1);
        albums.get(0).addSongToPlayList("Channa Mereya",playList_1);
        albums.get(1).addSongToPlayList("Bheegi Bheegi Raaton Mein",playList_1);


        //print playlist
        play(playList_1);
    }

    public static void play(LinkedList<Songs>playList)
    {
        ListIterator<Songs> listIterator = playList.listIterator();

        if(playList.size()==0)
        {
            return;
        }

        Scanner sc = new Scanner(System.in);
        printMenu();

        System.out.println("Now Playing: "+ listIterator.next().toString());

        boolean forward = true, quit=false;

        while(quit==false)
        {
            int choice = sc.nextInt();

            switch (choice)
            {
                //quit
                case 0:
                    quit = true;
                    break;

                    //to play next song
                case 1:
                    //check pointer is at left side ie we prev before it
                    if (forward==false && playList.size()>0)
                    {
                        listIterator.next();
                        forward = true;
                    }

                    if(listIterator.hasNext() && playList.size()>0)
                    {
                        System.out.println("Now Playing: "+listIterator.next().toString());
                    }
                    else if(!(listIterator.hasNext()) && playList.size()>0)
                    {
                        System.out.println("You are at the last song");
                    }
                    else
                    {
                        System.out.println("playlist is empty");
                    }
                    break;

                    //to play prevoius song
                case 2:
                    //check we play next song or prev
                    if(forward==true && playList.size()>0)
                    {
                        listIterator.previous();
                        forward=false;
                    }

                    if(listIterator.hasPrevious() && playList.size()>0)
                    {
                        System.out.println("Now Playing: "+listIterator.previous().toString());
                    }
                    else if(!(listIterator.hasPrevious()) && playList.size()>0)
                    {
                        System.out.println("You are at the first song");
                    }
                    else
                    {
                        System.out.println("playlist is empty");
                    }
                    break;

                    //repeat the song
                case 3:
                    if(forward==true && playList.size()>0) //if pointer on RHS then just go prev
                    {
                        System.out.println(listIterator.previous());
                        forward = false;
                    }
                    else if(forward==false && playList.size()>0) //if pointer on prev go to next
                    {
                        System.out.println(listIterator.next());
                        forward = true;
                    }
                    else
                    {
                        System.out.println("Playlist is empty");
                    }
                    break;

                    //list of all songs
                case 4:
                    printAllSongs(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    //delete a song
                    if(forward==true && playList.size()>0)
                    {
                        System.out.println(listIterator.previous().toString()+ " has been removed from playlist");
                        forward = false;

                        listIterator.remove();
                        if(playList.size()>0 && listIterator.hasNext())
                        {
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else if(playList.size()>0 && listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                        }
                        else
                        {
                            System.out.println("Playlist is empty");
                        }
                    }
                    else if(forward==false && playList.size()>0)
                    {
                        System.out.println(listIterator.next().toString()+"has been removed from playlist");
                        forward = true;

                        listIterator.remove();
                        if(playList.size()>0 && listIterator.hasNext())
                        {
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else if(playList.size()>0 && listIterator.hasPrevious())
                        {
                            System.out.println("Now Playing " + listIterator.previous().toString());
                        }
                        else
                        {
                            System.out.println("Playlist is empty");
                        }
                    }
                    else
                    {
                        System.out.println("Playlist is empty");
                    }
                    break;
            }
        }
    }

    public static void printAllSongs(LinkedList<Songs>playList)
    {
        ListIterator<Songs> listIterator = playList.listIterator();

        while (listIterator.hasNext())
        {
            System.out.println(listIterator.next().toString());
        }
    }

    public static void printMenu(){

        System.out.println("Available Options:\n Press");
        System.out.println("0 - to Quit\n"+
                "1 - to play next Song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all the songs\n"+
                "5 - print all the availbale options\n"+
                "6 - delete current song");
    }
}