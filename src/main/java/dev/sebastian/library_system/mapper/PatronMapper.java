/**
 * @author Sebastian Whyte
 * @date 09/05/2023
 * @version v1.0
 */

package dev.sebastian.library_system.mapper;

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
