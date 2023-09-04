package dev.sebastian.library_system.mapper;

import dev.sebastian.library_system.model.Book;
import dev.sebastian.library_system.model.Patron;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatronMapper implements RowMapper<Patron>
{

    /**
     * @param resultSet
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Patron mapRow(ResultSet resultSet, int rowNum) throws SQLException
    {
        // TODO - Fix the 500 error code that occurs when trying to delete patron (also check PatronDataAccessService class) - 09/04/2023
        Patron patron = new Patron();

        patron.setPatronId(resultSet.getString("patron_id"));
        patron.setFirstName(resultSet.getString("first_name"));
        patron.setLastName(resultSet.getString("last_name"));
        patron.setStreet(resultSet.getString("street"));
        patron.setAptNum(resultSet.getString("apt_num"));
        patron.setCity(resultSet.getString("city"));
        patron.setStateCode(resultSet.getString("state_code"));
        patron.setZip(resultSet.getString("zip"));

        return patron;
    }
}
