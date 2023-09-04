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
    private String firstName;

    private String lastName;
    private String street;
    private String aptNum;      // unit number if the patron lives in an apartment
    private String city;
    private String stateCode;
    private String zip;

    // ---------------------------------------------------------------------------------

    public Patron()
    {

    }

    /** Constructor
     *
     *  Creates a new record for a person/patron
     *
     * @param firstName
     * @param lastName
     * @param street    the street the patron lives on
     * @param aptNum    the unit of the patron's apartment
     * @param city      the patron's city
     * @param stateCode the patron's state of residence
     * @param zip       the patron's zip code
     */
    public Patron(@JsonProperty("patronId") String patronId,
                  @JsonProperty("first_name") String firstName,
                  @JsonProperty("last_name") String lastName,
                  @JsonProperty("street") String street,
                  @JsonProperty("apt_num") String aptNum,
                  @JsonProperty("city") String city,
                  @JsonProperty("state_code") String stateCode,
                  @JsonProperty("zip") String zip)
    {
        this.patronId = patronId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.aptNum = aptNum;
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


    public void setPatronId(String patronId)
    {
        this.patronId = patronId;
    }


    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return street + ", " + city + ", " + stateCode + ", " + zip;
    }


    public String getStreet()
    {
        return street;
    }


    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getAptNum()
    {
        return aptNum;
    }

    public void setAptNum(String aptNum)
    {
        this.aptNum = aptNum;
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


    public String getZip()
    {
        return zip;
    }


    public void setZip(String zip)
    {
        this.zip = zip;
    }
}
