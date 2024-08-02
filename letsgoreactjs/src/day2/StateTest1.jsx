import React, { useState } from "react";

function StateTest1(props) {
  const [color, setColor] = useState("red");
  const [message, setMessage] = useState("");
  const [mystyle, setMystyle] = useState({
    color: "red",
    border: "1px solid red",
  });

  const handleColorChange = (e) => {
    setColor(e.target.innerText);
    setMessage(e.target.innerText + "버튼 누름");
    setMystyle({
      color: `${e.target.innerText}`,
      border: `1px solid ${e.target.innerText}`,
    });
  };

  return (
    <div>
      <button onClick={handleColorChange}>RED</button>
      <button onClick={handleColorChange}>BLUE</button>
      <button onClick={handleColorChange}>GREEN</button>
      <h1 style={{ color }}>{message}</h1>
      <h1 style={mystyle}>{message}</h1>
    </div>
  );
}

export default StateTest1;
