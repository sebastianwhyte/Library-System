/** Describes a patron.
 *
 * @author Sebastian Whyte
 * @date Jul 24, 2023
 * @version V 1.0
 *
 */

package dev.sebastian.library_system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Patron
{
    /** Instance variables **/
    @Id
    private UUID patronId;
    private String name;
    //private String address;
    private String street;
    private String aptNum;      // unit number if the patron lives in an apartment
    private String city;
    private String stateCode;
    private int zip;

    // ---------------------------------------------------------------------------------

    public Patron()
    {

    }

    /** Constructor
     *
     *  Creates a record for a person/patron with the given info
     *
     * @param name      the patron's name
     * @param street    the street the patron lives on
     * //@param aptNum    the unit of the patron's apartment
     * @param city      the patron's city
     * @param stateCode the patron's state of residence
     * @param zip       the patron's zip code
     */
    public Patron(@JsonProperty("patronId") UUID patronId,
                  @JsonProperty("name") String name,
                  @JsonProperty("street") String street,
                  @JsonProperty("city") String city,
                  @JsonProperty("stateCode") String stateCode,
                  @JsonProperty("zip") int zip)
    {
        this.patronId = patronId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.stateCode = stateCode;
        this.zip = zip;
    }

    // ---------------------------------------------------------------------------------

    /**
     * @return  patron's id
     */
    public UUID getPatronId()
    {
        return patronId;
    }


    /**
     * @return  the name of this patron
     */
    public String getName()
    {
        return name;
    }


    /**
     * @return  string representation of the patron's full address
     */
    public String getAddress()
    {
        return street + ", " + city + ", " + stateCode + ", " + zip;
    }


    /**
     * @return street the patron lives on
     */
    public String getStreet()
    {
        return street;
    }


    /**
     * @return city the patron lives in
     */
    public String getCity()
    {
        return city;
    }


    /**
     * @param city  the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }


    /**
     * @return state the patron lives in
     */
    public String getStateCode()
    {
        return stateCode;
    }


    /**
     * @param stateCode state to set
     */
    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }


    /**
     * @return  patron's zip code
     */
    public int getZip()
    {
        return zip;
    }


    /**
     * @param zip   zip code to set
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }
}
