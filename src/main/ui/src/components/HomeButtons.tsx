import Button from '@mui/material/Button';
import Box from '@mui/material/Box';

// Have this class call super to its props to insert the button text dynamically -- the text
// will change depending on which view we are currently in

function HomeButton({value, onButtonClick})
{
    return (
        <button className="home-button" onClick={onButtonClick}>{ value }</button>
    );
}

function handleClick(value: string)
{
    alert("You clicked on the " +  value + " button!");
}

const buttons =
    (
        <>
            <HomeButton value={"Add New Book"} onButtonClick={() => handleClick("Add New Book")} />
            <HomeButton value={"Delete Book"} onButtonClick={() => handleClick("Delete Book")} />
            <HomeButton value={"Add New Patron"} onButtonClick={() => handleClick("Add New Patron")} />
            <HomeButton value={"Update Patron Record"} onButtonClick={() => handleClick("Update Patron Record")} />
            <HomeButton value={"Delete Patron"} onButtonClick={() => handleClick("Delete Patron")} />
            <HomeButton value={"Quit"} onButtonClick={() => handleClick("Quit")} />
        </>
    );


function HomeButtons()
{
    // TODO - make the buttons stack ontop of each other. Currently they are side by side
    return (
        <Box justifyContent="center"
              alignItems="center"
              minHeight="100vh"
             >
            <br/>
            {buttons}
        </Box>
    );
}

export default HomeButtons;