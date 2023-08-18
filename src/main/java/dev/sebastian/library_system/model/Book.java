package dev.sebastian.library_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table (name = "Book")
public class Book
{
    // Instance variables
    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Id
    @Column(name = "book_id")
    private UUID bookId;


    @Column(name = "status")
    private String status = "Active";       // can either be Active or Inactive (Default status is active)

    // ---------------------------------------------------------------------------------
    /** Stores a book with the given title, author, and id
     *
     * @param title
     * @param author
     * @param bookId
     */

    public Book(@JsonProperty("bookId") UUID bookId,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author)
    {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    public Book()
    {

    }


    /**
     * @return  the title of this book
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * @return  the author of this book
     */
    public String getAuthor()
    {
        return author;
    }


    /**
     * @return  the id belonging to this book
     */
    public UUID getBookId()
    {
        return bookId;
    }


    /**
     * @return
     */
    public String getStatus()
    {
        return status;
    }


    /**
     * @param status status to set (if book is active or inactive)
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
}
