package beans;

public class Book {
	private String title;
	private Author author;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public boolean IsMadeInChina() {
		return true;
	}
	
	public String type;
}
