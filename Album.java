import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist){
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	public boolean addSong(String title, double duration){
		if(findSong(title)==null){
			this.songs.add(new Song(title, duration));
			return true;
		}
		return false;
	}
	// public boolean addSong(Song song){
	// return addSong(song.getTitle(),song.getDuration());
	//}
	private Song findSong(String title){
		for(Song checkSong: this.songs){
			if(checkSong.getTitle().equalsIgnoreCase(title)){
				return checkSong;
			}
			
		}
		return null;
	}
	public boolean addToPlaylist(String title,LinkedList<Song> playlist){
			Song checkSong = findSong(title);
			if(checkSong!=null){
				playlist.add(checkSong);
				return true;
			}
			return false;
		}
	public boolean addToPlaylist(int trackNumber,LinkedList<Song> playlist){
			int index = trackNumber-1;
		if((index >= 0) && (index < this.songs.size())){
			playlist.add(this.songs.get(index));
		    return true;
		}
		return false;
	}
	//private Song findSong(Song song){
	//return findSong(song.getTitle());
	//}
}



