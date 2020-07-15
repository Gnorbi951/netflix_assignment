import React from "react";

const Video = (props) => {
    return (
        <React.Fragment>
            <div className="card-columns">
            {props.videos.map((video) =>
                <div class="card">
                    <div class="card-img-top">
                        <iframe width={"100%"}
                                height={"100%"}
                                frameBorder={0}
                                allow={"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture;"}
                                allowFullScreen={true}
                                title={video.id}
                            src={`https://youtube.com/embed/${video.viewKey}`} />
                    </div>
                    <div className="card-body">
                        <h2 key={video.id}>{video.name}</h2>
                    </div>
                </div>

            )}
            </div>
        </React.Fragment>
    );
}

export default Video;