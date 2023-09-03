package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository//("mysql")
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
     * Inserts a patron into the database
     *
     * @param id
     * @param patron
     * @return
     */

    @Override
    public int insertPatron(String id, Patron patron)
    {
        //patronList.add(new Patron(id, patron.getName(), patron.getStreet(), patron.getCity(),patron.getStateCode(), patron.getZip()));

        return 1;
    }


    /**
     * Selects a specific patron by looking up their assigned id
     *
     * @param patronId      id of the patron
     * @return
     */
    @Override
    public Patron selectPatronByID(String patronId)
    {
        /*
        return patronList.stream()
                .filter(patron -> patron.getPatronId().equals(patronId))
                .findFirst();

         */

        return null;
    }


    /**
     * Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    @Override
    public int deletePatronByID(String patronId)
    {
        Patron patron = selectPatronByID(patronId);

        return 1;
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

        /*
        return selectPatronByID(patronId)
                .map(currentPatron-> {
                    int indexOfPatronToUpdate = patronList.indexOf(currentPatron);

                    // If the person to delete is in the database, then get the index of the person we want to replace. And return 1 (successful deletion)
                    if (indexOfPatronToUpdate >= 0)
                    {
                        // Create a new person and insert them where the old person was
                        patronList.set(indexOfPatronToUpdate, new Patron(patronId, newPatron.getName(), newPatron.getStreet(), newPatron.getCity(), newPatron.getStateCode(), newPatron.getZip()));

                        return 1;
                    }

                    return 0;
                })
                .orElse(0);

         */


        return 1;
    }


    /**
     * Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    @Override
    public List<Patron> selectAllPatrons()
    {
        return new ArrayList<>();
    }

}
