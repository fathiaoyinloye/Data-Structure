package data.models;

import java.util.Date;

public class BookBorrowed {
    private int id;
    private int userId;
    private int bookId;
    private int borrowedBookId;
    private Date borrowDate;
    private Date returnDate;
    private boolean isReturned;


    public int getBorrowedBookId() {
        return borrowedBookId;
    }

    public void setBorrowedBookId(int borrowedBookId) {
        this.borrowedBookId = borrowedBookId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
