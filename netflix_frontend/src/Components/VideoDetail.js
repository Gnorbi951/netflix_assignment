import React, {useEffect, useState} from "react";
import axios from "axios";
import Recommendation from "./Recommendation";

const VideoDetail = (props) => {
    const [details, setDetails] = useState();
    const [video, setVideo]= useState();

    useEffect(() => {
        axios.get(`http://localhost:8762/videoservice/video-controller/video/${props.match.params.id}`)
            .then(response => setVideo(response));


        axios.get(`http://localhost:8762/videoservice/video-controller/video-with-recommendations/${props.match.params.id}`)
            .then(response => {
                setDetails(response)
                console.log(response.data);
            });
    }, [props] );
    return (

        <React.Fragment>
            <div className={"video"}>
            {video ? <iframe
                             frameBorder={0}
                             allow={"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture;"}
                             allowFullScreen={true}
                             title={video.id}
                             src={`https://youtube.com/embed/${video.viewKey}`} />
                             : <h1>Loading</h1>}
            </div>
            {details ? <Recommendation recommendations={details} /> : <h2>No Recommendations</h2>}
        {}</React.Fragment>

    );

}

export default VideoDetail;