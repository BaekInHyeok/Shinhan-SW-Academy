import React from "react";

import { Form, Button, InputGroup } from "react-bootstrap";
//import { useState } from "react";

function InputStudent({ student, changeHandler }) {
  return (
    <div>
      <h2>학생정보입력</h2>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">학생이름</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.name}
          name="name"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">이메일</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.email}
          name="email"
        />
      </InputGroup>
      <InputGroup className="mb-3">
        <InputGroup.Text id="basic-addon1">나이</InputGroup.Text>
        <Form.Control
          onChange={changeHandler}
          defaultValue={student.age}
          name="age"
        />
      </InputGroup>
    </div>
  );
}

export default InputStudent;
