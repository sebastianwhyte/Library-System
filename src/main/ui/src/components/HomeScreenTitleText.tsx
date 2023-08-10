import React from "react";
import Typography from "@mui/material/Typography"

const homeCardTitleText = (
    <h1>[Insert title text]</h1>
);

function HomeScreenTitleText()
{
    return (
        <>
            <Typography variant="h5" color="black" gutterBottom>
                Arthur's Library
            </Typography>
            <Typography variant="subtitle2" color="black" gutterBottom>
                <i>Having fun isn't hard, when you've got a library card!</i>
            </Typography>
            <br/>
        </>
    );
}


export default HomeScreenTitleText;