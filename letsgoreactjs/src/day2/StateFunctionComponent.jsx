import React, { useState } from "react";
import { Button } from "react-bootstrap";

function StateFunctionComponent(props) {
  //상태값을 변경하기 위해 반드시 setter를 이용한다.
  //useState()의 값이 초기값으로 할당된다.
  const [light, setLight] = useState("off");
  const [light2, setLight2] = useState(false);
  const [count, setCount] = useState(0);

  const clickHandler1 = () => {
    setLight(light === "on" ? "off" : "on");
  };
  const clickHandler2 = () => {
    setLight2(!light2);
  };

  const clickCounterHandler = (e) => {
    console.log(e.targt);
    if (e.target.innerHTML === "증가") setCount(count + 1);
    else setCount(count - 1);
  };

  const clickMinusHandler = () => {
    setCount(count - 1);
  };
  return (
    <div>
      <p>현재상태값:{light}</p>
      <p>현재상태값:{light2 ? "켜짐" : "꺼짐"}</p>
      <p>현재 Count값 : {count}</p>

      <Button onClick={clickHandler1}>상태 변경하기1</Button>
      <Button onClick={clickHandler2}>상태 변경하기2</Button>
      <Button onClick={clickCounterHandler}>증가</Button>
      <Button onClick={clickCounterHandler}>감소</Button>
    </div>
  );
}

export default StateFunctionComponent;
