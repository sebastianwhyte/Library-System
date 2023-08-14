function DeletePatronView()
{
    return (
        // TODO - Replace empty fragments with a container - Box, Grid, etc
        <>
            <p>Delete a patron by entering the following: </p>
            <h2>Patron Id:</h2>
            <input type="text" id="patron-id" name="patron-id" />
            <br />
            <br />
            <a href="/"><button>Back</button></a>
        </>
    );
}

export default DeletePatronView;