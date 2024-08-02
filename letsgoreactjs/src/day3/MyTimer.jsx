import React, { useEffect, useState } from "react";

function MyTimer(props) {
  const [currentTime, setCurrentTime] = useState("00:00:00");
  const now = () => {
    const date = new Date();
    const h = String(date.getHours()).padStart(2, "0");
    const m = String(date.getMinutes()).padStart(2, "0");
    const s = String(date.getSeconds()).padStart(2, "0");
    setCurrentTime(`${h}:${m}:${s}`); //currentTime 상태를 변경
    console.log("타이머실행");
  };
  useEffect(() => {
    const timer = setTimeout(now, 1000); //1초 후 now() 호출
    //useEffect 후에 뒷정리할 메서드를 return한다, clean-up
    return () => {
      clearTimeout(timer);
      console.log("timer 변수가 제거됨");
    };
  }, [currentTime]); //currentTiem 상태값이 변경됨
  return (
    <div>
      <p>현재시각 : {currentTime}</p>
    </div>
  );
}

export default MyTimer;
