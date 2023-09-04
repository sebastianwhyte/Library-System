/** Defines
 *
 */

package dev.sebastian.library_system.dao;

import dev.sebastian.library_system.exception.PatronNotFoundException;
import dev.sebastian.library_system.model.Book;
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
    int insertPatron(String id, Patron patron);


    /** Randomly generates an id for the specified patron who does not have an id
     * and inserts them into the database
     *
     * @param patron    patron to generate new id for
     * @return
     */
    default int insertPatron(Patron patron)
    {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        return insertPatron(id, patron);
    }


    /** Selects a specific patron by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    Patron selectPatronByID(String patronId) throws PatronNotFoundException;


    /** Updates the record of the patron with the given ID
     *
     * @param patronId
     * @param newPatron
     * @return
     */
    int updatePatronByID(String patronId, Patron newPatron);


    /** Deletes a person by looking up their assigned id
     *
     * @param patronId
     * @return
     */
    int deletePatronByID(String patronId) throws PatronNotFoundException;


    /** Selects and returns all patrons in the database
     *
     * @return all patrons currently in the database
     */
    List<Patron> selectAllPatrons();


    List<Patron> selectPatronsWithNameLike(String pattern);
}
