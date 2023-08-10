import * as React from "react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Box from '@mui/material/Box';
import HomeScreenTitleText from "./HomeScreenTitleText.tsx";
import HomeButtons from "./HomeButtons.tsx";



const card =  (
    <>
        <CardContent>
            <HomeScreenTitleText />
            <HomeButtons />
        </CardContent>
    </>
)

function HomeCard()
{
    return (
        <Box sx={{ maxWidth: 1/2 }}>
            <Card variant="outlined">
                {card}
            </Card>
       </Box>
    );
}


export default HomeCard;