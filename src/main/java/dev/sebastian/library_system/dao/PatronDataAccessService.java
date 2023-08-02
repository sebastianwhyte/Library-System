package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Patron;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository//("mysql")
public class PatronDataAccessService implements PatronDAO
{
    /** Instance variables **/

    // Temp storage for patrons. TODO - Implement CRUD operations to mysql database
    private static Set<Patron> patronSet = new HashSet<>();


    /**
     * Inserts a patron into the database
     *
     * @param patron    patron to add
     * @return
     */
    @Override
    public String addPatron(Patron patron)
    {
        return addNewPatron(patron.getPatronId(), patron.getName(), patron.getStreet(), patron.getCity(),patron.getStateCode(), patron.getZip());
    }


    private String addNewPatron(UUID patronId, String name, String street, String city, String stateCode, int zip)
    {
        patronSet.add(new Patron(patronId, name, street, city, stateCode, zip));

        return "New Patron: " + name + " with id: " + patronId + " added to database!";
    }


    // ---------------------------------------------------------------------------------
    /**
     * Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    @Override
    public Set<Patron> selectAllPatrons()
    {
        return patronSet;
    }

    // ---------------------------------------------------------------------------------

    /**
     * Selects a specific patron by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    @Override
    public Optional<Patron> selectPatronByID(UUID patronId)
    {
        return Optional.empty();
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
        return 0;
    }


    /**
     * Updates the record of the patron with the given ID
     *
     * @param patronID
     * @param patron
     * @return
     */
    @Override
    public int updatePatronByID(UUID patronID, Patron patron)
    {
        return 0;
    }
}
