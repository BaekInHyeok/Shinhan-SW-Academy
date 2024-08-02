import React, { Component } from "react";
import PropTypes from "prop-types";

class LifeCycleClass2 extends Component {
  constructor(props) {
    super(props);
    console.log("자식 constructor");
  }

  componentDidMount() {
    console.log("자식 componentDidMount");
  }

  shouldComponentUpdate(nextProps, nextState) {
    console.log("자식 shouldComponentUpdate");
    return true;
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("자식 componentDidUpdate");
  }

  componentWillUnmount() {
    console.log("자식 componentWillUnmount");
  }

  render() {
    console.log("자식 render");
    return (
      <div>
        <h3>자식 영역입니다. 부모의 값 전달받음:{this.props.title}</h3>
      </div>
    );
  }
}

LifeCycleClass2.propTypes = {};

export default LifeCycleClass2;
