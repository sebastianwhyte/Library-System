package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Patron;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class PatronDataAccessService implements PatronDAO
{
    /**
     * Inserts a patron into the database
     *
     * @param patron
     * @return
     */
    @Override
    public int addPatron(Patron patron)
    {
        return 0;
    }

    // ---------------------------------------------------------------------------------
    /**
     * Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    @Override
    public List<Patron> selectAllPatrons()
    {
        return null;
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

    // ---------------------------------------------------------------------------------
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
}
