package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Patron;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatronDAO
{
    // ---------------------------------------------------------------------------------
    /** Inserts a patron into the database
     *
     * @param patron
     * @return
     */
    int addPatron(Patron patron);

    // ---------------------------------------------------------------------------------
    /** Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    List<Patron> selectAllPatrons();

    // ---------------------------------------------------------------------------------
    /** Selects a specific patron by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    Optional<Patron> selectPatronByID(UUID patronId);

    // ---------------------------------------------------------------------------------
    /** Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    int deletePatronByID(UUID patronId);
}
