package dev.sebastian.library_system.model;

import java.util.UUID;

public class Book
{
    // Instance variables
    private final String title;
    private final String author;
    private final UUID bookId;
    private String status = "Active";       // can either be Active or Inactive (Default status is active)

    // ---------------------------------------------------------------------------------
    /** Stores a book with the given title, author, and id
     *
     * @param title
     * @param author
     * @param bookId
     */
    public Book(String title, String author, UUID bookId)
    {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    // ---------------------------------------------------------------------------------
    /** Retrieves this book's title
     *
     * @return  the title of this book
     */
    public String getTitle()
    {
        return title;
    }
    // ---------------------------------------------------------------------------------
    /** Retrieves this book's author
     *
     * @return  the author of this book
     */
    public String getAuthor()
    {
        return author;
    }
    // ---------------------------------------------------------------------------------

    /** Retrieves this book's id
     *
     * @return  the id belonging to this book
     */
    public UUID getBookId()
    {
        return bookId;
    }
    // ---------------------------------------------------------------------------------
    /** Retrieves the current status of this book
     *
     * @return
     */
    public String getStatus()
    {
        return status;
    }
    // ---------------------------------------------------------------------------------
    /** Sets the status of this book
     *
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
}
