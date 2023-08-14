import Box from '@mui/material/Box';
import Stack from "@mui/material/Stack";
import Button from "@mui/material/Button";


/*
function HomeButton({value, onButtonClick})
{
    return (

        <Button variant="contained" size="small" className="home-button" onClick={onButtonClick}>
            { value }
        </Button>
    );
}
*/


function handleClick(value: string)
{
    alert("You clicked on the " +  value + " button!");
}


const buttons =
    (
        <>
            <a href="/add-new-book"><button>Add New Book</button></a>
            <a href="/delete-book"><button>Delete Book</button></a>
            <a href='/add-new-patron'><button>Add New Patron</button></a>
            <a href='/update-patron'><button>Update Patron Record</button></a>
            <a href='/delete-patron'><button>Delete Patron</button></a>
        </>

        /*
        <>
            <HomeButton value={"Add New Book"} onButtonClick={() => handleClick("Add New Book")} />
            <HomeButton value={"Delete Book"} onButtonClick={() => handleClick("Delete Book")} />
            <HomeButton value={"Add New Patron"} onButtonClick={() => handleClick("Add New Patron")} />
            <HomeButton value={"Update Patron Record"} onButtonClick={() => handleClick("Update Patron Record")} />
            <HomeButton value={"Delete Patron"} onButtonClick={() => handleClick("Delete Patron")} />
        </>
         */

    );


function HomeButtons()
{
    return (
        <Box justifyContent="center"
              alignItems="center"
              maxHeight="75vh"
             >
            <Stack spacing={2}>
                {buttons}
            </Stack>
        </Box>
    );
}


export default HomeButtons;