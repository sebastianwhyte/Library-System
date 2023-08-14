const stateCodes = [
    'AL',
    'AK',
    'AZ',
    'AR',
    'CA',
    'CO',
    'CT',
    'DE',
    'DC',
    'FL',
    'GA',
    'HI',
    'ID',
    'IL',
    'IN',
    'IA',
    'KS',
    'KY',
    'LA',
    'ME',
    'MD',
    'MA',
    'MI',
    'MN',
    'MS',
    'MO',
    'MT',
    'NE',
    'NV',
    'NH',
    'NJ',
    'NM',
    'NY',
    'NC',
    'ND',
    'OH',
    'OK',
    'OR',
    'PA',
    'PR',
    'RI',
    'SC',
    'SD',
    'TN',
    'TX',
    'UT',
    'VT',
    'VA',
    'VI',
    'WA',
    'WV',
    'WI',
    'WY',

];

function AddNewPatronView()
{
    return (
        <>
            <p>Enter the following information to add a new patron: </p>
            <h2>Name:</h2>
                <input type="text" id="patron-name" name="patron-name" />
            <h2>Street:</h2>
                <input type="text" id="street" name="street" />
            <h2>City:</h2>
                <input type="text" id="city" name="city" />
            <h2>State:</h2>
                <select id="stateCode" name="stateCode">{stateCodes}</select>
            <h2>Zip:</h2>
                <input type="text" id="zip" name="zip" />
            <br />
            <br />
            <a href="/"><button>Back</button></a>
        </>
    )
}

export default AddNewPatronView;