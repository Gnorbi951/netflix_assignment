import React from "react";
import {Link} from "react-router-dom";
import styled from "styled-components";

const Video = (props) => {
    return (
        <React.Fragment>
            <div className="card-columns">
            {props.videos.map((video) =>
                <div className="card">
                    <div className="card-img-top">
                        <iframe width={"100%"}
                                height={"100%"}
                                frameBorder={0}
                                allow={"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture;"}
                                allowFullScreen={true}
                                title={video.id}
                            src={`https://youtube.com/embed/${video.viewKey}`} />
                    </div>
                    <div className="card-body">
                        <StyledLink to={"/video/"+video.id}>{video.name}</StyledLink>
                    </div>
                </div>

            )}
            </div>
        </React.Fragment>
    );
}

const StyledLink = styled(Link)`
    font-size: 2rem
`;

export default Video;