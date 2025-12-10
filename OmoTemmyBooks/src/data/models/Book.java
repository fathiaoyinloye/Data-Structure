package data.models;

public class Book {
    private String title;
    private String author;
    private Genre genre;
    private String isbn;
    private int pages;
    private String description;
    private int edition;
    private int id;
    private int quantity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        if(edition == 11 || edition == 12|| edition == 13) return edition + "th" + " edition";
        if  (edition % 10 == 1) return  edition + "st" + " edition";
        if(edition % 10 == 2) return  edition + "nd" + " edition";
        if(edition % 10 == 3) return  edition + "rd" + " edition";

      return edition + "th" + " edition";
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
