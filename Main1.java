import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
public class Main1{
	private static ArrayList<Album> albums = new ArrayList<Album>();
	public static void main(String args[]){
		Album album = new Album("Best of Arjit Singh","Arjit Singh");
		album.addSong("Tere Bina",4.56);
		album.addSong("Raabta",6.16);
		album.addSong("chaana mere ya",3.56);
		album.addSong("Zalima",4.26);
		album.addSong("Mere bina",2.56);
		album.addSong("humsafar",3.45);

		albums.add(album);
		album = new Album("best of atif aslam","Atif aslam");
		album.addSong("Tere Bina",4.56);
		album.addSong("Tere Bina",4.56);
		album.addSong("Tere Bina",4.56);
		album.addSong("Tere Bina",4.56);
		album.addSong("Tere Bina",4.56);
		albums.add(album);

		LinkedList<Song> playlist = new LinkedList<Song>();
		albums.get(0).addToPlaylist("Raabta",playlist);
		albums.get(0).addToPlaylist("Tere Bina",playlist);
		albums.get(0).addToPlaylist("Zaalima",playlist);
		albums.get(1).addToPlaylist(4,playlist);
		albums.get(1).addToPlaylist(3,playlist);
		albums.get(1).addToPlaylist(5,playlist);
		albums.get(1).addToPlaylist(13,playlist);//wont add!

		play(playlist);
	}
	private static void play(LinkedList<Song> playlist){
		Scanner scanner = new Scanner(System.in);
		boolean quit= false;
		boolean forward = true;
		ListIterator<Song> listIterator = playlist.listIterator();
		if(playlist.size()==0){
			System.out.println("no songs in the playlist");
			return;
		}
		System.out.println("now playing =>" + listIterator.next());
		printMenu();

	while(!quit){
		int action = scanner.nextInt();
		scanner.nextLine();
		switch(action){
			case 0:
			    System.out.println("Hope you enjoyed Listeneing to Songs!");
			    quit = true;
			    break;
			case 1:
			    if(!forward){
			    	if(listIterator.hasNext()){
			    		listIterator.next();
			    	}
			    	forward = true;
			    }
			    if(listIterator.hasNext()){
			    	System.out.println("Now Playing=>" + listIterator.next());
			    }else{
			    	System.out.println("We have reached to the end of the playlist");
			    	forward = false;
			    }
			    break;
			case 2:
			      if(forward){
			    	if(listIterator.hasPrevious()){
			    		listIterator.previous();
			    	}
			    	forward = false;
			    }
			    if(listIterator.hasPrevious()){
			    	System.out.println("Now Playing=>" + listIterator.previous());
			    }else{
			    	System.out.println("We have reached to the start of the playlist");
			    	forward = true;
			    }
			    break;
			case 3:
			    if(forward){
			    	if(listIterator.hasPrevious()){
			    		System.out.println("Replaying=>" + listIterator.previous());
			    		forward = false;
			    	}else{
			    		System.out.println("You are start of the list! cannot replay");
			    	}
			    }else{
			    	if(listIterator.hasNext()){
			    		System.out.println("Replaying=>" + listIterator.next());
			    		forward = true;
			    	}else{
			    		System.out.println("You are at the end of the string!cannot play");
			    	}
			    }
			    break;
			case 4:
			    printPlaylistSongs(playlist);
			    break;
			case 5:
			    printMenu();
			    break;
			case 6:
			    break;        

		}
	}

}
	private static void printMenu(){
		System.out.println("Available options:");
		System.out.println("0 - to quit\n" +
			                "1- play next\n"+
			                "2- play previous\n"+
			                "3- replay the current song\n"+
			                 "4- print the menu again\n"+
			                 "5- delete the current song from playlist");
	}
	private static void printPlaylistSongs(LinkedList<Song> playlist){
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("============================");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("===============================");
	}
}
