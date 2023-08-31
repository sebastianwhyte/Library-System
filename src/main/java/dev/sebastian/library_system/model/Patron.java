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


@Entity
public class Patron
{
    /** Instance variables **/
    @Id
    private String patronId;
    private String name;
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
    public Patron(@JsonProperty("patronId") String patronId,
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

    /** Getters and setters **/
    public String getPatronId()
    {
        return patronId;
    }


    public String getName()
    {
        return name;
    }


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


    public String getCity()
    {
        return city;
    }


    public void setCity(String city)
    {
        this.city = city;
    }


    public String getStateCode()
    {
        return stateCode;
    }


    public void setStateCode(String stateCode)
    {
        this.stateCode = stateCode;
    }


    public int getZip()
    {
        return zip;
    }


    public void setZip(int zip)
    {
        this.zip = zip;
    }
}
