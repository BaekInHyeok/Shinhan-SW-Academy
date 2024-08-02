import React, { Component } from "react";

class ClassComponentTest extends Component {
  constructor(props) {
    super(props);
    this.state = { message: "", color: "" };
  }
  enterListener = (e) => {
    console.log(e.target.innerText);
  };
  leaveListener = (e) => {
    console.log(e.target.innerText);
  };
  colorListener = (e) => {
    this.setState(
      {
        message: e.target.innerText + "변경",
        color: e.target.innerText,
      },
      () => {
        console.log("set 후 color 값" + this.state.color);
      }
    );
    //stter는 비동기이다...확인은 callback 함수를 사용한다.
    //console.log("set 후 color 값" + this.state.color);
  };
  render() {
    var myStyle = { color: this.state.color };
    return (
      <div>
        <button onClick={this.enterListener}>입장</button>{" "}
        <button onClick={this.leaveListener}>퇴장</button>
        <button onClick={this.colorListener}>BLUE</button>
        <button onClick={this.colorListener}>RED</button>{" "}
        <h1 style={myStyle}>{this.state.message}</h1>{" "}
        <h1>{this.state.color}</h1>
      </div>
    );
  }
}

export default ClassComponentTest;
