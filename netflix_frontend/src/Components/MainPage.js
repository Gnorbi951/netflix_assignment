import React, {useEffect, useState} from 'react';
import styled from "styled-components";
import axios from "axios";

const MainPage = () => {

    const [video, setVideo] = useState();

    useEffect(() => {
        axios.get("http://localhost:8762/videoservice/video-controller/all")
            .then(response => console.log(response));
    }, [])

    return (
        <React.Fragment>
        <MainPageHead>
            Some things that the app will display
        </MainPageHead>
        <div>

        </div>

        </React.Fragment>
    );
}

const MainPageHead = styled.div`
    background-color: grey;

`;

export default MainPage;