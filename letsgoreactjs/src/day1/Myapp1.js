import React from "react";
import Header from "day1/Header";
import Content from "day1/Menu";
import Section from "day1/Section";

//Component : 재사용이 가능함. 반드시 대문자로 시작. 외부에서 사용하려면 export 해야 함
function Myapp1(props) {
  //JSX(JavaScript XML) : 반드시 root 1개, tage는 반드시 닫는다
  return (
    <div>
      <h1>Function Component1</h1>
      <Header />
      <Content />
      <Section />
      
      <hr />
    </div>
  );
}

export default Myapp1;
