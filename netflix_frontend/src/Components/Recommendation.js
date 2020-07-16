import React from "react";

const Recommendation = (props) => {

    console.log(props.recommendations.data);
    return (
        <React.Fragment>
            {props.recommendations.data.map((detail) => (
                <div key={detail.id}>
                    <p>{detail.comment}</p>
                    <p>Rating: {detail.rating}/5</p>
                </div>
            ))}
        </React.Fragment>
    );
}

export default Recommendation;