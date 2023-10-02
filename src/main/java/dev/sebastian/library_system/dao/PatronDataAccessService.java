/**  Provides a means of accessing the database's Patron Table.
 *
 * @author Sebastian Whyte
 * @date 09/05/2023
 * @version v1.0
 */

package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.PatronNotFoundException;
import dev.sebastian.library_system.mapper.PatronMapper;
import dev.sebastian.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PatronDataAccessService implements PatronDAO
{
    /** Instance variables **/
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    // -------------------------------------------------------------------------

    /** Constructor **/
    public PatronDataAccessService(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @param id        id of the new patron
     * @param patron    patron object with info regarding this patron
     * @return          1 = successful insertion
     */

    @Override
    public int insertPatron(String id, Patron patron)
    {
        String SQL_INSERT_PATRON = "INSERT INTO Patron(patron_id, first_name, last_name, street, apt_num, city, state_code, zip) VALUES (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(SQL_INSERT_PATRON, id, patron.getFirstName(), patron.getLastName(), patron.getStreet(),
                                                    patron.getAptNum(), patron.getCity(), patron.getStateCode(),
                                                    patron.getZip());

        return 1;
    }


    /**
     * @param patronId      id of the patron
     * @return              patron with the specified id
     */
    @Override
    public Patron selectPatronByID(String patronId) throws PatronNotFoundException
    {
        Patron selectedPatron;

        try
        {
            String SQL_SELECT_PATRON_BY_ID = "SELECT * FROM Patron WHERE patron_id = ?";

            selectedPatron = jdbcTemplate.queryForObject(SQL_SELECT_PATRON_BY_ID, new PatronMapper(), patronId);
        }
        catch (EmptyResultDataAccessException exception)
        {
            //logger.("BookDataAccessService :: selectBookByID() : " + exception);
            throw new PatronNotFoundException("Patron with id: " + patronId + " not found in database!");
        }

        return selectedPatron;
    }


    /**
     * @return all patrons currently in the database
     */
    @Override
    public List<Patron> selectAllPatrons()
    {
        String SQL_SELECT_ALL_PATRONS = "SELECT * FROM Patron";

        return jdbcTemplate.query(SQL_SELECT_ALL_PATRONS, new PatronMapper());
    }


    /**
     * Finds patrons with first or last names that contain the given string
     *
     * @param pattern   pattern to match
     * @return  patrons with first names or last names that match the given pattern
     */
    public List<Patron> selectPatronsWithNameLike(String pattern)
    {
        String SQL_PATRONS_WITH_NAMES_LIKE = "SELECT * FROM Patron WHERE first_name LIKE ? OR last_name LIKE ?";

        return jdbcTemplate.query(SQL_PATRONS_WITH_NAMES_LIKE, new PatronMapper(), "%" + pattern + "%", "%" + pattern + "%");
    }


    /**
     * Updates the record of the patron with the given ID
     *
     * @param patronId      patron record to update
     * @param newPatron     patron to replace the old patron
     * @return
     */
    @Override
    public int updatePatronByID (String patronId, Patron newPatron)
    {
        String SQL_UPDATE_PATRON_BY_ID = "UPDATE Patron SET first_name = ?, last_name = ?, street = ?, apt_num = ?, city = ?, state_code = ?, zip = ? WHERE patron_id = ?";

        jdbcTemplate.update(SQL_UPDATE_PATRON_BY_ID, newPatron.getFirstName(), newPatron.getLastName(), newPatron.getStreet(), newPatron.getAptNum(), newPatron.getCity(), newPatron.getStateCode(), newPatron.getZip(), patronId);

        return 1;
    }


    /**
     * Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    @Override
    public int deletePatronByID(String patronId) throws PatronNotFoundException
    {
        Patron patron = selectPatronByID(patronId);

        // If the selected patron can't be found
        if (patron == null)
        {
            throw new PatronNotFoundException("Patron with id: " + patronId + " not found in database!");
        }

        String SQL_DELETE_PATRON_BY_ID = "DELETE FROM Patron WHERE patron_id = ?";

        jdbcTemplate.update(SQL_DELETE_PATRON_BY_ID, patronId);

        return 1;
    }
}
