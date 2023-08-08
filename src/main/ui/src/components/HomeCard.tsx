import * as React from "react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';

const card =  (
    <>
        <CardContent>
            <Typography variant="h5" color="black" gutterBottom>
                Arthur's Library
            </Typography>
        </CardContent>
    </>
)

function HomeCard()
{
    return (
        <Box sx={{ minWidth: 275 }}>
            <Card variant="outlined">
                {card}
            </Card>
       </Box>
    );
}

export default HomeCard;