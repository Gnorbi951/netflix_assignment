import React from "react";

const Recommendation = (props) => {

    console.log(props.recommendations.data);
    return (
        <React.Fragment>
            {
                props.recommendations.data.map((detail) =>
                <p>{detail.comment}</p>

                )
            }
        </React.Fragment>
    );
}

export default Recommendation;