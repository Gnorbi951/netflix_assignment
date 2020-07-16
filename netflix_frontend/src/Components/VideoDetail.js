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
    }, [props]);
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
            <form action={"http://localhost:8762/videoservice/video-controller/..."} method={"POST"}>
                <input name={"comment"} placeholder={"Your comment"} /><br/>
                <select name="rating">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select><br/>
                <StyledButton type={"submit"} >Submit</StyledButton>
            </form>
        </React.Fragment>

    );

}
const VideoContainer = styled.div`
    margin: 2rem;
    height: 30rem;
    padding: 5px;
`;

const StyledButton = styled.button`

    width:4rem;
    height:2rem;
    border-radius:5px;
    
`;



export default VideoDetail;