import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
//import App from "./App";
import reportWebVitals from "./reportWebVitals";
import Myapp1 from "day1/Myapp1";
import MyApp2 from "day1/MyApp2";
import EnvTest from "day1/EnvTest";
import MyApp3 from "day2/MyApp3";
import MyApp4 from "day2/MyApp4";
import MyApp5 from "day2/MyApp5";
import Day3App from "day3/Day3App";
import Day3App2 from "day3/Day3App2";
import ClassComponentTest from "day3/ClassComponentTest";
import LifeCycleClass from "day3/LifeCycleClass";
import LifeCycleFunction from "day3/LifeCycleFunction";
import AppStart from "day3/Projdect2/AppStart";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  //<React.StrictMode>
  <div>
    {/* <h1>ReactJS 시작하기</h1> */}
    {/* <Myapp1 />
    <MyApp2 />
    <EnvTest />
    <MyApp3 /> */}
    {/* <MyApp4 /> */}
    {/* <MyApp5 /> */}
    {/* <Day3App />
    
    <LifeCycleClass /> */}
    {/* <Day3App2 /> */}
    {/* <LifeCycleFunction /> */}
    <AppStart />
  </div>
  //</React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
