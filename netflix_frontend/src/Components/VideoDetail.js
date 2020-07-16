import React, {useEffect, useState} from "react";
import axios from "axios";

const VideoDetail = (props) => {
    const [details, setDetails] = useState();

    useEffect(() => {
        axios.get(`http://localhost:8762/videoservice/video-controller/video/${props.match.params.id}`)
            .then(response => {
                setDetails(response)
                console.log(response.data);
            });
    }, []);
    return (

        <React.Fragment>
            {details ? <h1>Hi</h1> : <h1>Loading</h1>}
        </React.Fragment>

    );

}

export default VideoDetail;