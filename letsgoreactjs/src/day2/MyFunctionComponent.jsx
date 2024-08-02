import React from "react";

function MyFunctionComponent(props2) {
  const inlineStyle = { border: "1px solid green", color: "blue" };

  const { subject, score } = props2; //{subect:"aaa",score:99}
  return (
    <div style={inlineStyle}>
      <h1 style={{ color: "red" }}>FunctionComponent</h1>
      <p>속성 받기 prop subject : {props2.subject}</p>
      <p>속성 받기 subject : {subject}</p>
      <p>속성 받기 prop score : {props2.score}</p>
      <p>속성 받기 score : {score}</p>
      <p>tag 사이의 내용. const children : {props2.children}</p>
    </div>
  );
}

export function MyFunctionComponent2({ subject, score, children }) {
  const inlineStyle = { border: "1px solid green", color: "blue" };

  return (
    <div style={inlineStyle}>
      <h1 style={{ color: "red" }}>FunctionComponent</h1>
      <p>속성 받기 subject : {subject}</p>
      <p>속성 받기 score : {score}</p>
      <p>tag 사이의 내용. const children : {children}</p>
    </div>
  );
}

export default MyFunctionComponent;
