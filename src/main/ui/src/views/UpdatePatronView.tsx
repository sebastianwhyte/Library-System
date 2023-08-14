function UpdatePatronView()
{
    return (
        <>
            <p>Enter the following information to update a patron record: </p>
            <h2>Patron Id:</h2>
            <input type="text" id="patron-id" name="patron-id" />
            <h2>Name:</h2>
            <input type="text" id="patron-name" name="patron-name" />
            <br />
            <br />
            <a href="/"><button>Back</button></a>
        </>
    )
}

export default UpdatePatronView;