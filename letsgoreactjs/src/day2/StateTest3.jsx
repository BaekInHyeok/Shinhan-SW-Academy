import React, { useState } from "react";

function StateTest3(props) {
  const [student, setStudent] = useState({
    username: "아무개",
    useremail: "zz@naver.com",
    userphone: "010-1234-5678",
  });
  const studentChangeHandler = (event) => {
    setStudent({
      ...student,
      [event.target.name]: event.target.value,
    });
  };
  return (
    <div>
      <p>이름:{student.username}</p>
      <p>email:{student.useremail}</p>
      <p>phone:{student.userphone}</p>
      이름:
      <input
        name="username"
        onChange={studentChangeHandler}
        value={student.username}
      />
      email:
      <input
        name="useremail"
        onChange={studentChangeHandler}
        value={student.useremail}
      />
      phone:
      <input
        name="userphone"
        onChange={studentChangeHandler}
        value={student.userphone}
      />
    </div>
  );
}

export default StateTest3;
