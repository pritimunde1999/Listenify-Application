package listenify.application;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    public String albumName;
    public String artistName;
    public List<Songs> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String title)
    {
        //songs is present in library or not
        for(Songs song : songList)
        {
            if(song.title.equals(title))
            {
                return true;
            }
        }

        return false;
    }

    public String addSongToAlbum(String title,double duration)
    {
        //check if song already present in library or not
        //if YES --> keep it
        //if NO --> add song to it
        if(findSongInAlbum(title))
        {
            return title +" is Already Added to Library";
        }
        else
        {
            //need to create song object here
            Songs newSong = new Songs(title,duration);
            songList.add(newSong);
            return title +" Added Succesfully in Library";
        }
    }

    public String addSongToPlayList(int trackNo, LinkedList<Songs> playList)
    {
        //trackNo --> 1,2,3,4,...
        //indices --> 0,1,2,3,...

        int index = trackNo-1;

        //checking for validity of index
        if(index>=0 && index<this.songList.size())
        {
            Songs song = this.songList.get(index);
            playList.add(song);
            return "Song added to PlayList";
        }
        else
        {
            return "Invalid Track Number";
        }
    }

    public String addSongToPlayList(String title,LinkedList<Songs>playList)
    {
        for(Songs song: songList)
        {
            if(song.title.equals(title))
            {
                playList.add(song);
                return "Song Added to Playlist";
            }
        }

        return "Song does not Exist ";
    }

}
