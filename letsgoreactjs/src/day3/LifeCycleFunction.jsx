import React, { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import MyTimer from "./MyTimer";

function LifeCycleFunction(props) {
  const [count, setCount] = useState(0);
  const [count2, setCount2] = useState(0);
  const [showYN, setShowYN] = useState(true);
  const changeHandler = () => {
    setShowYN(!showYN);
  };

  useEffect(() => {
    console.log("rendering 될 때마다 실행된다.(의존배열 생략)");
  });

  useEffect(() => {
    console.log("rendering 될 때마다 실행된다.(빈 의존배열)");
  }, []);
  useEffect(() => {
    console.log("rendering 될 때 & count 변경 시마다 실행된다.");
  }, [count]);

  useEffect(() => {
    console.log("rendering 될 때 & count2 변경 시마다 실행된다.");
  }, [count2]);

  useEffect(() => {
    console.log("rendering 될 때 , count, count2 변경 시마다 실행된다.");
  }, [count, count2]);

  const addHandler = () => {
    setCount(count + 1);
  };

  const addHandler2 = () => {
    setCount2(count2 - 1);
  };
  return (
    <div>
      <h1>
        함수의 LifeCycle : count={count} count2={count2}
      </h1>
      <Button onClick={addHandler}>1증가</Button>
      <Button onClick={addHandler2}>1감소</Button>
      {showYN && <MyTimer />}
      <Button onClick={changeHandler}>시작/중지</Button>
    </div>
  );
}

export default LifeCycleFunction;
