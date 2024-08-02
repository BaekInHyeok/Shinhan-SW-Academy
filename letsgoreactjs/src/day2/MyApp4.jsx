import React from "react";
import PropsComponentTest from "day2/PropsComponentTest";

function MyApp4(props) {
  const arr = ["HTML", "CSS", "javaScript", "ReactJS"];
  return (
    <div>
      <PropsComponentTest subject={arr}>
        배열로 들어온 속성값 주고받기
      </PropsComponentTest>
      <PropsComponentTest>보낸 값이 없을 경우</PropsComponentTest>
    </div>
  );
}

export default MyApp4;
