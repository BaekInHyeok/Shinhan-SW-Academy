import { Button } from "bootstrap";
import React from "react";

function UseRefTest2(props) {
  var score = 100;

  const clickHandler = () => {
    score = score + 1;
    console.log(score);
  };
  return (
    <div>
      <h1>자식</h1>
      <Button onClick={score}>점수 변경</Button>
    </div>
  );
}

export default UseRefTest2;
