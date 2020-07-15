import React from "react";

const Video = (props) => {
    return (
        <React.Fragment>
            <div className="card-columns">
            {props.videos.map((video) =>

                <h2 key={video.id}>{video.name}</h2>

            )}
            </div>
        </React.Fragment>
    );
}

export default Video;