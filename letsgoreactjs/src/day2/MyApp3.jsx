import React from "react";
import MyFunctionComponent, {
  MyFunctionComponent2,
} from "./MyFunctionComponent";
import MyClassComponent from "./MyClassComponent";
import PropTypes from "prop-types";

function MyApp3(props) {
  const myData = { subject: "리액트학습", score: 100 };
  return (
    <div>
      <MyFunctionComponent subject="react1" score={99}>
        function1
      </MyFunctionComponent>
      <MyFunctionComponent2 subject="react1" score={98}>
        function2
      </MyFunctionComponent2>
      <MyFunctionComponent {...myData}>function3</MyFunctionComponent>
      <MyFunctionComponent>function4</MyFunctionComponent>

      <MyClassComponent subject="react2" score={88}>
        class1
      </MyClassComponent>
      <MyClassComponent subject="react2" score={87}>
        class2
      </MyClassComponent>
    </div>
  );
}

//FunctionComponent의 defaultProps는 경고, JavaScript으로 처리하도록 권장
MyFunctionComponent.defaultProps = { subject: "default subject임", score: 50 };
MyClassComponent.defaultProps = { subject: "default subject2임", score: 55 };
MyFunctionComponent.propTypes = {
  subject: PropTypes.string,
  score: PropTypes.number.isRequired,
};

MyClassComponent.propTypes = {
  subject: PropTypes.string,
  score: PropTypes.number,
};
export default MyApp3;
