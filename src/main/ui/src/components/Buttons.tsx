import Button from '@mui/material/Button';
import Box from '@mui/material/Box';

// Have this class call super to its props to insert the button text dynamically -- the text
// will change depending on which view we are currently in


const homeButtons =
    (
        <>
            <Button variant="outline">Add New Book</Button>
            <Button variant="outline">Delete Book</Button>
            <Button variant="outline">Add New Patron</Button>
            <Button variant="outline">Update Patron Record</Button>
            <Button variant="outline">Delete Patron</Button>
            <Button variant="outline">Quit</Button>
        </>
    )


function HomeButtons()
{
    // TODO - make the buttons stack ontop of each other. Currently they are side by side
    return (
        <Box justifyContent="center"
              alignItems="center"
              minHeight="100vh"
             >
            <br/>
            {homeButtons}
        </Box>
    );
}

export default HomeButtons;