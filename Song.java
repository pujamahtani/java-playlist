public class Song {
	private String title;
	
	private double duration;

	public Song(String title,double duration)
	{
		this.title=title;
		
		this.duration=duration;

	}
	 public void setTitle(String title){
	 	this.title=title;
	 }
	 public String getTitle(){
		return this.title;
	 }
	 
	 
	 //annotation
	 @Override
	 public String toString(){
         return this.title + ":" + this.duration;
	 }
	 

    
}
