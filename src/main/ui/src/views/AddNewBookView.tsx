
function AddNewBookView()
{
    return (
        // TODO - Replace empty fragments with a container - Box, Grid, etc
        <>
            <p>Add a book by entering the following: </p>
            <h2>Title:</h2>
                <input type="text" id="bookTitle" name="bookTitle" />
            <h2>Author:</h2>
                <input type="text" id="author" name="author" />
            <a href="/"><button>Back</button></a>
        </>
    );
}

export default  AddNewBookView;