import React, {useEffect, useState} from "react";
import axios from "axios";
import Recommendation from "./Recommendation";
import styled from "styled-components";

const VideoDetail = (props) => {
    const [details, setDetails] = useState();
    const [video, setVideo]= useState();

    useEffect(() => {
        axios.get(`http://localhost:8762/videoservice/video-controller/video/${props.match.params.id}`)
            .then(response => {
                setVideo(response)});


        axios.get(`http://localhost:8762/videoservice/video-controller/video-with-recommendations/${props.match.params.id}`)
            .then(response => {
                if (response.data.length === 0) {
                    setDetails(null);
                } else {
                    setDetails(response);
                }

            });
    }, [props] );
    return (

        <React.Fragment>
            <VideoContainer>
            {video ? <iframe
                             width={"100%"}
                             height={"100%"}
                             frameBorder={0}
                             allow={"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture;"}
                             allowFullScreen={true}
                             title={video.id}
                             src={`https://youtube.com/embed/${video.data.viewKey}`} />
                             : <h1>Loading</h1>}
            </VideoContainer>
            {details ? <Recommendation recommendations={details} /> : <h2>No Recommendations</h2>}
        {}</React.Fragment>

    );

}
const VideoContainer = styled.div`
    margin: 2rem;
    height: 30rem;
    padding: 5px;
`;


export default VideoDetail;