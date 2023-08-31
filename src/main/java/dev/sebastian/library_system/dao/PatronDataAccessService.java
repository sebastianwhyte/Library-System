package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Patron;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository//("mysql")
public class PatronDataAccessService implements PatronDAO
{
    /** Instance variables **/

    // Temp storage for patrons. TODO - Implement CRUD operations to mysql database
    private static List<Patron> patronList = new ArrayList<>();


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
        patronList.add(new Patron(id, patron.getName(), patron.getStreet(), patron.getCity(),patron.getStateCode(), patron.getZip()));

        return 1;
    }


    /**
     * Selects a specific patron by looking up their assigned id
     *
     * @param patronId      id of the patron
     * @return
     */
    @Override
    public Optional<Patron> selectPatronByID(UUID patronId)
    {
        return patronList.stream()
                .filter(patron -> patron.getPatronId().equals(patronId))
                .findFirst();
    }


    /**
     * Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    @Override
    public int deletePatronByID(UUID patronId)
    {
        Optional<Patron> patron = selectPatronByID(patronId);

        // If optional is empty, then we couldn't find the specified patron in the database.
        if (patron.isEmpty())
        {
            return 0;
        }

        // Otherwise, get the patron object and remove it
        patronList.remove(patron.get());

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
    public int updatePatronByIDs patronId, Patron newPatron)
    {
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
    }


    /**
     * Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    @Override
    public List<Patron> selectAllPatrons()
    {
        return patronList;
    }

}
