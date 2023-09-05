/** Class that handles HTTP requests (GET, POST, PUT, DELETE / CRUD) for the Patron class.
 *
 * @author Sebastian Whyte
 * @date Jul 23, 2023
 * @version V 1.0
 *
 */

// --- Remember CRUD operations -> CREATE, READ, UPDATE DELETE.
//
//      CREATE --> POST(if we do NOT have id or uuid) / PUT
//      READ ----> GET
//      UPDATE ---> PUT (to replace) or PATCH (to modify)
//      DELETE ---> DELETE
//

package dev.sebastian.library_system.api;

import dev.sebastian.library_system.exception.PatronNotFoundException;
import dev.sebastian.library_system.model.Patron;
import dev.sebastian.library_system.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/library/v1/patrons")       // API endpoint for patrons
public class PatronController
{
    /** Instance variables **/
    @Autowired
    private final PatronService patronService;

    // ---------------------------------------------------------------------------------
    /** Constructor
     *
     * @param patronService
     */
    @Autowired
    public PatronController(PatronService patronService)
    {
        this.patronService = patronService;
    }


    /** Inserts the patron into the database.
     *
     * @param patron    patron to add to database
     */
    @PostMapping(path = "/add")
    public void addPatron(@RequestBody Patron patron)
    {
        patronService.addPatron(patron);
    }


    /**
     * @return  list of all patrons currently in the database
     */
    @GetMapping(path = "/all")
    public List<Patron> getAllPatrons()
    {
        return patronService.getAllPatrons();
    }


    /**
     * @param patronId      the patron's id
     * @return              patron with the specified id, if they are currently in database
     */
    @GetMapping(path = "/{patronId}")
    public Patron getPatronByID(@PathVariable("patronId") String patronId) throws PatronNotFoundException
    {
        return patronService.getPatronByID(patronId);
    }


    /**
     * @param pattern   pattern to match
     * @return          books with titles matching the given pattern
     */
    @GetMapping(path = "/find/{pattern}")
    public List<Patron> getPatronsWithNameLike(@PathVariable("pattern") String pattern)
    {
        return patronService.getPatronsWithNameLike(pattern);
    }

    /** Replaces a patron assigned to the given id with another patron
     *
     * @param patronId          id of patron to be replaced
     * @param patronToUpdate    new patron
     */
    @PutMapping(path = "/update/{patronId}")
    public void updatePatronByID(@PathVariable("patronId") String patronId,
                                 @RequestBody Patron patronToUpdate)
    {
        patronService.updatePatronByID(patronId, patronToUpdate);
    }


    /**
     * @param patronId      the patron's id
     */
    @DeleteMapping(path = "/delete/{patronId}")
    public void deletePatronID(@PathVariable("patronId") String patronId) throws PatronNotFoundException
    {
        patronService.deletePatronByID(patronId);
    }
}
