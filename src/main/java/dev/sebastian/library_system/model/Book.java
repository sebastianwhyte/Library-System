package dev.sebastian.library_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Book
{
    // Instance variables
    private String title;
    private String author;

    @Id
    private UUID bookId;
    private String status = "Active";       // can either be Active or Inactive (Default status is active)

    // ---------------------------------------------------------------------------------
    /** Stores a book with the given title, author, and id
     *
     * @param title
     * @param author
     * @param bookId
     */

    public Book(@JsonProperty("bookId") UUID bookId, @JsonProperty("title") String title,
                @JsonProperty("author") String author)
    {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    public Book()
    {

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
