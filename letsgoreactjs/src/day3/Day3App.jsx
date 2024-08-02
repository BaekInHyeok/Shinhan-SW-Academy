import React, { useEffect, useState } from "react";
import Displaycount from "./Displaycount";
import ControllerButton from "./ControllerButton";

function Day3App() {
  //data 상태 관리, 값 변경 시 자동으로 UI에 적용...함수형 컴포넌트에서 useState를 사용한다.
  const [count, setCount] = useState(0);
  const clickHandler = (e) => {
    setCount(count + Number(e.target.innerText)); //setter는 비동기이다.
    console.log("stter는 비동기...count:" + count);
  };
  const clickHandler2 = (value) => {
    setCount(count + value);
  };

  //Life Cycle을 관리할 때 사용되는 hook
  useEffect(() => {
    console.log("count가 변경될 때마다 수행됨 : " + count);
  }, [count]);
  return (
    <div>
      <h1>CountApp</h1>
      <Displaycount count={count} />
      <ControllerButton
        clickHandler={clickHandler}
        clickHandler2={clickHandler2}
      />
    </div>
  );
}

export default Day3App;
