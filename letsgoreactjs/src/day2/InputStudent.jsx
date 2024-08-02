import React from "react";

import { Form, Button, InputGroup } from "react-bootstrap";
//import { useState } from "react";

function InputStudent({ student, changeHandler }) {
  return (
    <div>
      <h2>학생정보입력</h2>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생번호</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.stdId}
          name="stdId"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생이름</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.stdName}
          name="stdName"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생전공</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.major}
          name="major"
        />
      </InputGroup>
    </div>
  );
}

export default InputStudent;
