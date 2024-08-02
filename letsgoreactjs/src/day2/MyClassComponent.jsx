import React, { Component } from "react";
import "day1/external.css";
import { Button } from "react-bootstrap";
//import "bootstrap/dist/css/bootstrap.min.css";

class MyClassComponent extends Component {
  render() {
    const { subject, score, children } = this.props;
    const inlineStyle = { border: "1px solid orange", color: "blue" };
    return (
      <div style={inlineStyle}>
        <h1 style={{ backgroundColor: "lightpink" }}>ClassComponent</h1>
        <h2 className="myStyle2">외부의 CSS 사용하기</h2>
        <p>속성 받기 prop subject : {this.props.subject}</p>
        <p>속성 받기 subject : {subject}</p>
        <p>속성 받기 prop score : {this.props.score}</p>
        <p>속성 받기 score : {score}</p>
        <p>tag 사이의 내용. const children : {this.props.children}</p>
        <p>tag 사이의 내용. const children : {children}</p>
        <Button variant="primary">Primary</Button>{" "}
        <Button variant="secondary">Secondary</Button>{" "}
      </div>
    );
  }
}

export default MyClassComponent;
