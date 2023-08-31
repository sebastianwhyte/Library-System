package dev.sebastian.library_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

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
    @NonNull
    @Column(name = "book_id")
    //private UUID bookId;
    private String bookId;


    @Column(name = "status")
    private String status = "Active";       // can either be Active or Inactive (Default status is active)

    // ---------------------------------------------------------------------------------
    /** Stores a book with the given title, author, and id
     *
     * @param title
     * @param author
     * @param bookId
     */

    public Book(@JsonProperty("bookId") String bookId,
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


    /** Getters and setters **/
    public void setTitle(String title)
    {
        this.title = title;
    }


    public void setAuthor(String author)
    {
        this.author = author;
    }


    public void setBookId(String bookId)
    {
        this.bookId = bookId;
    }


    public String getTitle()
    {
        return title;
    }


    public String getAuthor()
    {
        return author;
    }


    public String getBookId()
    {
        return bookId;
    }


    public String getStatus()
    {
        return status;
    }


    public void setStatus(String status)
    {
        this.status = status;
    }

}
