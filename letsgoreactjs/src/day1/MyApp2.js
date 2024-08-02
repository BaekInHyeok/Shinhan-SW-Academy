import React from "react";
import ExportTest, { constTest, varTest, Func1, Func2 } from "day1/ExportTest";
import "day1/external.css";

//함수형 Component :컴포넌트 이름은 반드시 대문자
function MyApp2(props) {
  var myname = "리액트JS";
  const score = 99;
  const student = { name: "Emmet", major: "소프트웨어" };
  //이 부분의 값은 JSX에서 읽어서 출력 시 display 안됨
  let score2 = null;
  let score3 = undefined;
  let score4 = false;
  const hobbyArr = ["Sports", "Music", "Movie"];
  const hobbyDisplay = hobbyArr.map((item, index) => (
    <li key={index}>{item}</li>
  ));

  //import한 값, 함수 사용하기
  console.log(constTest);
  console.log(varTest);
  console.log(Func1());
  console.log(Func2());

  const inlineStyle = { boarder: "3px dotted blue", color: "orange" };

  return (
    <div style={inlineStyle}>
      <h1 style={{ backgroundColor: "green" }}>함수형 Component</h1>
      {/* import 연습 */}
      <p className="myStyle2">constTest:{constTest}</p>
      <p>varTest:{varTest}</p>
      <Func1 />
      <Func2 />
      <ExportTest />
      <p>이름은 {myname}</p>
      <p>점수는 {score}</p>

      <p>
        student info: {student.name}----{student.major}
      </p>
      <p className="myStyle3">
        점수2는 {score2}....
        {score2 == null ? "값없음" : score2}{" "}
      </p>
      <p>
        점수3는 {score3}....
        {score3 === undefined ? "값없음" : score3}
      </p>
      <p>
        점수4는 {score4}....
        {score4 === false ? "값없음" : score4}
      </p>
      <div>{hobbyArr}</div>
      <div>
        <ul>
          {hobbyArr.map((item, index) => (
            <li key={index}>{item}</li>
          ))}
        </ul>
        <hr />
        <ul>{hobbyDisplay}</ul>
      </div>
      {/* <p>주석입니다.</p> */}
    </div>
  );
}

export default MyApp2;
