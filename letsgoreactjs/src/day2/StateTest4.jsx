import React, { useState } from "react";
import {
  Button,
  //ButtonToolbar,
  //Card,
  Form,
  InputGroup,
  //ListGroup,
} from "react-bootstrap";
import DisplayStudentList from "day2/DisplayStudentList";
import InputStudent from "day2/InputStudent";

//function component에서 상태관리를 위해 : state, setState()
//function component에서 상태관리를 위해 useState() 이용

const initStudent = { stdId: 1, stdName: "김민영", major: "컴공" };

function StateTest4(props) {
  //1건의 객체
  const [student, setStudent] = useState(initStudent);
  const [studnetList, setStudentList] = useState([initStudent]);

  const changeHandler = (event) => {
    setStudent({ ...student, [event.target.name]: event.target.value });
  };

  const addHandler = () => {
    setStudentList([...studnetList, student]);
  };
  return (
    <div>
      <InputStudent student={student} changeHandler={changeHandler} />
      <Button onClick={addHandler}>학생 ADD</Button>
      <DisplayStudentList studnetList={studnetList} />
    </div>
  );
}

export default StateTest4;
