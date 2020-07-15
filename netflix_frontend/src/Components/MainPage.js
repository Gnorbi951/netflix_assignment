import React, {useEffect, useState} from 'react';
import styled from "styled-components";
import axios from "axios";
import Video from "./Video";

const MainPage = () => {

    const [video, setVideo] = useState();

    useEffect(() => {
        axios.get("http://localhost:8762/videoservice/video-controller/all")
            .then(response => setVideo(response.data));
    }, [])

    return (
        <React.Fragment>
        <MainPageHead>
            {video ? <Video videos={video}/> : <p>Loading</p>}
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