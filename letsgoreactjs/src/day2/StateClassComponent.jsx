import React, { Component } from "react";
import PropTypes from "prop-types";
import { Button } from "react-bootstrap";

class StateClassComponent extends Component {
  constructor(props) {
    super(props);
    //코드 작성하려면 반드시 부모를 호출한다.
    console.log("StateClassComponent constructor");
    this.state = {
      count: 0,
      message: "count하기",
      f2: () => {
        console.log("f2 state에 있는 화살표 함수", this.state.message);
      },
      f3: function () {
        console.log("f3 state에 있는 선언적 함수", this.state.message);
      },
    };
    this.f1 = () => {
      console.log("f1 consturctor 속성으로 만든 함수", this.state.message);
    };
    //state에 있는 선언적 함수에 this가 이 객체임을 알린다.ㄴ
    this.state.f3 = this.state.f3.bind(this);
  }

  f4() {
    console.log("f4 state 밖에 있는 선언적 함수", this.state.message);
  }

  f5 = () => {
    console.log("f5 state 밖에 있는 화살표 함수", this.state.message);
  };

  clickCounterHandler = (e) => {
    console.log(e.targt);
    if (e.target.innerHTML === "더하기")
      this.setState({ count: this.state.count + 1, message: "더하기" });
    else this.setState({ count: this.state.count - 1, message: "빼기" });
  };

  render() {
    const { count, message } = this.state;
    return (
      <div>
        <h1>StateClassComponent!!!</h1>
        <p>현재 count : {this.state.count}</p>
        <p>현재 count : {count}</p>
        <p>현재 massage : {this.state.message}</p>
        <p>현재 massage : {message}</p>
        <hr />
        <h3>함수호출</h3>
        {this.f1()}
        {this.state.f2()}
        {this.state.f3()}
        {this.f4()}
        {this.f5()}
        <Button onClick={this.clickCounterHandler}>더하기</Button>
        <Button onClick={this.clickCounterHandler}>빼기</Button>
      </div>
    );
  }
}

export default StateClassComponent;
