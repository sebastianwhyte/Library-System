package dev.sebastian.library_system.mapper;

import dev.sebastian.library_system.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class BookMapper implements RowMapper<Book>
{
    // TODO - Receiving error " java.lang.IllegalArgumentException: Invalid UUID string: ���?��ϸ+�� " -- need to
    //  format the UUID correctly - 08/20/2023
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException
    {
        Book book = new Book();

        System.out.println(resultSet.getString("book_id"));

        //book.setBookId(UUID.fromString(resultSet.getString("book_id")));
        book.setBookId(resultSet.getString("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));

        return book;
    }
}
