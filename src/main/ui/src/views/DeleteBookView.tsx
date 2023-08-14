
function DeleteBookView()
{
    return (
        <>
            <p>Delete a book by entering the following: </p>
            <h2>Title:</h2>
                <input type="text" id="bookTitle" name="bookTitle" />
            <h2>Author:</h2>
                <input type="text" id="author" name="author" />
            <br />
            <br />
            <a href="/"><button>Back</button></a>
        </>
    )
}

export default DeleteBookView;