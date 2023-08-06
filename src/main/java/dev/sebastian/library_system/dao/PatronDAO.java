/** Defines
 *
 */

package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.model.Patron;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatronDAO
{

    /** Inserts a patron into the database
     *
     * @param patron
     * @return
     */
    int insertPatron(UUID id, Patron patron);


    /** Randomly generates an id for the specified patron who does not have an id
     * and inserts them into the database
     *
     * @param patron    patron to generate new id for
     * @return
     */
    default int insertPatron(Patron patron)
    {
        UUID id = UUID.randomUUID();

        return insertPatron(id, patron);
    }


    /** Selects a specific patron by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    Optional<Patron> selectPatronByID(UUID patronId);


    /** Updates the record of the patron with the given ID
     *
     * @param patronId
     * @param newPatron
     * @return
     */
    int updatePatronByID(UUID patronId, Patron newPatron);


    /** Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    int deletePatronByID(UUID patronId);


    /** Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    List<Patron> selectAllPatrons();

}
